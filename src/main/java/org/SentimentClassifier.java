package org;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

import java.util.Properties;

/**
 * Created by omar on 9/3/17.
 */
public class SentimentClassifier {
    StanfordCoreNLP pipeline;
    int score = 0;
    public SentimentClassifier(){
        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit, parse, sentiment");
        pipeline = new StanfordCoreNLP(props);
    };

    public int classifySentiment(String s){

        Annotation annotation = new Annotation(s);
        pipeline.annotate(annotation);
        for(CoreMap sentence: annotation.get(CoreAnnotations.SentencesAnnotation.class)){
            Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
            score = RNNCoreAnnotations.getPredictedClass(tree);
        }
        return score;
    }
}
