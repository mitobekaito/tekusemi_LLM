import java.util.*;

// 単語の予測を行うクラス
class WordPredictor {
    private Map<String, List<String>> nextWordPredictor;
    private Random random;

    public WordPredictor() {
        this.nextWordPredictor = new HashMap<>();
        this.random = new Random();
    }

    public void trainNextWordPredictor(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];

            nextWordPredictor
                    .computeIfAbsent(currentWord, k -> new ArrayList<>())
                    .add(nextWord);
        }
    }

    public String predictNextWord(String word) {
        List<String> possibleNextWords = nextWordPredictor.get(word);

        if (possibleNextWords == null || possibleNextWords.isEmpty()) {
            return "予測できません";
        }

        return possibleNextWords.get(
                random.nextInt(possibleNextWords.size())
        );
    }
}
