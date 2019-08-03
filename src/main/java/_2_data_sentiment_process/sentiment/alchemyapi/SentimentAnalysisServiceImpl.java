package _2_data_sentiment_process.sentiment.alchemyapi;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import _2_data_sentiment_process.sentiment.alchemyapi.xml.TextSentimentResult;
import _2_data_sentiment_process.sentiment.alchemyapi.xml.TextSentimentResultDocSentiment;

import com.alchemyapi.api.AlchemyAPI;

public class SentimentAnalysisServiceImpl {

	private String[] apiKeyList = {
			"88522a5fd17953333e57ca1795fad9a4f7e31b56",
			"f4dfd4e4bd6b84f856caa2d0c88455c10311c10e",
			"141f06a086196494ce8738343d8e1478071b6160",
			"8ba3dd15c197840f2baef05c33432c3bba535805",
	        "a79337b3d78182d8c639e426cca7a0b6a778882b",
	        "1542d0cde0b72b4a850879933155a42080e3d8d6",
	        "8ac7567d3b52089004dbe5a9cd07258cfac7b961",
	        "191a405c9db549e4944a1ab7dc5228fe85c0e1bb",
	        "3665cf85c2b3258868ee064283b41cfda3eafff2",
	        "90824f168e5684361c73548cb83a1e8b4d331172",
	        "513be3035eaec246667093a736eaa9911580be48",
	        "37fd612c6031f219d273f860db6b855a6e2d4c72",
	        "a912fc71659c753ca936fee51a14c2f27634ccc3",
	        "7011bbc59d68e00de203cdf4df4370c7009de1f9",
	        "4cd878505dfbacf344908e920507170c3306c070",
	        "5c727c8b8bdb37c5f48ff275404fb747e335aa02",
	        "05fcda0ef96108a4f58796ea24fcb1f31741420d",
	        "81d90a12a66a69f954d6a44d27f3f39b81ddd242",
	        "68a0bb7a035411537ab2c63d39870f424af73b03",
	        "dbbce8e85455c45885878dd208b9ec74b481f24b",
	        "23a75d397cd2e5a063bfc835d0090950ec1dc1ac",
			"423be0715bb40152304484b09106a80dfcf15595",
			"f06dbfce01b7fef518a741dc2bbe4f57102fe8c6",
			"464f55013289ca3566c7e60e29fc15d0644af1bb",
			"86ae5a3f042f68ea293d5cd9bdb646aabcb9399e",
			"874d63cf4e4bf8f7eb119bedc9bf412af398423d",
			"d3ea2e16df1fa4afde7c234ef24b2cea3f175782",
			"4cf9067c59a7c69412c39323b69fb0f4daa65ca8",
			"e75f1b37e8ef1bf190871eee83e037bed2839962",
			"9d4a9279530437334a4584bc8a6ae53c40b29857"
			};
	private int apiKeyIndex = 0;

	public TextSentimentResult analyzeTextSentiment(String text) {
		// in the API it is not allow null or "" text
		try {
			return extractFromDocument(getTextSentimentResult(text));
		} catch (Exception e) {
			e.printStackTrace();
			// only stop when api is invalid
			if (e.getMessage().contains("unsupported-text-language")
					|| e.getMessage().contains("Enter some text to analyze")) {
				TextSentimentResultDocSentiment docSentiment = new TextSentimentResultDocSentiment();
				docSentiment.setScore(0);
				TextSentimentResult result = new TextSentimentResult();
				result.setDocSentiment(docSentiment);
				return result;
			} else {
				throw new RuntimeException(e);
			}
		}
	}

	private Document getTextSentimentResult(String text) throws Exception {
		// Create an AlchemyAPI object.
		AlchemyAPI alchemyObj = AlchemyAPI
				.GetInstanceFromString(apiKeyList[apiKeyIndex]);

		try {
			// Extract sentiment for a text string.
			Document doc = alchemyObj.TextGetTextSentiment(text);
			return doc;
		} catch (Exception e) {
			if (e.getMessage().contains("daily-transaction-limit-exceeded")) {
				// when run out all the key, will throw
				// java.lang.ArrayIndexOutOfBoundsException, application stop
				e.printStackTrace();
				apiKeyIndex++;
				System.out.println("using key: " + apiKeyIndex);
				return getTextSentimentResult(text);
			} else {
				throw new RuntimeException(e);
			}
		}
		// System.out.println(getStringFromDocument(doc));

	}

	private TextSentimentResult extractFromDocument(Document doc)
			throws Exception {
		JAXBContext context = JAXBContext
				.newInstance(TextSentimentResult.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		TextSentimentResult result = (TextSentimentResult) unmarshaller
				.unmarshal(doc);
		System.out.println(result.toString());
		return result;
	}

	public String getStringFromDocument(Document doc) {
		try {
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);

			return writer.toString();
		} catch (TransformerException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
