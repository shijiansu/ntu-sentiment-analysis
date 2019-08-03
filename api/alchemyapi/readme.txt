#################################
1.
Download Java SDK from http://www.alchemyapi.com/developers/sdks/
Or,
Use alchemyapi_java-master.zip from this project

You can ignore the instruction of:
"
# can directly download from github
git clone https://github.com/AlchemyAPI/alchemyapi_java.git

# execute from ant
cd alchemyapi_java
ant jar

# prepare the api key, you can copy into testdir/api_key.txt also 
cp YOUR_API_KEY.txt testdir/api_key.txt
cd testdir

# run the test
java -jar ../dist/AlchemyAPI-Entity-Test.jar
"

#################################
2.
From above files you can know, to run the alchemyapi SDK, you only need copy all java files from:
alchemyapi_java-master\src\com\alchemyapi\api
to your project, under package:
com.alchemyapi.api

That is all.

#################################
Or, you can install into your local Maven repository after your "ant jar"
