
import java.util.*;

class TokenBucket {

    int tokens;
    int maxTokens;
    long lastRefill;

    TokenBucket(int max) {
        tokens = max;
        maxTokens = max;
        lastRefill = System.currentTimeMillis();
    }
}

public class Problem6 {

    static HashMap<String, TokenBucket> clients = new HashMap<>();
    static int LIMIT = 5;

    public static boolean checkRateLimit(String clientId) {

        clients.putIfAbsent(clientId, new TokenBucket(LIMIT));

        TokenBucket bucket = clients.get(clientId);

        long now = System.currentTimeMillis();

        if (now - bucket.lastRefill > 60000) {
            bucket.tokens = LIMIT;
            bucket.lastRefill = now;
        }

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 7; i++) {

            boolean allowed = checkRateLimit("client1");

            System.out.println("Request " + i + ": " + (allowed ? "Allowed" : "Denied"));
        }
    }
}