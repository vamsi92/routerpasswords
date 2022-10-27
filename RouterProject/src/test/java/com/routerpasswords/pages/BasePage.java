package com.routerpasswords.pages;

import com.routerpasswords.utils.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToElement(WebDriver driver, WebElement element) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForElementToLoad(WebDriver driver, Duration timeout, By element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void waitForJavaScriptToLoad(WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        boolean readyState=js.executeScript("return document.readyState").equals("complete");
        int count=0;
        while (!readyState){
            count++;
            if(count==300){
                break;
            }
        }
    }

    public void reloadPageIfNotLoaded(WebDriver driver) throws Exception {
        PropertiesFileReader propertiesInstance = PropertiesFileReader.getInstance();
        String url=propertiesInstance.getProperty("url");
        String updatedUrl=url.replace("https://","");
        int maxCount=10;
        do{
            driver.navigate().refresh();
            maxCount--;
        }while (driver.getTitle().contains(updatedUrl) && maxCount>0);
    }

    public void waitForElementStaleness(WebDriver driver, Duration timeout, By element) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(element))));
    }
}
