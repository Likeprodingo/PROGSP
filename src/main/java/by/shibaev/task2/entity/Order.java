package by.shibaev.task2.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Order {
    private List<Auto> order;
    private String name;

    public Order(String name) {
        this.name = name;
        order = new ArrayList<>();
    }

    public Order() {
    }

    public List<Auto> getOrder() {
        return Collections.unmodifiableList(order);
    }

    public void add(Auto auto) {
        order.add(auto);
    }

    public Optional<Auto> get(int i) {
        Optional<Auto> result = Optional.empty();
        if (i > 0 && i < order.size()) {
            result = Optional.of(order.get(i));
        }
        return result;
    }

    public void set(int i, Auto auto) {
        if (i > 0 && i < order.size()) {
            order.set(i, auto);
        }
    }

    public void remove(int i) {
        if (i > 0 && i < order.size()) {
            order.remove(i);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Order{");
        sb.append("order=").append(order);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
