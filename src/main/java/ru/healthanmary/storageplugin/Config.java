package ru.healthanmary.storageplugin;

import lombok.experimental.UtilityClass;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.lang.module.Configuration;

public class Config {
    public static void load(FileConfiguration file) {
        final var mysqlSection = file.getConfigurationSection("mysql");
        if (mysqlSection == null) {
            throw new IllegalStateException("Error load mysql configuration");
        } else {
            loadMysql(mysqlSection);
        }
    }
    private static void loadMysql(ConfigurationSection mysqlSection) {
        MySQL.HOST = mysqlSection.getString("host");
        MySQL.PORT = mysqlSection.getInt("port");
        MySQL.USER = mysqlSection.getString("user");
        MySQL.PASSWORD = mysqlSection.getString("password");
        MySQL.DATABASE = mysqlSection.getString("database");
    }
    public static class MySQL {
        public static String HOST;
        public static int PORT;
        public static String USER;
        public static String PASSWORD;
        public static String DATABASE;
    }
}
