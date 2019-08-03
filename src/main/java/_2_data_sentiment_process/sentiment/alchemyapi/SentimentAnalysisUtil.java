package _2_data_sentiment_process.sentiment.alchemyapi;

public class SentimentAnalysisUtil {

    public static Boolean isPositiveSentiment(double sentimentScore) {
        return sentimentScore > 0;
    }

    public static Boolean isNegativeSentiment(double sentimentScore) {
        return sentimentScore < 0;
    }

    public static Boolean isNaturalSentiment(double sentimentScore) {
        return sentimentScore == 0;
    }

    public static int countPositiveSentiment(double sentimentScore) {
        return isPositiveSentiment(sentimentScore) ? 1 : 0;
    }

    public static int countNegativeSentiment(double sentimentScore) {
        return isNegativeSentiment(sentimentScore) ? 1 : 0;
    }

    public static int countNaturalSentiment(double sentimentScore) {
        return isNaturalSentiment(sentimentScore) ? 1 : 0;
    }

}
