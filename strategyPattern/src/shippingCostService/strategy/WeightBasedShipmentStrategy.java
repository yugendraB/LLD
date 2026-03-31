package shippingCostService.strategy;

import shippingCostService.models.Order;

public class WeightBasedShipmentStrategy implements ShippingStrategy{
    private final double ratePerKg;

    public WeightBasedShipmentStrategy(double rate){
        this.ratePerKg = rate;
    }
    @Override
    public double calculateCost(Order order) {
        System.out.println("Calculating with weight based shipment stratgy, at rate: " + ratePerKg + "/KG");
        return order.getWeight() * ratePerKg;
    }
}
