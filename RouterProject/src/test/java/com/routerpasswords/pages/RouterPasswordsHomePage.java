package com.routerpasswords.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class RouterPasswordsHomePage extends BasePage {
    WebDriver driver;

    private static final By routerManufacturerElement = By.name("router");
    private static final By findPasswordBtn = By.xpath("//button[contains(text(),'Find Password')]");

    public RouterPasswordsHomePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public void selectManufacturerAndFindPassword(String manufacturer){
        waitForJavaScriptToLoad(driver);
        waitForElementToLoad(driver, Duration.ofSeconds(30),routerManufacturerElement);
        WebElement selectElement = driver.findElement(routerManufacturerElement);
        Select select=new Select(selectElement);
        select.selectByValue(manufacturer);
        driver.findElement(findPasswordBtn).click();
    }
}
