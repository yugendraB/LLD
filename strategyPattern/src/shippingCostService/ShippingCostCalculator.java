package shippingCostService;

import shippingCostService.models.Order;
import shippingCostService.strategy.ShippingStrategy;

public class ShippingCostCalculator {
     private ShippingStrategy strategy;

     public void setStrategy(ShippingStrategy strategy){
         this.strategy = strategy;
     }

     public double calculateOrderShipmentCost(Order order){
         if(this.strategy == null) throw new IllegalStateException("No shipment strategy set to calculate shipment cost!!");

         double cost = strategy.calculateCost(order);
         System.out.println("ShippingCostService: Final Calculated Shipping Cost: $" + cost +
                 " (using " + strategy.getClass().getSimpleName() + ")");
         return cost;
     }
}
