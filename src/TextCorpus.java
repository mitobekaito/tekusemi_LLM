// テキストデータを管理するクラス
class TextCorpus {
    private String rawText;
    private String[] words;

    public TextCorpus(String text) {
        this.rawText = text;
        processText();
    }

    private void processText() {
        this.words = rawText.toLowerCase()
                .replaceAll("[^a-zA-Zあ-んア-ン一-龯]", " ")
                .split("\\s+");
    }

    public String[] getWords() {
        return words;
    }

    public String getRawText() {
        return rawText;
    }
}