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

public class AccountPage {
    protected   Wait<WebDriver> Fwait;
    protected    FluentWait<WebDriver> wait;
    protected   FluentWait<WebDriver> shortWait;
    private WebDriver driver;

    @FindBy(xpath = "//p[@class='page-title bt-mt-0']")
    private WebElement AccountHeeader_TXT;

    @FindBy(xpath = "//span[@class='bt-form-element bt-hide-edit-mode bt-txt-break']")
    private WebElement getEmailLabelTxt;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement getUsernameLabelTxt;





    public AccountPage(WebDriver driver) {
        this.driver = driver;
       this. wait = new WaitTime().createFluentWait(driver, Duration.ofMinutes(1), Duration.ofMillis(500));
        this.shortWait = new WaitTime().createFluentWait(driver, Duration.ofSeconds(5), Duration.ofMillis(500));


        PageFactory.initElements(driver, this);
    }


    // wait for loader to Disappear- "header loader with domain logo"
    public String AccountPageHeader(){
        shortWait.until(ExpectedConditions.visibilityOf(AccountHeeader_TXT)) ;
        shortWait.until(ExpectedConditions.textToBePresentInElement(AccountHeeader_TXT,"ACCOUNT")) ;
        String ACText=AccountHeeader_TXT.getText();

        return ACText;
    }
    public void GetLoggedInEmailAddressFromAccountPage(String Emailid){
        shortWait.until(ExpectedConditions.visibilityOf(getEmailLabelTxt)) ;
        shortWait.until(ExpectedConditions.textToBePresentInElement(getEmailLabelTxt,Emailid)) ;

    }
    public void GetLoggedInUsernameFromAccountPage(String username){
        shortWait.until(ExpectedConditions.visibilityOf(getUsernameLabelTxt)) ;
        shortWait.until(ExpectedConditions.textToBePresentInElement(getEmailLabelTxt,username)) ;
    }

}
