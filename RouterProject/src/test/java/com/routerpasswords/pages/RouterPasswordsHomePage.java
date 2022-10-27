package com.routerpasswords.pages;

import com.routerpasswords.utils.PropertiesFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class RouterPasswordsHomePage extends BasePage {
    WebDriver driver;

    private static final By routerManufacturerElement = By.xpath("//select[@class='form-control' and @name='router']");
    private static final By findPasswordBtn = By.xpath("//button[contains(text(),'Find Password')]");
    public RouterPasswordsHomePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public void selectAllManufacturerAndStoreData() throws Exception {
        PropertiesFileReader propertiesInstance = PropertiesFileReader.getInstance();
        String url=propertiesInstance.getProperty("url");

        waitForJavaScriptToLoad(driver);
        waitForElementToLoad(driver, Duration.ofSeconds(30),routerManufacturerElement);
        WebElement selectElement = driver.findElement(routerManufacturerElement);
        Select select=new Select(selectElement);
        List<WebElement> options=select.getOptions();
        List<String> manufacturers=new ArrayList<String>();
        for(WebElement option:options){
            manufacturers.add(option.getText());
        }
        for(String option:manufacturers){
            driver.navigate().refresh();
            waitForJavaScriptToLoad(driver);
            waitForElementToLoad(driver, Duration.ofSeconds(30),routerManufacturerElement);
            WebElement selectElementNew = driver.findElement(routerManufacturerElement);
            Select selectNew=new Select(selectElementNew);
            selectNew.selectByValue(option);
            driver.findElement(findPasswordBtn).click();
            reloadPageIfNotLoaded(driver);
            RouterPasswordsResultsPage resultsPage=new RouterPasswordsResultsPage(driver);
            resultsPage.storeRouterDetails();
            driver.get(url);
            waitForJavaScriptToLoad(driver);
            waitForElementToLoad(driver, Duration.ofSeconds(30),routerManufacturerElement);
            reloadPageIfNotLoaded(driver);
        }
    }
}
