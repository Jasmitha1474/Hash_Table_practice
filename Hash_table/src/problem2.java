
import java.util.*;

public class problem2 {

    static HashMap<String, Integer> stock = new HashMap<>();
    static HashMap<String, Queue<Integer>> waitingList = new HashMap<>();

    public static void addProduct(String productId, int quantity) {
        stock.put(productId, quantity);
        waitingList.put(productId, new LinkedList<>());
    }

    public static int checkStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }

    public static synchronized String purchaseItem(String productId, int userId) {

        int currentStock = stock.getOrDefault(productId, 0);

        if (currentStock > 0) {
            stock.put(productId, currentStock - 1);
            return "Success, " + (currentStock - 1) + " units remaining";
        } else {
            waitingList.get(productId).add(userId);
            return "Added to waiting list, position #" + waitingList.get(productId).size();
        }
    }

    public static void main(String[] args) {

        addProduct("IPHONE15_256GB", 3);

        System.out.println("Stock: " + checkStock("IPHONE15_256GB"));

        System.out.println(purchaseItem("IPHONE15_256GB", 123));
        System.out.println(purchaseItem("IPHONE15_256GB", 456));
        System.out.println(purchaseItem("IPHONE15_256GB", 789));
        System.out.println(purchaseItem("IPHONE15_256GB", 999));
    }
}