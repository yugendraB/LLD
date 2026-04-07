package shoppingCart.items;

import shoppingCart.visitors.CartItemVisitor;

public abstract class DigitalItem implements CartItem{
    boolean taxApplicable = false;
    boolean shippingChargesApplicable = false;
    boolean eligibleForCoupons = false;
    double price;
    public DigitalItem(double price) {
        this.price= price;
        taxApplicable = true;
        shippingChargesApplicable = false;
        eligibleForCoupons = true;
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

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(CartItemVisitor visitor) {
        visitor.visitDigitalItem(this);
    }
}
