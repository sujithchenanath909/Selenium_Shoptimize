# Selenium_Shoptimize

Selenium framework created as part of shoptmize assignment 

This is a maven based Java-TestNG framework . 

* Basic properties such as browser , base url and chrome driver path are updated in data.properties file 
    Update this file as per your driver binary path .
    
* project can be executed from command line using > mvn clean test -Dtest=HomePageTestCases 
 ![alt text](https://github.com/sujithchenanath909/Selenium_Shoptimize/blob/main/ScreenShots/cmd.PNG)

* Extent report is integrated into this and report will be generated at ../reports/index.html 

 ## Extent Report Sample
 ![alt text](https://github.com/sujithchenanath909/Selenium_Shoptimize/blob/main/ScreenShots/reports.PNG)


* Log4j is integrated for logging purpose and log file will be generated at ../logs/shoptimize.log
    Rolling file startegy is defined in log4j such that after each execution the old logs will be archeived with appeding its date to it . Thus all execution log files per day are     available 
    
