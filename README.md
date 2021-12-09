# CS6422
Analysis and Benchmarking of Threaded Applications on MySQL and Neo4j
The main objective of this project is to find the most optimal implementation for the back-end of a Social Media data set. This was done by comparing two completely different approaches to store data: a Relational database, that stores data in the form of relations (attributes and tuples) and a Graph-based database, that stores data in the form of Graph nodes, and connects these nodes together to show relations between them.

There are two project source directories that can be accessed in order to access the code for both of them. JavaApplication6 consists of the test code for MySQL test and mavenproject3, the test code for Neo4j.

To set up MySQL:
1. Go to the link https://dev.mysql.com/downloads/workbench/ to download the latest version of MySQL.
2. Open MySQL and create a database for the data to be put in.
3. Open the SQL files using MySQL and add them to the required database.
4. If they are not added that way, simply open them using Notepad and start copying their code by code.
5. Now, try using MySQL commands to query the data, and check for its validity.

To set up Neo4j:
1. Go to https://neo4j.com/download/ and download the Neo4j Server at: https://neo4j.com/download-center/#enterprise
2. Run Command Prompt as an Administrator. Navigate to the Neo4j folder.
3. Locate to the bin directory of the same and run the command "neo4j.bat install-service".
4. Now the service has been set up. Type the command "net start Neo4j" to start it.
5. Go to a browser and type http://localhost:7474/ to use Neo4j.

Note: If the CSV files are not loaded in the system, store them in the 'import' directory of the Neo4j folder. Then try to load them again. Some screenshots have been provided to help with loading the files.

To run the Java files:
As mentioned before, the JavaApplication6 folder contains the test files for MySQL and mavenproject3 contains the test files for Neo4j.
1. Navigate to JavaApplication6/src/newpackage/Test.java for Single-threaded tests on MySQL.
2. Navigate to JavaApplication6/src/newpackage/Test2.java for Multi-threaded tests on MySQL.
3. Navigate to mavenproject3/src/main/java/TestNeo4j.java for Single-threaded tests on Neo4j.
4. Navigate to mavenproject3/src/main/java/Test2Neo4j.java for Multi-threaded tests on Neo4j.

These tests run the whole query and return the amount of time required to run each of them, in the console.log output.
