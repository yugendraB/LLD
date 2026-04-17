package atmCashDispenser.cashHandler;

public abstract class BaseCashHandler implements CashHandler{
    private CashHandler next;
    int denominition;

    public BaseCashHandler(int denominition) {
        this.denominition = denominition;
    }

    @Override
    public void setNext(CashHandler handler) {
        this.next = handler;
    }

    @Override
    public void handle(int amount) {
        if(amount >= denominition){
            int noteCount = amount/denominition;
            amount = amount%denominition;
            System.out.println(denominition + "Dispenser: " + noteCount + " Notes dispensed");
            forward(amount);
        }
        else{
            forward(amount);
        }
    }

    public void forward(int amount){
        if(null!=next){
            this.next.handle(amount);
        }

    }
}
