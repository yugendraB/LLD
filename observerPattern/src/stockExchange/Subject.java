package stockExchange;

import stockExchange.observers.StockObserver;

public interface Subject {
    void addObserver(StockObserver observer);
    void removeObserver(StockObserver observer);
    void notifyObserver();
}
