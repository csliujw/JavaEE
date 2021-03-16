package lg.dao;


import lg.pojo.Users;

import java.sql.*;
import java.util.ArrayList;

public class JDBC {
    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC",
                "root",
                "root");
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        String sql = "select * from users";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Users> users = new ArrayList<>();
        int i = 0;
        while (resultSet.next()) {
            if (i == 100) break;
            i++;
            Users temp = new Users(resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("birthday"),
                    resultSet.getString("address"));
            users.add(temp);
            resultSet.beforeFirst();
        }
        users.stream().forEach(System.out::println);
    }
}
