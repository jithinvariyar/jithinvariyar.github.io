package learjava;

import java.util.Map;

public class Main {
    private static  StockList stockList = new StockList();
    public static void main(String[] args) {
	    StockItem temp = new StockItem("Bread",0.86,100);
        stockList.addStock(temp);

        temp = new StockItem("Cake",1.10,7);
        stockList.addStock(temp);

        temp = new StockItem("Car",12.50,2);
        stockList.addStock(temp);

        temp = new StockItem("Chair",62.0,10);
        stockList.addStock(temp);

        temp = new StockItem("Cup",0.50,200);
        stockList.addStock(temp);
        temp = new StockItem("Cup",0.45,7);
        stockList.addStock(temp);

        temp = new StockItem("Door",72.95,4);
        stockList.addStock(temp);

        temp = new StockItem("Juice",2.50,36);
        stockList.addStock(temp);

        temp = new StockItem("Phone",96.99,35);
        stockList.addStock(temp);

        temp = new StockItem("Towel",2.40,80);
        stockList.addStock(temp);

        temp = new StockItem("Vase",8.76,40);
        stockList.addStock(temp);


        for(String item : stockList.Items().keySet()){
            System.out.println(item);
        }

        Basket jithinBasket = new Basket("Jithin");
        sellItem(jithinBasket,"Car",1);
        System.out.println(jithinBasket);
        sellItem(jithinBasket,"Car",1);
        System.out.println(jithinBasket);

        sellItem(jithinBasket,"Car",1);
        System.out.println(jithinBasket);

        sellItem(jithinBasket,"Spanner",5);
        System.out.println(jithinBasket);
        sellItem(jithinBasket,"Juice",4);
        sellItem(jithinBasket,"Cup",12);
        sellItem(jithinBasket,"Bread",1);
        System.out.println(jithinBasket);

        System.out.println(stockList);
        for(Map.Entry<String,Double> itemPrice : stockList.printPrices().entrySet()){
            System.out.println(itemPrice.getKey() + " Costs " + itemPrice.getValue());
        }


    }

    public static int sellItem(Basket basket , String item , int quantity){
        //retrieve the item from the stockList
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell the item: " + item);
            return 0;
        }
        if(stockList.sellStock(item,quantity) != 0){
            basket.addToBasket(stockItem,quantity);
            return quantity;
        }
        return 0;
    }
}
