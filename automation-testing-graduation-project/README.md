# OrangeHRM Automation Testing Graduation Project

Selenium WebDriver + TestNG + Page Object Model, run against the OrangeHRM public demo.

## Stack
- Java 11, Maven
- Selenium 4, TestNG
- Allure reports
- Log4j2 (log file in `logs/test.log`)
- Jackson (test data in `src/test/resources/testdata.json`)

## Structure
```
src/main/java
  pages/   Page Objects
  utils/   DriverManager (ThreadLocal<WebDriver>), ConfigReader, JsonReader, RetryAnalyzer, RetryListener
src/test/java
  base/    BaseTest
  login/   LoginTests (TC1-3)
  pim/     EmployeeSearchTests (TC4-5), AddEmployeeTests (TC6-8)
  admin/   AddUserTests (TC9)
  ui/      UiTests (TC10-11)
src/test/resources
  config.properties, testdata.json, log4j2.xml, allure.properties
testng.xml   parallel="tests", thread-count="3"
allure-report/   generated static report
```

## Test cases
1. Login with valid credentials
2. Login with invalid credentials (data driven)
3. Login with empty fields
4. Search for an employee
5. Search for a non-existing employee
6. Open Add Employee page
7. Add employee with empty First Name
8. Add a new employee end to end
9. Admin > Add User form fields
10. Footer "OrangeHRM, Inc" link
11. Sidebar menu items

## Configuration
Edit `src/test/resources/config.properties` (`base.url`, `browser`, `headless`, `explicit.wait`).

## Run
```
mvn test
allure generate allure-results --clean -o allure-report
allure open allure-report
```
Failed tests are retried up to 2 times. `allure-results` is not committed.
