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

public class PopupPage {

    protected    FluentWait<WebDriver> wait;
    protected   FluentWait<WebDriver> shortWait;
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='modal-text']")
    private WebElement Signout_confirmationMesage;
    @FindBy(xpath = "//span[@class='modal-button modal-button-bold']")
    private WebElement signoutOkButton;




    public PopupPage(WebDriver driver) {
        this.driver = driver;
       this. wait = new WaitTime().createFluentWait(driver, Duration.ofMinutes(1), Duration.ofMillis(500));
        this.shortWait = new WaitTime().createFluentWait(driver, Duration.ofSeconds(5), Duration.ofMillis(500));


        PageFactory.initElements(driver, this);
    }


     public void GetSigoutMessage(){
         shortWait.until(ExpectedConditions.visibilityOf(Signout_confirmationMesage)) ;
         shortWait.until(ExpectedConditions.visibilityOf(Signout_confirmationMesage)).isDisplayed() ;
         shortWait.until(ExpectedConditions.textToBePresentInElement(Signout_confirmationMesage,"ARE YOU SURE YOU WANT TO SIGN OUT?")) ;

     }
    public void  Clcik_sigOutPopUP(){
        shortWait.until(ExpectedConditions.visibilityOf(signoutOkButton)).isEnabled();
        shortWait.until(ExpectedConditions.visibilityOf(signoutOkButton)).isDisplayed();
        shortWait.until(ExpectedConditions.elementToBeClickable(signoutOkButton)).click(); ;



    }

}
