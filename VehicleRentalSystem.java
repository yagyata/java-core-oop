import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public void displayDetails(int days) {
        System.out.println("Vehicle Type: " + type);
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Rental Cost for " + days + " days: " + calculateRentalCost(days));
    }
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * 500;
    }

    @Override
    public double calculateInsurance() {
        return 500 * 0.1;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Details";
    }

    @Override
    public void displayDetails(int days) {
        super.displayDetails(days);
        System.out.println("Insurance Cost: " + calculateInsurance());
        System.out.println(getInsuranceDetails());
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * 200;
    }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * 1000;
    }

    @Override
    public double calculateInsurance() {
        return 1000 * 0.2;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Details";
    }

    @Override
    public void displayDetails(int days) {
        super.displayDetails(days);
        System.out.println("Insurance Cost: " + calculateInsurance());
        System.out.println(getInsuranceDetails());
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("PB91SD6846", 500));
        vehicles.add(new Bike("PB10GD5741", 200));
        vehicles.add(new Truck("HP21HR8567", 1000));

        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails(5);
            System.out.println();
        }
    }
}
