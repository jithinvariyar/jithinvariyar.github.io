package learnjava;

public class Main {

    public static void main(String[] args) {
        Dimensions dimension = new Dimensions(20,20,5);
	    Case theCase = new Case("220B","Dell","240",dimension);
        Monitor monitor = new Monitor("27inch Beast","Acer",27 , new Resolution(2540,1440));
        Motherboard motherboard = new Motherboard("BJ-200","Azus",4,6,"v2.44");
        PC thePC = new PC(motherboard , monitor , theCase);
        thePC.getMonitor().drawPixelAt(1500,1200,"red");
        thePC.getMotherboard().loadProgram("Windows 1.8");
        thePC.getTheCase().pressPowerButton();

        Wall wall1 = new Wall("West");
        Wall wall2 = new Wall("East");
        Wall wall3 = new Wall("South");
        Wall wall4 = new Wall("North");
        Ceiling ceiling = new Ceiling(12,55);
        Bed bed = new Bed("Modern",4,3,2,1);
        Lamp lamp = new Lamp("Classic",false,75);
        BedRoom bedRoom = new BedRoom("Jithin's Room", wall1,wall2,wall3,wall4,ceiling,bed,lamp);
        bedRoom.makeBed();
        bedRoom.getLamp().turnOn();
    }
}
