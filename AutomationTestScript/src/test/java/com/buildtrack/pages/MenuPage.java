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
import java.util.List;

public class MenuPage {
    protected Wait<WebDriver> Fwait;
    protected FluentWait<WebDriver> wait;
    protected   FluentWait<WebDriver> shortWait;
    private WebDriver driver;

    @FindBy(xpath = "//i[@class='icon-menu']")
    private WebElement menuIcon;
    @FindBy(xpath = "//ul[@class='left-main-menu']//li")
    private  List<WebElement> leftMenuOptionsList;

    @FindBy(xpath = "//div[contains(text(),'ACCOUNT')]")
    private  WebElement AccountOption;
    @FindBy(xpath = "//div[contains(text(),'LOGOUT')]")
    private  WebElement LogOutOption;



    public MenuPage(WebDriver driver) {
        this.driver = driver;
        this. wait = new WaitTime().createFluentWait(driver, Duration.ofMinutes(1), Duration.ofMillis(500));
        this.shortWait = new WaitTime().createFluentWait(driver, Duration.ofSeconds(5), Duration.ofMillis(500));


        PageFactory.initElements(driver, this);
    }


    // wait for loader to Disappear- "header loader with domain logo"
    public void  Click_MenuIcon(){
        shortWait.until(ExpectedConditions.visibilityOf(menuIcon)).isDisplayed() ;
        shortWait.until(ExpectedConditions.visibilityOf(menuIcon)).isEnabled() ;
        shortWait.until(ExpectedConditions.elementToBeClickable(menuIcon)).click();
    }

    public List<WebElement> CheckLeftMenuMenuOptions()
    {

        List<WebElement> elements = shortWait.until(ExpectedConditions.visibilityOfAllElements(leftMenuOptionsList));

        return elements;
    }

    public void click_AccountsOptionsFromMenu(){
        shortWait.until(ExpectedConditions.visibilityOf(AccountOption)).isDisplayed() ;
        shortWait.until(ExpectedConditions.elementToBeClickable(AccountOption)).click();

    }
    public void Click_LogoutOptionFromMenu(){
        shortWait.until(ExpectedConditions.visibilityOf(LogOutOption)).isDisplayed() ;
        shortWait.until(ExpectedConditions.elementToBeClickable(LogOutOption)).click();
    }

}
