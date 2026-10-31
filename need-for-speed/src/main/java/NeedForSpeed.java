class NeedForSpeed {
    private final int speed;
    private final int batteryDrain;
    private int distance;
    private int currentBattery = 100;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return currentBattery < batteryDrain;
    }

    public int distanceDriven() {
        return this.distance;
    }

    public void drive() {
        if (!batteryDrained()) {
            this.distance += speed;
            currentBattery -= batteryDrain;
        }
    }

    //the formula inside () determines how many times the car can drive, and the int rounding is deliberate,
    //because a leftover battery can't be used if it's below the batteryDrain
    public int distanceItCanGo() {
        return (currentBattery / batteryDrain) * speed;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private final int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
       return car.distanceItCanGo() >= distance;
    }
}
