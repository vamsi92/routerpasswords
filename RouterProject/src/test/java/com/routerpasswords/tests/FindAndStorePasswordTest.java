package com.routerpasswords.tests;

import com.routerpasswords.pages.RouterPasswordsHomePage;
import com.routerpasswords.pages.RouterPasswordsResultsPage;
import com.routerpasswords.utils.PropertiesFileReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class FindAndStorePasswordTest extends BaseTest{

    public WebDriver driver;

    @Before
    public void setUp(){
        driver=initDriver();
    }

    @Test
    public void findAndStorePassword() throws Exception {

        PropertiesFileReader propertiesInstance = PropertiesFileReader.getInstance();
        String manufacturer=propertiesInstance.getProperty("manufacturer");
        RouterPasswordsHomePage routerPasswordsHomePage = new RouterPasswordsHomePage(driver);
        routerPasswordsHomePage.selectManufacturerAndFindPassword(manufacturer);
        RouterPasswordsResultsPage resultsPage=new RouterPasswordsResultsPage(driver);
        resultsPage.storeRouterDetails();
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
