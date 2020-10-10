package com.Module;

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

public class FilterSettlementReportUsingDate extends TestBase {
    @Test
    public void FILTER_SETTLEMENT_REPORT_USING_DATE() throws IOException, InterruptedException {
        test = extent.createTest("FILTER SETTLEMENT REPORT USING DATE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);
        TabHandle tabHandle = new TabHandle(driver);
        RandomStuff randomStuff = new RandomStuff();

        login.LoginCorrectDetails();

        driver.findElement(By.xpath(Utility.fetchLocator("UcgBTN_XPATH"))).click();

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CollectionBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("SettlementReport_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(1500);
        //START DATE
        WebElement jjl = driver.findElement(By.xpath(Utility.fetchLocator("From1_XPATH")));
        jjl.clear();
        jjl.sendKeys(Utility.fetchLocator("Date_TEXT"));

        //END DATE
        WebElement jjlK = driver.findElement(By.xpath(Utility.fetchLocator("To1_XPATH")));
        jjlK.clear();
        jjlK.sendKeys(Utility.fetchLocator("EDate_TEXT"));

        WebElement element1v = driver.findElement(By.xpath(Utility.fetchLocator("Display2_XPATH")));
        JavascriptExecutor js1v = (JavascriptExecutor) driver;
        js1v.executeScript("arguments[0].click();", element1v);

        WebElement Elementl = driver.findElement(By.xpath(Utility.fetchLocator("AssertSettlementDetail_XPATH")));
        JavascriptExecutor jskl = (JavascriptExecutor) driver;
        jskl.executeScript("arguments[0].scrollIntoView();", Elementl);

        driver.quit();
        System.out.println("********************FILTER SETTLEMENT REPORT USING DATE********************");
    }
}
