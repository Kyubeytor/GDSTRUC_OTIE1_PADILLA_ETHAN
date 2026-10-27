public class Main {
    public static void main(String[] args){

        Player pikachu = new Player(1, "Pikachu", 20);
        Player celebi = new Player(2, "Celebi", 17);
        Player hitmonchan = new Player(3, "Hitmonchan", 13);
        Player mankey = new Player(4, "Mankey", 11);
        Player starmie = new Player(5, "Starmie", 20);
        Player togepi = new Player(6, "Togepi", 30);

        SimpleHashtable hashtable = new SimpleHashtable();
        hashtable.put(pikachu.getUserName(), pikachu);
        hashtable.put(celebi.getUserName(), celebi);
        hashtable.put(hitmonchan.getUserName(), hitmonchan);
        hashtable.put(mankey.getUserName(), mankey);
        hashtable.put(starmie.getUserName(), starmie);
        hashtable.put(togepi.getUserName(), togepi);

        System.out.println("Original Hashtable:");
        hashtable.printHashtable();

        System.out.println("\nRemoving Pikachu...");

        Player removedPlayer = hashtable.remove("Pikachu");
        System.out.println("Removed player: " + removedPlayer);
        System.out.println("\nHashtable after removal:");

        hashtable.printHashtable();

        System.out.println("\nSearching for Pikachu:");
        System.out.println(hashtable.get("Pikachu"));
        System.out.println("\nSearching for Celebi:");
        System.out.println(hashtable.get("Celebi"));
    }
}
