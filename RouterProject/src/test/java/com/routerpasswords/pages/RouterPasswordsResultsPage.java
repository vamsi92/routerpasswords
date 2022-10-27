package com.routerpasswords.pages;

import com.routerpasswords.utils.ExcelUtils;
import com.routerpasswords.utils.RouterDefaultPasswords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RouterPasswordsResultsPage extends BasePage{
    WebDriver driver;
    private static final By routerPasswordsHeading = By.xpath("//h1[contains(text(),'Router Default Passwords')]");
    private static final By routerTable = By.className("table");

    public RouterPasswordsResultsPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public void storeRouterDetails() throws Exception {
        waitForJavaScriptToLoad(driver);
        reloadPageIfNotLoaded(driver);
        waitForElementToLoad(driver, Duration.ofSeconds(30),routerPasswordsHeading);
        WebElement tableElement=driver.findElement(routerTable);
        scrollToElement(driver,tableElement);
        List<WebElement> tableRows=tableElement.findElements(By.tagName("tr"));
        List<WebElement> tableColumns=null;
        List<RouterDefaultPasswords> listDetails = new ArrayList<RouterDefaultPasswords>();
        for(int i=1;i<tableRows.size();i++){
            tableColumns=tableRows.get(i).findElements(By.tagName("td"));
            listDetails.add(new RouterDefaultPasswords(tableColumns.get(1).getText(),tableColumns.get(3).getText()));
        }
        ExcelUtils.writeAllDataInSingleFile(listDetails);
    }
}
