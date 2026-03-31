package shippingCostService.models;

public class Order {
    private double weight;
    private String destinationZone;
    private double amount;

    public Order(double weight, String destinationZone, double amount) {
        this.weight = weight;
        this.destinationZone = destinationZone;
        this.amount = amount;
    }

    public double getWeight() {
        return weight;
    }

    public String getDestinationZone() {
        return destinationZone;
    }

    public double getAmount() {
        return amount;
    }
}
