package com.buildtrack.pages;

import com.buildtrack.utilities.WaitTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class DashBoardPage {
    protected   Wait<WebDriver> Fwait;
    protected    FluentWait<WebDriver> wait;
    protected   FluentWait<WebDriver> shortWait;
    private WebDriver driver;

    @FindBy(xpath = "//p[@class='page-title bt-mt-0']")
    private WebElement DashboardGeader_TXT;





    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
       this. wait = new WaitTime().createFluentWait(driver, Duration.ofMinutes(1), Duration.ofMillis(500));
        this.shortWait = new WaitTime().createFluentWait(driver, Duration.ofSeconds(5), Duration.ofMillis(500));


        PageFactory.initElements(driver, this);
    }


    // wait for loader to Disappear- "header loader with domain logo"
    public String DashboardHeader(){
        shortWait.until(ExpectedConditions.visibilityOf(DashboardGeader_TXT)) ;
        shortWait.until(ExpectedConditions.textToBePresentInElement(DashboardGeader_TXT,"DASHBOARD")) ;
        String DBText=DashboardGeader_TXT.getText();

        return DBText;
    }

}
