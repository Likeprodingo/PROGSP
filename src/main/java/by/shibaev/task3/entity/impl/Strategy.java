package by.shibaev.task3.entity.impl;

import by.shibaev.task3.entity.Entity;
import by.shibaev.task3.entity.Game;

public class Strategy implements Entity, Game {

    private int unitNumber;
    private int mapNumber;
    private boolean isReady;

    public Strategy() {
    }

    public Strategy(int unitNumber, int mapNumber) {
        this.unitNumber = unitNumber;
        this.mapNumber = mapNumber;
    }

    public Strategy(int unitNumber, int mapNumber, boolean isReady) {
        this.unitNumber = unitNumber;
        this.mapNumber = mapNumber;
        this.isReady = isReady;
    }

    @Override
    public String print() {
        return toString();
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public int getMapNumber() {
        return mapNumber;
    }

    public void setMapNumber(int mapNumber) {
        this.mapNumber = mapNumber;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Strategy strategy = (Strategy) o;

        if (unitNumber != strategy.unitNumber) return false;
        if (mapNumber != strategy.mapNumber) return false;
        return isReady == strategy.isReady;
    }

    @Override
    public int hashCode() {
        int result = unitNumber;
        result = 31 * result + mapNumber;
        result = 31 * result + (isReady ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Strategy{");
        sb.append("unitNumber=").append(unitNumber);
        sb.append(", mapNumber=").append(mapNumber);
        sb.append(", isReady=").append(isReady);
        sb.append('}');
        return sb.toString();
    }
}
