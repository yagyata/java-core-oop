import java.util.ArrayList;
import java.util.List;

abstract class Product {
    private int productId;
    private String name;
    private double price;
    private String type;

    public Product(int productId, String name, double price, String type) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateDiscount();

    public void displayDetails() {
        double discount = calculateDiscount();
        double finalPrice = price - discount;
        System.out.println("Product Type: " + type);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Discount: " + discount);
        System.out.println("Final Price: " + finalPrice);
    }
}

interface Taxable {
    double calculateTax();
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price, "Electronics");
    }

    public double calculateDiscount() {
        return getPrice() * 0.1;
    }

    public double calculateTax() {
        return getPrice() * 0.18;
    }

    @Override
    public void displayDetails() {
        double discount = calculateDiscount();
        double tax = calculateTax();
        double finalPrice = getPrice() + tax - discount;
        super.displayDetails();
        System.out.println("Tax: " + tax);
        System.out.println("Final Price (After Tax): " + finalPrice);
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price, "Clothing");
    }

    public double calculateDiscount() {
        return getPrice() * 0.2;
    }

    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public void displayDetails() {
        double discount = calculateDiscount();
        double tax = calculateTax();
        double finalPrice = getPrice() + tax - discount;
        super.displayDetails();
        System.out.println("Tax: " + tax);
        System.out.println("Final Price (After Tax): " + finalPrice);
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price, "Groceries");
    }

    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Electronics(101, "Smartphone", 50000));
        products.add(new Clothing(102, "Jacket", 2000));
        products.add(new Groceries(103, "Carrots", 100));

        for (Product product : products) {
            product.displayDetails();
            System.out.println();
        }
    }
}
