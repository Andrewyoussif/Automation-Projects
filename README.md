# The Internet Website – Selenium Automation Testing Framework

A Java-based UI test automation project built with **Selenium WebDriver**, **TestNG**, and the **Page Object Model (POM)**. The framework automates a range of interactive features on [The Internet](https://the-internet.herokuapp.com/) and demonstrates practical browser automation, reusable test utilities, and test reporting with Allure.

> **Project focus:** building maintainable UI automation tests for common web application behaviors, including authentication, dynamic content, browser alerts, frames, windows, keyboard interactions, and file uploads.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 26 | Programming language (configured in `pom.xml`) |
| Selenium WebDriver 4.49.0 | Browser automation and UI interactions |
| TestNG 7.12.0 | Test execution, lifecycle annotations, and assertions |
| Maven | Dependency and build management |
| Allure TestNG 3.0.0 | Test execution reporting and metadata |
| Chrome / ChromeDriver | Browser used by the test setup |

## Framework Design

The project follows the **Page Object Model (POM)** to keep page-specific locators and actions separate from test scenarios.

- **`pages/`** – Page classes that represent application pages and expose actions or information used by tests.
- **`utils/`** – Reusable Selenium helper methods and browser navigation/window management.
- **`src/test/java/`** – Test classes grouped by the feature under test.
- **`src/test/resources/`** – Test-related configuration, including Allure properties.

### Reusable utilities

- `SelUtils` centralizes common Selenium operations such as clicking elements, entering text, selecting dropdown options, handling JavaScript alerts, switching frames, uploading files, and scrolling to elements.
- `WindowManager` provides browser navigation actions and switching between windows by title.
- `BaseTests` initializes the Chrome browser, navigates to the application home page before each test, and closes the browser after the test class.

## Automated Test Coverage

The suite contains **20 TestNG test methods** covering the following areas:

| Feature | Coverage |
|---|---|
| Authentication | Valid login and successful navigation to the secure area |
| JavaScript Alerts | Alert text, accepting and dismissing confirmation dialogs, and submitting prompt text |
| Dropdowns | Selecting an option and verifying the selected value |
| Entry Ad | Closing the modal and checking the page header |
| Frames | Reading content from nested left and bottom frames |
| Mouse Hover | Hovering over a figure and checking its caption, name, and profile link |
| Inputs | Verifying the Inputs page header |
| JavaScript Executor & Actions | Scrolling to a table using JavaScript Executor and the Actions class |
| Keyboard Actions | Typing text, using Shift, and pressing Backspace |
| Browser Navigation | Back, forward, refresh, and navigating to another URL |
| Multiple Windows | Switching to a newly opened window and verifying its heading |
| File Upload | Uploading a file and verifying the uploaded filename |
| Dynamic Loading & Waits | Handling dynamically loaded content in both examples and verifying the result |

## Project Structure

```text
TheInternetWebSiteProject/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   └── java/
    │       ├── pages/
    │       │   ├── HomePage.java
    │       │   ├── LoginPage.java
    │       │   ├── SecureAreaPage.java
    │       │   ├── DropDownPage.java
    │       │   ├── HoversPage.java
    │       │   ├── JavaScriptAlertsPage.java
    │       │   ├── DynamicLoadingPage.java
    │       │   └── ...
    │       └── utils/
    │           ├── SelUtils.java
    │           └── WindowManager.java
    └── test/
        ├── java/
        │   ├── base/
        │   │   └── BaseTests.java
        │   ├── alerts/
        │   ├── dropDown/
        │   ├── entryAd/
        │   ├── frames/
        │   ├── hovers/
        │   ├── inputs/
        │   ├── js/
        │   ├── keys/
        │   ├── login/
        │   ├── navigate/
        │   ├── uploadFiles/
        │   └── waits/
        └── resources/
            └── allure.properties
```

## Prerequisites

Before running the tests, make sure you have:

1. **JDK 26** installed and configured. The Maven compiler source and target are set to `26` in `pom.xml`.
2. **Maven** installed and available from your terminal.
3. **Google Chrome** installed.
4. A working internet connection to access the target website and resolve Maven dependencies.

Selenium 4.49.0 uses Selenium Manager to help manage browser drivers. If automatic driver management does not work in your environment, configure a compatible ChromeDriver.

## Run the Tests

Clone the repository:

```bash
git clone <YOUR_REPOSITORY_URL>
cd TheInternetWebSiteProject
```

Run the complete TestNG suite through Maven:

```bash
mvn clean test
```

Maven Surefire runs the tests and the configured Allure results directory is:

```text
target/allure-results
```

## Allure Report

After test execution, generate and open an Allure report using the Allure command-line tool:

```bash
allure serve target/allure-results
```

Alternatively, generate a static report:

```bash
allure generate target/allure-results --clean -o target/allure-report
allure open target/allure-report
```

Make sure the Allure command-line tool is installed and available on your system before running these commands.

## Notes

- The tests launch **Chrome** from the shared `BaseTests` setup.
- The file-upload test currently uses a local Windows file path. Update the `path` and `fileName` values in `UploadFilesTests.java` to point to a file that exists on your machine before running that test.
- The project targets the live demo website. Test results may be affected by website availability or changes to its content.

## What This Project Demonstrates

- Applying the Page Object Model to organize UI automation code.
- Creating reusable Selenium helper methods to reduce duplicated actions.
- Automating common web UI components and browser behaviors.
- Working with dynamic elements, waits, alerts, frames, and multiple windows.
- Using TestNG annotations, assertions, and test severity metadata.
- Integrating Allure to produce readable test execution reports.

---

**Author:** Andrew Youssif Farid  
**Project:** The Internet Website – Selenium Automation Testing Framework
