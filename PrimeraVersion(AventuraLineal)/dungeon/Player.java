package dungeon;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private List<String> inventory;

    public Player(String name, int health) {
        this.name = name;
        this.health = health;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(name + " recibe " + damage + " de daño. Salud restante: " + health);
    }

    public void addItem(String item) {
        inventory.add(item);
        System.out.println(name + " recogió: " + item);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void showStatus() {
        System.out.println("Jugador: " + name + " | Salud: " + health + " | Inventario: " + inventory);
    }
}