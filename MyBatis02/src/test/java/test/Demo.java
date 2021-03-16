package test;

import com.bbxx.dao.IUserDao;
import com.bbxx.pojo.UserVO;
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

public class Demo {
    InputStream in = null;
    SqlSessionFactoryBuilder builder = null;
    SqlSessionFactory factory = null;
    SqlSession sqlSession = null;
    IUserDao mapper = null;

    @Before
    public void init() throws IOException {
        // 读取配置文件
        in = Resources.getResourceAsStream("SqlConfig.xml");
        // 创建sessionFactory构建器
        builder = new SqlSessionFactoryBuilder();
        // 创建Session工厂
        factory = builder.build(in);
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(IUserDao.class);
    }

    @Test
    public void findAll() {
        List<UserVO> all = mapper.findAll();
        all.stream().forEach(System.out::println);
    }

    @Test
    public void findCondition(){
        List<UserVO> condition = mapper.findCondition(new UserVO(1, "liujiawe", null));
        condition.stream().forEach(System.out::println);
    }

    @Test
    public void delete(){
        Integer delete = mapper.delete(1);
        System.out.println(delete);
        sqlSession.commit();
    }

    @Test
    public void update(){
        Boolean payphone = mapper.update(new UserVO(2, "payphone", "1997-11-03"));
        System.out.println(payphone);
        sqlSession.commit();
    }

    @Test
    public void insert(){
        Boolean liu = mapper.insert(new UserVO(null, "liu", "1997-11-30"));
        System.out.println(liu);
        sqlSession.commit();
    }

    @Test
    public void findByName(){
        List<UserVO> o = mapper.findByName("o");
        o.stream().forEach(System.out::println);
    }

    @Test
    public void findTotal(){
        Long total = mapper.findTotal();
        System.out.println(total);
    }

    @After
    public void destroy() throws IOException {
        sqlSession.close();
        in.close();
    }
}
