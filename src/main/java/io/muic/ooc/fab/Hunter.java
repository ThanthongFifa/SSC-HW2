package io.muic.ooc.fab;

import java.util.Iterator;
import java.util.List;

public class Hunter extends Actor{
    private static final int MAX_AGE = 999999;

    public Hunter( boolean randomAge,Field field, Location location) {
        super(randomAge, field, location);
    }

    @Override
    protected int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    public void act(List<Actor> newActors) {
        if (isAlive()){
            Location newlocation = hunt();
            if (newlocation == null) {
                newlocation = getField().freeAdjacentLocation(getLocation());
            }
            if (newlocation != null) {
                setLocation(newlocation);
            }
        }
    }

    private Location hunt() {
        List<Location> adjacent = getField().adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal = getField().getObjectAt(where);

            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    return where;
                }
            }

            else if (animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if (fox.isAlive()) {
                    fox.setDead();
                    return where;
                }
            }

            else if (animal instanceof Tiger) {
                Tiger tiger = (Tiger) animal;
                if (tiger.isAlive()) {
                    tiger.setDead();
                    return where;
                }
            }

        }
        return null;
    }


}
