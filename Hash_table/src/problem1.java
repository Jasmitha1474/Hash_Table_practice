

import java.util.*;

public class problem1 {

    private HashMap<String, Integer> usernameMap = new HashMap<>();
    private HashMap<String, Integer> attemptFrequency = new HashMap<>();

    // Register user
    public void registerUser(String username, int userId) {
        usernameMap.put(username, userId);
    }

    // Check username availability
    public boolean checkAvailability(String username) {
        attemptFrequency.put(username, attemptFrequency.getOrDefault(username, 0) + 1);
        return !usernameMap.containsKey(username);
    }

    // Suggest alternatives
    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            String suggestion = username + i;
            if (!usernameMap.containsKey(suggestion)) {
                suggestions.add(suggestion);
            }
        }

        String suggestion = username + "_123";
        if (!usernameMap.containsKey(suggestion)) {
            suggestions.add(suggestion);
        }

        return suggestions;
    }

    // Get most attempted username
    public String getMostAttempted() {
        String mostAttempted = "";
        int max = 0;

        for (Map.Entry<String, Integer> entry : attemptFrequency.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostAttempted = entry.getKey();
            }
        }

        return mostAttempted;
    }

    public static void main(String[] args) {

        problem1 p = new problem1();

        p.registerUser("john_doe", 1);

        System.out.println(p.checkAvailability("john_doe"));
        System.out.println(p.checkAvailability("jane_smith"));

        System.out.println(p.suggestAlternatives("john_doe"));

        System.out.println(p.getMostAttempted());
    }
}
