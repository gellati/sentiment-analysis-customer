package org;

//import org.deeplearning4j.eval.ConfusionMatrix;
//import com.aliasi.classify.ConfusionMatrix;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

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

      while ((line = bufferedReader.readLine()) != null) {
        String [] lineElements = line.split(delimiter);
        if(lineElements[0].equals("Actual sentiment")){
          continue;
        }
        Sentence s = new Sentence();
        s.setActualSentiment(Integer.parseInt(lineElements[0]));
        s.setSentence(lineElements[1]);
        parsedSet.add(s);
      }
      inputStream.close();
    }

    catch (IOException e) {
      e.printStackTrace();
    }
    return parsedSet;
  }
}
