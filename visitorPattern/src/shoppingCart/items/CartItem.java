package shoppingCart.items;

import shoppingCart.visitors.CartItemVisitor;

public interface CartItem {

    public void accept(CartItemVisitor visitor);
}
