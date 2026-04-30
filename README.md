# Recap_Project — Password Validator

[![CI](https://github.com/ObscuraStudio/Recap_Project/actions/workflows/ci.yml/badge.svg)](https://github.com/ObscuraStudio/Recap_Project/actions)

A simple password validator base written in Java. Validates passwords
against a configurable strength policy.

## Password Policy

Must-Have Criteria:

- minimum of eight characters
- minimum of one number (0–9) (ASCII)
- at least one uppercase character and one lowercase character
- not in a list of weak/often used passwords
- contains at least one special character (ASCII)

## Build, Run & Tests

**Requirements:** Java 25+, Maven 3.8+

**Run tests locally:** mvn clean verify

**Build artifact:** mvn package

Produces a JAR in `target/*.jar`.

## Usage

After building, run from the project root:

​```
java -jar target/Recap_Project-1.0-SNAPSHOT.jar your-password-here
​```

Or interactively (no argument):

​```
java -jar target/Recap_Project-1.0-SNAPSHOT.jar
​```

## Project Structure

src/main/java/→ Main.java (validator logic)

src/test/java/→ MainTest.java (JUnit 5 tests)

## CI

GitHub Actions runs `mvn clean verify` on every push and pull request
to `master`. See the badge above for current build status.

## Bonus Scope

- Implemented special characters (ASCII)
- Implemented a customizable password generator & strength policy
- Implemented password input with validation check
- implemented error handling for invalid input (e.g., null or wrong passwords)
- Implemented CLI integration for interactive password validation
