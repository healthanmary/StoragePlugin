package ru.healthanmary.storageplugin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class User {
    private String name;
    private int age;
}
