package io.muic.ooc.fab;

import java.util.List;
import java.util.Random;

public abstract class Animal {
    // A shared random number generator to control breeding.
    private static final Random RANDOM = new Random();

    private int age = 0;
    // Whether the animal is alive or not.
    private boolean alive = true;
    // The animal's position.
    private Location location;
    // The field occupied.
    private Field field;

    protected abstract int getMaxAge();{}

    protected abstract int getBreedingAge();{}

    public Animal(boolean randomAge, Field field, Location location) {
        this.field = field;
        setLocation(location);
        if (randomAge) {
            setAge(RANDOM.nextInt(getMaxAge()));
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Field getField() {
        return field;
    }

    public Location getLocation() {
        return location;
    }


    /**
     * Increase the age. This could result in the animal's death.
     */
    protected void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            setDead();
        }
    }

    /**
     * A animal can breed if it has reached the breeding age.
     *
     * @return true if the animal can breed, false otherwise.
     */
    protected boolean canBreed() {
        return getAge() >= getBreedingAge();
    }

    /**
     * Check whether the animal is alive or not.
     *
     * @return true if the animal is still alive.
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Place the rabbit at the new location in the given field.
     *
     * @param newLocation The rabbit's new location.
     */
    protected void setLocation(Location newLocation) {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Indicate that the rabbit is no longer alive. It is removed from the
     * field.
     */
    protected void setDead() {
        setAlive(false);
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Generate a number representing the number of births, if it can breed.
     *
     * @return The number of births (may be zero).
     */
    protected int breed() {
        int births = 0;
        if (canBreed() && RANDOM.nextDouble() <= getBreedingProb()) {
            births = RANDOM.nextInt(getMaxLitSize()) + 1;
        }
        return births;
    }

    protected abstract int getMaxLitSize();

    protected abstract double getBreedingProb();

    public abstract void act(List<Animal> newAnimals);


    }
