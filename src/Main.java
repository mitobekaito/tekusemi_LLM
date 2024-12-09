// Shift を 2 回押して 'どこでも検索' ダイアログを開き、`show whitespaces` と入力して
// Enter キーを押します。これでコードに空白文字が表示されます。
public class Main {
    public static void main(String[] args) {
        // デモ用のトレーニングテキスト
        String[] trainingTexts = {
                "私は猫が好きです。猫は可愛い動物です。動物は友達のようです。",
                "プログラミングは楽しいです。プログラミングは創造的な活動です。活動は新しいアイデアを生み出します。"
        };

        // 複数のテキストでデモンストレーション
        for (String text : trainingTexts) {
            // 言語モデルを初期化
            LanguageModel llm = new LanguageModel(text);

            // 結果を表示
            System.out.println("======= 言語モデル分析 =======");
            System.out.println("学習テキスト: " + llm.getOriginalText());
            System.out.println("最も頻繁な単語: " + llm.getMostFrequentWord());

            // サンプルの単語で次の単語を予測
            String[] words = text.split("\\s+");
            if (words.length > 0) {
                String sampleWord = words[0];
                System.out.println(
                        sampleWord + "の次の単語: " +
                                llm.predictNextWord(sampleWord)
                );
            }

            System.out.println(); // 改行
        }
    }
}