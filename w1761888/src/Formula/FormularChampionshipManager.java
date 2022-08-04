package Formula;

import java.io.*;
import java.util.ArrayList;

class Formula1ChampionshipManager implements ChampionshipManager
{

    private static final int numOfDriver = 10;    //I assumed that maximum number of drivers who will participate in F1 championship as 20 drivers
    static ArrayList<Formula1Drivers>Formula1DriverArrayList = new ArrayList<>();  //ArrayList to hold Formula 1 Drivers
    static ArrayList<Race>raceArray = new ArrayList<>();    //ArrayList to hold new races

    public Formula1ChampionshipManager(){}

    @Override
    public void addDriver(Formula1Drivers addNewDriver)
    { //method to add new driver
        if (Formula1DriverArrayList.size() < numOfDriver)
        {
            Formula1DriverArrayList.add(addNewDriver);
            System.out.println(Formula1DriverArrayList.toString());
        }else
        {
            System.out.println("Drivers are filled to all the teams.\n If you want to add a new driver, Please delete a existing driver.");
        }
    }

    @Override
    public void deleteDriver(String delDriver)
    { //method to delete a driver
        for (int i = 0; i < Formula1DriverArrayList.size(); i++)
        {
            if (Formula1DriverArrayList.get(i).getName().equalsIgnoreCase(delDriver))
            {
                Formula1DriverArrayList.remove(i);
                System.out.println(delDriver +" was successfully removed from F1 championship.");
                break;
            }else
            {
                if (i==(Formula1DriverArrayList.size()-1))
                {   //checking the whether driver existed

                    System.out.println("Drivers name is not here. Please check again!");
                    break;
                }
            }
        }
    }

    @Override
    public void changeDriver(String curDriver, String newDriver)
    { //method to change driver for an existing constructor team
        for (int c = 0; c < Formula1DriverArrayList.size(); c++ )
        {
            if (Formula1DriverArrayList.get(c).getName().equalsIgnoreCase(curDriver))
            {
                Formula1DriverArrayList.get(c).setName(newDriver);  //setting the new name
                System.out.println(Formula1DriverArrayList.get(c).toString());
            }
        }
    }

    @Override
    public void displayStatistics(String disStatDriver)
    {//method to display statistics
        for (int s = 0; s <= 10; s++)
        {  //for loop to for 10 drivers
            if (Formula1DriverArrayList.get(s).getName().equalsIgnoreCase(disStatDriver))
            {
                System.out.println(Formula1DriverArrayList.get(s).toString());
                break;
            }
        }
    }

    @Override
    public void formula1Table()
    {

        ArrayList<Formula1Drivers>Formula1DriverArrayTempList = new ArrayList<>();  //n the method
        Formula1DriverArrayTempList = Formula1DriverArrayList;
        int t  = Formula1DriverArrayTempList.size();
        Formula1Drivers tmp = null; //bubble sort is using to store drivers according to their points
        for (int a = 0; a < t-1; a++)
        {
            for (int b = 0; b < (t-a-1); b++)
            {
                if (Formula1DriverArrayTempList.get(b).getTotalPoints() < Formula1DriverArrayTempList.get(b + 1).getTotalPoints())
                {
                    tmp = Formula1DriverArrayTempList.get(b);
                    Formula1DriverArrayTempList.set(b, Formula1DriverArrayTempList.get(b+1));
                    Formula1DriverArrayTempList.set(b+1, tmp);  //changing positions

                }else if (Formula1DriverArrayTempList.get(b).getTotalPoints() == Formula1DriverArrayTempList.get(b+1).getTotalPoints())
                {  //if points equals
                    if (Formula1DriverArrayTempList.get(b).getPos1() < Formula1DriverArrayTempList.get(b + 1).getPos1())
                    {
                        tmp = Formula1DriverArrayTempList.get(b);
                        Formula1DriverArrayTempList.set(b, Formula1DriverArrayTempList.get(b+1));
                        Formula1DriverArrayTempList.set(b+1, tmp);  //changing positions
                    }
                }
            }
        }
        System.out.println("______________________________________________________________________________________________________________");
        System.out.printf("%8s %11s %9s %10s %10s %10s %10s %10s", "| NAME |", " LOCATION |", " TEAM |", " FIRST PLACES |", " SECOND PLACES |", " THIRD PLACES |", " TOTAL POINTS |", " TOTAL RACES |\n");
        System.out.println("______________________________________________________________________________________________________________");
        for (Formula1Drivers formula1Driver : Formula1DriverArrayTempList)
        {
            System.out.format("%7s %9s %9s %8s %15s %16s %16s %16s", Formula1Drivers.getName(), Formula1Drivers.getLocation(), Formula1Drivers.getTeam(),
                    Formula1Drivers.getPos1(), Formula1Drivers.getPos2(), Formula1Drivers.getPos3(), Formula1Drivers.getTotalPoints(), Formula1Drivers.getTotalRaces());
            System.out.println();
        }
        System.out.println("________________");
    }

    @Override
    public void addRace(String dName,int numDriver, int racePositions) {}


    @Override
    public void saveToFile()
    {//method to save to file
        try
        {
            FileOutputStream file1 =new FileOutputStream("F1.txt"); //
            ObjectOutputStream obj1 =new ObjectOutputStream(file1);
            obj1.writeObject(Formula1DriverArrayList);
            file1.close();
            obj1.close();

            FileOutputStream file2 =new FileOutputStream("Formular1Race.txt");
            ObjectOutputStream obj2 =new ObjectOutputStream(file2);
            obj2.writeObject(raceArray);
            file2.close();
            obj2.close();
            //https://stackoverflow.com/questions/22411958/how-to-save-a-file-in-java
        }catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    @Override
    public void readFile()
    { //method to load data from file
        try
        {
            FileInputStream files1 = new FileInputStream("F1.txt"); //reading text file
            ObjectInputStream objs1 = new ObjectInputStream(files1);
            Formula1DriverArrayList = (ArrayList<Formula1Drivers>) objs1.readObject();
            objs1.close();
            files1.close();

            FileInputStream files2 = new FileInputStream("Formular1Race.txt");
            ObjectInputStream objs2 = new ObjectInputStream(files2);
            raceArray = (ArrayList<Race>) objs2.readObject();
            objs2.close();
            files2.close();

        } catch (FileNotFoundException | ClassNotFoundException e)  //https://alvinalexander.com/java/java-file-save-write-text-binary-data
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println(" Data loaded.");
    }
}