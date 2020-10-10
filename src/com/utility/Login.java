package com.utility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void AcceptAlert() throws IOException, InterruptedException {
        if (driver.switchTo().alert() != null)//switches only if alert is displayed
        {
            Alert alert = driver.switchTo().alert();
            alert.accept(); // alert.accept();
        }
    }

    public void AlertDismis() throws IOException, InterruptedException {
        if (driver.switchTo().alert() != null) {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        }
    }

    public void LoginWrongDomainName() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("Domain_XPATH"))).sendKeys(Utility.fetchLocator("DefaultShopName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("UcgEmail1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("UcgPassword1_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }

    public void LoginWrongEmail() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("Domain_XPATH"))).sendKeys(Utility.fetchLocator("UcgDomainName1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("DefaultEmail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("UcgPassword1_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }

    public void LoginWrongPassWord() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("Domain_XPATH"))).sendKeys(Utility.fetchLocator("UcgDomainName1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("UcgEmail1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("DefaultPassWord_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }

    public void LoginCorrectDetails() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("Domain_XPATH"))).sendKeys(Utility.fetchLocator("UcgDomainName1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Email_XPATH"))).sendKeys(Utility.fetchLocator("UcgEmail1_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys(Utility.fetchLocator("UcgPassword1_TEXT"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LoginBTN_XPATH"))).click();
    }
}
