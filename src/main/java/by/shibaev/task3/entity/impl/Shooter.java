package by.shibaev.task3.entity.impl;

import by.shibaev.task3.entity.Entity;
import by.shibaev.task3.entity.Game;

public class Shooter implements Game, Entity {

    private String gunModel;
    private int levelNumber;

    public Shooter() {
    }

    public Shooter(String gunModel, int levelNumber) {
        this.gunModel = gunModel;
        this.levelNumber = levelNumber;
    }

    @Override
    public String print() {
        return toString();
    }

    public String getGunModel() {
        return gunModel;
    }

    public void setGunModel(String gunModel) {
        this.gunModel = gunModel;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shooter shooter = (Shooter) o;

        if (levelNumber != shooter.levelNumber) return false;
        return gunModel != null ? gunModel.equals(shooter.gunModel) : shooter.gunModel == null;
    }

    @Override
    public int hashCode() {
        int result = gunModel != null ? gunModel.hashCode() : 0;
        result = 31 * result + levelNumber;
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Shooter{");
        sb.append("gunModel='").append(gunModel).append('\'');
        sb.append(", levelNumber=").append(levelNumber);
        sb.append('}');
        return sb.toString();
    }
}
