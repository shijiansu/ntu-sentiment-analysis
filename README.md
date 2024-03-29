![](https://img.shields.io/badge/development%20year-2014-orange)

# Database

1. Ensure application connection - MySql account at `spring.xml`
2. Maven and research data -> Missed

MySql account at pom.xml

sql:execute Execute SQL statements.

# Sentiment Analysis

(by default not using proxy (AlchemyAPI.java), should be RESTFul call better)
Need to setup sentiment analysis api: alchemyapi at sentiment.alchemyapi.properties
You can apply api key from http://www.alchemyapi.com

If need to invoke proxy, change this part

```shell
private boolean isProxy = false;
private String proxyAddress = "proxy.xxxxxxxxxxxxxxxx.com";
private int proxyPort = 22;
```
