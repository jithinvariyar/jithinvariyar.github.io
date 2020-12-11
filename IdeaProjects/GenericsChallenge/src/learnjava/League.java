package learnjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League<T extends Team> {
    private String name;
    private ArrayList<T> league = new ArrayList<>();
    public League(String name) {
        this.name = name;
    }

    public boolean add(T teamName){
        if(league.contains(teamName)){
            return false;
        }
        league.add(teamName);
        return true;
    }

    public void showLeagueTable(){
        Collections.sort(league);
        for(T t : league){
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }
}
