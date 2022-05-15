package quickstart;

import cn.mapper.AssociationQuery;
import cn.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.io.InputStream;

public class AssociationQueryTest {
    String resourcePath = "MyBatisConfig.xml";
    SqlSession sqlSession;
    AssociationQuery userDao;

    @BeforeEach
    public void init() throws IOException {
        InputStream in = Resources.getResourceAsStream(resourcePath);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession(true); // 設置自動提交事務
        userDao = sqlSession.getMapper(UserMapper.class);
    }
}
