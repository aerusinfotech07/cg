package com.cg.java8.classes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s (%s): $%.2f", name, category, price);
    }
}

public class ForEachMethodExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Intel i9", "CPU", 499.99),
                new Product("AMD Ryzen 9", "CPU", 449.99),
                new Product("NVIDIA RTX 3090", "GPU", 1499.99),
                new Product("Samsung SSD", "Storage", 199.99),
                new Product("Corsair RAM", "Memory", 89.99)
        );

        // 1. Print all products
        System.out.println("All Products:");
        products.forEach(product -> System.out.println(product));

        // 2. Print product names only
        System.out.println("\nProduct Names:");
        products.forEach(product -> System.out.println(product.getName()));

        // 3. Print products with prices greater than $200
        System.out.println("\nProducts over $200:");
        products.stream()
                .filter(product -> product.getPrice() > 200)
                .forEach(product -> System.out.println(product));

        // 4. Print products by category
        System.out.println("\nProducts by Category:");
        products.forEach(product -> System.out.println(product.getCategory() + ": " + product.getName()));

        // 5. Apply a discount and print new prices
        System.out.println("\nDiscounted Prices (10% off):");
        products.forEach(product -> {
            double discountedPrice = product.getPrice() * 0.9;
            System.out.println(product.getName() + ": $" + discountedPrice);
        });

        // 6. Collect and print total price of all products
        double totalPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("\nTotal Price: $" + totalPrice);

        // 7. Print product names in uppercase
        System.out.println("\nProduct Names in Uppercase:");
        products.forEach(product -> System.out.println(product.getName().toUpperCase()));

        // 8. Print products sorted by price
        System.out.println("\nProducts Sorted by Price:");
        products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .forEach(product -> System.out.println(product));

        // 9. Print unique categories of products
        System.out.println("\nUnique Categories:");
        products.stream()
                .map(Product::getCategory)
                .distinct()
                .forEach(System.out::println);

        // 10. Print product details in a formatted manner
        System.out.println("\nFormatted Product Details:");
        products.forEach(product -> System.out.printf("Product: %s | Category: %s | Price: $%.2f%n",
                product.getName(), product.getCategory(), product.getPrice()));

        // 11. Print products with prices rounded to nearest integer
        System.out.println("\nPrices Rounded to Nearest Integer:");
        products.forEach(product -> {
            int roundedPrice = (int) Math.round(product.getPrice());
            System.out.println(product.getName() + ": $" + roundedPrice);
        });

        // 12. Print only the cheapest product
        System.out.println("\nCheapest Product:");
        products.stream()
                .min(Comparator.comparingDouble(Product::getPrice))
                .ifPresent(System.out::println);

        // 13. Print the most expensive product
        System.out.println("\nMost Expensive Product:");
        products.stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .ifPresent(System.out::println);

        // 14. Print products whose names start with 'N'
        System.out.println("\nProducts Starting with 'N':");
        products.stream()
                .filter(product -> product.getName().startsWith("N"))
                .forEach(System.out::println);

        // 15. Print products in descending order of price
        System.out.println("\nProducts in Descending Order of Price:");
        products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .forEach(System.out::println);

        // 16. Print all product categories with counts
        System.out.println("\nProduct Categories with Counts:");
        products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()))
                .forEach((category, count) -> System.out.println(category + ": " + count));

        // 17. Print products in a specific format
        System.out.println("\nProducts in Specific Format:");
        products.forEach(product -> System.out.printf("Name: %s | Price: %.2f%n", product.getName(), product.getPrice()));

        // 18. Print only products from the 'CPU' category
        System.out.println("\nProducts in the 'CPU' Category:");
        products.stream()
                .filter(product -> "CPU".equals(product.getCategory()))
                .forEach(System.out::println);

        // 19. Print the total number of products
        System.out.println("\nTotal Number of Products:");
        System.out.println(products.size());

        // 20. Print the average price of products
        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0);
        System.out.println("\nAverage Price: $" + averagePrice);

        // 21. Print the names and prices of products formatted as a CSV
        System.out.println("\nProducts as CSV:");
        products.forEach(product -> System.out.printf("%s,$%.2f%n", product.getName(), product.getPrice()));

        // 22. Print products with prices in range $100 to $500
        System.out.println("\nProducts in Price Range $100 to $500:");
        products.stream()
                .filter(product -> product.getPrice() >= 100 && product.getPrice() <= 500)
                .forEach(System.out::println);

        // 23. Print each product's category and a message
        System.out.println("\nProduct Categories and Message:");
        products.forEach(product -> System.out.println(product.getCategory() + " is available now!"));

        // 24. Print products with specific formatting for promotions
        System.out.println("\nPromotional Products:");
        products.forEach(product -> System.out.printf("Hurry! Get %s for just $%.2f!%n", product.getName(), product.getPrice()));

        // 25. Print the number of characters in each product name
        System.out.println("\nNumber of Characters in Each Product Name:");
        products.forEach(product -> System.out.println(product.getName() + ": " + product.getName().length() + " chars"));

        // 26. Print products sorted by name
        System.out.println("\nProducts Sorted by Name:");
        products.stream()
                .sorted(Comparator.comparing(Product::getName))
                .forEach(System.out::println);

        // 27. Print products that are not CPUs
        System.out.println("\nProducts That Are Not CPUs:");
        products.stream()
                .filter(product -> !"CPU".equals(product.getCategory()))
                .forEach(System.out::println);

        // 28. Print the names of products and their prices multiplied by 2
        System.out.println("\nProduct Names and Double Prices:");
        products.forEach(product -> System.out.printf("%s: $%.2f%n", product.getName(), product.getPrice() * 2));

        // 29. Print the first character of each product name
        System.out.println("\nFirst Character of Each Product Name:");
        products.forEach(product -> System.out.println(product.getName().charAt(0)));

        // 30. Print product details with a header
        System.out.println("\nProduct Details:");
        System.out.println("Name | Category | Price");
        products.forEach(product -> System.out.printf("%s | %s | $%.2f%n",
                product.getName(), product.getCategory(), product.getPrice()));

        // 31. Print names of products along with their index
        System.out.println("\nProduct Names with Indices:");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d: %s%n", i + 1, products.get(i).getName());
        }

        // 32. Print the total value of all products with a message
        System.out.println("\nTotal Value of Products:");
        double totalValue = products.stream().mapToDouble(Product::getPrice).sum();
        System.out.println("Total Value: $" + totalValue);

        // 33. Print products with their index and price
        System.out.println("\nProducts with Index and Price:");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("Index: %d, %s - $%.2f%n", i, products.get(i).getName(), products.get(i).getPrice());
        }

        // 34. Print products that cost less than a certain amount
        double maxPrice = 500;
        System.out.println("\nProducts that cost less than $" + maxPrice + ":");
        products.stream()
                .filter(product -> product.getPrice() < maxPrice)
                .forEach(System.out::println);

        // 35. Print products whose name length is greater than 5
        System.out.println("\nProducts with Names Longer than 5 Characters:");
        products.stream()
                .filter(product -> product.getName().length() > 5)
                .forEach(System.out::println);

        // 36. Print products with formatted prices
        System.out.println("\nProducts with Formatted Prices:");
        products.forEach(product -> System.out.printf("%s: $%.2f%n", product.getName(), product.getPrice()));

        // 37. Print all products with a custom message
        System.out.println("\nCustom Message for Each Product:");
        products.forEach(product -> System.out.println("Check out the amazing " + product.getName() + "!"));

        // 38. Print products sorted by category and then by price
        System.out.println("\nProducts Sorted by Category and then Price:");
        products.stream()
                .sorted(Comparator.comparing(Product::getCategory)
                        .thenComparing(Product::getPrice))
                .forEach(System.out::println);

        // 39. Print the products in reverse order
        System.out.println("\nProducts in Reverse Order:");
        Collections.reverse(products);
        products.forEach(System.out::println);

        // 40. Print products that belong to the 'Memory' category
        System.out.println("\nProducts in the 'Memory' Category:");
        products.stream()
                .filter(product -> "Memory".equals(product.getCategory()))
                .forEach(System.out::println);

        // 41. Print products that have a price lower than the average
        System.out.println("\nProducts with Prices Lower than the Average:");
        double avg = products.stream().mapToDouble(Product::getPrice).average().orElse(0);
        products.stream()
                .filter(product -> product.getPrice() < avg)
                .forEach(System.out::println);

        // 42. Print the names of products that are on sale (e.g., priced under $100)
        System.out.println("\nProducts on Sale (under $100):");
        products.stream()
                .filter(product -> product.getPrice() < 100)
                .forEach(System.out::println);

        // 43. Print product details as a JSON-like string
        System.out.println("\nProducts in JSON-like Format:");
        products.forEach(product -> System.out.printf("{\"name\": \"%s\", \"category\": \"%s\", \"price\": %.2f}%n",
                product.getName(), product.getCategory(), product.getPrice()));

        // 44. Print the number of products in each category
        System.out.println("\nNumber of Products in Each Category:");
        products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()))
                .forEach((category, count) -> System.out.println(category + ": " + count));

        // 45. Print the products with a custom index
        System.out.println("\nProducts with Custom Index:");
        IntStream.range(0, products.size())
                .forEach(i -> System.out.printf("Product %d: %s%n", i + 1, products.get(i).getName()));

        // 46. Print products that contain 'SSD' in their name
        System.out.println("\nProducts Containing 'SSD':");
        products.stream()
                .filter(product -> product.getName().contains("SSD"))
                .forEach(System.out::println);

        // 47. Print products sorted by name in reverse order
        System.out.println("\nProducts Sorted by Name in Reverse Order:");
        products.stream()
                .sorted(Comparator.comparing(Product::getName).reversed())
                .forEach(System.out::println);

        // 48. Print product names with their lengths
        System.out.println("\nProduct Names with Their Lengths:");
        products.forEach(product -> System.out.printf("%s: %d characters%n", product.getName(), product.getName().length()));

        // 49. Print products in a tabulated format
        System.out.println("\nProducts in a Tabulated Format:");
        System.out.printf("%-20s %-10s %-10s%n", "Name", "Category", "Price");
        products.forEach(product -> System.out.printf("%-20s %-10s $%-10.2f%n", product.getName(), product.getCategory(), product.getPrice()));

        // 50. Print unique product names
        System.out.println("\nUnique Product Names:");
        products.stream()
                .map(Product::getName)
                .distinct()
                .forEach(System.out::println);
    }
}

