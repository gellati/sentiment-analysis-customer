from nltk.sentiment.vader import SentimentIntensityAnalyzer
from sklearn.metrics import confusion_matrix
from sklearn.metrics import precision_recall_fscore_support as score
import csv, unidecode, unicodedata, io



def sentimentRange(s):
    if s >= -1.00 and s < -0.33:
        return 1
    if s >= -0.33 and s <= 0.33:
        return 2
    if s > 0.33 and s <= 1.00:
        return 3
#infile = "../src/main/resources/test_set.csv"
infile = "../src/main/resources/answers_reviewed.csv"

csvreader = csv.reader(io.open(infile, 'rb'), delimiter=';', quotechar='"') #, coding='utf-8')
csvreader.next()

y_true = []
y_pred = []

analyzer = SentimentIntensityAnalyzer()

for row in csvreader:
    s = analyzer.polarity_scores(row[1].decode('utf-8'))
    y_true.append(int(row[0]))
    y_pred.append(sentimentRange(s['compound']))

precision, recall, fscore, support = score(y_true, y_pred)
print confusion_matrix(y_true, y_pred)
print('precision: {}'.format(precision))
print('recall: {}'.format(recall))
print('fscore: {}'.format(fscore))
print('support: {}'.format(support))
