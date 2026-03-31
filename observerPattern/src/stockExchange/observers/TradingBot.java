package stockExchange.observers;

import stockExchange.StockExchange;
import stockExchange.model.Stock;

import java.util.*;

public class TradingBot implements StockObserver{
    private final Map<Stock, Double> previousPrices = new HashMap<>();
    @Override
    public void onPriceUpdate(StockExchange exchange) {
        Stock stock = exchange.getLastUpdatedStock();
        double currentPrice = exchange.getPrice(stock);
        double previousPrice = 0;
        if(previousPrices.containsKey(stock)){
            previousPrice = previousPrices.get(stock);
        }
        if (currentPrice > previousPrice) {
            System.out.println("Bot -> " + stock.getSymbol() + " rising ($" + previousPrice +
                    " -> $" + currentPrice + "). HOLD.");
        } else if (currentPrice < previousPrice) {
            System.out.println("Bot -> " + stock.getSymbol() + " dropping ($" + previousPrice +
                    " -> $" + currentPrice + "). BUY.");
        }
        previousPrices.put(stock, currentPrice);
    }
}
