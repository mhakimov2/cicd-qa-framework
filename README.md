Selenium / JUnit5 / Selenoid  

### Scope:
    1. Test execution on Jenkins server. 
    2. Screenshot creation for failed tests
    3. Parallel test execution
    4. Logging
    5. Allure reporting
    
### Configuration:

Configuration defined in ApplicationProperties.java

Examples:
You need to specify the following parameters:

-Dapplication.appUrl = {URL of app under test}



You can specify browser by using one of the following switches:

-Dbrowser=FIREFOX
-Dbrowser=CHROME

Also you can specify where to run tests, on local machine / Jenkins:

-Dselenium.remoteDriver=true
 

### How to run test?
Execute the following command in the terminal or Jenkinsfile:

        mvn clean install test -Dapplication.appUrl={} 

       
### Technical choice
Java: a popular programming language. It is supported by Selenium, and runs faster than most of the 
popular programming languages.

Page Object Model as a framework structure: this design pattern makes the code clean and re-usable.
