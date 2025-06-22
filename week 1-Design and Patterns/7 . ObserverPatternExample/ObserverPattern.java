import java.util.*;
interface Stock{
    void register(Observer observer);
    void deregister(Observer observer);
    void notify(String stockName, double price);
}

class StockMarket implements Stock{
    private List<Observer> observers = new ArrayList<>();

    public void register(Observer observer){
        observers.add(observer);
    }
    public void deregister(Observer observer){
        observers.remove(observer);
    }
    public void notify(String stockName, double price){
        for (Observer o : observers){
            o.update(stockName, price);
        }
    }
    public void setPrice(String stockName, double price){
        System.out.println("Price updated: " + stockName + " - Rs." + price);
        notify(stockName, price);
    }
}

interface Observer{
    void update(String stockName, double price);
}

class MobileApp implements Observer{
    private String appName;

    public MobileApp(String appName){
        this.appName = appName;
    }
    public void update(String stockName, double price){
        System.out.println(appName + "(Mobile) received update: " + stockName + " is now Rs." + price);
    }
}

class WebApp implements Observer{
    private String appName;

    public WebApp(String appName){
        this.appName = appName;
    }
    public void update(String stockName, double price){
        System.out.println(appName + "(Web) received update: " + stockName + " is now Rs." + price);
    }
}

public class ObserverPattern {
    public static void main(String[] args){
        StockMarket market = new StockMarket();
        Observer mobile = new MobileApp("GrowFast");
        Observer web = new WebApp("TradeNow");
        market.register(mobile);
        market.register(web);
        market.setPrice("TCS", 2287.75);
        market.setPrice("INFOSYS", 4575.60);
        market.deregister(web);
        market.setPrice("WIPRO", 2462.35);
    }
}