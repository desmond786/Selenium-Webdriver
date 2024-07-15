package SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    ConfigReader config;
    WebDriverWait wait;

    SoftAssert assertion;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        config = new ConfigReader();
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        assertion =new SoftAssert();

    }
    @Test(priority = 2)
    public void adminboard(){
        String ActualText = driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).getText();
        String ExpectedText = driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")).getText();
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ExpectedText)));*/
        assertion.assertNotEquals(ActualText,ExpectedText,"Test case failed");


    }

    @Test(priority = 1)
    public void verifyLogin() {
        driver.get(config.getUrl());

        // Enter Username
        driver.findElement(By.name("uid")).sendKeys(config.getUsername());

        // Enter Password
        driver.findElement(By.name("password")).sendKeys(config.getPassword());

        // Click Login
        driver.findElement(By.name("btnLogin")).click();


    }



    @AfterClass
    public void teardown() {
        driver.quit();
    }
}


