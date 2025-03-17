// Abstract class Vehicle
abstract class Vehiclee {
    protected String vehicleId;
    protected String driverName;
    protected double ratePerKm;

    public Vehiclee(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm);
    }
}

interface GPS {
    void getCurrentLocation();
    void updateLocation(String location);
}

class CarRide extends Vehiclee implements GPS {
    public CarRide(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Car location: Retrieved");
    }

    @Override
    public void updateLocation(String location) {
        System.out.println("Car location updated to: " + location);
    }
}

class BikeRide extends Vehiclee implements GPS {
    public BikeRide(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Bike location: Retrieved");
    }

    @Override
    public void updateLocation(String location) {
        System.out.println("Bike location updated to: " + location);
    }
}

class Auto extends Vehiclee implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Auto location: Retrieved");
    }

    @Override
    public void updateLocation(String location) {
        System.out.println("Auto location updated to: " + location);
    }
}

public class RideHailingApplication {
    public static void main(String[] args) {
        Vehiclee[] vehicles = {
                new CarRide("PB5754", "Harry", 7),
                new BikeRide("PB8746", "Hermoine", 6),
                new Auto("PB1111", "Ron", 10)
        };

        for (Vehiclee vehicle : vehicles) {
            vehicle.getVehicleDetails();
            if(vehicle instanceof GPS) {
                GPS location = (GPS) vehicle;
                location.getCurrentLocation();
                if (vehicle instanceof CarRide) {
                    location.updateLocation("Near Byepass");
                }
            }
            System.out.println("Fare for 10 km: " + vehicle.calculateFare(10) + "\n");
        }
    }
}