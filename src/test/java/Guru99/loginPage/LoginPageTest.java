package Guru99.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import Utils.BrowserDriver;


public class LoginPageTest {

    final int TIMEOUT_30 = 30;
    WebDriver driver = BrowserDriver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_30);

    @BeforeSuite
    public void testSetup() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
    }

    @Test
    public void loginToBankPage() {
        driver.get("http://demo.guru99.com/V1/index.php");
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr326410");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("rAzUnan");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        wait.until(ExpectedConditions.titleContains("HomePage"));
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, "GTPL Bank Manager HomePage");

    }

    @AfterSuite
    public void closeBrowser() {

        driver.close();

    }
}
