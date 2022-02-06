package io.muic.ooc.fab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Populator {

    private static final Random RANDOM = new Random();

    private Map<AnimalType, Double> probMap = new HashMap<>(){{
        AnimalType[] animalTypes = AnimalType.values();
        for( int i = 0; i < animalTypes.length; i++){
            put(animalTypes[i],animalTypes[i].getProb());
        }
    }};

    void populate(Field field, List<Animal> animals) {
        field.clear();
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                for (Map.Entry<AnimalType, Double> entry : probMap.entrySet()) {
                    if (RANDOM.nextDouble() <= entry.getValue()){
                        Location location = new Location(row, col);
                        Animal animal = AnimalFatory.createAnimal(entry.getKey(), true, field, location);
                        animals.add(animal);
                        break;
                    }
                }
            }
        }
    }


}
