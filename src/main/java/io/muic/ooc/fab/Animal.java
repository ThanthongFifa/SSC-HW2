package io.muic.ooc.fab;

public abstract class Animal {
    private int age = 0;
    // Whether the animal is alive or not.
    private boolean alive = true;

    protected abstract void setDead();

    protected abstract int getMaxAge();{}

    protected abstract int getBreedingAge();{}

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
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
}
