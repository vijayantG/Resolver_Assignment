**Selenium WebDriver Script Setup and Execution Guide**

**Overview**

This guide outlines the setup and execution steps for a Selenium WebDriver script using Microsoft Edge in Eclipse.

**Prerequisites**

- Java Development Kit (JDK): Ensure JDK 11 or higher is installed.
- Eclipse IDE: Install Eclipse IDE for Java Developers.
- Microsoft Edge WebDriver: Download `msedgedriver.exe` compatible with your Microsoft Edge version and place it in a `Driver` folder at the package level of your project.

**Setup**

1. Import Project into Eclipse:
   - Open Eclipse IDE.
   - Import your Java project containing `Task.java`.

2. Add Selenium WebDriver Dependencies:
   - Ensure your project includes Selenium WebDriver libraries. If not, add them to your project's build path.

3. Configure Edge WebDriver:
   - Download `msedgedriver.exe` from [Microsoft Edge WebDriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/).
   - Place `msedgedriver.exe` in the `Driver` folder at the package level of your project.

**Code Explanation**

- Task.java: This file contains the Selenium WebDriver script for testing various functionalities of a web application.
  - It initializes EdgeDriver with options to run in private mode (`inPrivate`).
  - Implements multiple test methods (`test1()` to `test6()`) to validate different elements and behaviors on the web page.
  - Uses explicit waits (`WebDriverWait`) for synchronization.
  - Each test method navigates to the `QE-index.html` page and asserts expected behaviors.

**Execution**

1. Run the Script:
   - Right-click on `Task.java` in Eclipse.
   - Select `Run As` > `Java Application`.
   - The script will execute, and results (pass/fail) for each test method will be displayed in the console.

**Troubleshooting**

- Driver Path Issues: Ensure `msedgedriver.exe` path in `getDriverPath()` method (`Task.java`) correctly points to the `Driver` folder relative to your project.
- WebDriver Initialization: Check `System.setProperty("webdriver.edge.driver", driverPath);` in `main()` method (`Task.java`) correctly sets the Edge WebDriver path.
