import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> wordCount = new HashMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        String mostFrequentWord = null;
        int maxFrequency = 0;

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            String word = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFrequency ||
                    (frequency == maxFrequency && word.compareTo(mostFrequentWord) < 0)) {
                mostFrequentWord = word;
                maxFrequency = frequency;
            }
        }

        System.out.println(mostFrequentWord);
    }
}