package learnjava;

public class Main {

    public static void main(String[] args) {
	    FootBallPlayer joe = new FootBallPlayer("Joe");
	    BaseBallPlayer pat = new BaseBallPlayer("Pat");
	    SoccerPlayer beckham = new SoccerPlayer("Beckham");

	    Team<FootBallPlayer> adelaideCrows = new Team<>("Adelaide Crows");
	    adelaideCrows.addPlayer(joe);
//	    adelaideCrows.addPlayer(pat);
//	    adelaideCrows.addPlayer(beckham);

        System.out.println(adelaideCrows.numPlayers());

        Team<BaseBallPlayer> baseBallTeam = new Team<>("Chicago cubs");
        baseBallTeam.addPlayer(pat);

        Team<SoccerPlayer> brokenTeam = new Team<>("this won't work");
        brokenTeam.addPlayer(beckham);

        Team<FootBallPlayer> melbourne = new Team<>("Melbourne");
        FootBallPlayer banks = new FootBallPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<FootBallPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootBallPlayer> fremantle = new Team<>("Fremantle");

        hawthorn.matchResult(fremantle,1,0);
        hawthorn.matchResult(adelaideCrows,3,8);

        adelaideCrows.matchResult(fremantle,2,1);
//        adelaideCrows.matchResult(baseBallTeam,1,1);
        System.out.println("Rankings");
        System.out.println(adelaideCrows.getName() + " : " + adelaideCrows.ranking());
        System.out.println(melbourne.getName() + " : " + melbourne.ranking());
        System.out.println(fremantle.getName() + " : " + fremantle.ranking());
        System.out.println(hawthorn.getName() + " : " + hawthorn.ranking());

        System.out.println(adelaideCrows.compareTo(melbourne));
        System.out.println(adelaideCrows.compareTo(hawthorn));
        System.out.println(hawthorn.compareTo(adelaideCrows));
        System.out.println(melbourne.compareTo(fremantle));

    }
}
