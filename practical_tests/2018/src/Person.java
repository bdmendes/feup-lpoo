import java.util.Objects;

public abstract class Person implements Comparable{
    protected String name;
    protected int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Person(String name){
        this(name, 0);
    }

    public String getName(){
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (o == null) return -1;
        Person person = (Person) o;
        return getName().compareTo(person.getName());
    }
}
