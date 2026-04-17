package atmCashDispenser;

import atmCashDispenser.dispenser.CashDispenser;

public class Customer {
    public static void main(String[] args) {
        CashDispenser atm = new CashDispenser();
        atm.dispense(9745);
    }
}
