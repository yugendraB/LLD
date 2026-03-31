package stockExchange.observers;

import stockExchange.StockExchange;
import stockExchange.model.Stock;

public class PriceDisplay implements StockObserver{
    @Override
    public void onPriceUpdate(StockExchange exchange) {
        Stock symbol = exchange.getLastUpdatedStock();
        System.out.println("Display -> " + symbol + ": $" + exchange.getPrice(symbol));
    }
}
