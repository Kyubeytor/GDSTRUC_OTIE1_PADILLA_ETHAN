
public class Main {

    public static void main(String[] args) {
        PlayerLinkedList playerList = new PlayerLinkedList();
        playerList.add(new Player(1, "Goku", 1));
        playerList.add(new Player(2, "Saitama", 2));
        playerList.add(new Player(3, "???", 3));

        playerList.printList();


    }
}
