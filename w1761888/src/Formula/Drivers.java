package Formula;

import java.io.Serializable;

//public class Drivers {
    abstract class Drivers implements Serializable {
    private static String nameOfDrivers;
    private static String locationOfDrivers;
    private static String teamOfDrivers;

    public Drivers(String nameOfDrivers, String locationOfDrivers, String teamOfDrivers) { //constructor
        this.nameOfDrivers = nameOfDrivers;
        this.locationOfDrivers = locationOfDrivers;
        this.teamOfDrivers = teamOfDrivers;

    }
    public Drivers(){ //create constructor
    }
    public static String getName() {
        return nameOfDrivers;
    }

    public void setName(String name) {
        this.nameOfDrivers = name;
    }

    public static String getLocation() {
        return locationOfDrivers;
    }

    public void setLocation(String location) {
        this.locationOfDrivers = location;
    }

    public static String getTeam() {
        return teamOfDrivers;
    }

    public void setTeam(String team) {
        this.teamOfDrivers = team;
    }


}


