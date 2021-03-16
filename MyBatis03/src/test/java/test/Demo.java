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
import java.util.ArrayList;
import java.util.List;

public class Demo {
    InputStream in = null;
    SqlSessionFactoryBuilder builder = null;
    SqlSessionFactory factory = null;
    SqlSession sqlSession = null;
    IUserDao mapper = null;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlConfig.xml");
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(IUserDao.class);
    }


    @Test
    public void findAll() {
        List<UserVO> all = mapper.findAll();
    }

    /**
     * 测试事务
     */
    @Test
    public void affairs() {
        sqlSession.commit(false);
        Integer delete = mapper.delete(5);
        System.out.println(delete);
        sqlSession.commit();// 提交事务后数据才会真的删除。 // 对比数据库中的信息查看即可。
    }

    /**
     * 测试动态SQL ==> if
     */
    @Test
    public void testIf() {
        // 查出四条数据
        List<UserVO> condition = mapper.findCondition(new UserVO(null, null, null));
        // 查出三条数据
        List<UserVO> o = mapper.findCondition(new UserVO(null, "o", null));
    }

    /**
     * 测试where，会去掉前面多余的and
     */
    @Test
    public void testWhere() {
        // 查出四条数据
        List<UserVO> condition = mapper.findCondition2(new UserVO(null, null, null));
        // 查出三条数据
        List<UserVO> o = mapper.findCondition2(new UserVO(null, "o", null));
    }

    /**
     * 测试set，会去掉末尾多余的 逗号(,)
     */
    @Test
    public void testSet() {
        boolean kkx = mapper.update(new UserVO(2, "kkx", null));
        sqlSession.commit();
    }

    /**
     * 批量新增
     */
    @Test
    public void testForeach1() {
        ArrayList<UserVO> userVOS = new ArrayList<>();
        userVOS.add(new UserVO(null, "001", "1988-11-11"));
        userVOS.add(new UserVO(null, "002", "1988-02-01"));
        userVOS.add(new UserVO(null, "003", "1999-11-11"));
        userVOS.add(new UserVO(null, "004", "1995-02-21"));
        Long aLong = mapper.insertBatch(userVOS);
        System.out.println(aLong);
        sqlSession.commit();
        findAll();
    }

    /**
     * 循环删除
     */
    @Test
    public void testForeach2() {
        Integer[] ids = {10, 11, 12, 13};
        Long aLong = mapper.deleteBatch(ids);
        System.out.println(aLong);
        sqlSession.commit();
    }


    @After
    public void destroy() throws IOException {
        sqlSession.close();
        in.close();
    }
}
