package org.sample.testsample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

public class Task {

    private static WebDriver driver;

    public static void main(String[] args) {
        // Get the path to the Edge WebDriver from the 'Driver' folder
        String driverPath = getDriverPath();

        // Set the system property to point to the Edge WebDriver
        System.setProperty("webdriver.edge.driver", driverPath);

        // Initialize EdgeDriver with options
        EdgeOptions options = new EdgeOptions();
        options.addArguments("inPrivate"); // To open Edge in private mode
        driver = new EdgeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            test1();
            test2();
            test3();
            test4();
            test5();
            test6();
            System.out.println("All tests passed successfully.");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    private static String getDriverPath() {
        // Assuming 'Driver' folder is at the package level outside src/test/resources
        String currentDir = System.getProperty("user.dir");
        Path driverPath = Paths.get(currentDir, "Driver", "msedgedriver.exe");
        return driverPath.toString();
    }

    private static void navigateToHome() {
        URL resource = Task.class.getClassLoader().getResource("QE-index.html");
        if (resource != null) {
            driver.get(resource.toString());
        } else {
            throw new RuntimeException("QE-index.html file not found in resources");
        }
    }

    private static void test1() {
        System.out.println("Starting test1: Validate email and password input fields and login button.");
        navigateToHome();
        WebElement emailInput = driver.findElement(By.id("inputEmail"));
        WebElement passwordInput = driver.findElement(By.id("inputPassword"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        assert emailInput != null;
        assert passwordInput != null;
        assert loginButton != null;

        emailInput.sendKeys("test@example.com");
        passwordInput.sendKeys("password");
        loginButton.click();
        System.out.println("test1 passed: Email and password input fields and login button are working.");
    }

    private static void test2() {
        System.out.println("Starting test2: Validate list items in test-2-div.");
        navigateToHome();
        List<WebElement> listGroup = driver.findElements(By.cssSelector("#test-2-div .list-group-item"));
        assert listGroup.size() == 3;

        WebElement secondItem = listGroup.get(1);
        assert secondItem.getText().contains("List Item 2");
        WebElement badge = secondItem.findElement(By.className("badge"));
        assert badge.getText().equals("6");
        System.out.println("test2 passed: List items in test-2-div are correct.");
    }

    private static void test3() {
        System.out.println("Starting test3: Validate dropdown menu button.");
        navigateToHome();
        WebElement dropdownButton = driver.findElement(By.id("dropdownMenuButton"));
        assert dropdownButton.getText().equals("Option 1");

        dropdownButton.click();
        WebElement option3 = driver.findElement(By.xpath("//a[text()='Option 3']"));
        option3.click();
        assert dropdownButton.getText().equals("Option 3");
        System.out.println("test3 passed: Dropdown menu button is working.");
    }

    private static void test4() {
        System.out.println("Starting test4: Validate button enable/disable states.");
        navigateToHome();
        List<WebElement> buttons = driver.findElements(By.cssSelector("#test-4-div button"));
        assert buttons.get(0).isEnabled();
        assert !buttons.get(1).isEnabled();
        System.out.println("test4 passed: Button enable/disable states are correct.");
    }

    private static void test5() {
        System.out.println("Starting test5: Validate visibility and clickability of test5-button and test5-alert.");
        navigateToHome();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement testButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test5-button")));
        testButton.click();

        WebElement successMessage = driver.findElement(By.id("test5-alert"));
        assert successMessage.isDisplayed();
        assert !testButton.isEnabled();
        System.out.println("test5 passed: test5-button and test5-alert are working as expected.");
    }

    private static void test6() {
        System.out.println("Starting test6: Validate table cell value in test-6-div.");
        navigateToHome();
        WebElement table = driver.findElement(By.cssSelector("#test-6-div table"));
        WebElement cellValue = table.findElement(By.xpath("//tr[3]/td[3]"));
        assert cellValue.getText().equals("Ventosanzap");
        System.out.println("test6 passed: Table cell value in test-6-div is correct.");
    }
}
