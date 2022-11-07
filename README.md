# Anagram Checker 
This is a program to check if two values are an anagram.

Assumptions include:
- If the word is not an anagram give correct message.
- A word that has the same number of characters as another is an anagram.
- Values that are valid anagrams that are added to the file, should not be allowed to be re-entered.
# Set up
Before running the application ensure to install Apache Maven and add \bin folder to your environment variable path:
```
C:\Program Files\apache-maven-3.8.6\bin
```

Depending on your version of Java, I am using version 17. Please update the pom.xml file to your version of Java:
```
 <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
 </properties>
```

Then you want to run the following commands in your \CodingChallenge directory:
```
mvn package
```
mvn package will build the program to create the /target folder and run the unit test.

Then you want to execute this command:
```
java -jar target/CodingChallenge-1.0-SNAPSHOT.jar
```
# Logging

Each time the application runs, logs will be visible in the terminal and written to a file within the \CodingChallenge directory.
