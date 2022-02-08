package io.muic.ooc.fab;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Tiger extends Animal{

    private static final int MAX_AGE = 180;
    private static final int BREEDING_AGE = 30;
    private static final double BREEDING_PROBABILITY = 0.01;
    private static final int MAX_LITTER_SIZE = 2;

    private static final int RABBIT_FOOD_VALUE = 9;
    private static final int FOX_FOOD_VALUE = 18;

    private static final Random RANDOM = new Random();

    private int foodLevel;

    @Override
    protected int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected int getBreedingAge() {
        return BREEDING_AGE;
    }

    public Tiger(boolean randomAge, Field field, Location location) {
        super(randomAge, field, location);
        this.foodLevel = RANDOM.nextInt(RABBIT_FOOD_VALUE + FOX_FOOD_VALUE);
    }

    @Override
    protected int getMaxLitSize() {
        return MAX_LITTER_SIZE;
    }

    @Override
    protected double getBreedingProb() {
        return BREEDING_PROBABILITY;
    }

    @Override
    public void act(List<Actor> newTigers) {
        incrementAge();
        incrementHunger();
        if (isAlive()) {
            giveBirth(newTigers);
            // Move towards a source of food if found.
            Location newLocation = findFood();
            if (newLocation == null) {
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                // Overcrowding.
                setDead();
            }
        }
    }

    private void incrementHunger() {
        foodLevel--;
        if (foodLevel <= 0) {
            setDead();
        }
    }

    private void giveBirth(List<Actor> newTigers) {
        List<Location> free = getField().getFreeAdjacentLocations(getLocation());
        int births = breed();
        for (int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Tiger young = new Tiger(false, getField(), loc);
            newTigers.add(young);
        }
    }

    private Location findFood() {
        List<Location> adjacent = getField().adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal = getField().getObjectAt(where);

            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    foodLevel = RABBIT_FOOD_VALUE;
                    return where;
                }
            }

            else if (animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if (fox.isAlive()) {
                    fox.setDead();
                    foodLevel = FOX_FOOD_VALUE;
                    return where;
                }
            }

        }
        return null;
    }
}
