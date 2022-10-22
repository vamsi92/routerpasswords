package com.routerpasswords.tests;

import com.routerpasswords.utils.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver initDriver(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        try {
            PropertiesFileReader propertiesInstance = PropertiesFileReader.getInstance();
            driver.get(propertiesInstance.getProperty("url"));
            driver.manage().window().maximize();
        }catch (Exception e){
            e.printStackTrace();
        }
        return driver;
    }
}
