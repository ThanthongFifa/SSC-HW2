package io.muic.ooc.fab;

import java.util.List;
import java.util.Random;

public abstract class Animal extends Actor {
    // A shared random number generator to control breeding.
    private static final Random RANDOM = new Random();

    private int age = 0;



    protected abstract int getBreedingAge();{}

    public Animal(boolean randomAge, Field field, Location location) {
        super(randomAge, field, location);
    }


    public int getAge() {
        return age;
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

    }
