import java.util.*;

public class Problem5 {

    static HashMap<String, Integer> pageViews = new HashMap<>();
    static HashMap<String, Set<String>> uniqueVisitors = new HashMap<>();
    static HashMap<String, Integer> trafficSources = new HashMap<>();

    public static void processEvent(String url, String userId, String source) {

        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueVisitors.putIfAbsent(url, new HashSet<>());
        uniqueVisitors.get(url).add(userId);

        trafficSources.put(source, trafficSources.getOrDefault(source, 0) + 1);
    }

    public static void getDashboard() {

        System.out.println("Top Pages:");

        for (String page : pageViews.keySet()) {

            System.out.println(page + " - " + pageViews.get(page) +
                    " views (" + uniqueVisitors.get(page).size() + " unique)");
        }

        System.out.println("\nTraffic Sources:");

        for (String source : trafficSources.keySet()) {

            System.out.println(source + " : " + trafficSources.get(source));
        }
    }

    public static void main(String[] args) {

        processEvent("/news", "user1", "google");
        processEvent("/news", "user2", "facebook");
        processEvent("/sports", "user3", "google");
        processEvent("/news", "user1", "direct");

        getDashboard();
    }
}