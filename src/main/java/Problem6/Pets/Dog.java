/*
 * DO NOT MAKE ANY CHANGES
 */

package Problem6.Pets;

import java.util.Objects;

/*
  __      _
o'')}____//
 `_/      )
 (_(_/-(_/
 */
public class Dog extends Animal {
    private String owner; // property specific to Dog

    public Dog(String name, String gender, int age, String owner) {

        // calling the base class constructor
        super(name, gender, age);

        // setting dog specific property
        this.owner = owner;
    }

    @Override
    public void speak() {
        System.out.println("Dog " + name + " says 'Woof'");
    }

    @Override
    public void play() {
        System.out.println("Dog " + name + " is chasing the cat");
    }

    @Override
    public void play(String toy) {
        if (toy == null || toy.isEmpty()) {
            return;
        }

        System.out.println(owner + "'s dog " + getName() + " is playing with a " + toy);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        if (!super.equals(other)) {
            return false;
        }
        Dog dog = (Dog) other;
        return Objects.equals(owner, dog.owner);
    }
}


