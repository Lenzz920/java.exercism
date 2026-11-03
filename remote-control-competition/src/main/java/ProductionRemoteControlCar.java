import java.util.ArrayList;
import java.util.List;

class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private int distanceTravelled;
    private static final int DRIVE_DISTANCE = 10;
    private int numberOfVictories;

    @Override
    public void drive() {
        distanceTravelled += DRIVE_DISTANCE;
    }

    @Override
    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar car) {
        return Integer.compare(car.getNumberOfVictories(), this.getNumberOfVictories());
    }
}