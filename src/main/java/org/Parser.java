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

//import Sentence;


public class Parser {
  public Parser(){

  }


  //      String csvFile = "answers_reviewed.csv";
        String csvFile = "test_set_1.csv";
        String delimiter = ";";
        int nRandomSentences = 5;


  public List<Sentence> parseFile(){
    List<String[]> results = new ArrayList<String[]>();
    myUtil myUtil = new myUtil();

    ClassPathResource resource = new ClassPathResource(csvFile);
    List<Sentence> parsedSet = new ArrayList<Sentence>();

    try (InputStream inputStream = resource.getInputStream()) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        List<Sentence> posSentences = new ArrayList<Sentence>();
        List<Sentence> neuSentences = new ArrayList<Sentence>();
        List<Sentence> negSentences = new ArrayList<Sentence>();

        while ((line = bufferedReader.readLine()) != null) {
            String [] lineElements = line.split(delimiter);
            if(lineElements[0].equals("Actual sentiment")){
              continue;
            }
//            results.add(new String [] {lineElements[0], lineElements[1]});
            Sentence s = new Sentence();
            s.setActualSentiment(Integer.parseInt(lineElements[0]));
            s.setSentence(lineElements[1]);
            parsedSet.add(s);
/*
            switch (lineElements[0]){
                case "1":
                    s.setSentence(lineElements[1]);
                    s.setActualSentiment(1);
                    s.setPredictedSentiment(sentimentClassifier.classifySentiment(lineElements[1]));
                    negSentences.add(s);
  System.out.println(sentimentClassifier.classifySentiment(lineElements[1]) + " " + lineElements[1] );
                    break;
                case "2":
                    s.setSentence(lineElements[1]);
                    s.setActualSentiment(2);
                    s.setPredictedSentiment(sentimentClassifier.classifySentiment(lineElements[1]));
                    neuSentences.add(s);
  System.out.println(sentimentClassifier.classifySentiment(lineElements[1]) + " " + lineElements[1] );
                    break;
                case "3":
                    s.setSentence(lineElements[1]);
                    s.setActualSentiment(3);
                    s.setPredictedSentiment(sentimentClassifier.classifySentiment(lineElements[1]));
                    posSentences.add(s);
  System.out.println(sentimentClassifier.classifySentiment(lineElements[1]) + " " + lineElements[1] );
                    break;
            }
*/


        }
        inputStream.close();
/*
        parsedSet.addAll(posSentences);
        parsedSet.addAll(neuSentences);
        parsedSet.addAll(negSentences);
*/
      }

     catch (IOException e) {
        e.printStackTrace();
    }
    return parsedSet;

}
}
