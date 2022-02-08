package io.muic.ooc.fab;

import java.awt.Color;

public enum ActorType {

    RABBIT(Rabbit.class, Color.ORANGE, 0.08),
    FOX(Fox.class, Color.BLUE, 0.02),
    TIGER(Tiger.class, Color.RED, 0.01);

    private Class<? extends Actor> actorClass;

    private Color color;

    private double prob;

    ActorType(Class<? extends Actor> actorClass, Color color, double prob) {
        this.actorClass = actorClass;
        this.color = color;
        this.prob = prob;
    }

    public Class<? extends Actor> getActorClass() {
        return actorClass;
    }

    public Color getColor() {
        return color;
    }

    public double getProb() {
        return prob;
    }
}
