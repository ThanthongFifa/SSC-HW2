package io.muic.ooc.fab;

import java.util.List;
import java.util.Random;

public abstract class Actor {

    // Whether the actor is alive or not.
    private boolean alive = true;

    // The actor's position.
    private Location location;

    // The field occupied.
    private Field field;

    private int age = 0;

    private static final Random RANDOM = new Random();

    public Actor(boolean randomAge ,Field field, Location location) {
        setField(field);
        setLocation(location);
        if (randomAge) {
            setAge(RANDOM.nextInt(getMaxAge()));
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    protected abstract int getMaxAge();{}

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Location getLocation() {
        return location;
    }

    protected void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    protected void setDead() {
        setAlive(false);
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    public abstract void act(List<Actor> newActors);


}