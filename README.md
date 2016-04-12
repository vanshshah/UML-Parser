Java source code to generate UML Class Diagram from .java files.
Steps to run the umlparser.jar file:
* Install the Graphviz on the system.
* Go to Terminal-> navigate to the directory where umlparser.jar resides-> type: java –jar umlparser.jar
* For example: java -jar /Users/ABC/Desktop/umlparser.jar /Users/ABC/Desktop/JavaFiles /Users/ABC/Desktop/ClassDiag.png


Steps to run the source code on Eclipse IDE:
* Go to File-> Import-> Existing Projects into Workspace.
* Browse the Source code path. Source contains the required jars: javaparser-core-2.2.3-SNAPSHOT.jar and plantuml.jar.
* Install the Graphviz on the system.
* Build the source code. Then go to Run-> Run Configurations-> click on Arguments tab.
* In Program arguments, enter the arguments, for example: "/Users/ABC/Desktop/JavaFiles" "/Users/ABC/Desktop/ClassDiag.png"
* Click on Apply and Run.

