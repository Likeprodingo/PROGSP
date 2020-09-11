package by.shibaev.task2.entity;

public class Person {
    private String surname;
    private int age;
    private boolean isMale;
    public static int manCounter = 0;

    public Person() {
    }

    public Person(String surname, int age) {
        this.surname = surname;
        this.age = age;
        isMale = true;
        manCounter++;
    }

    public Person(String surname, int age, boolean isMale) {
        this.surname = surname;
        this.age = age;
        this.isMale = isMale;
        if (isMale) {
            manCounter++;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (isMale != person.isMale) return false;
        return surname != null ? surname.equals(person.surname) : person.surname == null;
    }

    @Override
    public int hashCode() {
        int result = surname != null ? surname.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (isMale ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("surname='").append(surname).append('\'');
        sb.append(", age=").append(age);
        sb.append(", isMale=").append(isMale);
        sb.append('}');
        return sb.toString();
    }
}
