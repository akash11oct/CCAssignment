package practice.CCAssignment.ch3;

import java.util.LinkedList;

/**
 * This class implements an Animal Shelter that holds dogs and cats. The purpose
 * of this class is to return cats or dogs strictly based on FIFO order. You can
 * get the oldest dog, or oldest cat, or oldest animal. This class keeps track
 * of arrival time for each cat and dog.
 * 
 * The class uses a separate queue for cats and dogs. 
 * @author Akash Gandotra
 */
class AnimalShelter{
    private LinkedList<Cat> cats;
    private LinkedList<Dog> dogs;
    private int time;
    
    public AnimalShelter(){
        cats = new LinkedList<Cat>();
        dogs = new LinkedList<Dog>();
        time = 0;
    }
    
    /**
     * Enqueue an animal.
     * Track the arrival time and then add to the specific queue based on 
     * whether it's a cat or a dog.
     * 
     * @param a animal to be enqueued
     */
    public void enqueue(Animal a){
        if(a == null)
            return;
        time++;
        a.setArrivalTime(time);
        if(a instanceof Cat){
            cats.addFirst((Cat)a);
        }
        if(a instanceof Dog){
            dogs.addFirst((Dog)a);
        }
    }
    
    /**
     * Return the oldest cat.
     * 
     * @return oldest cat
     */
    public Cat dequeueCat(){
        if(cats.isEmpty())
            return null;
        return cats.removeLast();
    }
    
    /**
     * Return the oldest dog.
     * 
     * @return oldest dog
     */    
    public Dog dequeueDog(){
        if(dogs.isEmpty())
            return null;
        return dogs.removeLast();        
    }
    
    /**
     * Return the oldest animal.
     * Check and return the older one from the oldest cat or oldest dog using
     * arrival times.
     * 
     * @return oldest animal
     */        
    public Animal dequeueAny(){
        if(cats.isEmpty() && dogs.isEmpty())
            return null;
        if(cats.isEmpty())
            return dogs.getLast();
        if(dogs.isEmpty())
            return cats.getLast();
        
        Cat oldestCat = cats.getLast();
        Dog oldestDog = dogs.getLast();
        if(oldestCat.getArrivalTime()<oldestDog.getArrivalTime())
           return dequeueCat();
        return dequeueDog();        
    }
}

/**
 * This class implements an animal and tracks the name, breed and arrival time
 * for animal in the shelter.
 */
abstract class Animal{
    public String petName;
    public String breed;
    private int arrivalTime;
    
    public Animal(){
    }
    
    public Animal(String name){
        petName = name;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}

/**
 * This class implements a dog.
 */
class Dog extends Animal{
    public Dog(){
    }    
    public Dog(String name){
        super(name);
    }    
    public Dog(String name, String breed){
        super(name);
        setBreed(breed);
    }    

    @Override
    public String toString() {
        return petName + " is a dog. He is a " + breed;
    }
}


/**
 * This class implements a cat.
 */
class Cat extends Animal{
    public Cat(){
    }    
    public Cat(String name){
        super(name);
    }        
    public Cat(String name, String breed){
        super(name);
        setBreed(breed);
    }    

    @Override
    public String toString() {
        return petName + " is a cat. She is a " + breed;
    }
}

public class Solution06 {
    
    public static void main(String args[]){
        AnimalShelter pets = new AnimalShelter();
        pets.enqueue(new Dog("Pluto", "Golden Retriever"));
        pets.enqueue(new Cat("Buffy", "Bengal Cat"));
        pets.enqueue(new Cat("Daisy","Sphynx Cat"));
        pets.enqueue(new Cat("Fuzzy", "RagDoll"));
        pets.enqueue(new Dog("Max", "German Shepherd"));
        pets.enqueue(new Dog("Bear", "Labrador"));
        System.out.println(pets.dequeueAny());
        System.out.println(pets.dequeueAny());
        System.out.println(pets.dequeueDog());
        System.out.println(pets.dequeueCat());
    }    
}