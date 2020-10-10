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

public class SearchPendingCollectionsWithInCorrectCredentials extends TestBase {

    @Test
    public void SEARCH_PENDING_INCOLLECTION_WITH_CORRECT_CREDENTIALS() throws IOException, InterruptedException {
        test = extent.createTest("SEARCH PENDING COLLECTION WITH INCORRECT CREDENTIALS");
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

        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("PendingCollection_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);


        WebElement jjl = driver.findElement(By.xpath(Utility.fetchLocator("SearchCollectionInputBox_XPATH")));
        jjl.clear();
        jjl.sendKeys(Utility.fetchLocator("WInvoiceNumber_TEXT"));

        Thread.sleep(1000);
        screenShot.ScreenShot();

        WebElement elementPP = driver.findElement(By.xpath(Utility.fetchLocator("jj_XPATH")));
        JavascriptExecutor jsPP = (JavascriptExecutor) driver;
        jsPP.executeScript("arguments[0].click();", elementPP);

        Thread.sleep(1000);
        screenShot.ScreenShot();

        WebElement Elementl = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionPage_XPATH")));
        JavascriptExecutor jskl = (JavascriptExecutor) driver;
        jskl.executeScript("arguments[0].scrollIntoView();", Elementl);

        Thread.sleep(1000);
        screenShot.ScreenShot();

        //SEARCH WITH INVOICE NUMBER
        WebElement ele11p = driver.findElement(By.xpath(Utility.fetchLocator("DropDown_XPATH")));
        Select sel1p = new Select(ele11p);
        sel1p.selectByVisibleText("INVOICE NO");

        WebElement jjla = driver.findElement(By.xpath(Utility.fetchLocator("SearchCollectionInputBox_XPATH")));
        jjla.clear();
        jjla.sendKeys(Utility.fetchLocator("InvoicenUMBER_TEXT"));

        Thread.sleep(1000);
        screenShot.ScreenShot();
        WebElement elementPPO = driver.findElement(By.xpath(Utility.fetchLocator("jj_XPATH")));
        JavascriptExecutor jsPPO = (JavascriptExecutor) driver;
        jsPPO.executeScript("arguments[0].click();", elementPPO);

        Thread.sleep(1000);
        screenShot.ScreenShot();
        WebElement Elementlb = driver.findElement(By.xpath(Utility.fetchLocator("AllCollectionPage_XPATH")));
        JavascriptExecutor jsklb = (JavascriptExecutor) driver;
        jsklb.executeScript("arguments[0].scrollIntoView();", Elementlb);

        Thread.sleep(3000);
        screenShot.ScreenShotFullPage();

        driver.quit();
        System.out.println("*******************SEARCH PENDING COLLECTION WITH INCORRECT CREDENTIALS********************");
    }
}
