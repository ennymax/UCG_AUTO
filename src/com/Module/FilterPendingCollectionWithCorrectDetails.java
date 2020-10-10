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
import java.util.concurrent.TimeUnit;

public class FilterPendingCollectionWithCorrectDetails extends TestBase {

    @Test
    public void FILTER_PENDING_COLLECTION_WITH_CORRECT_CREDENTIALS() throws IOException, InterruptedException {
        test = extent.createTest("FILTER PENDING COLLECTION WITH CORRECT CREDENTIALS");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
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

        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("PendingCollection_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(3000);
        WebElement ele11p = driver.findElement(By.xpath(Utility.fetchLocator("DropDown_XPATH")));
        Select sel1p = new Select(ele11p);
        sel1p.selectByVisibleText("INVOICE NO");

        WebElement jjla = driver.findElement(By.xpath(Utility.fetchLocator("SearchCollectionInputBox_XPATH")));
        jjla.clear();
        jjla.sendKeys(Utility.fetchLocator("InvoicenUMBER_TEXT"));

        WebElement elementPPO = driver.findElement(By.xpath(Utility.fetchLocator("jj_XPATH")));
        JavascriptExecutor jsPPO = (JavascriptExecutor) driver;
        jsPPO.executeScript("arguments[0].click();", elementPPO);

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertOluwaseun_XPATH"))).size() != 0) {
            test.log(Status.PASS, "AssertSearchCollection_XPATH");
        } else {
            test.log(Status.FAIL, "AssertSearchCollection_XPATH");
        }

        WebElement Elementlbb = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionPage_XPATH")));
        JavascriptExecutor jsklbb = (JavascriptExecutor) driver;
        jsklbb.executeScript("arguments[0].scrollIntoView();", Elementlbb);

        driver.quit();
        System.out.println("********************FILTER PENDING COLLECTION WITH CORRECT CRENDENTIALS********************");
    }
}
