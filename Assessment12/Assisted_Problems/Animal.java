import java.util.*;
class Animal {
    String name;
    int age;
    
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    void makeSound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }
    
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }
    
    @Override
    void makeSound() {
        System.out.println("Cat meows");
    }
}

class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }
    
    @Override
    void makeSound() {
        System.out.println("Bird chirps");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Animal("Generic Animal", 5);
        a1.makeSound();
        
        Animal a2 = new Dog("Pluto", 3);
        a2.makeSound();
        
        Animal a3 = new Cat("Katori", 2);
        a3.makeSound();
        
        Animal a4 = new Bird("Tweety", 1);
        a4.makeSound();
    }
}
