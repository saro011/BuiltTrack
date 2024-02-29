package com.buildtrack.modules;

import com.buildtrack.hooks.Hooks;
import com.buildtrack.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
 import java.security.Provider;

public class loginModule {

    private final WebDriver driver;
    private final LoginPage loginPage;

    loginModule(){


        this.driver = Hooks.getDriver();
        this.loginPage = new LoginPage(this.driver);

    }

    public void Open_ProdLoginPage(){
        try {

            this.loginPage.openProdBuildTrackLoginPage();

        }catch (Exception ignored){

        }

public void
    }
}
