package shoppingCart.visitors;

import shoppingCart.items.DigitalItem;
import shoppingCart.items.GiftCard;
import shoppingCart.items.PhysicalItem;

public class TaxCalculatorVisitor implements CartItemVisitor{

    @Override
    public void visitPhysicalCartItem(PhysicalItem item) {
        if(item.isTaxApplicable()){
            double price = item.getPrice();
            System.out.println("Tax for physical Item: " + price*0.3);
        }
        else{
            System.out.println("Tax is not applicable on this item");
        }
    }

    @Override
    public void visitDigitalItem(DigitalItem item) {
        if(item.isTaxApplicable()){
            double price = item.getPrice();
            System.out.println("Tax for physical Item: " + price*0.3);
        }
        else{
            System.out.println("Tax is not applicable on this item");
        }
    }

    @Override
    public void visitGiftCard(GiftCard item) {
        if(item.isTaxApplicable()){
            double price = item.getPrice();
            System.out.println("Tax for physical Item: " + price*0.3);
        }
        else{
            System.out.println("Tax is not applicable on this item");
        }
    }
}
