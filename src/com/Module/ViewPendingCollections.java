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
import java.util.concurrent.TimeUnit;

public class ViewPendingCollections extends TestBase {
    @Test
    public void VIEW_PENDING_COLLECTION() throws IOException, InterruptedException {
        test = extent.createTest("VIEW PENDING COLLECTION");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
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

        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("PendingCollection_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(3000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("PendingCollectionlist_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Pending collection Page was Displayed");
        } else {
            test.log(Status.FAIL, "Pending Collection Page wasn't Displayed");
        }

        WebElement Elementlb = driver.findElement(By.xpath(Utility.fetchLocator("PendingCollectionlist_XPATH")));
        JavascriptExecutor jsklb = (JavascriptExecutor) driver;
        jsklb.executeScript("arguments[0].scrollIntoView();", Elementlb);

        driver.quit();
        System.out.println("********************VIEW PENDING COLLECTION********************");
    }
}
