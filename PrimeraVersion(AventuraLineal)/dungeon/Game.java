package dungeon;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu nombre: ");
        String name = scanner.nextLine();
        Player player = new Player(name, 100);

        Room[] dungeon = {
            new EmptyRoom(),
            new TreasureRoom("Espada mágica"),
            new EnemyRoom(20),
            new TreasureRoom("Poción de curación"),
            new EnemyRoom(30),
            new EmptyRoom()
        };

        int currentRoom = 0;
        while (player.isAlive() && currentRoom < dungeon.length) {
            System.out.println("\nSala #" + (currentRoom + 1));
            dungeon[currentRoom].enter(player);
            player.showStatus();
            currentRoom++;
            if (player.isAlive() && currentRoom < dungeon.length) {
                System.out.print("Presiona Enter para continuar a la siguiente sala...");
                scanner.nextLine();
            }
        }

        if (!player.isAlive()) {
            System.out.println("¡Has sido derrotado en la mazmorra!");
        } else {
            System.out.println("¡Felicidades, has explorado toda la mazmorra!");
        }
        scanner.close();
    }
}