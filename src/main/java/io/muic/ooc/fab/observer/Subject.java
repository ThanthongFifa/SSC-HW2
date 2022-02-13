package io.muic.ooc.fab.observer;

import io.muic.ooc.fab.Field;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void attach (Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers(int step, Field field){
        for (Observer observer: observers) {
            observer.update(step, field);
        }
    }

}
