package shippingCostService;

import shippingCostService.models.Order;
import shippingCostService.strategy.DistanceBasedShipping;
import shippingCostService.strategy.FlatRateShipmentStrategy;
import shippingCostService.strategy.ShippingStrategy;
import shippingCostService.strategy.WeightBasedShipmentStrategy;

public class Client {
    public static void main(String[] args) {
        Order order1 = new Order(5, "ZONE-A", 800);

        // Create different strategy instances
        ShippingStrategy flatRate = new FlatRateShipmentStrategy(10.0);
        ShippingStrategy weightBased = new WeightBasedShipmentStrategy(2.5);
        ShippingStrategy distanceBased = new DistanceBasedShipping(5.0);

        // Create context with an initial strategy
        ShippingCostCalculator shippingService = new ShippingCostCalculator();
        shippingService.setStrategy(flatRate);
        System.out.println("--- Order 1: Using Flat Rate (initial) ---");
        shippingService.calculateOrderShipmentCost(order1);

        System.out.println("\n--- Order 1: Changing to Weight-Based ---");
        shippingService.setStrategy(weightBased);
        shippingService.calculateOrderShipmentCost(order1);

        System.out.println("\n--- Order 1: Changing to Distance-Based ---");
        shippingService.setStrategy(distanceBased);
        shippingService.calculateOrderShipmentCost(order1);

    }
}
