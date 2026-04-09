package shoppingCart.visitors;

import shoppingCart.items.DigitalItem;
import shoppingCart.items.GiftCard;
import shoppingCart.items.PhysicalItem;

public class ShippingCostCalculator implements CartItemVisitor{
    @Override
    public void visitPhysicalCartItem(PhysicalItem item) {
        if(item.isShippingChargesApplicable()){
            double weight = item.getWeight();
            System.out.println("Shipping cost of the item is: " + weight*20);
        }
        else{
            System.out.println("Shipping charges are not applicable on this item");
        }
    }

    @Override
    public void visitDigitalItem(DigitalItem item) {
        System.out.println("Shipping chrages are not applicable on this item");
    }

    @Override
    public void visitGiftCard(GiftCard item) {
        System.out.println("Shipping chrages are not applicable on this item");
    }
}
