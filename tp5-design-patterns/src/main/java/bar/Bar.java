package bar;

import java.util.ArrayList;

public abstract class Bar {
    private boolean happyHour;
    private final ArrayList<BarObserver> observers;

    public Bar(){
        this.happyHour = false;
        this.observers = new ArrayList<BarObserver>();
    }

    public boolean isHappyHour() {
        return happyHour;
    }

    public void startHappyHour() {
        happyHour = true;
        notifyObservers();
    }

    public void endHappyHour() {
        happyHour = false;
        notifyObservers();
    }

    public void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (BarObserver observer : observers){
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
        }
    }

}
