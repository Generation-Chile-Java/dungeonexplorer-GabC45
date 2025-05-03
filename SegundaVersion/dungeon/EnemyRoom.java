package dungeon;

public class EnemyRoom implements Room {
    private int damage;

    public EnemyRoom(int damage) {
        this.damage = damage;
    }

    @Override
    public void enter(Player player) {
        System.out.println("¡Un enemigo ataca!");
        player.takeDamage(damage);
    }
}