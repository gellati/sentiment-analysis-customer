package org;

//import org.deeplearning4j.eval.ConfusionMatrix;
//import com.aliasi.classify.ConfusionMatrix;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map;

public class Parser {

    public static void main(String[] args) {

//      String csvFile = "answers_reviewed.csv";
        String csvFile = "test_set.csv";
        String cvsSplitBy = ";";
        int nRandomSentences = 5;

        List<String[]> results = new ArrayList<String[]>();
        myUtil myUtil = new myUtil();

        ClassPathResource resource = new ClassPathResource(csvFile);
        SentimentClassifier sentimentClassifier = new SentimentClassifier();

        try (InputStream inputStream = resource.getInputStream()) {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            List<Sentence> posSentences = new ArrayList<Sentence>();
            List<Sentence> neuSentences = new ArrayList<Sentence>();
            List<Sentence> negSentences = new ArrayList<Sentence>();

            while ((line = bufferedReader.readLine()) != null) {
                String [] lineElements = line.split(cvsSplitBy);
                results.add(new String [] {lineElements[0], lineElements[1]});
                Sentence s = new Sentence();
                switch (lineElements[0]){
                    case "1":
                        s.setSentence(lineElements[1]);
                        s.setActualSentiment(1);
                        s.setPredictedSentiment(sentimentClassifier.classifySentiment(lineElements[1]));
                        negSentences.add(s);
                        break;
                    case "2":
                        s.setSentence(lineElements[1]);
                        s.setActualSentiment(2);
                        s.setPredictedSentiment(sentimentClassifier.classifySentiment(lineElements[1]));
                        neuSentences.add(s);
                        break;
                    case "3":
                        s.setSentence(lineElements[1]);
                        s.setActualSentiment(3);
                        s.setPredictedSentiment(sentimentClassifier.classifySentiment(lineElements[1]));
                        posSentences.add(s);
                        break;
                }
            }
            inputStream.close();

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

           }

         catch (IOException e) {
            e.printStackTrace();
        }

    }

}
