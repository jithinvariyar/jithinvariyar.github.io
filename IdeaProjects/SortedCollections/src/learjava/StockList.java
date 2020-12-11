package learjava;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class StockList {
    private final Map<String,StockItem> list ;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item){
        if(item != null){
            StockItem inStock = list.getOrDefault(item.getName(),item);
            if(inStock != item){
                inStock.adjustStock(item.quantityInStock());
            }
            list.put(inStock.getName(),inStock);
            return inStock.quantityInStock();
        }
        return 0;
    }
    public int sellStock(String item, int quantity){
        StockItem inStock = list.getOrDefault(item, null);
        if((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity >=0)){
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public Map<String,Double> printPrices(){
        Map<String, Double> price = new LinkedHashMap<>();
        for(Map.Entry<String,StockItem> item : list.entrySet()){
            price.put(item.getKey(),item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(price);
    }

    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String,StockItem> Items(){
        return Collections.unmodifiableMap(list);
    }


    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for(Map.Entry<String, StockItem> item : list.entrySet()){
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + String.format("%.2f",totalCost);
    }
}
