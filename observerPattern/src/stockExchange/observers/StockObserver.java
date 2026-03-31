package stockExchange.observers;

import stockExchange.StockExchange;

public interface StockObserver {
    void onPriceUpdate(StockExchange exchange);
}
