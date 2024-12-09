import java.util.HashMap;
import java.util.Map;

// 単語の統計を計算するクラス
class WordStatistics {
    private Map<String, Integer> wordFrequency;

    public WordStatistics() {
        this.wordFrequency = new HashMap<>();
    }

    public void calculateFrequency(String[] words) {
        for (String word : words) {
            wordFrequency.put(word,
                    wordFrequency.getOrDefault(word, 0) + 1);
        }
    }

    public String getMostFrequentWord() {
        return wordFrequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("単語が見つかりません");
    }

    public Map<String, Integer> getWordFrequency() {
        return wordFrequency;
    }
}