import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(3);
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String[] names = {
                "Ellis",
                "Midra",
                "???",
                "Bjorn"
        };

        int nextPlayerId = 1;
        int gamesCreated = 0;

        System.out.println("  Player Matchmaking  ");

        while (gamesCreated < 10) {

            int playersToAdd = random.nextInt(7) + 1;

            System.out.println("\nPlayers joining this turn: "
                    + playersToAdd);

            for (int i = 0; i < playersToAdd; i++) {

                String playerName =
                        names[(nextPlayerId - 1) % names.length];

                Player player = new Player(
                        nextPlayerId,
                        playerName,
                        random.nextInt(100) + 1
                );

                queue.enqueue(player);

                System.out.println("Joined: " + player);

                nextPlayerId++;
            }

            System.out.println("\nCurrent queue:");
            queue.printQueue();

            System.out.println("\nPress Enter to end the turn...");
            scanner.nextLine();

            while (queue.size() >= 5 && gamesCreated < 10) {

                gamesCreated++;

                System.out.println("\n=== GAME "
                        + gamesCreated + " CREATED ===");

                for (int i = 0; i < 5; i++) {
                    Player matchedPlayer = queue.dequeue();
                    System.out.println("Matched: " + matchedPlayer);
                }

                System.out.println("Players remaining: "
                        + queue.size());
            }
        }

        System.out.println("\n  Matchmaking Complete  ");
        System.out.println("Games successfully created: "
                + gamesCreated);
        System.out.println("Players left in queue: "
                + queue.size());

        scanner.close();
    }
}

