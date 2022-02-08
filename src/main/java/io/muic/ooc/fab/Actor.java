package io.muic.ooc.fab;

import java.util.List;

public abstract class Actor {

    // Whether the actor is alive or not.
    private boolean alive = true;

    // The actor's position.
    private Location location;

    // The field occupied.
    private Field field;

    public Actor(Field field, Location location) {
        setField(field);
        setLocation(location);
    }

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