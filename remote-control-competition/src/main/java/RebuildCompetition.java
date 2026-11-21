import java.util.List;

public class RebuildCompetition {}

interface RemoteControlCarRebuild {
  void drive();

  int getDistanceTravelled();
}

class ProductionCar implements RemoteControlCarRebuild, Comparable<ProductionCar> {
  private int distanceTravelled;
  private static final int DRIVING_UNITS = 10;
  private int numberOfVictories;

  @Override
  public void drive() {
    distanceTravelled += DRIVING_UNITS;
  }

  @Override
  public int getDistanceTravelled() {
    return distanceTravelled;
  }

  @Override
  public int compareTo(ProductionCar o) {
    return Integer.compare(o.getNumberOfVictories(), this.getNumberOfVictories());
  }

  public int getNumberOfVictories() {
    return numberOfVictories;
  }

  public void setNumberOfVictories(int numberOfVictories) {
    this.numberOfVictories = numberOfVictories;
  }
}

class ExperimentalCar implements RemoteControlCarRebuild {
  private int distanceTravelled;
  private static final int DRIVING_UNITS = 20;

  @Override
  public void drive() {
    distanceTravelled += DRIVING_UNITS;
  }

  @Override
  public int getDistanceTravelled() {
    return distanceTravelled;
  }
}

class TestTrackRebuild {

  public void race(RemoteControlCarRebuild car) {
    car.drive();
  }

  List<ProductionCar> getRankedCars(List<ProductionCar> carRaceList) {
    return carRaceList.stream()
        .sorted((a, b) -> Integer.compare(b.getNumberOfVictories(), a.getNumberOfVictories()))
        .toList();
  }
}
