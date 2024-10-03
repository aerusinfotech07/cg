package com.cg.java8.scenarios.pet;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Pet {
    private String name;
    private String type; // e.g., Dog, Cat
    private int age;
    private String owner;

    public Pet(String name, String type, int age, String owner) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Pet{name='" + name + "', type='" + type + "', age=" + age + ", owner='" + owner + "'}";
    }
}

public class PetExample {

    private List<Pet> getPets() {
        return List.of(
                new Pet("Buddy", "Dog", 3, "Alice"),
                new Pet("Mittens", "Cat", 5, "Bob"),
                new Pet("Max", "Dog", 4, "Charlie"),
                new Pet("Whiskers", "Cat", 2, "Diana"),
                new Pet("Rex", "Dog", 6, "Ethan")
        );
    }

    public void runExamples() {
        List<Pet> petList = getPets();

        // 1. Filter: Find all dogs
        List<Pet> dogs = petList.stream()
                .filter(pet -> pet.getType().equals("Dog"))
                .collect(Collectors.toList());
        System.out.println("Dogs: " + dogs);

        // 2. Map: Get a list of pet names
        List<String> petNames = petList.stream()
                .map(Pet::getName)
                .collect(Collectors.toList());
        System.out.println("Pet names: " + petNames);

        // 3. Average Age: Calculate the average age of all pets
        double averageAge = petList.stream()
                .mapToInt(Pet::getAge)
                .average()
                .orElse(0);
        System.out.println("Average age of pets: " + averageAge);

        // 4. Grouping: Count pets by type
        Map<String, Long> petsByType = petList.stream()
                .collect(Collectors.groupingBy(Pet::getType, Collectors.counting()));
        System.out.println("Count of pets by type: " + petsByType);

        // 5. Sorted: Sort pets by age
        List<Pet> sortedPets = petList.stream()
                .sorted(Comparator.comparing(Pet::getAge))
                .collect(Collectors.toList());
        System.out.println("Pets sorted by age: " + sortedPets);
    }

    public static void main(String[] args) {
        PetExample example = new PetExample();
        example.runExamples();
    }
}
