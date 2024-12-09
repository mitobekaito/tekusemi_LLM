// 言語モデルのコア機能を提供するクラス
class LanguageModel {
    private TextCorpus corpus;
    private WordStatistics statistics;
    private WordPredictor predictor;

    public LanguageModel(String trainingText) {
        // テキストコーパスを作成
        this.corpus = new TextCorpus(trainingText);

        // 統計を計算
        this.statistics = new WordStatistics();
        statistics.calculateFrequency(corpus.getWords());

        // 予測モデルを学習
        this.predictor = new WordPredictor();
        predictor.trainNextWordPredictor(corpus.getWords());
    }

    // 分析結果を取得するメソッド
    public String getMostFrequentWord() {
        return statistics.getMostFrequentWord();
    }

    public String predictNextWord(String word) {
        return predictor.predictNextWord(word);
    }

    public String getOriginalText() {
        return corpus.getRawText();
    }
}