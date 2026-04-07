package shoppingCart.items;

import shoppingCart.visitors.CartItemVisitor;

public abstract class PhysicalItem implements CartItem{
    private int weight;
    boolean taxApplicable = false;
    boolean shippingChargesApplicable = false;
    boolean eligibleForCoupons = false;
    double price;

    public PhysicalItem(int weight, double price) {
        this.weight = weight;
        taxApplicable = true;
        shippingChargesApplicable = true;
        eligibleForCoupons = true;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isTaxApplicable() {
        return taxApplicable;
    }

    public boolean isShippingChargesApplicable() {
        return shippingChargesApplicable;
    }

    public boolean isEligibleForCoupons() {
        return eligibleForCoupons;
    }

    @Override
    public void accept(CartItemVisitor visitor) {
        visitor.visitPhysicalCartItem(this);
    }
}
