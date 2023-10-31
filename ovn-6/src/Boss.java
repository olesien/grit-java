public class Boss extends Enemy {

    Boss(String name, Double energyLevel, String weapon1, String weapon2, String weapon3) {
        super(name, energyLevel * 10, weapon1, weapon2, weapon3);
    }

    void Heal () {
        this.energyLevel += 5;
    }

}
