# develabs-test

*Tech Stack Overview*
1. Programming Language Used: Java (preferably with IntelliJ IDE)
2. Test Framework: Cucumber JUnit
3. Dependency Management: Maven
4. WebDriver: ChromeDriver (Provided by WebDriverManager)
5. Reporting tool: Cucumber Reporting Library (generates html file)


*Setup Requirements:*
- Java
- Maven
- Chrome

*Installing Dependencies*
- On the command line, navigate to the root directory of the project and enter `mvn clean install`
- Alternative on the IntelliJ IDE, open the pom.xml file and click `Install Dependencies`

*Running tests*
- On the command line, navigate to the root directory of the project and enter `mvn test`
- Alternative on the IntelliJ IDE, open features directory, select a feature file and then click the play button on the specific scenario or feature. (Using this will not generate an html report as the generation ilbrary is a Maven plugin)

*Viewing Test Artifacts*
1. Reports: Saved in `root/target/cucumber-reports.html`
2. Screenshots: Saved in `root/src/test/java/resources/screenshots`. One screenshot will be generated per test case

*Transaction Processes Tested:*
1. Guest session
2. Logged in session
