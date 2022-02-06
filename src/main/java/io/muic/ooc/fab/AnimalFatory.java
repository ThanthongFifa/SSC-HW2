package io.muic.ooc.fab;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class AnimalFatory {

    private static final Map<AnimalType, Class<? extends Animal>> ANIMAL_MAPPING = new HashMap<>();

    //add new animal here
    static {
        ANIMAL_MAPPING.put(AnimalType.RABBIT, Rabbit.class);
        ANIMAL_MAPPING.put(AnimalType.FOX, Fox.class);

    }

    public static Animal createAnimal(AnimalType animalType,boolean randomAge, Field field, Location location){
        try {
            return ANIMAL_MAPPING.get(animalType).getDeclaredConstructor(boolean.class, Field.class, Location.class).newInstance(randomAge, field, location);
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
