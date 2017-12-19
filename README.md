# Sentiment analysis of customer feedback

Java and Python applications for sentiment analysis.

## Java sentiment analysis

The Java sentiment analysis uses the [Stanford Core NLP library](https://stanfordnlp.github.io/CoreNLP/).

The data to be analyzed should be in the `src/main/resources` folder as a csv file, with a semicolon ';' as a delimiter. The name of the csv file can be set in the `src/main/java/org/Parser.java` class. The csv file contains an evaluation of the sentence and the sentence itself.

To compile the program

    ./gradlew clean build

The English model file has to be downloaded separately, and can be found [here](https://stanfordnlp.github.io/CoreNLP/). The file should be placed in a folder called extlibs in the project root.

To run the program, go to the `build/libs` directory and run

    java -jar sentimentprogram.jar

Alternatively, the program can be run with gradle like this:

    ./gradlew run

## Python sentiment analysis

The Python sentiment analysis programs are in the `python` folder. They analyse the same file as the Java counterpart.

Requirements are listed in the requirements.txt file and can be installed with

    pip install -r requirements.txt

For sentiment analysis the [TextBlob](http://textblob.readthedocs.io/en/dev/index.html#) library is used.


## Other

The software was used for a paper based on my Master of technology thesis.
