import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, long ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl;
    }
}

public class Problem3 {

    static HashMap<String, DNSEntry> cache = new HashMap<>();
    static int hits = 0, misses = 0;

    public static String resolve(String domain) {

        DNSEntry entry = cache.get(domain);

        if (entry != null && System.currentTimeMillis() < entry.expiry) {
            hits++;
            return "Cache HIT → " + entry.ip;
        }

        misses++;
        String ip = "172.217.14." + new Random().nextInt(255);
        cache.put(domain, new DNSEntry(ip, 30000));

        return "Cache MISS → " + ip;
    }

    public static void getCacheStats() {

        int total = hits + misses;
        double hitRate = (total == 0) ? 0 : (hits * 100.0 / total);

        System.out.println("Hit Rate: " + hitRate + "%");
    }

    public static void main(String[] args) {

        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));
        System.out.println(resolve("facebook.com"));

        getCacheStats();
    }
}
