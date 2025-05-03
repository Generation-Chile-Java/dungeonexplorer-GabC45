package dungeon;

public class EmptyRoom implements Room {
    @Override
    public void enter(Player player) {
        System.out.println("Entraste en una sala vacía. No hay nada aquí.");
    }
}