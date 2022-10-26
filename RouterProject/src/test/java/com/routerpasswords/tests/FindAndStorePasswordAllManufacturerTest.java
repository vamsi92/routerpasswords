package com.routerpasswords.tests;

import com.routerpasswords.pages.RouterPasswordsHomePage;
import com.routerpasswords.pages.RouterPasswordsResultsPage;
import com.routerpasswords.utils.PropertiesFileReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class FindAndStorePasswordAllManufacturerTest extends BaseTest{

    public WebDriver driver;

    @Before
    public void setUp(){
        driver=initDriver();
    }

    @Test
    public void findAndStorePasswordAllManufacturer() throws Exception {

        RouterPasswordsHomePage routerPasswordsHomePage = new RouterPasswordsHomePage(driver);
        routerPasswordsHomePage.selectAllManufacturerAndStoreData();
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
