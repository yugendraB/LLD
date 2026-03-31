package shippingCostService.strategy;

import shippingCostService.models.Order;

public class DistanceBasedShipping implements ShippingStrategy{
    private final double ratePerKm;

    public DistanceBasedShipping(double rate){
        this.ratePerKm = rate;
    }
    @Override
    public double calculateCost(Order order) {
        System.out.println("calculating with Distance based shipment strategy. at rate: " + ratePerKm + "/KM");
        String zone = order.getDestinationZone();
        if(zone.equals("ZONE-A"))return ratePerKm * 5.0;
        else if(zone.equals("ZONE-B")) return ratePerKm * 7.0;
        else return ratePerKm * 9.0;
    }
}
