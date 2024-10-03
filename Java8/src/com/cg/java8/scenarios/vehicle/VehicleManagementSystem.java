package com.cg.java8.scenarios.vehicle;

import java.util.*;
import java.util.stream.Collectors;

class Vehicle {
    private String licensePlate;
    private String model;
    private int year;
    private double price;

    public Vehicle(String licensePlate, String model, int year, double price) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return model + " (" + year + ") - " + licensePlate + " - $" + price;
    }
}

class Car extends Vehicle {
    private String bodyStyle;

    public Car(String licensePlate, String model, int year, double price, String bodyStyle) {
        super(licensePlate, model, year, price);
        this.bodyStyle = bodyStyle;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    @Override
    public String toString() {
        return "Car: " + super.toString() + " - Body Style: " + bodyStyle;
    }
}

class Truck extends Vehicle {
    private double payloadCapacity;

    public Truck(String licensePlate, String model, int year, double price, double payloadCapacity) {
        super(licensePlate, model, year, price);
        this.payloadCapacity = payloadCapacity;
    }

    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    @Override
    public String toString() {
        return "Truck: " + super.toString() + " - Payload Capacity: " + payloadCapacity + " lbs";
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String licensePlate, String model, int year, double price, boolean hasSidecar) {
        super(licensePlate, model, year, price);
        this.hasSidecar = hasSidecar;
    }

    public boolean hasSidecar() {
        return hasSidecar;
    }

    @Override
    public String toString() {
        return "Motorcycle: " + super.toString() + " - Sidecar: " + (hasSidecar ? "Yes" : "No");
    }
}

class Owner {
    private String name;
    private List<Vehicle> vehicles;

    public Owner(String name) {
        this.name = name;
        this.vehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public String toString() {
        return name + " (Vehicles: " + vehicles.size() + ")";
    }
}

public class VehicleManagementSystem {
    public static void main(String[] args) {
        // Create owners
        Owner alice = new Owner("Alice");
        Owner bob = new Owner("Bob");
        Owner charlie = new Owner("Charlie");

        // Create vehicles
        Car car1 = new Car("ABC123", "Toyota Camry", 2020, 24000, "Sedan");
        Car car2 = new Car("XYZ789", "Honda Accord", 2019, 22000, "Coupe");
        Truck truck1 = new Truck("LMN456", "Ford F-150", 2021, 30000, 2000);
        Motorcycle motorcycle1 = new Motorcycle("JKL012", "Harley Davidson", 2018, 15000, false);
        Motorcycle motorcycle2 = new Motorcycle("DEF345", "Yamaha", 2022, 12000, true);

        // Assign vehicles to owners
        alice.addVehicle(car1);
        alice.addVehicle(motorcycle1);
        bob.addVehicle(car2);
        bob.addVehicle(truck1);
        charlie.addVehicle(motorcycle2);

        List<Owner> owners = Arrays.asList(alice, bob, charlie);

        // 1. Print all vehicles owned by each owner
        owners.forEach(owner -> {
            System.out.println(owner);
            owner.getVehicles().forEach(System.out::println);
        });

        // 2. Filter vehicles based on price greater than $20,000
        List<Vehicle> expensiveVehicles = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v.getPrice() > 20000)
            .collect(Collectors.toList());
        System.out.println("Expensive Vehicles: " + expensiveVehicles);

        // 3. Calculate the total price of all vehicles
        double totalPrice = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .mapToDouble(Vehicle::getPrice)
            .sum();
        System.out.println("Total Price of All Vehicles: $" + totalPrice);

        // 4. Count total number of vehicles
        long totalVehiclesCount = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .count();
        System.out.println("Total Number of Vehicles: " + totalVehiclesCount);

        // 5. Get a list of all vehicle models
        List<String> vehicleModels = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .map(Vehicle::getModel)
            .collect(Collectors.toList());
        System.out.println("Vehicle Models: " + vehicleModels);

        // 6. Find the most expensive vehicle
        Optional<Vehicle> mostExpensiveVehicle = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .max(Comparator.comparingDouble(Vehicle::getPrice));
        mostExpensiveVehicle.ifPresent(v -> System.out.println("Most Expensive Vehicle: " + v));

        // 7. Group vehicles by year
        Map<Integer, List<Vehicle>> vehiclesByYear = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .collect(Collectors.groupingBy(Vehicle::getYear));
        System.out.println("Vehicles Grouped by Year: " + vehiclesByYear);

        // 8. Find all vehicles owned by Alice
        List<Vehicle> alicesVehicles = owners.stream()
            .filter(o -> o.getName().equals("Alice"))
            .flatMap(owner -> owner.getVehicles().stream())
            .collect(Collectors.toList());
        System.out.println("Alice's Vehicles: " + alicesVehicles);

        // 9. Check if any vehicle is older than 10 years
        boolean anyOldVehicles = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .anyMatch(v -> (2024 - v.getYear()) > 10);
        System.out.println("Any Vehicles Older Than 10 Years: " + anyOldVehicles);

        // 10. Sort vehicles by price
        List<Vehicle> sortedByPrice = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .sorted(Comparator.comparingDouble(Vehicle::getPrice))
            .collect(Collectors.toList());
        System.out.println("Vehicles Sorted by Price: " + sortedByPrice);

        // 11. Join vehicle models into a single string
        String joinedModels = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .map(Vehicle::getModel)
            .collect(Collectors.joining(", "));
        System.out.println("Joined Vehicle Models: " + joinedModels);

        // 12. Find the total number of trucks
        long totalTrucks = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v instanceof Truck)
            .count();
        System.out.println("Total Number of Trucks: " + totalTrucks);

        // 13. Find vehicles with a specific license plate
        String searchPlate = "ABC123";
        Optional<Vehicle> vehicleByPlate = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v.getLicensePlate().equals(searchPlate))
            .findFirst();
        vehicleByPlate.ifPresent(v -> System.out.println("Vehicle Found: " + v));

        // 14. Find all vehicles with sidecars
        List<Vehicle> vehiclesWithSidecars = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v instanceof Motorcycle && ((Motorcycle) v).hasSidecar())
            .collect(Collectors.toList());
        System.out.println("Vehicles with Sidecars: " + vehiclesWithSidecars);

        // 15. Get the average price of all vehicles
        double averagePrice = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .mapToDouble(Vehicle::getPrice)
            .average()
            .orElse(0);
        System.out.println("Average Price of Vehicles: $" + averagePrice);

        // 16. List all vehicles manufactured after 2015
        List<Vehicle> recentVehicles = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v.getYear() > 2015)
            .collect(Collectors.toList());
        System.out.println("Vehicles Manufactured After 2015: " + recentVehicles);

        // 17. Count how many vehicles each owner has
        Map<String, Long> ownerVehicleCount = owners.stream()
            .collect(Collectors.toMap(Owner::getName, owner -> (long) owner.getVehicles().size()));
        System.out.println("Owner Vehicle Count: " + ownerVehicleCount);

        // 18. List vehicles sorted by year and then by price
        List<Vehicle> sortedByYearAndPrice = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .sorted(Comparator.comparingInt(Vehicle::getYear).thenComparingDouble(Vehicle::getPrice))
            .collect(Collectors.toList());
        System.out.println("Vehicles Sorted by Year and Price: " + sortedByYearAndPrice);

        // 19. Find the least expensive vehicle
        Optional<Vehicle> leastExpensiveVehicle = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .min(Comparator.comparingDouble(Vehicle::getPrice));
        leastExpensiveVehicle.ifPresent(v -> System.out.println("Least Expensive Vehicle: " + v));

        // 20. Print vehicle details of each owner
        owners.forEach(owner -> {
            System.out.println(owner.getName() + "'s Vehicles:");
            owner.getVehicles().forEach(System.out::println);
        });

        // 21. Find the total payload capacity of all trucks
        double totalPayloadCapacity = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v instanceof Truck)
            .mapToDouble(v -> ((Truck) v).getPayloadCapacity())
            .sum();
        System.out.println("Total Payload Capacity of Trucks: " + totalPayloadCapacity + " lbs");

        // 22. Get a list of unique vehicle models
        List<String> uniqueVehicleModels = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .map(Vehicle::getModel)
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Unique Vehicle Models: " + uniqueVehicleModels);

        // 23. Find all vehicles of a specific type (e.g., Car)
        List<Vehicle> allCars = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v instanceof Car)
            .collect(Collectors.toList());
        System.out.println("All Cars: " + allCars);

        // 24. Count the number of owners with at least one vehicle
        long ownersWithVehiclesCount = owners.stream()
            .filter(owner -> !owner.getVehicles().isEmpty())
            .count();
        System.out.println("Owners with at Least One Vehicle: " + ownersWithVehiclesCount);

        // 25. List all motorcycles
        List<Motorcycle> allMotorcycles = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v instanceof Motorcycle)
            .map(v -> (Motorcycle) v)
            .collect(Collectors.toList());
        System.out.println("All Motorcycles: " + allMotorcycles);

        // 26. Find the total number of vehicles for each year
        Map<Integer, Long> vehiclesPerYear = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .collect(Collectors.groupingBy(Vehicle::getYear, Collectors.counting()));
        System.out.println("Total Number of Vehicles Per Year: " + vehiclesPerYear);

        // 27. Find the average price of cars only
        double averageCarPrice = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v instanceof Car)
            .mapToDouble(Vehicle::getPrice)
            .average()
            .orElse(0);
        System.out.println("Average Price of Cars: $" + averageCarPrice);

        // 28. Find all vehicles by a specific model
        String specificModel = "Toyota Camry";
        List<Vehicle> vehiclesByModel = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v.getModel().equals(specificModel))
            .collect(Collectors.toList());
        System.out.println("Vehicles by Model '" + specificModel + "': " + vehiclesByModel);

        // 29. Check if all vehicles are newer than 2000
        boolean allNewerThan2000 = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .allMatch(v -> v.getYear() > 2000);
        System.out.println("All Vehicles Newer Than 2000: " + allNewerThan2000);

        // 30. Get a list of vehicles priced between $15,000 and $25,000
        List<Vehicle> midRangeVehicles = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v.getPrice() >= 15000 && v.getPrice() <= 25000)
            .collect(Collectors.toList());
        System.out.println("Vehicles Priced Between $15,000 and $25,000: " + midRangeVehicles);

        // 31. Find the total number of motorcycles with sidecars
        long totalMotorcyclesWithSidecars = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v instanceof Motorcycle && ((Motorcycle) v).hasSidecar())
            .count();
        System.out.println("Total Motorcycles with Sidecars: " + totalMotorcyclesWithSidecars);

        // 32. List vehicles by owner name
        Map<String, List<Vehicle>> vehiclesByOwnerName = owners.stream()
            .collect(Collectors.toMap(Owner::getName, Owner::getVehicles));
        System.out.println("Vehicles by Owner Name: " + vehiclesByOwnerName);

        // 33. Get the first vehicle found with a specific model
        Optional<Vehicle> firstSpecificModelVehicle = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v.getModel().equals("Toyota Camry"))
            .findFirst();
        firstSpecificModelVehicle.ifPresent(v -> System.out.println("First Toyota Camry Found: " + v));

        // 34. List owners with more than one vehicle
        List<Owner> multiVehicleOwners = owners.stream()
            .filter(owner -> owner.getVehicles().size() > 1)
            .collect(Collectors.toList());
        System.out.println("Owners with More Than One Vehicle: " + multiVehicleOwners);

        // 35. Print the license plates of all vehicles
        List<String> licensePlates = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .map(Vehicle::getLicensePlate)
            .collect(Collectors.toList());
        System.out.println("License Plates: " + licensePlates);

        // 36. Check if any owner has a vehicle priced over $30,000
        boolean anyOwnerHasExpensiveVehicle = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .anyMatch(v -> v.getPrice() > 30000);
        System.out.println("Any Owner Has Vehicle Priced Over $30,000: " + anyOwnerHasExpensiveVehicle);

        // 37. List all vehicles in descending order of year
        List<Vehicle> vehiclesDescendingYear = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .sorted(Comparator.comparingInt(Vehicle::getYear).reversed())
            .collect(Collectors.toList());
        System.out.println("Vehicles in Descending Order of Year: " + vehiclesDescendingYear);

        // 38. Find the oldest vehicle
        Optional<Vehicle> oldestVehicle = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .min(Comparator.comparingInt(Vehicle::getYear));
        oldestVehicle.ifPresent(v -> System.out.println("Oldest Vehicle: " + v));

        // 39. List vehicles whose models start with a specific letter
        char startingLetter = 'H';
        List<Vehicle> vehiclesStartingWith = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v.getModel().startsWith(String.valueOf(startingLetter)))
            .collect(Collectors.toList());
        System.out.println("Vehicles Starting with '" + startingLetter + "': " + vehiclesStartingWith);

        // 40. Count how many cars are available
        long carCount = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v instanceof Car)
            .count();
        System.out.println("Total Number of Cars: " + carCount);

        // 41. Get a list of vehicle models from owners who have more than one vehicle
        List<String> modelsFromMultiVehicleOwners = owners.stream()
            .filter(owner -> owner.getVehicles().size() > 1)
            .flatMap(owner -> owner.getVehicles().stream())
            .map(Vehicle::getModel)
            .collect(Collectors.toList());
        System.out.println("Models from Owners with More Than One Vehicle: " + modelsFromMultiVehicleOwners);

        // 42. Find the most common vehicle model
        Map<String, Long> modelCount = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .collect(Collectors.groupingBy(Vehicle::getModel, Collectors.counting()));

        String mostCommonModel = modelCount.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse("None");
        System.out.println("Most Common Vehicle Model: " + mostCommonModel);

        // 43. Count how many owners own each model
        Map<String, Long> ownersPerModel = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .collect(Collectors.groupingBy(Vehicle::getModel, Collectors.mapping(v -> v, Collectors.counting())));
        System.out.println("Owner Count per Model: " + ownersPerModel);

        // 44. List all vehicles that have a price under $15,000
        List<Vehicle> cheapVehicles = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v.getPrice() < 15000)
            .collect(Collectors.toList());
        System.out.println("Vehicles Priced Under $15,000: " + cheapVehicles);

        // 45. Find the sum of prices of all motorcycles
        double sumOfMotorcyclesPrice = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v instanceof Motorcycle)
            .mapToDouble(Vehicle::getPrice)
            .sum();
        System.out.println("Sum of Prices of All Motorcycles: $" + sumOfMotorcyclesPrice);

        // 46. Find vehicles whose models contain a specific substring
        String substring = "Honda";
        List<Vehicle> vehiclesWithSubstring = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .filter(v -> v.getModel().contains(substring))
            .collect(Collectors.toList());
        System.out.println("Vehicles Containing Substring '" + substring + "': " + vehiclesWithSubstring);

        // 47. Check if all vehicles are trucks
        boolean allTrucks = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .allMatch(v -> v instanceof Truck);
        System.out.println("All Vehicles Are Trucks: " + allTrucks);

        // 48. List all owners with their vehicles
        owners.forEach(owner -> {
            System.out.println(owner.getName() + "'s Vehicles: " + owner.getVehicles());
        });

        // 49. Check if there are any vehicles manufactured in the year 2000
        boolean anyFrom2000 = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .anyMatch(v -> v.getYear() == 2000);
        System.out.println("Any Vehicles Manufactured in 2000: " + anyFrom2000);

        // 50. List all vehicles sorted by model name
        List<Vehicle> vehiclesSortedByModel = owners.stream()
            .flatMap(owner -> owner.getVehicles().stream())
            .sorted(Comparator.comparing(Vehicle::getModel))
            .collect(Collectors.toList());
        System.out.println("Vehicles Sorted by Model Name: " + vehiclesSortedByModel);

        // 51. Find the total number of owners
        long totalOwnersCount = owners.size();
        System.out.println("Total Number of Owners: " + totalOwnersCount);
    }
}

/*

Explanation
This VehicleManagementSystem class covers:
Entities: Vehicle, Car, Truck, Motorcycle, and Owner.
Java 8 Features:
Streams: For processing collections of vehicles and owners.
Lambda Expressions: Used for filtering, mapping, and sorting operations.
Collectors: For grouping, counting, and joining data.
Optional: For safely handling the absence of values.
Scenarios Covered

Print all vehicles owned by each owner.
Filter vehicles with a price greater than $20,000.
Calculate the total price of all vehicles.
Count total number of vehicles.
Get a list of all vehicle models.
Find the most expensive vehicle.
Group vehicles by year.
Find all vehicles owned by a specific owner (e.g., Alice).
Check if any vehicle is older than 10 years.
Sort vehicles by price.
Join vehicle models into a single string.
Count total trucks.
Find vehicles with a specific license plate.
Find vehicles with sidecars.
Get the average price of all vehicles.
List vehicles manufactured after a specific year.
Count how many vehicles each owner has.
List vehicles sorted by year and then by price.
Find the least expensive vehicle.
Print vehicle details of each owner.
Find the total payload capacity of all trucks.
Get a list of unique vehicle models.
Find all vehicles of a specific type (e.g., Car).
Count the number of owners with at least one vehicle.
List all motorcycles.
Find the total number of vehicles for each year.
Find the average price of cars only.
Find all vehicles by a specific model.
Check if all vehicles are newer than 2000.
Get a list of vehicles priced between certain values.
Count how many motorcycles have sidecars.
List vehicles by owner name.
Get the first vehicle found with a specific model.
List owners with more than one vehicle.
Print license plates of all vehicles.
Check if any owner has a vehicle priced over a certain amount.
List all vehicles in descending order of year.
Find the oldest vehicle.
List vehicles whose models start with a specific letter.
Count how many cars are available.
Get a list of vehicle models from multi-vehicle owners.
Find the most common vehicle model.
Count how many owners own each model.
List all vehicles that have a price under a certain amount.
Find the sum of prices of all motorcycles.
Find vehicles whose models contain a specific substring.
Check if all vehicles are trucks.
List all owners with their vehicles.
Check if there are any vehicles manufactured in a specific year.
List all vehicles sorted by model name.
Find the total number of owners.

*/