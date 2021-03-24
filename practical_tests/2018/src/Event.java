import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeSet;

public class Event {
    private String title;
    private String date;
    private String description;
    private TreeSet<Person> persons;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Event(String title){
        this(title, "", "");
    }

    public Event(String title, String date){
        this(title, date, "");
    }

    public Event(String title, String date, String description){
        this.title = title;
        this.date = date;
        this.description = description;
        this.persons = new TreeSet<>();
    }

    public Event(Event e){
        this.title = e.getTitle();
        this.description = e.getDescription();
        this.date = e.getDate();
        this.persons = new TreeSet<>(e.getPersons());
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " is a " + description + " and will be held at " + date + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return getTitle().equals(event.getTitle()) && getDate().equals(event.getDate()) && getDescription().equals(event.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDate(), getDescription());
    }

    public TreeSet<Person> getPersons() {
        return persons;
    }

    public void addPerson(Person p){
        this.persons.add(p);
    }

    public int getAudienceCount(){
        int count = 0;
        for (Person p : persons) {
            count++;
        }
        return count;
    }
}
