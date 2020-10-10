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

public class SearchSettlementReportUsingCorrectCredential extends TestBase {

    @Test
    public void SEARCH_SETTLEMENT_REPORT_WITH_INCORRECT_CREDENTIALS() throws IOException, InterruptedException {
        test = extent.createTest("SEARCH SETTLEMENT REPORT WITH INCORRECT CREDENTIALS");
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

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UcgBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CollectionBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("SettlementReport_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(2000);
        WebElement jjl = driver.findElement(By.xpath(Utility.fetchLocator("SearchSettlement_XPATH")));
        jjl.clear();
        jjl.sendKeys(Utility.fetchLocator("TransactionID_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchBTN1_XPATH"))).click();

        Thread.sleep(2000);
        WebElement jjla = driver.findElement(By.xpath(Utility.fetchLocator("SearchSettlement_XPATH")));
        jjla.clear();
        jjla.sendKeys(Utility.fetchLocator("InvoicenUMBER_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchBTN1_XPATH"))).click();

        driver.quit();
        System.out.println("********************SEARCH SETTLEMENT REPORT WITH CORRECT CREDENTIALS********************");
    }
}
