package by.shibaev.task2.entity;

public class Auto {
    private String model;
    private String producer;
    private int year;

    public Auto(){
    }

    public Auto(String model, String producer, int year) {
        this.model = model;
        this.producer = producer;
        this.year = year;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Auto{");
        sb.append("model='").append(model).append('\'');
        sb.append(", producer='").append(producer).append('\'');
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auto auto = (Auto) o;

        if (year != auto.year) return false;
        if (model != null ? !model.equals(auto.model) : auto.model != null) return false;
        return producer != null ? producer.equals(auto.producer) : auto.producer == null;
    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }
}
