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

public class DownloadAllCollections extends TestBase {

    @Test
    public void DOWNLOAD_ALL_COLLECTION() throws IOException, InterruptedException {
        test = extent.createTest("DOWNLOAD ALL COLLECTION");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        BrokenLink brokenLink = new BrokenLink(driver);
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

        screenShot.ScreenShot();

        driver.findElement(By.xpath(Utility.fetchLocator("UcgBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CollectionBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionBTN_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        screenShot.ScreenShot();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AllCollectionPage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "All Collection Page Displayed");
        } else {
            test.log(Status.FAIL, "All Collection Page not Displayed");
        }

        Thread.sleep(2000);
        WebElement element13 = driver.findElement(By.xpath(Utility.fetchLocator("DownloadCollectionBTN_XPATH")));
        JavascriptExecutor js13 = (JavascriptExecutor) driver;
        js13.executeScript("arguments[0].click();", element13);

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSentEmail_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Report Sent To mail was Displayed");
        } else {
            test.log(Status.FAIL, "Report Sent Mail was not Displayed");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSentEmail_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Download was successful");
        } else {
            test.log(Status.FAIL, "Download was Failed");
        }

        Thread.sleep(3000);
        driver.quit();
        System.out.println("********************DOWNLOAD ALL COLLECTION********************");
    }
}
