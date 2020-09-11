package by.shibaev.task2.main;

import by.shibaev.task2.entity.Auto;
import by.shibaev.task2.entity.Order;
import by.shibaev.task2.entity.Person;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Person("Gundatev",12));
        System.out.println(Person.manCounter);

        Order order = new Order("vasia");
        order.add(new Auto("mira", "audi", 2000));
        System.out.println(order);
    }
}
