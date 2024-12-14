package vn.techzen.bai1.Model;

public class DictionaryModel {
    private static int idCounter = 0;
    private int id;
    private String EnglishVocabulary;
    private String VietNameVocabulary;

    public DictionaryModel(String EnglishVocabulary, String VietNameVocabulary) {
        this.id = ++idCounter;
        this.EnglishVocabulary = EnglishVocabulary;
        this.VietNameVocabulary = VietNameVocabulary;
    }

    public int getId() {
        return id;
    }

    public String getEnglishVocabulary() {
        return EnglishVocabulary;
    }

    public void setEnglishVocabulary(String EnglishVocabulary) {
        this.EnglishVocabulary = EnglishVocabulary;
    }

    public String getVietNameVocabulary() {
        return VietNameVocabulary;
    }

    public void setVietNameVocabulary(String VietNameVocabulary) {

        this.VietNameVocabulary = VietNameVocabulary;
    }

}
