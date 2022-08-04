package Formula;

import java.io.Serializable;

public class Formula1Drivers extends Drivers implements Serializable
 {
    private static int Pos1;  //1st pace
    private static int Pos2; //2nd place
    private static int Pos3;  //3rd place
    private static int totalPoints;    //total points
    private static int totalRaces; //total races

    public Formula1Drivers(){}

    public Formula1Drivers(String nameOfDrivers, String locationOfDrivers, String teamOfDrivers, int Pos1,
                          int Pos2, int Pos3, int totalPoints, int totalRaces)
    {
        super(nameOfDrivers, locationOfDrivers, teamOfDrivers);    //reusing Test.Driver class constructor
        this.Pos1 = Pos1;
        this.Pos2 = Pos2;
        this.Pos3 = Pos3;
        this.totalPoints = totalPoints;
        this.totalRaces = totalRaces;
    }

    public static int getPos1() {
        return Pos1;
    }

    public void setPos1(int Pos1) {
        this.Pos1 = Pos1;
    }

    public static int getPos2() {
        return Pos2;
    }

    public void setPos2(int Pos2) {
        this.Pos2 = Pos2;
    }

    public static int getPos3() {
        return Pos3;
    }

    public void setPos3(int Pos3) {
        this.Pos3 = Pos3;
    }

    public static int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public static int getTotalRaces() {
        return totalRaces;
    }

    public void setTotalRaces(int totalRaces) {
        this.totalRaces = totalRaces;
    }

    @Override
    public String toString()
    {
        return "Driver Name = " + getName() + ", Location = " + getLocation() + ", Team = " + getTeam() + ", 1st Position  = " + Pos1 +
                ", 2nd Position = " + Pos2 + ", 3rd Position = " + Pos3 +", totalPoints = " + totalPoints + ", totalRaces = " + totalRaces;
    }

}
