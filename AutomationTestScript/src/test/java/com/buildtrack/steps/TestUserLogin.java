package com.buildtrack.steps;

import com.buildtrack.hooks.Hooks;
import com.buildtrack.pages.*;
import com.buildtrack.utilities.EachPageTimeTaken;
import com.buildtrack.utilities.FinalResult;
import com.buildtrack.utilities.WaitTime;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TestUserLogin {
    private DashBoardPage dashBoardPage;
    private MenuPage MenuPage;
    private AccountPage accountPage;
    private LoginPage loginPage;
    private PopupPage popupPage;
    public FinalResult fResult;
    public  EachPageTimeTaken time;
    private WebDriver driver;
    private boolean isUserLoginwithEmail=false;
    private String userNameOrEmail;
    private String userPassword;
    private String errorMessage;
   public static  EachPageTimeTaken timetaken;
    // private static final Logger logger = LogManager.getLogger(TestUserLogin.class);


    private static final Logger logger = LogManager.getLogger(TestUserLogin.class);
    long startTime = System.currentTimeMillis();
     public static List<String[]> addEachPageTimeTaken = new ArrayList<>();
    public static List<String[]> negativeaddEachPageTimeTaken = new ArrayList<>();
    private String StartTime = new WaitTime().GetCurrentTime(),EndTime;
    long  BuildTrackpageloadsStartTime,
            BuildTrackpageendTime,
            hitLoginbuttonstartTime,
            DashboardstartTime,
            accountpagestartTime,
            signOutpageStarttime,
            logutTime,AlertMsgstartTime,AlertMsgendTime,errorMsgStarttime,errorMsgtime;
    String Status ="fail";
    String isvalidUsername,isValidPasssword;
    public TestUserLogin() {
        this.driver = Hooks.getDriver();

        this.loginPage = new LoginPage(this.driver);
        this.dashBoardPage = new DashBoardPage(this.driver);
        this.MenuPage=new MenuPage(this.driver);
      this.accountPage=  new AccountPage(this.driver);

        this.popupPage=new PopupPage(this.driver);
        fResult=  new FinalResult( );
        time=  new EachPageTimeTaken();


    }


    @Given("I am on the login page")
    public void iAmOnTheLoginPage()
    { BuildTrackpageloadsStartTime = System.currentTimeMillis();
        logger.info("-------------- Opening BuildTrack Url ----------------");
        this.loginPage.openProdBuildTrackLoginPage();


        logger.info("PASSED : BuidTrackUrl : https://ezcentral.buildtrack.in/login.html");
        this.loginPage. CheckLogoInLoginPage();
        BuildTrackpageendTime = System.currentTimeMillis()-BuildTrackpageloadsStartTime;

    }



    @When("I enter {string} username : {string}  and {string} password : {string}")
    public void iEnterUsernameAndPassword(String isvalidusername, String username, String isvalidPassword, String password) {

        isvalidUsername=isvalidusername;
        isValidPasssword=isvalidPassword;
        System.out.println();
        logger.info("-------------- CHECK LOGIN WITH "+isvalidusername+" USERNAME AND "+ isvalidPassword+" PASSWORD -------------------\n");

        logger.info("PASSED : Username text field  Enable");
        userNameOrEmail=username;
        userPassword=password;

        this.loginPage.enterUsername(username);
        this.loginPage.enterPassword(password);

        logger.info("PASSED : Password text field  Displayed");
        if(username.contains("@")) {
            isUserLoginwithEmail=true;
            logger.info("PASSED : Enter " + isvalidusername + " email : " + username);
            logger.info("PASSED : Enter " + isvalidPassword + " Password : " + password);
        } else if ((username.isEmpty() || password.isEmpty())) {
            logger.info("PASSED : Enter " + isvalidusername + " username : " + username);
            logger.info("PASSED : Enter " + isvalidPassword + " Password : " + password);
        }else {
            logger.info("PASSED : Enter " + isvalidusername + " username : " + username);
            logger.info("PASSED : Enter " + isvalidPassword + " Password : " + password);
        }

    }



    @And("I click the login button")
    public void iClickTheLoginButtonWithUsernameAndPassword( ) {

        if (!userNameOrEmail.isEmpty() ) {

            this.loginPage.clickLoginButton();
          hitLoginbuttonstartTime = System.currentTimeMillis();
            logger.info("PASSED : login button Displayed");
            logger.info("PASSED : login button Enable");
            logger.info("PASSED : Click login button ");
        } else {
            boolean isbuttonDisplayed=this.loginPage.isDisplayLogInButton();
            if(isbuttonDisplayed){
            logger.info("PASSED :  login button isDisplay  ");

            }
            else {
                logger.info("PASSED :  login button isNot Display  ");

            }
            boolean isbuttonEnable= this.loginPage.isEnableLoginButton() ;
            if(isbuttonEnable){
                this.loginPage.clickLoginButton();
                logger.info("PASSED :  login button Enable  ");
            }else{
                logger.info("PASSED :  login button Disable  ");
            }
        }
    }
public String FailureReason="-";


    @Then("I should be {string}")
    public boolean iShouldBe(String arg0) {



        switch (arg0){

            //positive flow for login

            case "logged-In":
                this.loginPage.isLogoLoaderDisappear();
                logger.info("PASSED : Domain_Logo Loader disappear - successfully ");
                try{
                    this.loginPage.isLogin2ndLoaderDisappear();
                    logger.info("PASSED :  LOADING. PLEASE WAIT loader disappear- successfully ");
                }catch (Exception e){
                    FailureReason="LOADING. PLEASE WAIT loader take's 30+sec";
                }
                try{
                this.dashBoardPage.DashboardHeader();
                    DashboardstartTime = System.currentTimeMillis()-hitLoginbuttonstartTime;
                }catch (Exception e){

                DashboardstartTime = System.currentTimeMillis()-hitLoginbuttonstartTime;
                    FailureReason="logo loader take's "+DashboardstartTime+" ms";
                }


try {
    logger.info("PASSED :  Check the Header text after login " + this.dashBoardPage.DashboardHeader());

                this.MenuPage.Click_MenuIcon();
                logger.info("PASSED :  Menu option is Enable");
                logger.info("PASSED :  Menu option is Displayed in Dashboard page");
                logger.info("PASSED :  Click menu icon from Dashboard page ");
                this.MenuPage.CheckLeftMenuMenuOptions();

                List<WebElement> menuList = this.MenuPage.CheckLeftMenuMenuOptions();
                System.out.println();

                logger.info("------------------- Available Menu list for user - "+userNameOrEmail +" --------------------");
                IntStream.range(0, menuList.size()).forEach(i -> logger.info("\t menuList[" + i + "] :  " + menuList.get(i).getText()));

                this.MenuPage.click_AccountsOptionsFromMenu();

                logger.info("-------------------- Navigate to Account page --------------------");

                    logger.info("PASSED :  Check the header of " + this.accountPage.AccountPageHeader() + " page");

                    if (isUserLoginwithEmail) {
                        System.out.println();
                        logger.info("\t ---------verifying  user logged-In  Email address ---------");
                        this.accountPage.GetLoggedInEmailAddressFromAccountPage(userNameOrEmail);
                         accountpagestartTime = System.currentTimeMillis()-DashboardstartTime;
                        logger.info("\t  PASSED :  Email Address Matched : " +userNameOrEmail +" !");

                    }else{
                        System.out.println();
                        this.accountPage.GetLoggedInUsernameFromAccountPage(userNameOrEmail);
                          accountpagestartTime = System.currentTimeMillis()-DashboardstartTime;
                        logger.info("\t ---------verifying  user logged-In  Username ---------");
                        this.accountPage.GetLoggedInEmailAddressFromAccountPage(userNameOrEmail);
                        logger.info("\t  PASSED :  Username Matched : " +userNameOrEmail +" !");

                    }
                    System.out.println();
                    logger.info("------------ Verifying Signing OUT User - " + userNameOrEmail +" ------------ ");
                this.MenuPage.Click_MenuIcon();
                this.MenuPage.Click_LogoutOptionFromMenu();

                this.popupPage.GetSigoutMessage();
                this.popupPage.Clcik_sigOutPopUP();
                signOutpageStarttime = System.currentTimeMillis()-accountpagestartTime;
                logger.info("PASSED :  Checking SignOut Message ");
                logger.info("PASSED :  Sig-out Ok button is Enable");
                logger.info("PASSED :  Sig-out Ok button is Displayed");
                logger.info("PASSED :  Click Sig-out Ok button ");
                this.loginPage.checkBuildTrackURL();
                long afterSigoutLoginpageEndtTime = System.currentTimeMillis();
                logutTime = afterSigoutLoginpageEndtTime - signOutpageStarttime;

}catch (Exception e){
    FailureReason="LOADING. PLEASE WAIT loader takes "+DashboardstartTime/1000+"sec";
}
                EndTime = new WaitTime().GetCurrentTime();

                if (isUserLoginwithEmail) {


                    if(FailureReason.equals("-")){
                        Status="Passed";
                        FinalResult.addTestScenario("Login with "+isvalidUsername+"-username "+isValidPasssword+"-password",userNameOrEmail,userPassword,StartTime,time.loadTimeInSec(BuildTrackpageendTime),time.loadTimeInSec(DashboardstartTime) ,EndTime,Status,FailureReason,addEachPageTimeTaken);

                    }else{
                        Status="Fail";
                        FinalResult.addTestScenario("Login with "+isvalidUsername+"-username "+isValidPasssword+"-password",userNameOrEmail,userPassword,StartTime,time.loadTimeInSec(BuildTrackpageendTime),time.loadTimeInSec(DashboardstartTime) ,EndTime,Status,FailureReason,addEachPageTimeTaken);

                    }

                 }else{
                    if(FailureReason.equals("-")){
                        Status="Passed";
                        FinalResult.addTestScenario("Login with "+isvalidUsername+"-username "+isValidPasssword+"-password",userNameOrEmail,userPassword,StartTime,time.loadTimeInSec(BuildTrackpageendTime),time.loadTimeInSec(DashboardstartTime) ,EndTime,Status,FailureReason,addEachPageTimeTaken);

                    }else{
                        Status="Fail";
                        FinalResult.addTestScenario("Login with "+isvalidUsername+"-username "+isValidPasssword+"-password",userNameOrEmail,userPassword,StartTime,time.loadTimeInSec(BuildTrackpageendTime),time.loadTimeInSec(DashboardstartTime) ,EndTime,Status,FailureReason,addEachPageTimeTaken);

                    }

                }
                 break;

            //negative flow

            case "not logged-In":

                boolean isbuttonDisplayed=this.loginPage.isDisplayLogInButton();
                logger.info("PASSED :  login button isDisplay  "+isbuttonDisplayed);
                boolean isbuttonEnable= this.loginPage.isEnableLoginButton() ;
                logger.info("PASSED :  login button isEnable  "+isbuttonEnable);
                AlertMsgstartTime= System.currentTimeMillis();
                System.out.println("laert msg : "+AlertMsgstartTime);
                if((userNameOrEmail.isEmpty() || userPassword.isEmpty()))
                {
                    logger.info("PASSED :   Username "+ (userNameOrEmail.isEmpty() ? "<empty>" : userNameOrEmail) +" Password "+(userPassword.isEmpty() ? "<empty>" : userPassword) );
                  if(userNameOrEmail.isEmpty()) {
                      logger.info("PASSED :  error message  : " +this.loginPage.isUserNameErrorMessageDisplayed()  );
                      errorMsgtime=System.currentTimeMillis()-AlertMsgstartTime;
                      Status="Passed";
                      EndTime = new WaitTime().GetCurrentTime();
                      FinalResult.addTestScenario("Login with "+isvalidUsername+"-username "+isValidPasssword+"-password",userNameOrEmail,userPassword,StartTime,time.loadTimeInSec(BuildTrackpageendTime),time.loadTimeInSec(AlertMsgendTime),time.loadTimeInSec(errorMsgtime),time.loadTimeInSec(errorMsgtime),EndTime,Status,negativeaddEachPageTimeTaken);

                  }else {
                      logger.info("PASSED :  error message  : " +  this.loginPage.isPasswordErrorMessageDisplayed());
                      errorMsgtime=System.currentTimeMillis()-AlertMsgstartTime;
                      EndTime = new WaitTime().GetCurrentTime();
                      Status="Passed";

                      FinalResult.addTestScenario("Login with "+isvalidUsername+"-username "+isValidPasssword+"-password",userNameOrEmail,userPassword,StartTime,time.loadTimeInSec(BuildTrackpageendTime),time.loadTimeInSec(AlertMsgendTime),time.loadTimeInSec(errorMsgtime),time.loadTimeInSec(errorMsgtime),EndTime,Status,negativeaddEachPageTimeTaken);

                  }
                 }else{
                    logger.info("PASSED :  error message  "+this.loginPage.getErrorMessage());
                    AlertMsgendTime=System.currentTimeMillis()-AlertMsgstartTime;
                    EndTime = new WaitTime().GetCurrentTime();
                    Status="Passed";
                    FinalResult.addTestScenario("Login with "+isvalidUsername+"-username "+isValidPasssword+"-password",userNameOrEmail,userPassword,StartTime,time.loadTimeInSec(BuildTrackpageendTime),time.loadTimeInSec(AlertMsgendTime),time.loadTimeInSec(errorMsgtime),time.loadTimeInSec(errorMsgtime),EndTime,Status,negativeaddEachPageTimeTaken);

                }

        }

        return false;
    }


    @Given("print the result")
    public void printTheResult() {
        String[] header = {"Positive testCases", "Username", "Password", "Test Start-Time","login page loading time","Dashboard loading time","Test End-Time","Status","Reason for failure"};
       new FinalResult() .PrinttableWithLinesAndMaxWidth(header,addEachPageTimeTaken);

        String[] header2 = {"Negative TestCases","Username","Password","Test Start-Time","login page loading time","invalid username/password msg","username required error msg","Password required error msg","Test End-Time","Status"};


        new FinalResult() .PrinttableWithLinesAndMaxWidth(header2,negativeaddEachPageTimeTaken);
}}
