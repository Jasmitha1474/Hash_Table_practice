

import java.util.*;

public class Problem4 {

    static HashMap<String, Set<String>> ngramIndex = new HashMap<>();

    public static List<String> generateNGrams(String text, int n) {

        String[] words = text.split(" ");
        List<String> ngrams = new ArrayList<>();

        for (int i = 0; i <= words.length - n; i++) {

            String gram = "";

            for (int j = 0; j < n; j++) {
                gram += words[i + j] + " ";
            }

            ngrams.add(gram.trim());
        }

        return ngrams;
    }

    public static void addDocument(String docId, String text) {

        List<String> ngrams = generateNGrams(text, 3);

        for (String gram : ngrams) {

            ngramIndex.putIfAbsent(gram, new HashSet<>());
            ngramIndex.get(gram).add(docId);
        }
    }

    public static void main(String[] args) {

        addDocument("doc1", "this is a sample essay for testing plagiarism");
        addDocument("doc2", "this is a sample essay written by student");

        System.out.println("Indexed ngrams: " + ngramIndex.size());
    }
}