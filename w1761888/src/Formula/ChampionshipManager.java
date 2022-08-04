package Formula;

public interface ChampionshipManager {
    void addDriver(Formula1Drivers addNewDriver);
    void deleteDriver(String delDriver);
    void changeDriver(String curDriver, String newDriver);
    void displayStatistics(String disStatDriver);
    void formula1Table();
    void addRace(String dName, int numDriver, int racePosition);
    void saveToFile();
    void readFile();
}
