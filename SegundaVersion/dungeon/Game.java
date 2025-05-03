package dungeon;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu nombre: ");
        String name = scanner.nextLine();
        Player player = new Player(name, 100);

        Room[] dungeon = {
            new EmptyRoom(),                    // 1
            new TreasureRoom("Espada mágica"),  // 2
            new EnemyRoom(15),                  // 3
            new EmptyRoom(),                    // 4
            new TreasureRoom("Armadura ligera"),// 5
            new EnemyRoom(10),                  // 6
            new EmptyRoom(),                    // 7
            new TreasureRoom("Anillo misterioso"), // 8
            new EnemyRoom(25),                  // 9
            new EmptyRoom(),                    //10
            new TreasureRoom("Poción de curación"), //11
            new EnemyRoom(20),                  //12
            new EmptyRoom(),                    //13
            new TreasureRoom("Llave dorada"),   //14
            new EnemyRoom(30)                   //15
        };

        boolean[] visited = new boolean[dungeon.length];
        int visitedCount = 0;

        while (player.isAlive() && visitedCount < dungeon.length) {
            System.out.println("\nSalas disponibles para visitar:");
            for (int i = 0; i < dungeon.length; i++) {
                if (!visited[i]) {
                    System.out.println((i + 1) + ". Sala #" + (i + 1));
                }
            }

            System.out.print("Elige el número de la sala que quieres visitar: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intenta de nuevo.");
                continue;
            }

            if (choice < 1 || choice > dungeon.length || visited[choice - 1]) {
                System.out.println("Sala inválida o ya visitada. Intenta con otra.");
                continue;
            }

            System.out.println("\n--- Entrando a la sala #" + choice + " ---");
            dungeon[choice - 1].enter(player);
            visited[choice - 1] = true;
            visitedCount++;
            player.showStatus();
        }

        if (!player.isAlive()) {
            System.out.println("¡Has sido derrotado en la mazmorra!");
        } else {
            System.out.println("¡Felicidades, has explorado toda la mazmorra!");
        }

        scanner.close();
    }
}