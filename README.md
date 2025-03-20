# Overview

This project is an automation framework for testing the General Store e-commerce application in iOS and Android using Appium with Java. It is designed to validate various functionalities of the application, including product search, add to cart, and checkout processes.

## Tech Stack

Programming Language: Java

Automation Tool: Appium

Build Tool: Maven

Testing Framework: TestNG

Design Pattern: Page Object Model Framework(POM) and Data-Driven Framework

Reporting: Extent Reports

## Project Structure
```bash
TutorialNinjaAutomation/
│-- src/
│   ├── main/java/com/basePage/    # Base Page class
│   ├── main/java/com/pages/          # Page classes
│   ├── main/java/utilities/    		 # Utility classes
│   ├── test/java/baseTest/        	 # Test BasePage class
│   ├── test/java/resources/ 		 # app and iOS file
│   ├── test/java/runner/  			 # testing.xml
│   ├── test/java/testcases/   		 # Test classes
│-- test-output/                       	         # Test reports
│-- pom.xml                                		 # Maven dependencies
│-- README.md                                     # Project documentation
```

## Features Automated
    
✅ Filling Form    
✅ Search Page       
✅ Product Search
✅ Add to Cart Functionality 
✅ Checkout Process

## Installation & Setup

### Prerequisites:

✅ Install Java JDK 8+
✅ Install Maven
✅ Install Eclipse
✅ Add required dependencies in pom.xml

## Steps to Set Up:

1. Clone the repository:
```bash
git clone https://github.com/rimad6949/GenaralStoreAppProject.git
```
2. Open the project in your preferred IDE.
3. Ensure all dependencies are installed using Maven:
```bash
mvn clean install
```
4. Execute test cases using TestNG Runner.

## Running Tests

### To run tests using TestNG, execute:
```bash
mvn test
```

### Check the test-output folder after execution.

## Reporting

Open the index.html file in browser to view the result


