package test;

import com.bbxx.dao.IRoleDao;
import com.bbxx.pojo.RoleVO;
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

public class TestRole {
    InputStream in = null;
    SqlSessionFactory factory = null;
    SqlSession sqlSession = null;
    IRoleDao mapper = null;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(IRoleDao.class);
    }

    /**
     * 测试一个角色 对应多个用户
     */
    @Test
    public void testRole() {
        RoleVO byPrimaryKey = mapper.findByPrimaryKey(1);
        System.out.println(byPrimaryKey.getUserList());
    }

    /**
     * 多对多查询
     */
    @Test
    public void testRoleMulti() {
        List<RoleVO> allRole = mapper.findAllRole();
        for (RoleVO vo : allRole) {
            vo.getUserList().stream().forEach(System.out::println);
        }

    }

    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
}
