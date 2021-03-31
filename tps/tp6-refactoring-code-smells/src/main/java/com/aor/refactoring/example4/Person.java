package com.aor.refactoring.example4;

import java.util.Objects;

public abstract class Person {
    protected final String name;
    protected final String phone;

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getName().equals(person.getName()) && getPhone().equals(person.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhone());
    }
}
