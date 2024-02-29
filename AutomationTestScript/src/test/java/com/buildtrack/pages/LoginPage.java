package com.buildtrack.pages;

import com.buildtrack.utilities.WaitTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    protected   Wait<WebDriver> Fwait;
    protected    FluentWait<WebDriver> wait;
    protected   FluentWait<WebDriver> shortWait;
    protected   FluentWait<WebDriver> shortWait5sec;
    private WebDriver driver;

    @FindBy(id = "useremail")
    private WebElement usernameField;

    @FindBy(id = "userpassword")
    private WebElement passwordField;

    @FindBy(xpath = "//button[normalize-space()='Login' and @class='btn btn-primary btn-block']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[normalize-space()='Login' and @class='btn btn-primary btn-block disabled']")
    private WebElement disableLoginButton;


    @FindBy(xpath = "//div[@class='pg-loading-wrapper']//h1")
    private WebElement logoLoader;

    @FindBy(xpath = "//div[@class='modal modal-no-buttons modal-preloader modal-in']")
    private WebElement pleaseWaitTextPreLoader; //end laoder after login

    @FindBy(xpath = "//span[@id='msgError']")
    private WebElement errorMessage;
    @FindBy(xpath = "//small[normalize-space()='The Password is required']")
    private WebElement PassworderrorMessage;
    @FindBy(xpath = "//small[normalize-space()='The email/username is required']")
    private WebElement UserNameErrorMessage;

    @FindBy(xpath = "//img[@src='control_newui/modules/hospitality/img/landing-page/btlogo.png']")
    private WebElement BuildTrackLoginPageLogo;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
       this. wait = new WaitTime().createFluentWait(driver, Duration.ofMinutes(1), Duration.ofMillis(500));
        this.shortWait = new WaitTime().createFluentWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        this.shortWait5sec = new WaitTime().createFluentWait(driver, Duration.ofSeconds(5), Duration.ofMillis(200));

        PageFactory.initElements(driver, this);
    }
public void checkBuildTrackURL(){
    wait.until(ExpectedConditions.urlContains("https://ezcentral.buildtrack.in/login.html"));
    String ActualUrl=driver.getCurrentUrl();
    Assert.assertEquals(ActualUrl,"https://ezcentral.buildtrack.in/login.html");

}
    public   void openProdBuildTrackLoginPage()
    {
        driver.get("https://ezcentral.buildtrack.in/login.html");


    }
    public void CheckLogoInLoginPage(){
        shortWait.until(ExpectedConditions.visibilityOf(BuildTrackLoginPageLogo));
    }

    public void enterUsername(String username)
    {
        shortWait.until(ExpectedConditions.visibilityOf(usernameField)).isEnabled();
        shortWait.until(ExpectedConditions.visibilityOf(usernameField)).click();
        shortWait.until(ExpectedConditions.visibilityOf(usernameField)). sendKeys(username);

    }

    public void enterPassword(String password) {
        shortWait.until(ExpectedConditions.visibilityOf(usernameField)).isEnabled();
        shortWait.until(ExpectedConditions.visibilityOf(passwordField)).click();
         shortWait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);

    }

    public void clickLoginButton() {
        shortWait.until(ExpectedConditions.visibilityOf(loginButton)).isEnabled();
        shortWait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();


    }

    //wait for loader to disappear "LOADING. PLEASE WAIT "
    public void isLogin2ndLoaderDisappear(){

        shortWait.until(ExpectedConditions.visibilityOf(pleaseWaitTextPreLoader)) ;

        shortWait.until(ExpectedConditions.invisibilityOf(pleaseWaitTextPreLoader)) ;

    }
    // wait for loader to Disappear- "header loader with domain logo"
    public void isLogoLoaderDisappear(){
        shortWait.until(ExpectedConditions.visibilityOf(logoLoader)) ;
        shortWait.until(ExpectedConditions.invisibilityOf(logoLoader)) ;


    }
    public boolean isEnableLoginButton(){
        return  shortWait.until(ExpectedConditions.visibilityOf(disableLoginButton)).isEnabled();
    }
    public boolean isDisplayLogInButton() {
        // Example: Check if a specific element exists on the page after login

        return  shortWait.until(ExpectedConditions.visibilityOf(disableLoginButton)).isDisplayed();
    }
public String isPasswordErrorMessageDisplayed(){

    shortWait.until(ExpectedConditions.visibilityOf(PassworderrorMessage)).isDisplayed();

    return shortWait.until(ExpectedConditions.visibilityOf(PassworderrorMessage)).getText();
}
    public String isUserNameErrorMessageDisplayed(){
        shortWait.until(ExpectedConditions.visibilityOf( UserNameErrorMessage)).isDisplayed();

        return shortWait.until(ExpectedConditions.visibilityOf(UserNameErrorMessage)).getText();
    }

    public String getErrorMessage() {
        shortWait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();

        return errorMessage.getText();
    }
}
