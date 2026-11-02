import java.util.ArrayList;
import java.util.List;

class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private int distanceTravelled;
    private static final int DRIVE_DISTANCE = 10;
    private int numberOfVictories;

    public void drive() {
        distanceTravelled += DRIVE_DISTANCE;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    public int compareTo(ProductionRemoteControlCar car) {
        return Integer.compare(car.getNumberOfVictories(), this.getNumberOfVictories());
    }
}

class Test {
    public static void main(String[] args) {

        List<ProductionRemoteControlCar> list = new ArrayList<>();
        ProductionRemoteControlCar car1 = new ProductionRemoteControlCar();
        ProductionRemoteControlCar car2 = new ProductionRemoteControlCar();

        list.add(car1);
        list.add(car2);

        car1.setNumberOfVictories(5);
        car2.setNumberOfVictories(3);
    }
}
