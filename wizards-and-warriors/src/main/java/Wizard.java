public class Wizard extends Fighter {

    private boolean preparedSpell;

    @Override
    boolean isVulnerable() {
        return !preparedSpell;
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
        return preparedSpell ? 12 : 3;
    }
}