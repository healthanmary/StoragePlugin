package ru.healthanmary.storageplugin.storage;

import ru.healthanmary.storageplugin.User;

public interface Storage {
    User getUser(String name);
    void setUserAge(String name, int age);
}
