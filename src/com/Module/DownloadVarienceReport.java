package com.Module;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class DownloadVarienceReport extends TestBase {

    @Test
    public void DOWNLOAD_VARIANCE_REPORT() throws IOException, InterruptedException {
        test = extent.createTest("DOWNLOAD VARIANCE REPORT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomStuff randomStuff = new RandomStuff();

        login.LoginCorrectDetails();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("UcgBTN_XPATH"))).click();

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CollectionBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        screenShot.ScreenShot();

        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("VarianceReport_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(2000);
        screenShot.ScreenShot();

        WebElement element13 = driver.findElement(By.xpath(Utility.fetchLocator("Downl_XPATH")));
        JavascriptExecutor js13 = (JavascriptExecutor) driver;
        js13.executeScript("arguments[0].click();", element13);

        Thread.sleep(9000);
        screenShot.ScreenShot();

        driver.quit();
        System.out.println("*******************DOWNLOAD VARIANCE REPORT********************");
    }
}
