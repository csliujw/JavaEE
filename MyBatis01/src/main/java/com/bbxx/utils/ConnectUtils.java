package com.bbxx.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis 快速 开启session
 */
public class ConnectUtils {
    private static SqlSessionFactory factor = null;
    private static SqlSession session = null;

    static {
        try {
            InputStream in = Resources.getResourceAsStream("SqlConfig.xml");
            factor = new SqlSessionFactoryBuilder().build(in);
            session = factor.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        return session;
    }

    public static void closeSession(SqlSession session) {
        session.close();
    }
}
