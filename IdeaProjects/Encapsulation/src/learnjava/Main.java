package learnjava;

public class Main {

    public static void main(String[] args) {
	    Player player = new Player();
	    player.name = "Jithin";
	    player.health = 20;
	    player.weapon = "Sword";

	    int damage = 10;
	    player.loseHealth(damage);
        System.out.println("Remaining health = " +player.healthRemaining());
    	damage = 11;
    	player.loseHealth(damage);
		System.out.println("Remaining health = " +player.healthRemaining());
		EnhancedPlayer player1 = new EnhancedPlayer("Jithin" , 50 , "sword");
		System.out.println("Initial health is = " +player1.getHealth());
	}
}
