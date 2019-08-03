## Database:
Need to setup database: 
1) application connection 
MySql account at spring.xml
2) maven and research data -> Missed
MySql account at pom.xml

sql:execute Execute SQL statements.

## Sentiment Analysis
(by default not using proxy (AlchemyAPI.java), should be RESTFul call better)
Need to setup sentiment analysis api: alchemyapi at sentiment.alchemyapi.properties
You can apply api key from http://www.alchemyapi.com

If need to invoke proxy, change this part
    private boolean isProxy = false;
    private String proxyAddress = "proxy.xxxxxxxxxxxxxxxx.com";
    private int proxyPort = 22;
