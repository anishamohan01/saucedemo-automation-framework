# Automation Framework for SauceDemo

This project is an automation framework built from scratch for the [SauceDemo](https://www.saucedemo.com) website using Selenium, Java, Cucumber, TestNg and related tools. The framework follows the Page Object Model (POM) design pattern with Page Factory, ensuring modular and maintainable test code.

## Project Structure

```plaintext
src
└──_ main
    └── java
        └── com
            └── saucedemo
                ├── pages                     # Page classes with locators and methods
                │   ├── LoginPage.java
                │   ├── ProductsPage.java
                │   └── CartPage.java
                └── utils                     # Utility classes
                    ├── ConfigReader.java     # Configuration reader utility
                    ├── DriverFactory.java    # WebDriver initialization
                    └── LoggerHelper.java     # Logger helper
└── test
    └── java
        └── com
            └── saucedemo
                └── stepdefinitions           # Step definition classes for Cucumber
                    ├── LoginSteps.java
                    └── Hooks.java            # Pre/post conditions
                └── runners                   # Cucumber test runner
                    └── TestRunner.java
└── resources
    ├── features                              # Cucumber feature files
    │   └── login.feature
    ├── config.properties                     # Application configuration properties
    └── log4j2.xml                            # Logger configuration

```

## Prerequisites

- **Java Development Kit (JDK)**: 17
- **Maven**: For dependency management

## Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. **Configure Maven**

   Ensure that Maven is installed and configured in your system. The project uses Maven to manage dependencies and build the project.


4. **Install Dependencies**

   Run the following command in the project root to install the required dependencies:

   ```bash
   mvn clean install
   ```

## Running Tests

To run the tests, execute the following command:

```bash
mvn test
```

This command will compile the code, run the Cucumber tests, and generate reports.

### Viewing Reports

Reports will be generated in the `allure-results` folder. You can view the HTML report to see the results of your tests.

## Logging

The framework uses Log4j2 for logging actions. Logs will be saved in the `logs/app.log` file.

## Features

- **Page Object Model**: Encourages reusability and maintainability.
- **Cucumber Integration**: Allows for behavior-driven development with Gherkin syntax.
- **Extensive Logging**: Captures actions performed during test execution.
- **Report Generation**: Generates detailed reports for test execution results.

