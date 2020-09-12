package by.shibaev.task4.tcp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Schedule {
    private List<Subject> schedule;

    public Schedule() {
        schedule = new ArrayList<>();
    }

    public List<Subject> getSchedule() {
        return Collections.unmodifiableList(schedule);
    }

    public void add(Subject subject) {
        schedule.add(subject);
    }

    public Optional<Subject> get(String name) {
        Optional<Subject> subject = Optional.empty();
        for (Subject s : schedule) {
            if (s.getName().equals(name)) {
                subject = Optional.of(s);
            }
        }
        return subject;
    }

    public void remove(String name) {
        schedule.removeIf(s -> s.getName().equals(name));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schedule schedule1 = (Schedule) o;

        return schedule != null ? schedule.equals(schedule1.schedule) : schedule1.schedule == null;
    }

    @Override
    public int hashCode() {
        return schedule != null ? schedule.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Schedule{");
        sb.append("schedule=").append(schedule);
        sb.append('}');
        return sb.toString();
    }
}
