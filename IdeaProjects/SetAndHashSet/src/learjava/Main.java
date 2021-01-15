package learjava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<HeavenlyBody.Key,HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();
    public static void main(String[] args) {
        HeavenlyBody temp = new Planet("Mercury",80);

        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Venus",225);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Earth",365);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon",27);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars",687);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos",1.3);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Phobes",8.3);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Jupiter",4332);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        tempMoon = new Moon("Io",1.8);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Europa",3.5);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Ganymede",7.1);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Callisto",16.7);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Saturn",10759);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Uranus",30660);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Neptune",165);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        temp = new Planet("Pluto",248);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);


        System.out.println("Planets");
        for(HeavenlyBody planet : planets){
            System.out.println(planet.getKey());
        }

        System.out.println("\n");
        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Mars", HeavenlyBody.BodyTypes.PLANET));
        System.out.println("Moons of " + body.getKey());
        for(HeavenlyBody jupiterMoon : body.getSatellites()){
            System.out.println("\t" + jupiterMoon.getKey());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody moon : planets){
            moons.addAll(moon.getSatellites());
        }
        System.out.println("\n");
         System.out.println("Moons in the solar system are ");
        System.out.println("\t");
        for(HeavenlyBody moon : moons){
            System.out.println(moon.getKey());
        }

        HeavenlyBody pluto = new DwarfPlanet("Pluto",842);
        planets.add(pluto);
        solarSystem.put(pluto.getKey(),pluto);

        System.out.println("\n");
        for(HeavenlyBody planet : planets){
            System.out.println(planet.getKey() + ": " + planet.getOrbitalPeriod());
        }



        HeavenlyBody earth1 = new Planet("Earth",365);
        HeavenlyBody earth2 = new HeavenlyBody("Earth",365, HeavenlyBody.BodyTypes.PLANET);
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));
        System.out.println(pluto.getClass());
        System.out.println(solarSystem.keySet());
    }
}