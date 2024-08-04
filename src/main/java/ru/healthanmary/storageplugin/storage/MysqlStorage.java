package ru.healthanmary.storageplugin.storage;

import ru.healthanmary.storageplugin.Config;
import ru.healthanmary.storageplugin.User;

import java.sql.*;

public class MysqlStorage implements Storage {
                 // jdbc:mysql://hostname:port/database
    private String url = "jdbc:mysql://"+ Config.MySQL.HOST+":"+Config.MySQL.PORT+"/"+Config.MySQL.DATABASE;

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, Config.MySQL.USER, Config.MySQL.PASSWORD);
    }
    @Override
    public User getUser(String name) {
        try (Connection conn = createConnection()) {
            final PreparedStatement ps = conn.prepareStatement("""
                    SELECT * FROM test
                    WHERE `name` = ?
                    """);

            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                final int age = rs.getInt("age");

                return new User(name, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setUserAge(String name, int age) {
    }
}