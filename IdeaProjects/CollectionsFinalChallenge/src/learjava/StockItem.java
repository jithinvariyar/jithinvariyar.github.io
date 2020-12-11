package learjava;


public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int availableQuantity() {
        return quantityStock - reserved;
    }

    public int reserveStock(int quantity){
        if(quantity <= availableQuantity()){
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int finalizeStock(int quantity){
        if(quantity <= reserved){
            reserved -= quantity;
            quantityStock -= quantity;
            return quantity;
        }
        return 0;
    }

    public int unReserveStock(int quantity){
        if(quantity <= reserved){
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

//    public void setPrice(double price) {
//        if(price > 0.0)
//            this.price = price;
//    }



    public void adjustStock(int quantity){
        int newQuantity = this.quantityStock + quantity;
        if(newQuantity >=0)
            this.quantityStock = newQuantity;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals()");
        if(this == obj)
            return false;
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        String objName = ((StockItem)obj).getName();
        return this.name.equals(objName);

    }

    @Override
    public int hashCode() {
        System.out.println("===============");
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
//        System.out.println("Entering StockItem.compareTo");
        if(this == o)
            return 0;
        if(o != null)
            return this.name.compareTo(o.getName());
        throw  new NullPointerException();
    }


    @Override
    public String toString() {
        return this.name + ": Price:" + this.price + ". Rserved: " + reserved;
    }
}

