import com.bbxx.dao.IUserDao;
import com.bbxx.pojo.UserVO;
import com.bbxx.utils.ConnectUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {

    /**
     * 还能默写出 MyBatis的加载流程吗？
     * 1 读取配置文件
     * 2 获得SqlSessionFactor 对象
     * 3 简历对象
     * 4 获得session
     */

    @Test
    public void fn1() throws IOException {
        ConcurrentHashMap
        // 注释上  写的是 以classpaht为根目录进行读取
        SqlSession sqlSession = ConnectUtils.getSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<UserVO> all = mapper.findAll();
        all.stream().forEach(s -> {
            System.out.format("name is,%s", s.getUsername());
        });
        ConnectUtils.closeSession(sqlSession);
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
