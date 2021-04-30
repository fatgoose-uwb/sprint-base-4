/*
 * DO NOT MAKE ANY CHANGES
 */

package Problem6.Pets;

public abstract class Animal implements Action, Comparable<Animal> {

    protected String name;
    protected String gender;
    protected int age;

    /*
    setters and getters to allow access from outside
     */
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // constructor
    public Animal(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Animal)) {
            return false;
        }

        Animal otherAnimal = (Animal) obj;
        return this.name.equals(otherAnimal.name) &&
                this.gender.equals(otherAnimal.gender) &&
                this.age == otherAnimal.age;
    }

    @Override
    public String toString() {
        return "name:" + name + ", gender:" + gender + ", age:" + age;
    }

    @Override
    public int compareTo(Animal other) {
        return this.age - other.age;
    }
}
