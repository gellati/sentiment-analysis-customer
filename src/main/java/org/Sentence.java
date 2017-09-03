package org;

/**
 * Created by omar on 9/3/17.
 */
public class Sentence {
    private String sentence;
    private int actualSentiment;
    private int predictedSentiment;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public int getActualSentiment() {
        return actualSentiment;
    }

    public void setActualSentiment(int actualSentiment) {
        this.actualSentiment = actualSentiment;
    }

    public int getPredictedSentiment() {
        return predictedSentiment;
    }

    public void setPredictedSentiment(int predictedSentiment) {
        this.predictedSentiment = predictedSentiment;
    }
}
