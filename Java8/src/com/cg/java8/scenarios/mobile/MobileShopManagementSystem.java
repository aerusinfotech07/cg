package com.cg.java8.scenarios.mobile;

import java.util.*;
import java.util.stream.Collectors;

class Mobile {
    private String model;
    private String brand;
    private double price;
    private int year;

    public Mobile(String model, String brand, double price, int year) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return brand + " " + model + " (" + year + ") - $" + price;
    }
}

class Customer {
    private String name;
    private List<Mobile> purchasedMobiles;

    public Customer(String name) {
        this.name = name;
        this.purchasedMobiles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Mobile> getPurchasedMobiles() {
        return purchasedMobiles;
    }

    public void purchaseMobile(Mobile mobile) {
        purchasedMobiles.add(mobile);
    }

    @Override
    public String toString() {
        return name + " (Mobiles Purchased: " + purchasedMobiles.size() + ")";
    }
}

class Sale {
    private Customer customer;
    private Mobile mobile;
    private String date;

    public Sale(Customer customer, Mobile mobile, String date) {
        this.customer = customer;
        this.mobile = mobile;
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public String getDate() {
        return date;
    }
}

class MobileShop {
    private List<Mobile> mobiles;
    private List<Customer> customers;
    private List<Sale> sales;

    public MobileShop() {
        mobiles = new ArrayList<>();
        customers = new ArrayList<>();
        sales = new ArrayList<>();
    }

    public void addMobile(Mobile mobile) {
        mobiles.add(mobile);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void recordSale(Sale sale) {
        sales.add(sale);
        sale.getCustomer().purchaseMobile(sale.getMobile());
    }

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Sale> getSales() {
        return sales;
    }
}

public class MobileShopManagementSystem {
    public static void main(String[] args) {
        MobileShop shop = new MobileShop();

        // Adding mobiles
        Mobile mobile1 = new Mobile("Galaxy S21", "Samsung", 799.99, 2021);
        Mobile mobile2 = new Mobile("iPhone 13", "Apple", 999.99, 2021);
        Mobile mobile3 = new Mobile("Pixel 6", "Google", 599.99, 2021);
        Mobile mobile4 = new Mobile("OnePlus 9", "OnePlus", 729.99, 2021);
        Mobile mobile5 = new Mobile("Xiaomi Mi 11", "Xiaomi", 749.99, 2021);
        Mobile mobile6 = new Mobile("Nokia 3310", "Nokia", 49.99, 2000);

        shop.addMobile(mobile1);
        shop.addMobile(mobile2);
        shop.addMobile(mobile3);
        shop.addMobile(mobile4);
        shop.addMobile(mobile5);
        shop.addMobile(mobile6);

        // Adding customers
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");
        Customer customer3 = new Customer("Charlie");

        shop.addCustomer(customer1);
        shop.addCustomer(customer2);
        shop.addCustomer(customer3);

        // Recording sales
        shop.recordSale(new Sale(customer1, mobile1, "2023-10-01"));
        shop.recordSale(new Sale(customer2, mobile2, "2023-10-02"));
        shop.recordSale(new Sale(customer3, mobile3, "2023-10-03"));
        shop.recordSale(new Sale(customer1, mobile4, "2023-10-04"));
        shop.recordSale(new Sale(customer2, mobile5, "2023-10-05"));

        // Scenarios
        List<Mobile> mobiles = shop.getMobiles();
        List<Customer> customers = shop.getCustomers();
        List<Sale> sales = shop.getSales();

        // 1. Print all mobiles available in the shop
        System.out.println("All Mobiles in the Shop:");
        mobiles.forEach(System.out::println);

        // 2. Find the total number of mobiles in the shop
        long totalMobilesCount = mobiles.size();
        System.out.println("Total Mobiles Count: " + totalMobilesCount);

        // 3. Calculate the total sales amount
        double totalSalesAmount = sales.stream().mapToDouble(sale -> sale.getMobile().getPrice()).sum();
        System.out.println("Total Sales Amount: $" + totalSalesAmount);

        // 4. Get the most expensive mobile
        Optional<Mobile> mostExpensiveMobile = mobiles.stream()
            .max(Comparator.comparingDouble(Mobile::getPrice));
        mostExpensiveMobile.ifPresent(mobile -> System.out.println("Most Expensive Mobile: " + mobile));

        // 5. Find all mobiles from a specific brand (e.g., Apple)
        List<Mobile> appleMobiles = mobiles.stream()
            .filter(mobile -> mobile.getBrand().equals("Apple"))
            .collect(Collectors.toList());
        System.out.println("Apple Mobiles: " + appleMobiles);

        // 6. Count how many customers are there
        long totalCustomersCount = customers.size();
        System.out.println("Total Customers Count: " + totalCustomersCount);

        // 7. List all sales recorded
        System.out.println("All Sales Recorded:");
        sales.forEach(sale -> System.out.println(sale.getCustomer().getName() + " bought " + sale.getMobile().getModel() + " on " + sale.getDate()));

        // 8. Find the cheapest mobile
        Optional<Mobile> cheapestMobile = mobiles.stream()
            .min(Comparator.comparingDouble(Mobile::getPrice));
        cheapestMobile.ifPresent(mobile -> System.out.println("Cheapest Mobile: " + mobile));

        // 9. Count total sales made
        long totalSalesCount = sales.size();
        System.out.println("Total Sales Count: " + totalSalesCount);

        // 10. Find all mobiles released after 2020
        List<Mobile> recentMobiles = mobiles.stream()
            .filter(mobile -> mobile.getYear() > 2020)
            .collect(Collectors.toList());
        System.out.println("Mobiles Released After 2020: " + recentMobiles);

        // 11. Get the average price of all mobiles
        double averagePrice = mobiles.stream()
            .mapToDouble(Mobile::getPrice)
            .average()
            .orElse(0);
        System.out.println("Average Price of Mobiles: $" + averagePrice);

        // 12. List all customers and their purchased mobiles
        System.out.println("Customers and Their Purchased Mobiles:");
        customers.forEach(customer -> {
            System.out.println(customer.getName() + ": " + customer.getPurchasedMobiles());
        });

        // 13. Check if any customer has purchased a mobile from Samsung
        boolean hasSamsungCustomer = customers.stream()
            .flatMap(customer -> customer.getPurchasedMobiles().stream())
            .anyMatch(mobile -> mobile.getBrand().equals("Samsung"));
        System.out.println("Any Customer Purchased Samsung Mobile: " + hasSamsungCustomer);

        // 14. Get a list of unique brands sold in the shop
        Set<String> uniqueBrands = mobiles.stream()
            .map(Mobile::getBrand)
            .collect(Collectors.toSet());
        System.out.println("Unique Brands in the Shop: " + uniqueBrands);

        // 15. Find all mobiles priced above $600
        List<Mobile> expensiveMobiles = mobiles.stream()
            .filter(mobile -> mobile.getPrice() > 600)
            .collect(Collectors.toList());
        System.out.println("Mobiles Priced Above $600: " + expensiveMobiles);

        // 16. Count how many mobiles of a specific model exist (e.g., "Galaxy S21")
        long galaxyS21Count = mobiles.stream()
            .filter(mobile -> mobile.getModel().equals("Galaxy S21"))
            .count();
        System.out.println("Total Galaxy S21 Count: " + galaxyS21Count);

        // 17. Find the total number of sales for a specific customer (e.g., Alice)
        long alicesSalesCount = sales.stream()
            .filter(sale -> sale.getCustomer().getName().equals("Alice"))
            .count();
        System.out.println("Total Sales for Alice: " + alicesSalesCount);

        // 18. Sort mobiles by price
        List<Mobile> sortedByPrice = mobiles.stream()
            .sorted(Comparator.comparingDouble(Mobile::getPrice))
            .collect(Collectors.toList());
        System.out.println("Mobiles Sorted by Price: " + sortedByPrice);

        // 19. Get mobiles with names starting with "P"
        List<Mobile> mobilesStartingWithP = mobiles.stream()
            .filter(mobile -> mobile.getModel().startsWith("P"))
            .collect(Collectors.toList());
        System.out.println("Mobiles Starting with 'P': " + mobilesStartingWithP);

        // 20. Find the latest mobile
        Optional<Mobile> latestMobile = mobiles.stream()
            .max(Comparator.comparingInt(Mobile::getYear));
        latestMobile.ifPresent(mobile -> System.out.println("Latest Mobile: " + mobile));

        // 21. Find all mobiles that have a price between $500 and $800
        List<Mobile> midRangeMobiles = mobiles.stream()
            .filter(mobile -> mobile.getPrice() >= 500 && mobile.getPrice() <= 800)
            .collect(Collectors.toList());
        System.out.println("Mobiles Priced Between $500 and $800: " + midRangeMobiles);

        // 22. Count how many unique mobiles have been sold
        long uniqueMobilesSoldCount = sales.stream()
            .map(sale -> sale.getMobile())
            .distinct()
            .count();
        System.out.println("Unique Mobiles Sold Count: " + uniqueMobilesSoldCount);

        // 23. List all customers who purchased more than one mobile
        List<Customer> multiMobileCustomers = customers.stream()
            .filter(customer -> customer.getPurchasedMobiles().size() > 1)
            .collect(Collectors.toList());
        System.out.println("Customers Who Purchased More Than One Mobile: " + multiMobileCustomers);

        // 24. Count how many mobiles were sold in total
        long totalMobilesSoldCount = sales.stream()
            .map(sale -> sale.getMobile())
            .count();
        System.out.println("Total Mobiles Sold: " + totalMobilesSoldCount);

        // 25. Get the names of all customers who bought an Apple mobile
        List<String> appleCustomers = sales.stream()
            .filter(sale -> sale.getMobile().getBrand().equals("Apple"))
            .map(sale -> sale.getCustomer().getName())
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Customers Who Bought Apple Mobiles: " + appleCustomers);

        // 26. Check if any mobile was purchased in 2023
        boolean anyPurchaseIn2023 = sales.stream()
            .anyMatch(sale -> sale.getDate().startsWith("2023"));
        System.out.println("Any Mobile Purchased in 2023: " + anyPurchaseIn2023);

        // 27. List all sales by date
        System.out.println("Sales Recorded by Date:");
        sales.stream()
            .collect(Collectors.groupingBy(Sale::getDate))
            .forEach((date, saleList) -> {
                System.out.println(date + ": " + saleList.size() + " sales");
            });

        // 28. Find the total number of mobiles sold for each brand
        Map<String, Long> mobilesSoldByBrand = sales.stream()
            .collect(Collectors.groupingBy(sale -> sale.getMobile().getBrand(), Collectors.counting()));
        System.out.println("Mobiles Sold by Brand: " + mobilesSoldByBrand);

        // 29. Get the total number of sales made by each customer
        Map<String, Long> salesCountByCustomer = sales.stream()
            .collect(Collectors.groupingBy(sale -> sale.getCustomer().getName(), Collectors.counting()));
        System.out.println("Sales Count by Customer: " + salesCountByCustomer);

        // 30. Find the average price of mobiles sold
        double averageSoldPrice = sales.stream()
            .mapToDouble(sale -> sale.getMobile().getPrice())
            .average()
            .orElse(0);
        System.out.println("Average Price of Mobiles Sold: $" + averageSoldPrice);

        // 31. List all mobiles sorted by model name
        List<Mobile> mobilesSortedByModel = mobiles.stream()
            .sorted(Comparator.comparing(Mobile::getModel))
            .collect(Collectors.toList());
        System.out.println("Mobiles Sorted by Model Name: " + mobilesSortedByModel);

        // 32. Count how many customers have not purchased any mobiles
        long customersWithoutPurchasesCount = customers.stream()
            .filter(customer -> customer.getPurchasedMobiles().isEmpty())
            .count();
        System.out.println("Customers Without Purchases: " + customersWithoutPurchasesCount);

        // 33. Find all mobiles that are not from the brand "Xiaomi"
        List<Mobile> nonXiaomiMobiles = mobiles.stream()
            .filter(mobile -> !mobile.getBrand().equals("Xiaomi"))
            .collect(Collectors.toList());
        System.out.println("Mobiles Not from Xiaomi: " + nonXiaomiMobiles);

        // 34. Find total sales amount for each customer
        Map<String, Double> totalSalesByCustomer = sales.stream()
            .collect(Collectors.groupingBy(sale -> sale.getCustomer().getName(),
                Collectors.summingDouble(sale -> sale.getMobile().getPrice())));
        System.out.println("Total Sales Amount by Customer: " + totalSalesByCustomer);

        // 35. Get the top three most expensive mobiles
        List<Mobile> topThreeExpensiveMobiles = mobiles.stream()
            .sorted(Comparator.comparingDouble(Mobile::getPrice).reversed())
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("Top Three Most Expensive Mobiles: " + topThreeExpensiveMobiles);

        // 36. Find all mobiles that were sold for under $500
        List<Mobile> budgetMobiles = sales.stream()
            .map(Sale::getMobile)
            .filter(mobile -> mobile.getPrice() < 500)
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Mobiles Sold for Under $500: " + budgetMobiles);

        // 37. Count how many unique customers made purchases
        long uniqueCustomersCount = sales.stream()
            .map(sale -> sale.getCustomer())
            .distinct()
            .count();
        System.out.println("Unique Customers Count: " + uniqueCustomersCount);

        // 38. Find the total number of sales made in a specific year (2023)
        long salesIn2023Count = sales.stream()
            .filter(sale -> sale.getDate().startsWith("2023"))
            .count();
        System.out.println("Total Sales Made in 2023: " + salesIn2023Count);

        // 39. Find the cheapest mobile sold
        Optional<Mobile> cheapestSoldMobile = sales.stream()
            .map(Sale::getMobile)
            .min(Comparator.comparingDouble(Mobile::getPrice));
        cheapestSoldMobile.ifPresent(mobile -> System.out.println("Cheapest Mobile Sold: " + mobile));

        // 40. List all mobiles that were sold in a specific date (e.g., 2023-10-02)
        List<Mobile> mobilesSoldOnDate = sales.stream()
            .filter(sale -> sale.getDate().equals("2023-10-02"))
            .map(Sale::getMobile)
            .collect(Collectors.toList());
        System.out.println("Mobiles Sold on 2023-10-02: " + mobilesSoldOnDate);

        // 41. Count how many mobiles are still available in the shop
        long availableMobilesCount = mobiles.stream()
            .filter(mobile -> sales.stream().noneMatch(sale -> sale.getMobile().equals(mobile)))
            .count();
        System.out.println("Available Mobiles in the Shop: " + availableMobilesCount);

        // 42. Find all sales made by a specific customer and their details
        Customer specificCustomer = customers.get(0); // Alice
        List<Sale> alicesSales = sales.stream()
            .filter(sale -> sale.getCustomer().equals(specificCustomer))
            .collect(Collectors.toList());
        System.out.println("Alice's Sales: " + alicesSales);

        // 43. List all mobiles with prices above the average price
        List<Mobile> aboveAveragePriceMobiles = mobiles.stream()
            .filter(mobile -> mobile.getPrice() > averagePrice)
            .collect(Collectors.toList());
        System.out.println("Mobiles Above Average Price: " + aboveAveragePriceMobiles);

        // 44. Find all sales that exceed a certain price threshold
        double priceThreshold = 700.00;
        List<Sale> highValueSales = sales.stream()
            .filter(sale -> sale.getMobile().getPrice() > priceThreshold)
            .collect(Collectors.toList());
        System.out.println("Sales Exceeding $" + priceThreshold + ": " + highValueSales);

        // 45. Count how many mobiles of each brand are available
        Map<String, Long> mobilesAvailableByBrand = mobiles.stream()
            .collect(Collectors.groupingBy(Mobile::getBrand, Collectors.counting()));
        System.out.println("Available Mobiles Count by Brand: " + mobilesAvailableByBrand);

        // 46. Find the oldest mobile in terms of release year
        Optional<Mobile> oldestMobile = mobiles.stream()
            .min(Comparator.comparingInt(Mobile::getYear));
        oldestMobile.ifPresent(mobile -> System.out.println("Oldest Mobile: " + mobile));

        // 47. Get a summary of total purchases by customer
        System.out.println("Summary of Purchases by Customer:");
        customers.forEach(customer -> {
            long purchaseCount = customer.getPurchasedMobiles().size();
            double totalSpent = customer.getPurchasedMobiles().stream()
                .mapToDouble(Mobile::getPrice)
                .sum();
            System.out.println(customer.getName() + " - Purchases: " + purchaseCount + ", Total Spent: $" + totalSpent);
        });

        // 48. List all mobile brands sold in the shop
        List<String> soldMobileBrands = sales.stream()
            .map(sale -> sale.getMobile().getBrand())
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Mobile Brands Sold in the Shop: " + soldMobileBrands);

        // 49. List all customers who purchased more than one brand of mobile
        List<Customer> diverseBrandCustomers = customers.stream()
            .filter(customer -> customer.getPurchasedMobiles().stream()
                .map(Mobile::getBrand)
                .distinct()
                .count() > 1)
            .collect(Collectors.toList());
        System.out.println("Customers Who Purchased More Than One Brand: " + diverseBrandCustomers);

        // 50. Get the details of the mobile with the highest sales
        Map<Mobile, Long> salesCountPerMobile = sales.stream()
            .collect(Collectors.groupingBy(Sale::getMobile, Collectors.counting()));
        Mobile highestSalesMobile = salesCountPerMobile.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey)
            .orElse(null);
        System.out.println("Mobile with Highest Sales: " + highestSalesMobile);

        // 51. List all customers who have never purchased any mobile
        List<Customer> noPurchasesCustomers = customers.stream()
            .filter(customer -> customer.getPurchasedMobiles().isEmpty())
            .collect(Collectors.toList());
        System.out.println("Customers Who Never Purchased Any Mobile: " + noPurchasesCustomers);
    }
}
/*
 Explanation
This MobileShopManagementSystem class covers:

Entities:

Mobile: Represents a mobile phone with properties like model, brand, price, and year.
Customer: Represents a customer who can purchase mobiles.
Sale: Represents a sale transaction between a customer and a mobile.
MobileShop: Manages the list of mobiles, customers, and sales.
Java 8 Features:

Streams: Used for processing collections of mobiles, customers, and sales.
Lambda Expressions: For filtering, mapping, and reducing operations.
Collectors: For grouping, counting, and summing data.
Optional: For safely handling the absence of values.
Scenarios Covered
Print all mobiles available in the shop.
Find the total number of mobiles in the shop.
Calculate the total sales amount.
Get the most expensive mobile.
Find all mobiles from a specific brand (e.g., Apple).
Count how many customers are there.
List all sales recorded.
Find the cheapest mobile.
Count total sales made.
Find all mobiles released after 2020.
Get the average price of all mobiles.
List all customers and their purchased mobiles.
Check if any customer has purchased a Samsung mobile.
Get a list of unique brands sold in the shop.
Find all mobiles priced above $600.
Count how many mobiles of a specific model exist.
Find the total number of sales for a specific customer (e.g., Alice).
Sort mobiles by price.
Get mobiles with names starting with "P".
Find the latest mobile.
Find all mobiles that have a price between $500 and $800.
Count how many unique mobiles have been sold.
List all customers who purchased more than one mobile.
Count how many mobiles were sold in total.
Get the names of all customers who bought an Apple mobile.
Check if any mobile was purchased in 2023.
List all sales by date.
Find the total number of mobiles sold for each brand.
Get the total number of sales made by each customer.
Find the average price of mobiles sold.
List all mobiles sorted by model name.
Count how many customers have not purchased any mobiles.
Find all mobiles that are not from the brand "Xiaomi".
Find total sales amount for each customer.
Get the top three most expensive mobiles.
Find all mobiles that were sold for under $500.
Count how many unique customers made purchases.
Find the total number of sales made in a specific year (2023).
Find the cheapest mobile sold.
List all mobiles that were sold on a specific date (e.g., 2023-10-02).
Count how many mobiles are still available in the shop.
Find all sales made by a specific customer and their details.
List all mobiles with prices above the average price.
Find all sales that exceed a certain price threshold.
Count how many mobiles of each brand are available.
Find the oldest mobile in terms of release year.
Get a summary of total purchases by customer.
List all mobile brands sold in the shop.
List all customers who purchased more than one brand of mobile.
Get the details of the mobile with the highest sales.
List all customers who have never purchased any mobile.

*/
