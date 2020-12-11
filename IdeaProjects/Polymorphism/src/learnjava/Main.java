package learnjava;

class Movie{
    private String name;

    public Movie(String name) {
        this.name = name;
    }
    public String plot(){
        return "No plot here";
    }

    public String getName() {
        return name;
    }
}

class Spadikam extends Movie{
    public Spadikam(){
        super("Spadikam");
    }

    public String plot(){
        return "Aadu thoma and chacko mashu";
    }
}

class Manichithrathazhu extends Movie{
    public Manichithrathazhu() {
        super("Manichithrathazhu");
    }
    public String plot(){
        return "Multiple personality in ganga";
    }
}

class Valsalyam extends Movie{
    public Valsalyam() {
        super("Valsalyam");
    }
    public String plot(){
        return "Family issues after marriage";
    }
}

class Guru extends Movie{
    public Guru() {
        super("Guru");
    }
    public String plot(){
        return "Religion issues in an epic way";
    }
}

class Vandhanam extends Movie{
    public Vandhanam() {
        super("Vandhanam");
    }
    //No plot method
}

public class Main {

    public static void main(String[] args) {
        for(int i = 1 ; i < 11 ; i++){
            Movie movie = randomMovie();
            System.out.println("Movie #" +i + " : " +movie.getName() + "\n" + "Plot : " +movie.plot() + '\n');
        }
    }

    public static Movie randomMovie(){
        int randomNumber = (int) ((Math.random() * 5) + 1);
        System.out.println("Random number generated was : " +randomNumber);
        switch (randomNumber){
            case 1:
                return new Spadikam();
            case 2:
                return new Manichithrathazhu();
            case 3:
                return new Valsalyam();
            case 4:
                return new Guru();
            case 5:
                return new Vandhanam();
            default:
                return null;
        }
    }
}
