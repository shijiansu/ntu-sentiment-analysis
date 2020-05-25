![](https://img.shields.io/badge/language-java-blue)
![](https://img.shields.io/badge/technology-facebook%20comments,@20sentiment%20analysis-blue)
![](https://img.shields.io/badge/development%20year-2014-orange)
![](https://img.shields.io/badge/contributor-shijian%20su-purple)
![](https://img.shields.io/badge/license-MIT-lightgrey)

![](https://img.shields.io/github/languages/top/shijiansu/ntu-sentiment-analysis)
![](https://img.shields.io/github/languages/count/shijiansu/ntu-sentiment-analysis)
![](https://img.shields.io/github/languages/code-size/shijiansu/ntu-sentiment-analysis)
![](https://img.shields.io/github/repo-size/shijiansu/ntu-sentiment-analysis)
![](https://img.shields.io/github/last-commit/shijiansu/ntu-sentiment-analysis?color=red)

![](https://github.com/shijiansu/ntu-sentiment-analysis/workflows/ci%20build/badge.svg)

--------------------------------------------------------------------------------

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
