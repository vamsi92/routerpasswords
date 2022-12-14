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
        Thread.sleep(2000);//added this to make the data extraction much efficient
        WebElement tableElement=driver.findElement(routerTable);
        scrollToElement(driver,tableElement);
        List<WebElement> tableRows=tableElement.findElements(By.tagName("tr"));
        List<WebElement> tableColumns=null;
        List<RouterDefaultPasswords> listDetails = new ArrayList<RouterDefaultPasswords>();
        for(int i=1;i<tableRows.size();i++){
            Thread.sleep(1000);//added this to make the data extraction much efficient
            tableColumns=tableRows.get(i).findElements(By.tagName("td"));
            listDetails.add(new RouterDefaultPasswords(tableColumns.get(0).getText(),tableColumns.get(1).getText(),tableColumns.get(2).getText(),tableColumns.get(3).getText(),tableColumns.get(4).getText()));
        }
        ExcelUtils.writeAllDataInSingleFile(listDetails);
    }

    public void iterateAndStoreData(List<String> manufacturers) throws Exception {

        ExcelUtils.createManufacturerList(manufacturers);
        List<String> urls=ExcelUtils.getManufacturerListForIncompleteStatus();
        for(String url:urls){
            driver.get(url);
            storeRouterDetails();
            ExcelUtils.updateManufacturerList(url);
        }
    }
}
