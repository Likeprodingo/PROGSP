package by.shibaev.task3.entity.impl;

import by.shibaev.task3.entity.Entity;
import by.shibaev.task3.entity.Game;

public abstract class Quest implements Game, Entity {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
