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

/**
 * 源码阅读从HelloWorld开始
 * 1.加载配置信息
 * 2.拿到SqlSessionFactory
 * 3.拿到SqlSession
 * 4.拿到代理对象Mapper
 * 5.执行CRUD
 * -----
 * MyBatis在四大对象的创建过程中，都会有插件进行介入。插件可以利用动态代理机制一层层的包装目标对象，而实现在目标对象执行目标方法之前
 * 进行拦截的效果。
 * MyBatis允许在已映射语句执行过程中的某一点进行拦截调用。
 * 默认情况下，MyBatis允许使用插件来拦截的方法调用包括
 * - Executor
 * - ParameterHandler
 * - ResultSetHandler
 * - StatementHandler
 */

public class Source {
    @Test
    public void helloWorld() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factor = builder.build(in);
        SqlSession sqlSession = factor.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<UserVO> all = mapper.findAll();
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
}
