# Anagram checker 
This is a program to check if two values are an anagram.

Assumptions include:
- If the word is not an anagram give correct message.
- A word that has the same number of characters as another is an anagram.
# Set up
Before running the application ensure to install Apache Maven and add /bin folder to your environment variable path:
```
C:\Program Files\apache-maven-3.8.6\bin
```

Then you want to run the following commands in your \CodingChallenge directory:
```
mvn package
```
mvn package will build the program to create the /target folder and run the unit tests

Then you want to execute this command:
```
java -jar target/CodingChallenge-1.0-SNAPSHOT.jar
```