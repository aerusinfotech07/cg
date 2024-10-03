package com.cg.java8.scenarios.mobile.shop.computer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ComputerShop {

    // Product and Customer Classes
    static class Product {
        String name;
        double price;
        String category;
        int stock;

        public Product(String name, double price, String category, int stock) {
            this.name = name;
            this.price = price;
            this.category = category;
            this.stock = stock;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
        public String getCategory() { return category; }
        public int getStock() { return stock; }

        @Override
        public String toString() {
            return name + " ($" + price + ")";
        }
    }

    static class Customer {
        String name;
        List<Product> purchasedProducts;

        public Customer(String name) {
            this.name = name;
            this.purchasedProducts = new ArrayList<>();
        }

        public String getName() { return name; }
        public List<Product> getPurchasedProducts() { return purchasedProducts; }

        public void purchase(Product product) {
            purchasedProducts.add(product);
        }

        @Override
        public String toString() {
            return name + " (Purchases: " + purchasedProducts.size() + ")";
        }
    }

    // Lists to store products and customers
    private List<Product> products = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    // Constructor to initialize data
    public ComputerShop() {
        // Sample products
        products.add(new Product("Gaming PC", 1200.00, "PC", 10));
        products.add(new Product("Gaming Laptop", 1500.00, "Laptop", 5));
        products.add(new Product("Mechanical Keyboard", 100.00, "Accessory", 50));
        products.add(new Product("Gaming Mouse", 50.00, "Accessory", 30));
        products.add(new Product("Monitor", 300.00, "Accessory", 20));
        products.add(new Product("Motherboard", 150.00, "Hardware", 15));
        products.add(new Product("RAM", 80.00, "Hardware", 40));

        // Sample customers
        customers.add(new Customer("Alice"));
        customers.add(new Customer("Bob"));
        customers.add(new Customer("Charlie"));
    }

    // 1. Add New Product
    public void addProduct(String name, double price, String category, int stock) {
        products.add(new Product(name, price, category, stock));
    }

    // 2. Remove Product by Name
    public boolean removeProduct(String name) {
        return products.removeIf(product -> product.getName().equals(name));
    }

    // 3. Update Product Details
    public void updateProduct(String name, double price, String category, int stock) {
        products.stream()
            .filter(product -> product.getName().equals(name))
            .findFirst()
            .ifPresent(product -> {
                product.price = price;
                product.category = category;
                product.stock = stock;
            });
    }

    // 4. Search Product by Name
    public Optional<Product> searchProductByName(String name) {
        return products.stream()
            .filter(product -> product.getName().equalsIgnoreCase(name))
            .findFirst();
    }

    // 5. List All Products
    public List<Product> listAllProducts() {
        return new ArrayList<>(products);
    }

    // 6. Filter Products by Category
    public List<Product> filterProductsByCategory(String category) {
        return products.stream()
            .filter(product -> product.getCategory().equalsIgnoreCase(category))
            .collect(Collectors.toList());
    }

    // 7. Sort Products by Price
    public List<Product> sortProductsByPrice() {
        return products.stream()
            .sorted(Comparator.comparingDouble(Product::getPrice))
            .collect(Collectors.toList());
    }

    // 8. Find Top N Expensive Products
    public List<Product> findTopNExpensiveProducts(int n) {
        return products.stream()
            .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
            .limit(n)
            .collect(Collectors.toList());
    }

    // 9. Check Product Availability
    public boolean isProductAvailable(String name) {
        return products.stream()
            .anyMatch(product -> product.getName().equalsIgnoreCase(name) && product.getStock() > 0);
    }

    // 10. Track Product Sales
    public void trackProductSales(String productName, int quantity) {
        products.stream()
            .filter(product -> product.getName().equalsIgnoreCase(productName))
            .findFirst()
            .ifPresent(product -> product.stock -= quantity);
    }

    // 11. Add New Customer
    public void addCustomer(String name) {
        customers.add(new Customer(name));
    }

    // 12. Update Customer Information
    public void updateCustomer(String name, String newName) {
        customers.stream()
            .filter(customer -> customer.getName().equalsIgnoreCase(name))
            .findFirst()
            .ifPresent(customer -> customer.name = newName);
    }

    // 13. List All Customers
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers);
    }

    // 14. Search Customer by Name
    public Optional<Customer> searchCustomerByName(String name) {
        return customers.stream()
            .filter(customer -> customer.getName().equalsIgnoreCase(name))
            .findFirst();
    }

    // 15. Check Customer Purchase History
    public List<Product> checkCustomerPurchaseHistory(String customerName) {
        return customers.stream()
            .filter(customer -> customer.getName().equalsIgnoreCase(customerName))
            .flatMap(customer -> customer.getPurchasedProducts().stream())
            .collect(Collectors.toList());
    }

    // 16. Generate Quotation for Single Product
    public String generateQuotationForSingleProduct(String productName) {
        return searchProductByName(productName)
            .map(product -> "Quotation: " + product.getName() + " - $" + product.getPrice())
            .orElse("Product not found");
    }

    // 17. Generate Quotation for Multiple Products
    public String generateQuotationForMultipleProducts(List<String> productNames) {
        List<Product> productsToQuote = productNames.stream()
            .map(this::searchProductByName)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());

        double total = productsToQuote.stream()
            .mapToDouble(Product::getPrice)
            .sum();

        return "Total Quotation: $" + total + " for products: " + productsToQuote;
    }

    // 18. Apply Discounts on Quotations
    public String generateDiscountedQuotation(String productName, double discountPercentage) {
        return searchProductByName(productName)
            .map(product -> {
                double discountedPrice = product.getPrice() * (1 - discountPercentage / 100);
                return "Discounted Quotation: " + product.getName() + " - $" + discountedPrice;
            })
            .orElse("Product not found");
    }

    // 19. Include Taxes in Quotations
    public String generateTaxedQuotation(String productName, double taxPercentage) {
        return searchProductByName(productName)
            .map(product -> {
                double taxedPrice = product.getPrice() * (1 + taxPercentage / 100);
                return "Taxed Quotation: " + product.getName() + " - $" + taxedPrice;
            })
            .orElse("Product not found");
    }

    // 20. Generate Quotation in PDF (Simulation)
    public String generateQuotationPDF(String productName) {
        return "PDF generated for product: " + productName;
    }

    // 21. Purchase Product
    public void purchaseProduct(String customerName, String productName) {
        Optional<Customer> customerOpt = searchCustomerByName(customerName);
        Optional<Product> productOpt = searchProductByName(productName);

        if (customerOpt.isPresent() && productOpt.isPresent()) {
            Customer customer = customerOpt.get();
            Product product = productOpt.get();

            if (product.getStock() > 0) {
                customer.purchase(product);
                trackProductSales(productName, 1);
            } else {
                System.out.println("Product is out of stock.");
            }
        } else {
            System.out.println("Customer or product not found.");
        }
    }

    // 22. Bulk Purchase Discount
    public double calculateBulkPurchaseDiscount(List<String> productNames) {
        return productNames.size() > 5 ? 10.0 : 0.0; // 10% discount for more than 5 items
    }

    // 23. Payment Processing (Simulation)
    public String processPayment(String customerName, double amount) {
        return "Payment of $" + amount + " processed for " + customerName;
    }

    // 24. Track Inventory After Purchase
    public void updateInventoryAfterPurchase(String productName, int quantity) {
        products.stream()
            .filter(product -> product.getName().equalsIgnoreCase(productName))
            .findFirst()
            .ifPresent(product -> product.stock -= quantity);
    }

    // 25. Return/Exchange Product
    public void returnProduct(String customerName, String productName) {
        Optional<Customer> customerOpt = searchCustomerByName(customerName);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            customer.getPurchasedProducts().removeIf(product -> product.getName().equalsIgnoreCase(productName));
            System.out.println("Product returned: " + productName);
        }
    }

    // 26. Daily Sales Report
    public double generateDailySalesReport() {
        return customers.stream()
            .flatMap(customer -> customer.getPurchasedProducts().stream())
            .mapToDouble(Product::getPrice)
            .sum();
    }

    // 27. Monthly Sales Summary (Simulation)
    public String generateMonthlySalesSummary() {
        double totalSales = generateDailySalesReport() * 30; // Simple estimation
        return "Estimated Monthly Sales: $" + totalSales;
    }

    // 28. Top Selling Products
    public List<Product> identifyTopSellingProducts(int n) {
        Map<String, Long> productCount = customers.stream()
            .flatMap(customer -> customer.getPurchasedProducts().stream())
            .collect(Collectors.groupingBy(Product::getName, Collectors.counting()));

        return productCount.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(n)
            .map(entry -> searchProductByName(entry.getKey()).orElse(null))
            .collect(Collectors.toList());
    }

    // 29. Customer Purchase Trends
    public Map<String, Long> analyzeCustomerPurchaseTrends() {
        return customers.stream()
            .flatMap(customer -> customer.getPurchasedProducts().stream())
            .collect(Collectors.groupingBy(Product::getName, Collectors.counting()));
    }

    // 30. Inventory Status Report
    public List<Product> reportInventoryStatus() {
        return products.stream()
            .filter(product -> product.getStock() < 10)
            .collect(Collectors.toList());
    }

    // 31. Search Bar for Products
    public List<Product> searchProducts(String keyword) {
        return products.stream()
            .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()))
            .collect(Collectors.toList());
    }

    // 32. Filter Options on Product Page
    public List<Product> filterProductsByPriceRange(double min, double max) {
        return products.stream()
            .filter(product -> product.getPrice() >= min && product.getPrice() <= max)
            .collect(Collectors.toList());
    }

    // 33. Sort Options on Customer Page
    public List<Customer> sortCustomersByLastPurchaseDate() {
        // For simplicity, we assume customers are sorted by name (this can be adjusted)
        return customers.stream()
            .sorted(Comparator.comparing(Customer::getName))
            .collect(Collectors.toList());
    }

    // 34. Responsive Quotation Form (Simulation)
    public String createResponsiveQuotationForm() {
        return "Quotation form created.";
    }

    // 35. Dynamic Product Recommendation (based on purchased products)
    public List<Product> recommendProducts(String customerName) {
        List<Product> purchased = checkCustomerPurchaseHistory(customerName);
        return products.stream()
            .filter(product -> !purchased.contains(product)) // Recommend products not purchased
            .collect(Collectors.toList());
    }

    // 36. Stream Processing for Sales Data
    public void processSalesData() {
        // This would be a placeholder for actual processing
        System.out.println("Sales data processed.");
    }

    // 37. Lambda Expressions for Filtering
    public List<Product> filterProductsUsingLambda() {
        return products.stream()
            .filter(product -> product.getPrice() < 500)
            .collect(Collectors.toList());
    }

    // 38. Functional Interfaces for Operations
    public void performOperation(Function<Double, Double> operation, double value) {
        System.out.println("Operation result: " + operation.apply(value));
    }

    // 39. Method References for Sorting
    public List<Product> sortProductsUsingMethodReference() {
        return products.stream()
            .sorted(Comparator.comparingDouble(Product::getPrice))
            .collect(Collectors.toList());
    }

    // 40. Optional for Handling Missing Data
    public String getCustomerDetails(String name) {
        return searchCustomerByName(name)
            .map(Customer::getName)
            .orElse("Customer not found");
    }

    // 41. Low Stock Alert
    public List<Product> lowStockAlert() {
        return products.stream()
            .filter(product -> product.getStock() < 5)
            .collect(Collectors.toList());
    }

    // 42. Email Confirmation for Quotations (Simulation)
    public String sendEmailConfirmation(String customerName) {
        return "Email confirmation sent to " + customerName;
    }

    // 43. Customer Birthday Discounts (Simulation)
    public String birthdayDiscount(String customerName) {
        return "Birthday discount applied for " + customerName;
    }

    // 44. Integrate Payment Gateway (Simulation)
    public String integratePaymentGateway() {
        return "Payment gateway integrated.";
    }

    // 45. Connect to Supplier API (Simulation)
    public String connectToSupplierAPI() {
        return "Connected to supplier API.";
    }

    // 46. Currency Converter for International Sales (Simulation)
    public double convertCurrency(double amount, double conversionRate) {
        return amount * conversionRate;
    }

    // 47. Customer Loyalty Program (Simulation)
    public String manageLoyaltyProgram(String customerName) {
        return "Loyalty program managed for " + customerName;
    }

    // 48. User Authentication and Role Management (Simulation)
    public String manageUserRole(String username, String role) {
        return "User " + username + " assigned role: " + role;
    }

    // 49. Feedback System (Simulation)
    public String collectCustomerFeedback(String feedback) {
        return "Feedback collected: " + feedback;
    }

    // 50. Audit Trail of Transactions (Simulation)
    public String maintainAuditTrail(String transaction) {
        return "Audit trail entry: " + transaction;
    }

    // Main method for testing
    public static void main(String[] args) {
        ComputerShop shop = new ComputerShop();

        // Simulating purchases
        shop.purchaseProduct("Alice", "Gaming PC");
        shop.purchaseProduct("Bob", "Gaming Laptop");
        shop.purchaseProduct("Charlie", "Mechanical Keyboard");

        // Generating reports
        System.out.println("Daily Sales Report: $" + shop.generateDailySalesReport());
        System.out.println("Top Selling Products: " + shop.identifyTopSellingProducts(2));
        System.out.println("Low Stock Inventory: " + shop.reportInventoryStatus());
        System.out.println("Customer Purchase Trends: " + shop.analyzeCustomerPurchaseTrends());
        
        // Test other features
        System.out.println(shop.generateQuotationForSingleProduct("Gaming PC"));
        System.out.println(shop.sendEmailConfirmation("Alice"));
        System.out.println(shop.birthdayDiscount("Charlie"));
    }
}
/*
Features and Scenarios
Product Management:

Add, remove, update, search, and list products.
Filter and sort products based on various criteria.
Track product availability and sales.
Customer Management:

Add, update, search, and list customers.
Check customer purchase history.
Quotation Generation:

Generate quotations for single and multiple products.
Apply discounts and calculate taxes.
Simulate generating quotations in PDF format.
Purchase Scenarios:

Purchase products, manage returns, and track inventory.
Offer bulk purchase discounts.
Reporting:

Generate daily sales reports and monthly summaries.
Identify top-selling products and analyze purchase trends.
User Interface Features:

Search for products, filter options, and dynamic recommendations.
Functional Programming Features:

Use streams and lambda expressions for various operations.
Handle optional values gracefully.
Notifications and Alerts:

Low stock alerts and email confirmations.
Integration with External Services:

Simulate integration with payment gateways and supplier APIs.
Currency conversion for international sales.
Miscellaneous Features:

Manage customer loyalty programs, user authentication, feedback systems, and audit trails.
Testing
The main method simulates some purchases and generates reports to demonstrate the functionality of the ComputerShop class. You can expand or modify scenarios to fit your application needs further.

*/