# Term ranking app

This app searches for terms on github issue API and then stores the term along with a score.
The score is calculated based on a simple formula:

Each hit on `{term} rocks` gets a positive hit, while a `{term} sucks` gets a negative hit.
With these two put into relation, the score is scaled from 0 .. 10.

The scores are cached in a local h2 database, which is embedded with this project.


## How to use?

Run this command:

```
mvn package && java -jar target/issue-analyzer-0.0.1-SNAPSHOT.jar
```

Once the server is up, run a curl command to see results

```
curl http://localhost:8080/score?term=java
```

Alternatively the same url can be run in your favorite browser.

To see the records in the h2 database, open the following link in your browser,
while the application is running.

```
http://localhost:8080/h2
```

The `src/main/resources/application.properties` contains the username and password to access the database.


Supported Java versions:

```
Java 7, Java 8, Java 9, Java 10
```
