package org;

//import Parser;
//import Sentence;

import java.util.*;

public class Analyzer{
  Parser parser = new Parser();
  SentimentClassifier sentimentClassifier = new SentimentClassifier();

  public Analyzer(){

  }

  public void run(){
    List<Sentence> sentences = parser.parseFile();


    ConfusionMatrix cm = new ConfusionMatrix();
    sentences.forEach((i)->{
      System.out.println(i.getSentence());
      System.out.println(i.getActualSentiment());
        i.setPredictedSentiment(sentimentClassifier.classifySentiment(i.getSentence()));
        cm.increaseValue(Integer.toString(i.getActualSentiment()), Integer.toString(i.getPredictedSentiment()));
    });

    System.out.println(cm.toString());
    System.out.println(cm.getCohensKappa());
    System.out.println(cm.getAccuracy());
    System.out.println(cm.getRecallForLabels());
    System.out.println(cm.getPrecisionForLabels());
    System.out.println(cm.getTotalSum());
    Map<String, Double> labelPrecisions = cm.getPrecisionForLabels();
    Map<String, Double> labelRecalls = cm.getRecallForLabels();
    /*
*/

  }




  /*
        List<Sentence> testSet = new ArrayList<Sentence>();

        testSet.addAll(myUtil.selectRandomSentences(posSentences, nRandomSentences));
        testSet.addAll(myUtil.selectRandomSentences(neuSentences, nRandomSentences));
        testSet.addAll(myUtil.selectRandomSentences(negSentences, nRandomSentences));

        System.out.println(testSet.size());

        ConfusionMatrix cm = new ConfusionMatrix();
        testSet.forEach((i)->{
            cm.increaseValue(Integer.toString(i.getActualSentiment()), Integer.toString(i.getPredictedSentiment()));
        });

        System.out.println("hello");
        System.out.println(cm.toString());
        System.out.println(cm.getCohensKappa());
        System.out.println(cm.getAccuracy());
        System.out.println(cm.getRecallForLabels());
        System.out.println(cm.getPrecisionForLabels());
        System.out.println(cm.getTotalSum());
        Map<String, Double> labelPrecisions = cm.getPrecisionForLabels();
        Map<String, Double> labelRecalls = cm.getRecallForLabels();
  */

}
