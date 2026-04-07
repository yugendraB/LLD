package shoppingCart.visitors;

import shoppingCart.items.DigitalItem;
import shoppingCart.items.GiftCard;
import shoppingCart.items.PhysicalItem;

public class DiscountCalculatorVisitor implements CartItemVisitor{
    @Override
    public void visitPhysicalCartItem(PhysicalItem item) {
        if(item.isEligibleForCoupons()){
            double price = item.getPrice();
            System.out.println("Discount for this item is: " + price*0.15);
        }
        else{
            System.out.println("This item is not applicable for dicount");
        }
    }

    @Override
    public void visitDigitalItem(DigitalItem item) {
        if(item.isEligibleForCoupons()){
            double price = item.getPrice();
            System.out.println("Discount for this item is: " + price*0.15);
        }
        else{
            System.out.println("This item is not applicable for dicount");
        }
    }

    @Override
    public void visitGiftCard(GiftCard item) {
        if(item.isEligibleForCoupons()){
            double price = item.getPrice();
            System.out.println("Discount for this item is: " + price*0.15);
        }
        else{
            System.out.println("This item is not applicable for dicount");
        }
    }
}
