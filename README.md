# validityCoopExercise

Steps to successfully run the web application:

1. Clone the repository named "validityCoopExercise". Run the following command from the terminal
    git clone git@github.com:AmanNigam1912/validityCoopExercise.git 
2. Open the application in any IDE, for example Eclipse - Spring Tool Suite
3. Import any dependencies asked by your IDE. All the required dependencies are already present in the pom.xml 
4. Make the following changes in the src/main/java/com/validity/workspace/ReadAndProcessCSV/ReadAndProcessCSV.java
    At Line 20: Replace the file name within quotes with the location of the normal.csv file on your local storage
    (P.S. The file is present in the repository)
5. Setup the server on your IDE to serve up the application. You can use Apache Tomcat.
6. By now you are all set to launch your application. Run the application
7. On successful compilation. Open up any browser and navigate to the following URL
    http://localhost:8080/workspace/home
    You can see all the duplicate records as well as none duplicate records.
8. By Default, the application will show just one record as that is the only one that is exact duplicate. Though one could play         around with the Person.java file, line number 125 to 128 and change the edit value for whatever fields they want from == 0 to        <=3 or <=4
9. Now the applciation will show records based on those results.