package shoppingCart.items;

import shoppingCart.visitors.CartItemVisitor;

import javax.swing.*;

public abstract class GiftCard implements CartItem{
    double price;
    boolean taxApplicable = false;
    boolean shippingChargesApplicable = false;
    boolean eligibleForCoupons = false;

    public GiftCard(double price) {
        this.price = price;
        taxApplicable = true;
        shippingChargesApplicable = false;
        eligibleForCoupons = false;
    }

    public double getPrice() {
        return price;
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
        visitor.visitGiftCard(this);
    }
}
