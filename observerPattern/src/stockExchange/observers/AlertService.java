package stockExchange.observers;

import stockExchange.StockExchange;
import stockExchange.model.Stock;

import java.util.*;

public class AlertService implements StockObserver{
    private final Map<Stock, Double> thresholds = new HashMap<>();

    public void setAlert(Stock stock, Double price){
        thresholds.put(stock, price);
    }
    @Override
    public void onPriceUpdate(StockExchange exchange) {
        Stock stock = exchange.getLastUpdatedStock();
        if(thresholds.containsKey(stock)){
            double thresholdValue = thresholds.get(stock);
            double price = exchange.getPrice(stock);
            if(price>thresholdValue){
                System.out.println("ALERT -> " + stock.getSymbol() + " hit $" + price +
                        " (threshold: $" + thresholdValue + ")");
            }
        }
    }
}
