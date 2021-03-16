package lazy;

import com.bbxx.dao.lazy.IAccountDao;
import com.bbxx.dao.lazy.IUserDao;
import com.bbxx.pojo.Account;
import com.bbxx.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LazyDemo {
    InputStream in = null;
    SqlSessionFactory factory = null;
    SqlSession sqlSession = null;
    IAccountDao dao = null;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        dao = sqlSession.getMapper(IAccountDao.class);
    }

    @Test
    public void testLazy(){
        List<Account> all = dao.findAll();
//        不使用user的话，就不会查询出来数据。
//        System.out.println(all.get(0).getUser());
        System.out.println("============");
    }

    @Test
    public void testLazy2(){
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<User> all = mapper.findAll();
        for (User u :all){
            u.getAccounts();
        }
    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
}
