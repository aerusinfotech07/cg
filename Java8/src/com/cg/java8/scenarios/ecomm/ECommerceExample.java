package com.cg.java8.scenarios.ecomm;

import java.util.*;
import java.util.stream.Collectors;

enum ProductCategory {
    ELECTRONICS, GROCERY, CLOTHING, FURNITURE
}

class Product {
    private String name;
    private double price;
    private ProductCategory category;
    private int stock;

    public Product(String name, double price, ProductCategory category, int stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", stock=" + stock +
                '}';
    }
}

class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

class Transaction {
    private Customer customer;
    private Product product;
    private int quantity;

    public Transaction(Customer customer, Product product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "customer=" + customer +
                ", product=" + product +
                ", quantity=" + quantity +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}

class Order {
    private Customer customer;
    private List<Transaction> transactions;

    public Order(Customer customer, List<Transaction> transactions) {
        this.customer = customer;
        this.transactions = transactions;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getTotalOrderValue() {
        return transactions.stream()
                .mapToDouble(Transaction::getTotalPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", transactions=" + transactions +
                ", totalOrderValue=" + getTotalOrderValue() +
                '}';
    }
}

public class ECommerceExample {

    private List<Product> getProducts() {
        return List.of(
                new Product("Laptop", 1200.00, ProductCategory.ELECTRONICS, 30),
                new Product("Smartphone", 800.00, ProductCategory.ELECTRONICS, 50),
                new Product("Jeans", 40.00, ProductCategory.CLOTHING, 100),
                new Product("Sofa", 600.00, ProductCategory.FURNITURE, 10),
                new Product("Apple", 1.00, ProductCategory.GROCERY, 500)
        );
    }

    private List<Customer> getCustomers() {
        return List.of(
                new Customer("Alice", "alice@example.com"),
                new Customer("Bob", "bob@example.com"),
                new Customer("Charlie", "charlie@example.com"),
                new Customer("David", "david@example.com")
        );
    }

    private List<Transaction> getTransactions(List<Product> products, List<Customer> customers) {
        return List.of(
                new Transaction(customers.get(0), products.get(0), 1),
                new Transaction(customers.get(1), products.get(1), 2),
                new Transaction(customers.get(2), products.get(2), 3),
                new Transaction(customers.get(3), products.get(3), 1),
                new Transaction(customers.get(0), products.get(4), 10)
        );
    }

    private List<Order> getOrders(List<Product> products, List<Customer> customers) {
        List<Transaction> transactions = getTransactions(products, customers);
        return List.of(
                new Order(customers.get(0), transactions.subList(0, 1)),
                new Order(customers.get(1), transactions.subList(1, 2)),
                new Order(customers.get(2), transactions.subList(2, 3)),
                new Order(customers.get(3), transactions.subList(3, 4))
        );
    }

    public void runExamples() {
        List<Product> productList = getProducts();
        List<Customer> customerList = getCustomers();
        List<Order> orderList = getOrders(productList, customerList);

        // 1. Filter: Find all products in the electronics category
        List<Product> electronicsProducts = productList.stream()
                .filter(product -> product.getCategory() == ProductCategory.ELECTRONICS)
                .collect(Collectors.toList());
        System.out.println("Electronics Products: " + electronicsProducts);

        // 2. Map: Get a list of product names
        List<String> productNames = productList.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println("Product Names: " + productNames);

        // 3. Count: Count products that are in stock
        long countInStock = productList.stream()
                .filter(product -> product.getStock() > 0)
                .count();
        System.out.println("Count of products in stock: " + countInStock);

        // 4. Grouping: Count products by category
        Map<ProductCategory, Long> productsByCategory = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println("Count of products by category: " + productsByCategory);

        // 5. Sorted: Sort products by price in descending order
        List<Product> sortedByPrice = productList.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());
        System.out.println("Products sorted by price (descending): " + sortedByPrice);

        // 6. Peek: Print each product while counting them
        long totalProducts = productList.stream()
                .peek(product -> System.out.println("Product: " + product))
                .count();
        System.out.println("Total number of products: " + totalProducts);

        // 7. Limit: Get the first 2 products
        List<Product> firstTwoProducts = productList.stream()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("First two products: " + firstTwoProducts);

        // 8. Skip: Skip the first 2 products
        List<Product> skippedProducts = productList.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("Products after skipping the first 2: " + skippedProducts);

        // 9. Find First: Find the first product with a price greater than 500
        Optional<Product> firstExpensiveProduct = productList.stream()
                .filter(product -> product.getPrice() > 500)
                .findFirst();
        firstExpensiveProduct.ifPresent(product -> System.out.println("First expensive product: " + product));

        // 10. Find Any: Find any product in the grocery category
        Optional<Product> anyGroceryProduct = productList.stream()
                .filter(product -> product.getCategory() == ProductCategory.GROCERY)
                .findAny();
        anyGroceryProduct.ifPresent(product -> System.out.println("Any grocery product: " + product));

        // 11. Reduce: Find the total value of products in stock
        double totalStockValue = productList.stream()
                .mapToDouble(product -> product.getPrice() * product.getStock())
                .sum();
        System.out.println("Total stock value: " + totalStockValue);

        // 12. Collect: Gather products with a price above 100 into a list
        List<Product> expensiveProducts = productList.stream()
                .filter(product -> product.getPrice() > 100)
                .collect(Collectors.toList());
        System.out.println("Products with price above 100: " + expensiveProducts);

        // 13. Grouping by Category: Group products by their category
        Map<ProductCategory, List<Product>> productsGroupedByCategory = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("Products grouped by category: " + productsGroupedByCategory);

        // 14. Join: Join all product names into a single string
        String allProductNames = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));
        System.out.println("All product names: " + allProductNames);

        // 15. Distinct: Get distinct product categories
        List<ProductCategory> distinctCategories = productList.stream()
                .map(Product::getCategory)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct product categories: " + distinctCategories);

        // 16. Filtering and Collecting: Collect customers with a specific email domain
        List<Customer> gmailCustomers = customerList.stream()
                .filter(customer -> customer.getEmail().endsWith("@example.com"))
                .collect(Collectors.toList());
        System.out.println("Customers with example.com email: " + gmailCustomers);

        // 17. Average Price: Calculate the average price of all products
        OptionalDouble averagePrice = productList.stream()
                .mapToDouble(Product::getPrice)
                .average();
        averagePrice.ifPresent(avg -> System.out.println("Average product price: " + avg));

        // 18. Count Transactions: Count total transactions for each customer
        Map<Customer, Long> transactionsCountByCustomer = getTransactions(productList, customerList).stream()
                .collect(Collectors.groupingBy(Transaction::getCustomer, Collectors.counting()));
        System.out.println("Transaction count by customer: " + transactionsCountByCustomer);

        // 19. Total Order Value: Get total order value for each order
        for (Order order : orderList) {
            System.out.println("Order for " + order.getCustomer().getName() + " total value: " + order.getTotalOrderValue());
        }

        // 20. Grouping and Summing: Sum the total price of transactions for each customer
        Map<Customer, Double> totalSpentByCustomer = getTransactions(productList, customerList).stream()
                .collect(Collectors.groupingBy(Transaction::getCustomer,
                        Collectors.summingDouble(Transaction::getTotalPrice)));
        System.out.println("Total spent by each customer: " + totalSpentByCustomer);

        // 21. Partitioning: Partition products into those priced above and below 100
        Map<Boolean, List<Product>> partitionedProducts = productList.stream()
                .collect(Collectors.partitioningBy(product -> product.getPrice() > 100));
        System.out.println("Products partitioned by price > 100: " + partitionedProducts);

        // 22. Count Unique Products: Count distinct products in orders
        long uniqueProductCount = orderList.stream()
                .flatMap(order -> order.getTransactions().stream())
                .map(transaction -> transaction.getProduct().getName())
                .distinct()
                .count();
        System.out.println("Count of unique products in orders: " + uniqueProductCount);

        // 23. Collecting to Set: Collect unique product names
        Set<String> uniqueProductNames = productList.stream()
                .map(Product::getName)
                .collect(Collectors.toSet());
        System.out.println("Unique product names: " + uniqueProductNames);

        // 24. Mapping and Filtering: Get names of customers who bought more than 2 items
        List<String> frequentCustomers = getTransactions(productList, customerList).stream()
                .filter(transaction -> transaction.getQuantity() > 2)
                .map(transaction -> transaction.getCustomer().getName())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Customers who bought more than 2 items: " + frequentCustomers);

        // 25. Total Transactions Value: Calculate the total value of all transactions
        double totalTransactionsValue = getTransactions(productList, customerList).stream()
                .mapToDouble(Transaction::getTotalPrice)
                .sum();
        System.out.println("Total value of all transactions: " + totalTransactionsValue);

        // 26. Products Low on Stock: Find products with low stock (less than 10)
        List<Product> lowStockProducts = productList.stream()
                .filter(product -> product.getStock() < 10)
                .collect(Collectors.toList());
        System.out.println("Products low on stock: " + lowStockProducts);

        // 27. Total Quantity Sold: Calculate total quantity sold for each product
        Map<Product, Integer> totalQuantitySold = getTransactions(productList, customerList).stream()
                .collect(Collectors.groupingBy(Transaction::getProduct,
                        Collectors.summingInt(Transaction::getQuantity)));
        System.out.println("Total quantity sold for each product: " + totalQuantitySold);

        // 28. Group Orders by Customer: Group orders by customer
        Map<Customer, List<Order>> ordersByCustomer = orderList.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
        System.out.println("Orders grouped by customer: " + ordersByCustomer);

        // 29. Most Popular Product: Find the product sold the most
        Optional<Map.Entry<Product, Integer>> mostPopularProduct = totalQuantitySold.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        mostPopularProduct.ifPresent(entry -> System.out.println("Most popular product: " + entry.getKey() + " sold " + entry.getValue() + " times"));

        // 30. Average Order Value: Calculate the average value of orders
        OptionalDouble averageOrderValue = orderList.stream()
                .mapToDouble(Order::getTotalOrderValue)
                .average();
        averageOrderValue.ifPresent(avg -> System.out.println("Average order value: " + avg));
    }

    public static void main(String[] args) {
        ECommerceExample example = new ECommerceExample();
        example.runExamples();
    }
}
/*


Certainly! Below is a Java program that creates `Product`, `Customer`, `Transaction`, and `Order` classes, each with relevant fields and methods. I also included 30 scenarios using Java Streams to demonstrate various operations on these classes.

```java
package com.cg.java8.scenarios;

import java.util.*;
import java.util.stream.Collectors;

enum ProductCategory {
    ELECTRONICS, GROCERY, CLOTHING, FURNITURE
}

class Product {
    private String name;
    private double price;
    private ProductCategory category;
    private int stock;

    public Product(String name, double price, ProductCategory category, int stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", stock=" + stock +
                '}';
    }
}

class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

class Transaction {
    private Customer customer;
    private Product product;
    private int quantity;

    public Transaction(Customer customer, Product product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "customer=" + customer +
                ", product=" + product +
                ", quantity=" + quantity +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}

class Order {
    private Customer customer;
    private List<Transaction> transactions;

    public Order(Customer customer, List<Transaction> transactions) {
        this.customer = customer;
        this.transactions = transactions;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getTotalOrderValue() {
        return transactions.stream()
                .mapToDouble(Transaction::getTotalPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", transactions=" + transactions +
                ", totalOrderValue=" + getTotalOrderValue() +
                '}';
    }
}

public class ECommerceExample {

    private List<Product> getProducts() {
        return List.of(
                new Product("Laptop", 1200.00, ProductCategory.ELECTRONICS, 30),
                new Product("Smartphone", 800.00, ProductCategory.ELECTRONICS, 50),
                new Product("Jeans", 40.00, ProductCategory.CLOTHING, 100),
                new Product("Sofa", 600.00, ProductCategory.FURNITURE, 10),
                new Product("Apple", 1.00, ProductCategory.GROCERY, 500)
        );
    }

    private List<Customer> getCustomers() {
        return List.of(
                new Customer("Alice", "alice@example.com"),
                new Customer("Bob", "bob@example.com"),
                new Customer("Charlie", "charlie@example.com"),
                new Customer("David", "david@example.com")
        );
    }

    private List<Transaction> getTransactions(List<Product> products, List<Customer> customers) {
        return List.of(
                new Transaction(customers.get(0), products.get(0), 1),
                new Transaction(customers.get(1), products.get(1), 2),
                new Transaction(customers.get(2), products.get(2), 3),
                new Transaction(customers.get(3), products.get(3), 1),
                new Transaction(customers.get(0), products.get(4), 10)
        );
    }

    private List<Order> getOrders(List<Product> products, List<Customer> customers) {
        List<Transaction> transactions = getTransactions(products, customers);
        return List.of(
                new Order(customers.get(0), transactions.subList(0, 1)),
                new Order(customers.get(1), transactions.subList(1, 2)),
                new Order(customers.get(2), transactions.subList(2, 3)),
                new Order(customers.get(3), transactions.subList(3, 4))
        );
    }

    public void runExamples() {
        List<Product> productList = getProducts();
        List<Customer> customerList = getCustomers();
        List<Order> orderList = getOrders(productList, customerList);

        // 1. Filter: Find all products in the electronics category
        List<Product> electronicsProducts = productList.stream()
                .filter(product -> product.getCategory() == ProductCategory.ELECTRONICS)
                .collect(Collectors.toList());
        System.out.println("Electronics Products: " + electronicsProducts);

        // 2. Map: Get a list of product names
        List<String> productNames = productList.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println("Product Names: " + productNames);

        // 3. Count: Count products that are in stock
        long countInStock = productList.stream()
                .filter(product -> product.getStock() > 0)
                .count();
        System.out.println("Count of products in stock: " + countInStock);

        // 4. Grouping: Count products by category
        Map<ProductCategory, Long> productsByCategory = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println("Count of products by category: " + productsByCategory);

        // 5. Sorted: Sort products by price in descending order
        List<Product> sortedByPrice = productList.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());
        System.out.println("Products sorted by price (descending): " + sortedByPrice);

        // 6. Peek: Print each product while counting them
        long totalProducts = productList.stream()
                .peek(product -> System.out.println("Product: " + product))
                .count();
        System.out.println("Total number of products: " + totalProducts);

        // 7. Limit: Get the first 2 products
        List<Product> firstTwoProducts = productList.stream()
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("First two products: " + firstTwoProducts);

        // 8. Skip: Skip the first 2 products
        List<Product> skippedProducts = productList.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("Products after skipping the first 2: " + skippedProducts);

        // 9. Find First: Find the first product with a price greater than 500
        Optional<Product> firstExpensiveProduct = productList.stream()
                .filter(product -> product.getPrice() > 500)
                .findFirst();
        firstExpensiveProduct.ifPresent(product -> System.out.println("First expensive product: " + product));

        // 10. Find Any: Find any product in the grocery category
        Optional<Product> anyGroceryProduct = productList.stream()
                .filter(product -> product.getCategory() == ProductCategory.GROCERY)
                .findAny();
        anyGroceryProduct.ifPresent(product -> System.out.println("Any grocery product: " + product));

        // 11. Reduce: Find the total value of products in stock
        double totalStockValue = productList.stream()
                .mapToDouble(product -> product.getPrice() * product.getStock())
                .sum();
        System.out.println("Total stock value: " + totalStockValue);

        // 12. Collect: Gather products with a price above 100 into a list
        List<Product> expensiveProducts = productList.stream()
                .filter(product -> product.getPrice() > 100)
                .collect(Collectors.toList());
        System.out.println("Products with price above 100: " + expensiveProducts);

        // 13. Grouping by Category: Group products by their category
        Map<ProductCategory, List<Product>> productsGroupedByCategory = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("Products grouped by category: " + productsGroupedByCategory);

        // 14. Join: Join all product names into a single string
        String allProductNames = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));
        System.out.println("All product names: " + allProductNames);

        // 15. Distinct: Get distinct product categories
        List<ProductCategory> distinctCategories = productList.stream()
                .map(Product::getCategory)
                .distinct()
                .collect(Collectors.toList());
        System.out.println

("Distinct product categories: " + distinctCategories);

        // 16. Filtering and Collecting: Collect customers with a specific email domain
        List<Customer> gmailCustomers = customerList.stream()
                .filter(customer -> customer.getEmail().endsWith("@example.com"))
                .collect(Collectors.toList());
        System.out.println("Customers with example.com email: " + gmailCustomers);

        // 17. Average Price: Calculate the average price of all products
        OptionalDouble averagePrice = productList.stream()
                .mapToDouble(Product::getPrice)
                .average();
        averagePrice.ifPresent(avg -> System.out.println("Average product price: " + avg));

        // 18. Count Transactions: Count total transactions for each customer
        Map<Customer, Long> transactionsCountByCustomer = getTransactions(productList, customerList).stream()
                .collect(Collectors.groupingBy(Transaction::getCustomer, Collectors.counting()));
        System.out.println("Transaction count by customer: " + transactionsCountByCustomer);

        // 19. Total Order Value: Get total order value for each order
        for (Order order : orderList) {
            System.out.println("Order for " + order.getCustomer().getName() + " total value: " + order.getTotalOrderValue());
        }

        // 20. Grouping and Summing: Sum the total price of transactions for each customer
        Map<Customer, Double> totalSpentByCustomer = getTransactions(productList, customerList).stream()
                .collect(Collectors.groupingBy(Transaction::getCustomer,
                        Collectors.summingDouble(Transaction::getTotalPrice)));
        System.out.println("Total spent by each customer: " + totalSpentByCustomer);

        // 21. Partitioning: Partition products into those priced above and below 100
        Map<Boolean, List<Product>> partitionedProducts = productList.stream()
                .collect(Collectors.partitioningBy(product -> product.getPrice() > 100));
        System.out.println("Products partitioned by price > 100: " + partitionedProducts);

        // 22. Count Unique Products: Count distinct products in orders
        long uniqueProductCount = orderList.stream()
                .flatMap(order -> order.getTransactions().stream())
                .map(transaction -> transaction.getProduct().getName())
                .distinct()
                .count();
        System.out.println("Count of unique products in orders: " + uniqueProductCount);

        // 23. Collecting to Set: Collect unique product names
        Set<String> uniqueProductNames = productList.stream()
                .map(Product::getName)
                .collect(Collectors.toSet());
        System.out.println("Unique product names: " + uniqueProductNames);

        // 24. Mapping and Filtering: Get names of customers who bought more than 2 items
        List<String> frequentCustomers = getTransactions(productList, customerList).stream()
                .filter(transaction -> transaction.getQuantity() > 2)
                .map(transaction -> transaction.getCustomer().getName())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Customers who bought more than 2 items: " + frequentCustomers);

        // 25. Total Transactions Value: Calculate the total value of all transactions
        double totalTransactionsValue = getTransactions(productList, customerList).stream()
                .mapToDouble(Transaction::getTotalPrice)
                .sum();
        System.out.println("Total value of all transactions: " + totalTransactionsValue);

        // 26. Products Low on Stock: Find products with low stock (less than 10)
        List<Product> lowStockProducts = productList.stream()
                .filter(product -> product.getStock() < 10)
                .collect(Collectors.toList());
        System.out.println("Products low on stock: " + lowStockProducts);

        // 27. Total Quantity Sold: Calculate total quantity sold for each product
        Map<Product, Integer> totalQuantitySold = getTransactions(productList, customerList).stream()
                .collect(Collectors.groupingBy(Transaction::getProduct,
                        Collectors.summingInt(Transaction::getQuantity)));
        System.out.println("Total quantity sold for each product: " + totalQuantitySold);

        // 28. Group Orders by Customer: Group orders by customer
        Map<Customer, List<Order>> ordersByCustomer = orderList.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
        System.out.println("Orders grouped by customer: " + ordersByCustomer);

        // 29. Most Popular Product: Find the product sold the most
        Optional<Map.Entry<Product, Integer>> mostPopularProduct = totalQuantitySold.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        mostPopularProduct.ifPresent(entry -> System.out.println("Most popular product: " + entry.getKey() + " sold " + entry.getValue() + " times"));

        // 30. Average Order Value: Calculate the average value of orders
        OptionalDouble averageOrderValue = orderList.stream()
                .mapToDouble(Order::getTotalOrderValue)
                .average();
        averageOrderValue.ifPresent(avg -> System.out.println("Average order value: " + avg));
    }

    public static void main(String[] args) {
        ECommerceExample example = new ECommerceExample();
        example.runExamples();
    }
}
```

### Explanation of the Scenarios:

1. **Filter**: Finds all products in the electronics category.
2. **Map**: Extracts the names of all products.
3. **Count**: Counts how many products are in stock.
4. **Grouping**: Counts products by category.
5. **Sorted**: Sorts products by price in descending order.
6. **Peek**: Prints each product while counting.
7. **Limit**: Gets the first 2 products.
8. **Skip**: Skips the first 2 products.
9. **Find First**: Finds the first product with a price greater than 500.
10. **Find Any**: Finds any product in the grocery category.
11. **Reduce**: Calculates the total value of products in stock.
12. **Collect**: Gathers products with a price above 100 into a list.
13. **Grouping by Category**: Groups products by their category.
14. **Join**: Joins all product names into a single string.
15. **Distinct**: Gets distinct product categories.
16. **Filtering and Collecting**: Collects customers with a specific email domain.
17. **Average Price**: Calculates the average price of all products.
18. **Count Transactions**: Counts total transactions for each customer.
19. **Total Order Value**: Gets the total order value for each order.
20. **Grouping and Summing**: Sums the total price of transactions for each customer.
21. **Partitioning**: Partitions products into those priced above and below 100.
22. **Count Unique Products**: Counts distinct products in orders.
23. **Collecting to Set**: Collects unique product names.
24. **Mapping and Filtering**: Gets names of customers who bought more than 2 items.
25. **Total Transactions Value**: Calculates the total value of all transactions.
26. **Products Low on Stock**: Finds products with low stock.
27. **Total Quantity Sold**: Calculates total quantity sold for each product.
28. **Group Orders by Customer**: Groups orders by customer.
29. **Most Popular Product**: Finds the product sold the most.
30. **Average Order Value**: Calculates the average value of orders.

*/
