import java.util.ArrayList;

public class Party extends Event{
    private final ArrayList<Event> events;

    public Party(String title) {
        super(title);
        this.events = new ArrayList<>();
    }

    public Party(String title, String date, String description){
        super(title, date, description);
        this.events = new ArrayList<>();
    }

    @Override
    public int getAudienceCount() {
        int count = super.getAudienceCount();
        for (Event e : events){
            count += e.getAudienceCount();
        }
        return count;
    }

    public void addEvent(Event e){
        events.add(e);
    }
}
