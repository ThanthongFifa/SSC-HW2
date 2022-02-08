package io.muic.ooc.fab;

import java.awt.Color;

public enum AnimalType {

    RABBIT(Rabbit.class, Color.ORANGE, 0.08),
    FOX(Fox.class, Color.BLUE, 0.02),
    TIGER(Tiger.class, Color.RED, 0.01);

    private Class<? extends Animal> aimalClass;

    private Color color;

    private double prob;

    AnimalType(Class<? extends Animal> aimalClass, Color color, double prob) {
        this.aimalClass = aimalClass;
        this.color = color;
        this.prob = prob;
    }

    public Class<? extends Animal> getAimalClass() {
        return aimalClass;
    }

    public Color getColor() {
        return color;
    }

    public double getProb() {
        return prob;
    }
}
