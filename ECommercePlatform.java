import java.util.ArrayList;
import java.util.List;

abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();
}

class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.1;
    }

    public double calculateTax() {
        return getPrice() * 0.18;
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.2;
    }

    public double calculateTax() {
        return getPrice() * 0.05;
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
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
            double discount = product.calculateDiscount();
            double tax;
            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
            } else {
                tax = 0;
            }
            double finalPrice = product.getPrice() + tax - discount;

            System.out.println(product.getClass().getSimpleName() + " Final Price: " + finalPrice);
        }
    }
}
