package ru.healthanmary.storageplugin;

import org.bukkit.plugin.java.JavaPlugin;
import ru.healthanmary.storageplugin.storage.MysqlStorage;
import ru.healthanmary.storageplugin.storage.Storage;
import ru.healthanmary.storageplugin.storage.getDbUser;

public final class StoragePlugin extends JavaPlugin {
    private Storage storage;

    @Override
    public void onEnable() {
        storage = new MysqlStorage();
        getLogger().info("StoragePlugin enable");
        getCommand("getdbuser").setExecutor(new getDbUser(storage));
    }
    @Override
    public void onDisable() {
        getLogger().info("StoragePlugin disable");
    }
}
