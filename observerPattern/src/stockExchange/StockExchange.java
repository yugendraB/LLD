package stockExchange;

import stockExchange.exceptions.ResourceAlreadyFoudException;
import stockExchange.exceptions.ResourceNotFoundException;
import stockExchange.model.Stock;
import stockExchange.observers.StockObserver;
import java.util.*;

import java.util.ArrayList;

public class StockExchange implements Subject{
    protected List<StockObserver> observers = new ArrayList<>();
    protected Map<Stock, Double> prices = new HashMap<>();
    private Stock lastUpdatedStock;

    public void registerStock(Stock stock, Double price) throws ResourceAlreadyFoudException {
        if(prices.containsKey(stock)) throw new ResourceAlreadyFoudException("This stock with this symbol already exists!!");
        prices.put(stock, price);
        this.lastUpdatedStock = stock;
        notifyObserver();
    }

    public void deleteStock(Stock stock) throws ResourceNotFoundException {
        if(!prices.containsKey(stock)) throw new ResourceNotFoundException("No such stock found to delete");
        prices.remove(stock);
        notifyObserver();
    }

    public void updatePrice(Stock stock, Double price) throws ResourceNotFoundException{
        if(!prices.containsKey(stock)) throw new ResourceNotFoundException("No such stock found to delete");
        prices.put(stock, price);
        this.lastUpdatedStock = stock;
        notifyObserver();
    }

    public Stock getLastUpdatedStock() {
        return lastUpdatedStock;
    }

    public double getPrice(Stock stock){
        int hashValue = stock.hashCode();
        return prices.get(stock);
    }

    @Override
    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(StockObserver observer : observers){
            observer.onPriceUpdate(this);
        }
    }
}
