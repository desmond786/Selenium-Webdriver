package Framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void readExcel() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        try {
            // Set the Excel file and sheet
            ExcelUtils.setExcelFile("Resources/Sheet_1.xlsx", "Sheet1");

            // Read test data
            String testCaseID = ExcelUtils.getCellData(1, 0);
            String testScenario = ExcelUtils.getCellData(1, 1);
            String testStep = ExcelUtils.getCellData(1, 2);
            String testData = ExcelUtils.getCellData(1, 3);
            String expectedOutput = ExcelUtils.getCellData(1, 4);

            // Extract username and password from the test data
            String[] credentials = testData.split("\n");
            String username = credentials[0].split("=")[1].trim();
            String password = credentials[1].split("=")[1].trim();

            // Navigate to the login page and perform login
            driver.get("https://www.demo.guru99.com/V4/index.php");
            driver.manage().window().maximize();
            driver.findElement(By.name("uid")).sendKeys(username);
            driver.findElement(By.name("password")).sendKeys(password);
            driver.findElement(By.name("btnLogin")).click();

            // Validate the expected output (This is just an example, you need to replace with actual validation logic)
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedOutput)) {
                System.out.println("Test Passed");
            } else {
                System.out.println("Test Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}




