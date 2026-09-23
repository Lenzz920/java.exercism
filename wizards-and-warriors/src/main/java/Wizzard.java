public class Wizzard extends Fighter{

    public boolean preparedSpell;

    @Override
    public boolean isVulnerable() {
        if(preparedSpell) {
            return false;
        }
        return super.isVulnerable();
    }

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }

    public void prepareSpell() {
        preparedSpell = true;
    }

    @Override
    public int getDamagePoints(Fighter fighter) {
        if(preparedSpell) {
            return 12;
        } else {
            return 3;
        }
    }
}
