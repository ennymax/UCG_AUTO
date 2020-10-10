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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;

public class FilterAllCollectionUsingStartDateAndEndDate extends TestBase {

    @Test
    public void FILTER_ALL_COLLECTION_USING_START_DATE_AND_END_DATE() throws IOException, InterruptedException {
        test = extent.createTest("FILTER ALL COLLECTION USING START DATE AND END DATE");
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

        driver.findElement(By.xpath(Utility.fetchLocator("UcgBTN_XPATH"))).click();

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CollectionBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        screenShot.ScreenShot();

        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionBTN_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        if (driver.findElements(By.xpath(Utility.fetchLocator("AllCollectionPage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "All Collection Page Displayed");
        } else {
            test.log(Status.FAIL, "All Collection Page not Displayed");
        }

        Thread.sleep(2000);
        screenShot.ScreenShot();

        WebElement ele11p = driver.findElement(By.xpath(Utility.fetchLocator("Privders_XPATH")));
        Select sel1p = new Select(ele11p);
        sel1p.selectByVisibleText("CASH");

        //START DATE
        WebElement jjl = driver.findElement(By.xpath(Utility.fetchLocator("UCGStartDate_XPATH")));
        jjl.clear();
        jjl.sendKeys(Utility.fetchLocator("Date_TEXT"));

        //END DATE
        WebElement jjlK = driver.findElement(By.xpath(Utility.fetchLocator("UCGEndDate_XPATH")));
        jjlK.clear();
        jjlK.sendKeys(Utility.fetchLocator("EDate_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("DisplayBTN_XPATH"))).click();

        Thread.sleep(2000);
        screenShot.ScreenShot();

        WebElement Elementl = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionPage_XPATH")));
        JavascriptExecutor jskl = (JavascriptExecutor) driver;
        jskl.executeScript("arguments[0].scrollIntoView();", Elementl);

        Thread.sleep(3000);
        screenShot.ScreenShot();

        driver.quit();
        System.out.println("********************FILTER ALL COLLECTION USING START DATE AND END DATE********************");
    }
}
