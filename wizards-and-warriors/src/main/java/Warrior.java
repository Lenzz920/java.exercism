public class Warrior extends Fighter {

    @Override
    public boolean isVulnerable() {
        return false;
    }

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    public int getDamagePoints(Fighter fighter) {
        if(fighter.isVulnerable()) {
            return 10;
        } else {
            return 6;
        }
    }
}
