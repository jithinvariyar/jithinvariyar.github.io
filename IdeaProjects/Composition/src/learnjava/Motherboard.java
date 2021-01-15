package learnjava;

public class Motherboard {
    private String model;
    private String manufacturer;
    private int ramSLots;
    private int cardSlots;
    private String bios;

    public Motherboard(String model, String manufacturer, int ramSLots, int cardSlots, String bios) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.ramSLots = ramSLots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }

    public void loadProgram(String programName){
        System.out.println("Program " +programName + " is now loading..!!");
    }

    public int getCardSlots() {
        return cardSlots;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getRamSLots() {
        return ramSLots;
    }

    public String getBios() {
        return bios;
    }
}
