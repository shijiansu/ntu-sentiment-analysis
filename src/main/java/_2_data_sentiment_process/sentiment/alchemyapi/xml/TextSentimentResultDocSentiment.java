package _2_data_sentiment_process.sentiment.alchemyapi.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TextSentimentResultDocSentiment {
	@XmlElement(name = "type")
	private String type;

	@XmlElement(name = "score")
	private double score;

	@XmlElement(name = "mixed")
	private int mixed;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getMixed() {
		return mixed;
	}

	public void setMixed(int mixed) {
		this.mixed = mixed;
	}

	@Override
	public String toString() {
		return "TextSentimentResultDocSentiment [type=" + type + ", score="
				+ score + ", mixed=" + mixed + "]";
	}

}
