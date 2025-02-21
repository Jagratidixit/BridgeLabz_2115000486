import java.io.*;
import java.util.*;
public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "textfile.txt";
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z]", " ").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCountMap.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Total words: " + wordCountMap.values().stream().mapToInt(Integer::intValue).sum());
        System.out.println("Top 5 most frequent words:");
        sortedWords.stream().limit(5).forEach(entry -> 
            System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
