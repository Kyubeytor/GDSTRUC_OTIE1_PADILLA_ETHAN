public class PlayerLinkedList {
    private PlayerNode head;
    private int size;

    public void add(Player player) {
        PlayerNode node = new PlayerNode(player);
        node.setNextPlayer(head);
        head = node;
        size++;
    }

    public Player removeFirst() {
        if (head == null) {
            return null;
        }

        Player removedPlayer = head.getPlayer();
        head = head.getNextPlayer();
        size--;

        return removedPlayer;
    }

    public int size() {
        return size;
    }

    public boolean contains(Player player) {
        PlayerNode currentNode = head;

        while (currentNode != null) {
            if (currentNode.getPlayer().equals(player)) {
                return true;
            }

            currentNode = currentNode.getNextPlayer();
        }

        return false;
    }

    public int indexOf(Player player) {
        PlayerNode currentNode = head;
        int index = 0;

        while (currentNode != null) {
            if (currentNode.getPlayer().equals(player)) {
                return index;
            }

            currentNode = currentNode.getNextPlayer();
            index++;
        }

        return -1;
    }

    public void printList() {
        PlayerNode currentNode = head;

        System.out.println("Head ");

        while (currentNode != null) {
            System.out.print(" ->" + currentNode.getPlayer());
            currentNode = currentNode.getNextPlayer();
        }
    }
}