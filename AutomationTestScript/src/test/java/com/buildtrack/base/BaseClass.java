package com.buildtrack.base;

import com.buildtrack.hooks.Hooks;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

public class BaseClass {


    public  WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseClass.class);

    public WebDriver SetupBrowserandDriver(){
       return  driver = Hooks.getDriver();
    }
    public void SetupLogger(){

    }

}
