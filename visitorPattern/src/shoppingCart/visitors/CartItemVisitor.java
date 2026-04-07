package shoppingCart.visitors;

import shoppingCart.items.CartItem;
import shoppingCart.items.DigitalItem;
import shoppingCart.items.GiftCard;
import shoppingCart.items.PhysicalItem;

public interface CartItemVisitor {

    public void visitPhysicalCartItem(PhysicalItem item);
    public void visitDigitalItem(DigitalItem item);
    public void visitGiftCard(GiftCard item);
}
