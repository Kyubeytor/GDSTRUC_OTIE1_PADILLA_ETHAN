import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int DECK_SIZE = 30;
    private static final int MAX_CARDS_PER_TURN = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        CardStack playerHand = new CardStack(DECK_SIZE);
        CardStack playerDeck = new CardStack(DECK_SIZE);
        CardStack discardPile = new CardStack(DECK_SIZE);

        // Create the 30-card player deck.
        for (int i = 1; i <= DECK_SIZE; i++) {
            playerDeck.push(new Card("Card " + i));
        }

        System.out.println("=== Card Drawing Game ===");

        while (!playerDeck.isEmpty()) {
            System.out.println("\n------------------------------");

            int command = random.nextInt(3) + 1;

            int numberOfCards = random.nextInt(MAX_CARDS_PER_TURN) + 1;

            if (command == 1) {
                drawCards(playerDeck, playerHand, numberOfCards);
            } else if (command == 2) {
                discardCards(playerHand, discardPile, numberOfCards);
            } else {
                getFromDiscardPile(playerHand, discardPile, numberOfCards);
            }

            System.out.println("\nPlayer Hand:");
            playerHand.printStack();

            System.out.println("\nCards remaining in Player Deck: "
                    + playerDeck.size());

            System.out.println("Cards in Discard Pile: "
                    + discardPile.size());

            if (!playerDeck.isEmpty()) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        System.out.println("\n==============================");
        System.out.println("Player deck is empty.");
        System.out.println("Game Over!");
        System.out.println("==============================");

        scanner.close();
    }

    private static void drawCards(
            CardStack playerDeck,
            CardStack playerHand,
            int numberOfCards) {

        System.out.println("Command: Draw " + numberOfCards + " card(s)");

        int cardsToDraw = Math.min(numberOfCards, playerDeck.size());

        for (int i = 0; i < cardsToDraw; i++) {
            playerHand.push(playerDeck.pop());
        }
    }

    private static void discardCards(
            CardStack playerHand,
            CardStack discardPile,
            int numberOfCards) {

        System.out.println("Command: Discard " + numberOfCards + " card(s)");

        int cardsToDiscard = Math.min(numberOfCards, playerHand.size());

        for (int i = 0; i < cardsToDiscard; i++) {
            discardPile.push(playerHand.pop());
        }
    }

    private static void getFromDiscardPile(
            CardStack playerHand,
            CardStack discardPile,
            int numberOfCards) {

        System.out.println(
                "Command: Get " + numberOfCards
                        + " card(s) from Discard Pile");

        int cardsToGet = Math.min(numberOfCards, discardPile.size());

        for (int i = 0; i < cardsToGet; i++) {
            playerHand.push(discardPile.pop());
        }
    }
}
