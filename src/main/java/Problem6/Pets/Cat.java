/*
 * DO NOT MAKE ANY CHANGES
 */

package Problem6.Pets;

/*
    |\__/,|   (`\
  _.|o o  |_   ) )
-(((---(((--------
 */
public class Cat extends Animal {

    // Constructor
    public Cat(String name, String gender, int age) {
        // calling the base class constructor
        super(name, gender, age);
    }

    // cat specific method
    void purr() {
        System.out.println("Cat " + name + ": Purrrrrrr...");
    }

    @Override   // what does this @Override do?
    public void speak() {
        System.out.println("Cat " + name + " says 'Meow (I'm hungry)!'");
    }

    @Override
    public void play() {
        System.out.println("Cat " + name + " jumps on a kitchen table");
    }

    // an overload of function play() with different argument(s)
    // this also override Animal.play(String)
    @Override
    public void play(String toy) {
        if (toy == null || toy.isEmpty()) {
            return;
        }
        System.out.println("Cat " + getName() + " is playing with " + toy);
    }
}


