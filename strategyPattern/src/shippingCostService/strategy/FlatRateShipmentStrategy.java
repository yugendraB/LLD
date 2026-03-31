package shippingCostService.strategy;

import shippingCostService.models.Order;

public class FlatRateShipmentStrategy implements ShippingStrategy{
    private double rate;
    public FlatRateShipmentStrategy(double rate){
        this.rate = rate;
    }
    @Override
    public double calculateCost(Order order) {
        System.out.println("Calculating with Flate Rate Strategy at rate: " + rate);
        return rate;
    }
}
