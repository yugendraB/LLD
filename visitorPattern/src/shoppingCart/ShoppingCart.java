package shoppingCart;

import shoppingCart.items.CartItem;
import shoppingCart.products.AmazonGiftCard;
import shoppingCart.products.AudioBook;
import shoppingCart.products.Fan;
import shoppingCart.visitors.DiscountCalculatorVisitor;
import shoppingCart.visitors.ShippingCostCalculator;
import shoppingCart.visitors.TaxCalculatorVisitor;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public static void main(String[] args) {
        List<CartItem> items = new ArrayList<>();
        items.add(new Fan(2,150));
        items.add(new AudioBook(500));
        items.add(new AmazonGiftCard(600));

        DiscountCalculatorVisitor discountCalculatorVisitor = new DiscountCalculatorVisitor();
        TaxCalculatorVisitor taxCalculatorVisitor = new TaxCalculatorVisitor();
        ShippingCostCalculator shippingCostCalculator = new ShippingCostCalculator();
        for(CartItem item : items){
            item.accept(discountCalculatorVisitor);
        }
        for(CartItem item : items){
            item.accept(taxCalculatorVisitor);
        }
        for(CartItem item : items){
            item.accept(shippingCostCalculator);
        }

    }


}
