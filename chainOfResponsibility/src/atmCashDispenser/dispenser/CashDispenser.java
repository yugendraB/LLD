package atmCashDispenser.dispenser;

import atmCashDispenser.cashHandler.BaseCashHandler;
import atmCashDispenser.cashHandler.FiftyDispenser;
import atmCashDispenser.cashHandler.HundredDispenser;
import atmCashDispenser.cashHandler.TenDispenser;

public class CashDispenser {
    BaseCashHandler hunderDispenser = new HundredDispenser();
    BaseCashHandler fiftyDispenser = new FiftyDispenser();
    BaseCashHandler tenDispenser = new TenDispenser();

    public CashDispenser(){
        hunderDispenser.setNext(fiftyDispenser);
        fiftyDispenser.setNext(tenDispenser);
    }
    public void dispense(int amount){
        hunderDispenser.handle(amount);
    }
}
