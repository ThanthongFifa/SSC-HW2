package io.muic.ooc.fab;

public abstract class Animal {
    private int age = 0;

    protected abstract void setDead();

    protected abstract int getMaxAge();{}

    protected abstract int getBreedingAge();{}

    public void setAge(int age) {
        this.age = age;
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
     * @return true if the rabbit can breed, false otherwise.
     */
    protected boolean canBreed() {
        return getAge() >= getBreedingAge();
    }
}
