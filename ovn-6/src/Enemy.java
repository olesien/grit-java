import java.util.ArrayList;
import java.util.Random;

public class Enemy {
    private String name;
    Double energyLevel;
    private ArrayList<String> weapons = new ArrayList<String>();

    Enemy(String name, Double energyLevel, String weapon1, String weapon2, String weapon3) {
        weapons.add(weapon1);
        weapons.add(weapon2);
        weapons.add(weapon3);

        this.name = name;
        this.energyLevel = energyLevel;
        this.weapons = weapons;
    }

    void Attack(String weapon ) {
        if (weapons.contains(weapon)) {
            System.out.println(name + " attacked using their " + weapon);
        } else {
            System.out.println(name + " tried to attack but they had an undefined weapon");
        }
    }

    void Defend() {
        Random rand = new Random();
        int damageTaken = rand.nextInt(5) + 1;
        System.out.println(name + " had to defend and lost " + damageTaken + " energy and now has " + energyLevel);
        this.energyLevel -= damageTaken;
    }

    Double getEnergyLevel() {
        return this.energyLevel;
    }
}
