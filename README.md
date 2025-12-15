[![CI](../../actions/workflows/ci.yaml/badge.svg)](../../actions/workflows/ci.yaml)

# java-selenium-framework

Mini UI automation framework built with **Java 17**, **Selenium 4**, and **JUnit 5**, following the **Page Object Model (POM)**.

The tests automate core flows on **saucedemo.com**:
- Valid login
- Invalid login
- Add item to cart

## Tech stack
- Java 17
- Maven
- Selenium WebDriver
- JUnit 5
- WebDriverManager

## Project structure

```
java-selenium-framework/
├── pom.xml                     # Maven configuration and dependencies
├── README.md                   # Project documentation
├── .gitignore                  # Git ignore rules
├── .github/
│   └── workflows/
│       └── ci.yml              # GitHub Actions CI pipeline
└── src/
    └── test/
        ├── java/
        │   ├── framework/      # Core test infrastructure
        │   │   ├── BaseTest.java       # Test setup/teardown
        │   │   ├── DriverFactory.java  # WebDriver creation
        │   │   └── Waits.java          # Explicit waits abstraction
        │   ├── pages/          # Page Object Model (POM)
        │   │   ├── LoginPage.java
        │   │   ├── InventoryPage.java
        │   │   └── CartPage.java
        │   └── tests/          # JUnit test cases
        │       ├── LoginTests.java
        │       └── CartTests.java
        └── resources/
            └── config.properties        # Test configuration
```

## How to run locally

### Requirements
- Java 17+
- Maven
- Google Chrome installed

### Run tests
```bash
mvn clean test
```

### Configuration

Edit `src/test/resources/config.properties`:

```
baseUrl=https://www.saucedemo.com/
browser=chrome
headless=true
```

Tip: set `headless=false` to see the browser.

## Notes

- No `Thread.sleep()` is used; synchronization is handled via explicit waits (`framework/Waits`).
- Assertions are kept in tests; Page Objects expose actions/state only.

## License

MIT