package learjava;

import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();
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


        Basket jithinBasket = new Basket("Jithin");
        sellItem(jithinBasket,"Car",1);
        System.out.println(jithinBasket);
        sellItem(jithinBasket,"Car",1);
        System.out.println(jithinBasket);

        if(sellItem(jithinBasket,"Car",1) != 1)
            System.out.println("\nThere are no more cars left in stock\n");

        sellItem(jithinBasket,"Spanner",5);

        sellItem(jithinBasket,"Juice",4);
        sellItem(jithinBasket,"Cup",12);
        sellItem(jithinBasket,"Bread",1);
        System.out.println(jithinBasket);

        Basket basket = new Basket("Jishnu basket");
        sellItem(basket, "Cup", 100);
        sellItem(basket, "Juice", 5);
        removeItem(basket, "Cup",1);
        System.out.println(basket);

        removeItem(jithinBasket,"Car",1);
        removeItem(jithinBasket,"Cup",9);
        removeItem(jithinBasket,"Car",1);
        System.out.println("Cars removed " + removeItem(jithinBasket,"Car",1)); //Shouldn't remove any

        System.out.println(jithinBasket);

        removeItem(jithinBasket,"Bread",1);
        removeItem(jithinBasket,"Cup",3);
        removeItem(jithinBasket,"Juice",4);
        removeItem(jithinBasket,"Cup",3);

        System.out.println(jithinBasket);
        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);
//        System.out.println(stockList);
//        for(Map.Entry<String,Double> itemPrice : stockList.printPrices().entrySet()){
//            System.out.println(itemPrice.getKey() + " Costs " + itemPrice.getValue());
//        }

        checkOut(jithinBasket);
        System.out.println(jithinBasket);

    }

    public static int sellItem(Basket basket , String item , int quantity){
        //retrieve the item from the stockList
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell the item: " + item);
            return 0;
        }
        if(stockList.reserveStock(item,quantity) != 0){
            return basket.addToBasket(stockItem,quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket){
        for(Map.Entry<StockItem,Integer> basketItem : basket.items().entrySet()){
            StockItem item = basketItem.getKey();
            Integer quantity = basketItem.getValue();
            stockList.sellStock(item.getName(),quantity);
        }
        basket.clearBasket();
    }

    public static int removeItem(Basket basket , String item , int quantity){
        //retrieve the item from the stockList
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("We don't sell the item: " + item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem,quantity) == quantity){
            return stockList.unReserveStock(item,quantity);
        }
        return 0;
    }
}
