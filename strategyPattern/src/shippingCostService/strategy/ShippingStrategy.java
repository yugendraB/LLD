package shippingCostService.strategy;

import shippingCostService.models.Order;

public interface ShippingStrategy {
    double calculateCost(Order order);
}
