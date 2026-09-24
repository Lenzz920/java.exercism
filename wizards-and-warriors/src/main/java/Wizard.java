public class Wizard extends Fighter{

    boolean preparedSpell;

    @Override
    boolean isVulnerable() {
        if(preparedSpell) {
            return false;
        }
        return super.isVulnerable();
    }

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }

    void prepareSpell() {
        preparedSpell = true;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        if(preparedSpell) {
            return 12;
        } else {
            return 3;
        }
    }
}
