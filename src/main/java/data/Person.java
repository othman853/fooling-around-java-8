package data;

import java.time.LocalDate;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class Person {

    private final String name;
    private final Optional<LocalDate> dateOfBirth;
    private final double weight;
    private final double height;
    private final boolean married;

    private Person(String name, Optional<LocalDate> dateOfBirth, double weight, double height, boolean married) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
        this.married = married;
    }

    public static Person someone() {
        return new Person("", empty(), 0, 0, false);
    }

    public Person named(String name) {
        return new Person(name, dateOfBirth, weight, height, false);
    }

    public Person born(LocalDate dateOfBirth) {
        return new Person(this.name, of(dateOfBirth), weight, height, false);
    }

    public Person weighing(double weight) {
        return new Person(name, dateOfBirth, weight, height, false);
    }

    public Person thisTall(double height) {
        return new Person(name, dateOfBirth, weight, height, false);
    }

    public Person married() {
        return new Person(name, dateOfBirth, weight, height, true);
    }


    public String name() {
        return name;
    }

    public Optional<LocalDate> dateOfBirth() {
        return dateOfBirth;
    }

    public double weight() {
        return weight;
    }

    public double height() {
        return height;
    }

    public boolean isMarried() {
        return married;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("data.Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", weight=").append(weight);
        sb.append(", height=").append(height);
        sb.append('}');
        return sb.toString();
    }
}
