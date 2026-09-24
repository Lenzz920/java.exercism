public class Warrior extends Fighter {

    @Override
    boolean isVulnerable() {
        return false;
    }

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        if(fighter.isVulnerable()) {
            return 10;
        } else {
            return 6;
        }
    }
}
