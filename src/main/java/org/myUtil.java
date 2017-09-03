package org;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by omar on 9/3/17.
 */
public class myUtil {

    public List<Integer> getRandomIntegers(int n, int roof){
        List<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < n) {
            int random = randomGenerator.nextInt(roof);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        return numbers;
    }

    public List<Sentence> selectRandomSentences(List<Sentence> sentences, int nRandomNumbers){
        List<Sentence> randomSentences = new ArrayList<Sentence>();
        List<Integer> randomNumbers = getRandomIntegers(nRandomNumbers, sentences.size());
        randomNumbers.forEach(integer -> {
            randomSentences.add(sentences.get(integer));
        });
        return randomSentences;
    }
}
