package Formula;
/*
* IIT - 2018348
* UOW - 1761888
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String menu = "";

        boolean end = true;
        if (!(menu.equals("Q"))) //Until user input "Q" or "q" menu will run
        {

        } else {
            System.out.println("--Thank you--");
            //break;
        }


        //console output
        while (end) {
            System.out.println("******************************************************************");
            System.out.println("-----------Welcome to The Formula 1 racing  championship---------");
            System.out.println("Please Select Option : " +
                    "\n Enter \"A\" to Add new driver" +
                    "\n Enter \"D\" to Delete driver" +
                    "\n Enter \"C\" to Change driver" +
                    "\n Enter \"S\" to View statistics" +
                    "\n Enter \"T\" to Show formula 1 driver table" +
                    "\n Enter \"R\" to Add a race" +
                    "\n Enter \"G\" to View driver GUI" +
                    "\n Enter \"U\" to Save driver data" +
                    "\n Enter \"L\" to Load driver data" +
                    "\n Enter \"Q\" to Quite the program" +
                    "\n----------------------------------------------------------------------------------"+
                    "\n Please select valid option");
            System.out.println("*******************************************************************");
            System.out.println("Input Your Answer : ");
            Scanner input = new Scanner(System.in);

            //Scanner input=new Scanner(System.in);
            String userinput = input.next();
            userinput = userinput.toUpperCase();
            //return input.next();
            switch (userinput) {
                case "A":
                    addnewDriver ();
                    break;//add new Driver
                case "D":
                    removeDriver();
                    break;//delete driver
                case "C":
                    changeDriver();
                    break;//change driver details
                case "S":
                    viweStatics();
                    break;//display statics
                case "T":
                    ShowDriverTable();
                    break;//show the driver tables
                case "R":
                    addnewRace();
                    break;//add new race
                case "G":
                    showGUI();
                    break;//show the gui
                case "U":
                    updateFile();
                    break;//save all records
                case "L":
                    loardFile();
                    break;//loard text file

                case "Q": { // end programme
                    System.out.println("EXIT FROM PROGRAM");
                    end = false;

                }
                System.out.println("Invalid !! \n Try Again");


            }
        }
    }
    //adding new driver
    public static void addnewDriver()
    {
        Scanner input = new Scanner(System.in);
        try
        {Scanner input1 = new Scanner(System.in);
            System.out.println("##- Add Driver name: ");
            String dName = input1.next();

            for (int i = 0; i < Formula1ChampionshipManager.Formula1DriverArrayList.size(); i++)
            {
                if (Formula1ChampionshipManager.Formula1DriverArrayList.get(i).getName().equals(dName))
                {//checking the entered value being already in F1 championship
                    System.out.println("Driver already registered to the Formula 1 Championship");
                    return;
                }
            }
            Scanner input2= new Scanner(System.in);   //created new scanner to get 2 strings. for example "Sri Lanka"
            System.out.println("Enter the driver's location: ");
            String dLocation = input2.nextLine();
            System.out.println("Enter the driver's team: ");
            String dTeam = input.next();

            for (int j = 0; j < Formula1ChampionshipManager.Formula1DriverArrayList.size(); j++)
            {
                if (Formula1ChampionshipManager.Formula1DriverArrayList.get(j).getTeam().equals(dTeam))
                {//checking the team was already filled with driver
                    System.out.println("Team has a driver already. Enter a different team."); //since one has one driver
                    return;
                }
            }
            System.out.println("1. Enter the driver's first positions: ");
            int dFiPositions = input.nextInt();
            System.out.println("2. Enter the driver's second positions: ");
            int dSePositions = input.nextInt();
            System.out.println("3. Enter the driver's third positions: ");
            int dThPositions = input.nextInt();
            System.out.println("4. Enter the driver's total points: ");
            int dPoints = input.nextInt();
            System.out.println("5. Enter the driver's total races: ");
            int dToRaces = input.nextInt();

            Formula1Drivers F1Driver = new Formula1Drivers(dName, dLocation, dTeam, dFiPositions, dSePositions, dThPositions, dPoints, dToRaces); // created a driver object to store in ArrayList
            Formula1ChampionshipManager f1Drive = new Formula1ChampionshipManager();
            f1Drive.addDriver(F1Driver); //created the driver object

        } catch (Exception e)
        {
            System.out.println("Your input is incorrect!");
        }
    }

    public static void removeDriver()
    {//when user Select d or D
        Scanner sc = new Scanner(System.in);

        for (int k = 0; k< Formula1ChampionshipManager.Formula1DriverArrayList.size(); k++)
        {
            System.out.println((Formula1ChampionshipManager.Formula1DriverArrayList.get(k)).toString());
        }
        System.out.println("##-Enter the drivers name to delete from Formula 1 Championship: ");
        String delDriveName = sc.next();

        Formula1ChampionshipManager f1Driver = new Formula1ChampionshipManager();
        f1Driver.deleteDriver(delDriveName);
    }

    //Change drive for an existing constructor team when "C" or "c"
    public static void changeDriver()
    {   //method to change driver for an existing constructor team
        Scanner sc = new Scanner(System.in);

        try
        {
            System.out.println("##-Enter the driver's name: ");
            String curDriver = sc.next();

            for (int l = 0; l < Formula1ChampionshipManager.Formula1DriverArrayList.size(); l++)
            {
                if (Formula1ChampionshipManager.Formula1DriverArrayList.get(l).getName().equalsIgnoreCase(curDriver))
                {
                    System.out.println("Enter the new driver's name: ");
                    String newNameDriver = sc.next();

                    Formula1ChampionshipManager f1Driver = new Formula1ChampionshipManager();
                    f1Driver.changeDriver(curDriver, newNameDriver);
                    break;

                }else
                {
                    if (l ==(Formula1ChampionshipManager.Formula1DriverArrayList.size()-1))
                    {
                        System.out.println("Current driver's name is not in the F1 Championship. \nPlease try again!!!");
                        break;
                    }
                }
            }
        }catch (Exception e)
        {
            System.out.println("Your input is incorrect!");
        }
    }


    public static void viweStatics()
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.println("##- Enter the name of the driver :");
            String statDriver = sc.next();

            for (int m = 0; m < Formula1ChampionshipManager.Formula1DriverArrayList.size(); m++)
            {
                if (Formula1ChampionshipManager.Formula1DriverArrayList.get(m).getName().equalsIgnoreCase(statDriver))
                {
                    Formula1ChampionshipManager f1Driver = new Formula1ChampionshipManager();
                    f1Driver.displayStatistics(statDriver);
                    break;
                }else
                {
                    if (m ==(Formula1ChampionshipManager.Formula1DriverArrayList.size()-1))
                    {
                        System.out.println("The name you entered is not in F1 Championship . Please try again");
                        break;
                    }
                }
            }
        }catch (Exception e)
        {
            System.out.println("Your input is incorrect!");
        }
    }

    //Display Formula 1 table "T" or "t"
    public static void ShowDriverTable()
    {
        Formula1ChampionshipManager f1Driver = new Formula1ChampionshipManager();
        f1Driver.formula1Table();
    }

    //Add a new race when "R" or "r"
    public static void addnewRace()
    {
        Scanner sc = new Scanner(System.in);

        //variables
        int newRacePosition =0;
        String inputtedName = "";
        Race newRace;
        String[] driverNames;
        int[] racePos;

        try
        {
            System.out.println("Please enter the date of the race:- ");
            System.out.print("Year: ");
            int newRaceYear = sc.nextInt();
            System.out.print("Month: ");
            int newRaceMonth = sc.nextInt();

            if (newRaceMonth > 12)
            {//check the input is valid
                System.out.println("Invalid month. Please enter the correct month!!");
                return;
            }
            System.out.print("Day: ");
            int newRaceDay = sc.nextInt();

            if (newRaceDay > 31)
            {//check the input is valid
                System.out.println("Invalid date. Please enter the correct date!!");
                return;
            }
            RaceDate newRaceDate = new RaceDate(newRaceYear, newRaceMonth, newRaceDay);
            System.out.println("Race date: " + newRaceDate);

            System.out.println("Enter the number of drivers who participated in new race: ");
            int count = sc.nextInt();

            driverNames = new String[count];
            racePos = new int[count];

            if (count >= 2)
            {//To add race need more than 1 racer

                for (int n = 0; n <count; n++)
                {
                    System.out.println("Enter the driver name: ");
                    inputtedName = sc.next();
                    driverNames[n]=inputtedName;

                    for (int i = 0; i < Formula1ChampionshipManager.Formula1DriverArrayList.size()-1; i++)
                    {
                        if (Formula1ChampionshipManager.Formula1DriverArrayList.get(i).getName().equalsIgnoreCase(inputtedName))
                        {//checking the inputted driver existed in the f1 driver table
                            System.out.println("Enter the position of " + inputtedName + " : ");
                            newRacePosition = sc.nextInt();
                            racePos[n] = newRacePosition;

                            Formula1Drivers driver = Formula1ChampionshipManager.Formula1DriverArrayList.get(i);
                            addPoints(newRacePosition, driver); //Calling add point method

                            break;
                        }

                        if (i == Formula1ChampionshipManager.Formula1DriverArrayList.size()-1)
                        {//if not printing the below massage
                            System.out.println(inputtedName + " is not existed in F1 Championship");
                            n--;
                        }
                    }
                }
                //Adding to the array List
                newRace = new Race(newRaceDate, count, inputtedName, newRacePosition, driverNames,racePos);
                Formula1ChampionshipManager.raceArray.add(newRace);

                System.out.println("Race added!");
                //Letting know that race were successfully added.
            }else
            {
                System.out.println("Enter more than 1 racer.");
            }

            for (int o = 0; o < Formula1ChampionshipManager.raceArray.size(); o++)
            {
                System.out.println("Race Date: " + Formula1ChampionshipManager.raceArray.get(o).getrDate());
                System.out.println("Number of Drivers in the Race: " + Formula1ChampionshipManager.raceArray.get(o).getNumOfDrivers());
            }
        } catch (InputMismatchException e)
        {
            System.out.println("Please enter the correct value.");
        }
    }

    public static void addPoints(int newRacePosition, Formula1Drivers driver)
    {
        int [] pointArr = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        if (newRacePosition == 1)
        {// place values
            driver.setPos1(driver.getPos1() + 1);
        }
        else if (newRacePosition == 2)
        {
            driver.setPos2(driver.getPos2() + 1);
        }
        else if (newRacePosition == 3)
        {
            driver.setPos3(driver.getPos3() + 1);
        }
        driver.setTotalRaces(driver.getTotalRaces() + 1);    //total race
        driver.setTotalPoints(driver.getTotalPoints() + pointArr[newRacePosition-1]);    //total points
    }
    public static void showGUI()
    {
        String[] args = new String[0];
        F1ChampionshipManagerGUI.main(args);
        System.out.println(" ...");
        System.out.println(" F1 Championship Manager GUI Loaded!");
    }


    public static void updateFile()
    { //method to save to file
        Formula1ChampionshipManager f1Driver = new Formula1ChampionshipManager();
        f1Driver.saveToFile();

        System.out.println("Data has saved to the file.");
    }


    public static void loardFile()
    {   //method to load data from file
        Formula1ChampionshipManager f1Driver = new Formula1ChampionshipManager();
        f1Driver.readFile();

        System.out.println("Loaded data. Please check the file.");
        System.out.println(" " + "\n Driver Details: ");
        for (int r = 0; r < Formula1ChampionshipManager.Formula1DriverArrayList.size(); r++)
        {
            System.out.println(Formula1ChampionshipManager.Formula1DriverArrayList.get(r).toString());
        }
        System.out.println(" " + "\n Race Details: ");
        for (int k = 0; k < Formula1ChampionshipManager.raceArray.size(); k++)
        {
            System.out.println(Formula1ChampionshipManager.raceArray.get(k).toString());
        }
    }
}






