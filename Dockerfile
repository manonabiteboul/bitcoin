FROM java:8
ADD target/bitcoin-*.jar app.jar
CMD java -jar app.jar
