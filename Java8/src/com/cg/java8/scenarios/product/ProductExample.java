package com.cg.java8.scenarios.product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductExample {

    // Sample data
    static class Product {
        String name;
        double price;
        String category;

        public Product(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
        public String getCategory() { return category; }

        @Override
        public String toString() {
            return name + " ($" + price + ")";
        }
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Gaming PC", 1200.00, "PC"),
            new Product("Gaming Laptop", 1500.00, "Laptop"),
            new Product("Mechanical Keyboard", 100.00, "Accessory"),
            new Product("Gaming Mouse", 50.00, "Accessory"),
            new Product("Monitor", 300.00, "Accessory"),
            new Product("Motherboard", 150.00, "Hardware"),
            new Product("RAM", 80.00, "Hardware"),
            new Product("SSD", 200.00, "Hardware")
        );

        // 1. Collect to List
        List<Product> productList = products.stream()
            .filter(product -> product.getPrice() < 500)
            .collect(Collectors.toList());
        System.out.println("Products under $500: " + productList);

        // 2. Collect to Set
        Set<String> productCategories = products.stream()
            .map(Product::getCategory)
            .collect(Collectors.toSet());
        System.out.println("Product Categories: " + productCategories);

        // 3. Collect to Map
        Map<String, Double> productMap = products.stream()
            .collect(Collectors.toMap(Product::getName, Product::getPrice));
        System.out.println("Product Map: " + productMap);

        // 4. Count Elements
        long count = products.stream()
            .filter(product -> product.getPrice() > 100)
            .count();
        System.out.println("Products over $100: " + count);

        // 5. Group by Category
        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("Products grouped by Category: " + groupedByCategory);

        // 6. Group by Category and Summarize
        Map<String, Double> categoryTotalPrice = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory,
                Collectors.summingDouble(Product::getPrice)));
        System.out.println("Total price by Category: " + categoryTotalPrice);

        // 7. Group by Category and Count
        Map<String, Long> categoryCount = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println("Count of products by Category: " + categoryCount);

        // 8. Partitioning by Price
        Map<Boolean, List<Product>> partitionedByPrice = products.stream()
            .collect(Collectors.partitioningBy(product -> product.getPrice() < 500));
        System.out.println("Products partitioned by price (< $500): " + partitionedByPrice);

        // 9. Joining Strings
        String productNames = products.stream()
            .map(Product::getName)
            .collect(Collectors.joining(", "));
        System.out.println("Product Names: " + productNames);

        // 10. Joining with a delimiter
        String productNamesWithDelimiter = products.stream()
            .map(Product::getName)
            .collect(Collectors.joining(" | "));
        System.out.println("Product Names with delimiter: " + productNamesWithDelimiter);

        // 11. Collecting into a TreeSet
        Set<String> sortedCategories = products.stream()
            .map(Product::getCategory)
            .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("Sorted Categories: " + sortedCategories);

        // 12. Collecting with a custom collector (counting)
        long totalProductCount = products.stream()
            .collect(Collectors.counting());
        System.out.println("Total Product Count: " + totalProductCount);

        // 13. Collecting with a custom collector (averaging)
        double averagePrice = products.stream()
            .collect(Collectors.averagingDouble(Product::getPrice));
        System.out.println("Average Product Price: $" + averagePrice);

        // 14. Collecting to a summary statistics
        DoubleSummaryStatistics stats = products.stream()
            .collect(Collectors.summarizingDouble(Product::getPrice));
        System.out.println("Price Summary: " + stats);

        // 15. Collecting to a List of names
        List<String> productNameList = products.stream()
            .map(Product::getName)
            .collect(Collectors.toList());
        System.out.println("Product Name List: " + productNameList);

        // 16. Flattening lists
        List<List<Product>> productLists = Arrays.asList(
            Arrays.asList(new Product("Mouse", 20, "Accessory")),
            Arrays.asList(new Product("Keyboard", 30, "Accessory"))
        );
        List<Product> flatList = productLists.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
        System.out.println("Flattened Product List: " + flatList);

        // 17. Collecting to a LinkedHashMap (preserving insertion order)
        Map<String, Double> orderedProductMap = products.stream()
            .collect(Collectors.toMap(Product::getName, Product::getPrice, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("Ordered Product Map: " + orderedProductMap);

        // 18. Collecting to a Multimap (custom implementation)
        Map<String, List<Product>> multiMap = new HashMap<>();
        products.forEach(product -> multiMap.computeIfAbsent(product.getCategory(), k -> new ArrayList<>()).add(product));
        System.out.println("MultiMap: " + multiMap);

        // 19. Grouping and counting
        Map<String, Long> groupedAndCounted = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println("Grouped and Counted: " + groupedAndCounted);

        // 20. Grouping by category and getting the first product
        Map<String, Optional<Product>> firstProductByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory, Collectors.reducing((first, second) -> first)));
        System.out.println("First Product by Category: " + firstProductByCategory);

        // 21. Collecting to a Map with merging values
        Map<String, Double> mergedProductPrices = products.stream()
            .collect(Collectors.toMap(Product::getName, Product::getPrice, Double::sum));
        System.out.println("Merged Product Prices: " + mergedProductPrices);

        // 22. Collecting to a List and filtering empty
        List<String> namesWithNonEmptyStrings = Arrays.asList("Alice", "", "Bob", null, "Charlie");
        List<String> nonEmptyNames = namesWithNonEmptyStrings.stream()
            .filter(name -> name != null && !name.isEmpty())
            .collect(Collectors.toList());
        System.out.println("Non-empty Names: " + nonEmptyNames);

        // 23. Summarizing prices
        DoubleSummaryStatistics priceSummary = products.stream()
            .collect(Collectors.summarizingDouble(Product::getPrice));
        System.out.println("Price Summary: " + priceSummary);

        // 24. Grouping by a calculated property (price range)
        Map<String, List<Product>> priceRangeGroup = products.stream()
            .collect(Collectors.groupingBy(product -> {
                if (product.getPrice() < 100) return "Low";
                else if (product.getPrice() < 500) return "Medium";
                else return "High";
            }));
        System.out.println("Products by Price Range: " + priceRangeGroup);

        // 25. Finding the maximum price
        Optional<Product> maxPriceProduct = products.stream()
            .collect(Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)));
        System.out.println("Most Expensive Product: " + maxPriceProduct);

        // 26. Finding the minimum price
        Optional<Product> minPriceProduct = products.stream()
            .collect(Collectors.minBy(Comparator.comparingDouble(Product::getPrice)));
        System.out.println("Cheapest Product: " + minPriceProduct);

        // 27. Collecting unique prices
        Set<Double> uniquePrices = products.stream()
            .map(Product::getPrice)
            .collect(Collectors.toSet());
        System.out.println("Unique Prices: " + uniquePrices);

        // 28. Grouping and getting the last product in each category
        Map<String, Optional<Product>> lastProductByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory, Collectors.reducing((first, second) -> second)));
        System.out.println("Last Product by Category: " + lastProductByCategory);

        // 29. Filtering and collecting in a single operation
        List<Product> filteredCollected = products.stream()
            .filter(product -> product.getPrice() < 200)
            .collect(Collectors.toList());
        System.out.println("Filtered Products under $200: " + filteredCollected);

        // 30. Collecting to a TreeSet with custom sorting
        Set<Product> sortedProductSet = products.stream()
            .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Product::getPrice))));
        System.out.println("Sorted Product Set: " + sortedProductSet);

        // 31. Grouping and getting the average price in each category
        Map<String, Double> averagePriceByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory,
                Collectors.averagingDouble(Product::getPrice)));
        System.out.println("Average Price by Category: " + averagePriceByCategory);

        // 32. Grouping and listing product names by category
        Map<String, List<String>> namesByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory,
                Collectors.mapping(Product::getName, Collectors.toList())));
        System.out.println("Product Names by Category: " + namesByCategory);

        // 33. Partitioning products based on a condition
        Map<Boolean, List<Product>> partitionedProducts = products.stream()
            .collect(Collectors.partitioningBy(product -> product.getPrice() < 500));
        System.out.println("Partitioned Products: " + partitionedProducts);

        // 34. Grouping products by their first letter
        Map<Character, List<Product>> productsByFirstLetter = products.stream()
            .collect(Collectors.groupingBy(product -> product.getName().charAt(0)));
        System.out.println("Products by First Letter: " + productsByFirstLetter);

        // 35. Collecting to a list and converting to uppercase
        List<String> upperCaseNames = products.stream()
            .map(Product::getName)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Uppercase Product Names: " + upperCaseNames);

        // 36. Collecting all products to a single string
        String allProducts = products.stream()
            .map(Product::toString)
            .collect(Collectors.joining(", "));
        System.out.println("All Products: " + allProducts);

        // 37. Grouping by the length of product names
        Map<Integer, List<Product>> lengthGroup = products.stream()
            .collect(Collectors.groupingBy(product -> product.getName().length()));
        System.out.println("Products Grouped by Name Length: " + lengthGroup);

        // 38. Collecting products to a map of names and prices as strings
        Map<String, String> productNamePriceMap = products.stream()
            .collect(Collectors.toMap(Product::getName, product -> "$" + product.getPrice()));
        System.out.println("Product Name-Price Map: " + productNamePriceMap);

        // 39. Collecting average price of products in each category
        Map<String, Double> averagePricePerCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
        System.out.println("Average Price per Category: " + averagePricePerCategory);

        // 40. Grouping and counting the occurrences of product names
        Map<String, Long> nameCount = products.stream()
            .collect(Collectors.groupingBy(Product::getName, Collectors.counting()));
        System.out.println("Name Count: " + nameCount);

        // 41. Collecting unique product categories
        Set<String> uniqueCategories = products.stream()
            .map(Product::getCategory)
            .collect(Collectors.toSet());
        System.out.println("Unique Categories: " + uniqueCategories);

        // 42. Collecting to a List of distinct categories
        List<String> distinctCategories = products.stream()
            .map(Product::getCategory)
            .distinct()
            .collect(Collectors.toList());
        System.out.println("Distinct Categories: " + distinctCategories);

        // 43. Grouping by category and getting the maximum price in each category
        Map<String, Optional<Product>> maxPriceByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory,
                Collectors.reducing((a, b) -> a.getPrice() > b.getPrice() ? a : b)));
        System.out.println("Max Price by Category: " + maxPriceByCategory);

        // 44. Grouping by category and getting the minimum price in each category
        Map<String, Optional<Product>> minPriceByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory,
                Collectors.reducing((a, b) -> a.getPrice() < b.getPrice() ? a : b)));
        System.out.println("Min Price by Category: " + minPriceByCategory);

        // 45. Grouping by price range and counting
        Map<String, Long> priceRangeCount = products.stream()
            .collect(Collectors.groupingBy(product -> {
                if (product.getPrice() < 100) return "Low";
                else if (product.getPrice() < 500) return "Medium";
                else return "High";
            }, Collectors.counting()));
        System.out.println("Price Range Count: " + priceRangeCount);

        // 46. Collecting to a list of product names with lengths
        List<String> productNamesWithLengths = products.stream()
            .map(product -> product.getName() + " (" + product.getName().length() + " chars)")
            .collect(Collectors.toList());
        System.out.println("Product Names with Lengths: " + productNamesWithLengths);

        // 47. Counting products by price category
        Map<String, Long> productsByPriceCategory = products.stream()
            .collect(Collectors.groupingBy(product -> {
                if (product.getPrice() < 300) return "Affordable";
                else return "Expensive";
            }, Collectors.counting()));
        System.out.println("Products by Price Category: " + productsByPriceCategory);

        // 48. Collecting to a list of products sorted by name
        List<Product> sortedByName = products.stream()
            .sorted(Comparator.comparing(Product::getName))
            .collect(Collectors.toList());
        System.out.println("Products Sorted by Name: " + sortedByName);

        // 49. Collecting a Map of categories and their total count
        Map<String, Long> totalCountByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println("Total Count by Category: " + totalCountByCategory);

        // 50. Collecting to a TreeMap to maintain order
        Map<String, List<Product>> treeMapByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory, TreeMap::new, Collectors.toList()));
        System.out.println("TreeMap of Products by Category: " + treeMapByCategory);
    }
}
