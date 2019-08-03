package _2_data_sentiment_process.sentiment.alchemyapi.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "results")
// Use XmlAccessorType let JAXB only look at field.
// Otherwise has "Class has two properties of the same name" error
@XmlAccessorType(XmlAccessType.FIELD)
public class TextSentimentResult {
    @XmlElement(name = "status")
    private String status;

    @XmlElement(name = "usage")
    private String usage;

    @XmlElement(name = "url")
    private String url;

    @XmlElement(name = "language")
    private String language;

    private TextSentimentResultDocSentiment docSentiment;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public TextSentimentResultDocSentiment getDocSentiment() {
        return docSentiment;
    }

    public void setDocSentiment(TextSentimentResultDocSentiment docSentiment) {
        this.docSentiment = docSentiment;
    }

    @Override
    public String toString() {
        return "TextSentimentResult [status=" + status + ", usage=" + usage + ", url=" + url + ", language=" + language
                + ", docSentiment=" + docSentiment + "]";
    }

}
