package atmCashDispenser.cashHandler;

public interface CashHandler {
    void setNext(CashHandler handler);
    void handle(int amount);
}
