package io.muic.ooc.fab;

import java.lang.reflect.InvocationTargetException;

public class ActorFactory {

    public static Actor createActor(ActorType actorType, boolean randomAge, Field field, Location location){
        try {
            return actorType.getActorClass().getDeclaredConstructor(boolean.class, Field.class, Location.class).newInstance(randomAge, field, location);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Unknow actor type");
    }
}
