package io.muic.ooc.fab;

import java.lang.reflect.InvocationTargetException;

public class AnimalFatory {

    public static Animal createAnimal(AnimalType animalType,boolean randomAge, Field field, Location location){
        try {
            return animalType.getAimalClass().getDeclaredConstructor(boolean.class, Field.class, Location.class).newInstance(randomAge, field, location);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Unknow animal type");
    }
}
