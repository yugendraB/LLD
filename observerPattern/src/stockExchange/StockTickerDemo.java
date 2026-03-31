package stockExchange;

import stockExchange.exceptions.ResourceAlreadyFoudException;
import stockExchange.exceptions.ResourceNotFoundException;
import stockExchange.model.Stock;
import stockExchange.observers.AlertService;
import stockExchange.observers.PriceDisplay;
import stockExchange.observers.TradingBot;

public class StockTickerDemo {
    public static void main(String[] args) {
        StockExchange exchange = new StockExchange();

        PriceDisplay display = new PriceDisplay();
        AlertService alerts = new AlertService();
        TradingBot bot = new TradingBot();

        exchange.addObserver(display);
        exchange.addObserver(alerts);
        exchange.addObserver(bot);

        Stock appleStock = new Stock("AAPL", "Apple", "Apple", "TECH");
        Stock googleStock = new Stock("GOOG", "Google", "Alpahbet", "TECH");

        alerts.setAlert(appleStock, 180.0);
        alerts.setAlert(googleStock, 140.0);
        try{
            exchange.registerStock(appleStock, 170.00);
            exchange.registerStock(googleStock, 140.00);
        }catch (ResourceAlreadyFoudException e){
            System.out.println(e.getMessage());
        }


        try{
            exchange.updatePrice(appleStock, 175.50);
            exchange.updatePrice(googleStock, 138.25);
            exchange.updatePrice(appleStock, 182.00);
            exchange.updatePrice(googleStock, 141.75);
        }catch (ResourceNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
