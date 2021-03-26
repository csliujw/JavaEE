import com.bbxx.dao.IUserDao;
import com.bbxx.pojo.UserVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Source {
    @Test
    public void helloWorld() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlConfig.xml");
        SqlSessionFactory factor = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factor.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<UserVO> all = mapper.findAll();
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

}
