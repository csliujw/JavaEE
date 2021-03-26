import com.bbxx.dao.IUserDao;
import com.bbxx.pojo.UserVO;
import com.bbxx.utils.ConnectUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.SimpleFormatter;

public class SimpleCRUD {

    SqlSession session = null;
    IUserDao mapper = null;

    @Before
    public void before() {
        session = ConnectUtils.getSession();
        mapper = session.getMapper(IUserDao.class);
    }

    @After
    public void after() {
        session.commit();
        ConnectUtils.closeSession(session);
    }

    /**
     * 还能默写出 MyBatis的加载流程吗？
     * 1 读取配置文件
     * 2 获得SqlSessionFactor 对象
     * 3 简历对象
     * 4 获得session
     */
    @Test
    public void findAll() throws IOException {
        // 注释上  写的是 以classpaht为根目录进行读取
        List<UserVO> all = mapper.findAll();
        all.stream().forEach(s -> {
            System.out.format("name=%s == id=%d", s.getUsername(), s.getId());
        });
    }

    @Test
    public void findByCondition() {
        UserVO userVO = new UserVO();
        userVO.setId(4);
        List<UserVO> byCondition = mapper.findByCondition(userVO);
        byCondition.stream().forEach(s -> {
            System.out.println("s.getUsername() = " + s.getUsername());
        });
    }

    @Test
    public void insert() {
        UserVO userVO = new UserVO();
        userVO.setAddress("nanchang");
        userVO.setUsername("ljw");
        userVO.setBirthday(null);
        mapper.insert(userVO);
        System.out.println(userVO);
    }

    @Test
    public void delete() {
        UserVO userVO = new UserVO();
        userVO.setId(18);
        mapper.delete(userVO);
    }

    /**
     * UserVO selectOne(String username);
     * username = #{username}
     */

    @Test
    public void selectOne() {
        UserVO payphone = mapper.selectOne("payphone");
        System.out.println(payphone);
    }

    /**
     * * <p>
     * UserVO selectOne2(@Param("username") String name);
     * username = #{username}
     */
    @Test
    public void selectOne2() {
        UserVO payphone = mapper.selectOne2("payphone");
        System.out.println(payphone);
    }

    /**
     * <p>
     * UserVO selectOne3(String name);
     * username = #{value}
     */
    @Test
    public void selectOne3() {
        UserVO payphone = mapper.selectOne3("payphone");
        System.out.println(payphone);
    }

    @Test
    public void selectOne4() {
        UserVO payphone = mapper.selectOne4("payphone");
        System.out.println(payphone);
    }

    /**
     * 步骤多  看起来麻烦 实际上的确是很麻烦，但是可以多种组合，拓展性强
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlConfig.xml");
        // 创建sessionFactory构建器
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 创建Session工厂
        SqlSessionFactory build = builder.build(in);
        // 获得sqlSession
        SqlSession sqlSession = build.openSession();
        // 创建代理mapper对象
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        // 执行查询方法
        List<UserVO> all = mapper.findAll();
        if (all == null) {
            return;
        }
        // 遍历查询到的数据
        all.stream().forEach(System.out::println);
        // 条件查询
        UserVO userVO = new UserVO();
        userVO.setId(2);
        List<UserVO> byCondition = mapper.findByCondition(userVO);
        byCondition.stream().forEach(System.out::println);
        sqlSession.close();
    }
}
