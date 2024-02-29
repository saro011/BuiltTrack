package com.buildtrack.hooks;

import com.buildtrack.steps.TestUserLogin;
import com.buildtrack.utilities.EachPageTimeTaken;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {


    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>();

    @BeforeAll
    public static void setUp() {
      //  WebDriverManager.chromedriver().setup();
       // WebDriverManager.chromedriver().browserVersion("121").setup();
       /* WebDriver driver = new ChromeDriver(); // You can use other drivers here
        driverThreadLocal.set(driver);*/
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @Before
    public void beforeEachScenario() {
        WebDriver driver = new ChromeDriver();// You can use other drivers here

        driverThreadLocal.set(driver);

    }
    @After
    public void afterEachScenario(){
        driverThreadLocal.get().quit();
    }

}
