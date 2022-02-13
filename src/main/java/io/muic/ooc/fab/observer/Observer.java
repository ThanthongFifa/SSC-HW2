package io.muic.ooc.fab.observer;

import io.muic.ooc.fab.Field;

public abstract class Observer {
    protected Subject subject;
    //public abstract void update();

    public abstract void update(int step, Field field);
}
