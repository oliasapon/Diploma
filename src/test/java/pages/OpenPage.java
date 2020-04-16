package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class OpenPage extends DriverPage{

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView")
    private AndroidElement mainPage;


    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_in_form_forgot_password_text\"]/android.widget.TextView")
    private AndroidElement linkForgotPassword;

    @AndroidFindBy(id = "reset_password_form_email_field")
    private AndroidElement inputEmail;

    @AndroidFindBy(id = "forgot_password_form_submit_button")
    private AndroidElement buttonSubmit;

    @AndroidFindBy(id = "android:id/alertTitle")
    private AndroidElement message1;

    @AndroidFindBy(id = "android:id/message")
    private AndroidElement message2;

    @AndroidFindBy(id = "android:id/button1")
    private AndroidElement buttonOk;


    public OpenPage(AppiumDriver<MobileElement>  androidDriver) {
        super(androidDriver);
    }

    public boolean mainPageIsDisplayed() {
        /*if(mainPage.isDisplayed()) {
            System.out.println("Test 1 - successfully");
            return true;
        }
        else{
            return false;
        }*/
        return mainPage.isDisplayed();
    }



    public void clickForgotPassword() {
        linkForgotPassword.click();
    }

    public void clickEmail() {
        inputEmail.click();
    }

    public void clickSubmit() {
        buttonSubmit.click();
    }

    public void setValueEmail() {
        inputEmail.setValue("vasy_999@gmail.com");
    }

    /*public boolean getTextMessage1(){
        if(message1.getText() == "Success") {
            System.out.println("Tsdfsdfsdfsdfsdfully");
            return true;
        }
        else{
            return false;
        }
        //message1.getText().getClass().getName();
        //System.out.println( message1.getText().getClass().getName());
    }

    public boolean getTextMessage2(){
        if(message2.getText() == "Please check your email for a password change link.") {
            System.out.println("Tsdfsdfsdfs11111111111111111111111111lly");
            return true;
        }
        else{
            return false;
        }
        //System.out.println(message2.getText());
    }*/

    public String getTextMessage1(){
        /*if(message1.getText() == "Success") {
            System.out.println("Tsdfsdfsdfsdfsdfully");
            return true;
        }
        else{
            return false;
        }*/
        //message1.getText().getClass().getName();
        //System.out.println( message1.getText().getClass().getName());
        System.out.println("Tsdfsdfsdfsdfsdfully11111111");
        return message1.getText();
    }

    public String getTextMessage2(){
        /*if(message2.getText() == "Please check your email for a password change link.") {
            System.out.println("Tsdfsdfsdfs11111111111111111111111111lly");
            return true;
        }
        else{
            return false;
        }*/
        //System.out.println(message2.getText());
        System.out.println("Tsdfsdfsdfsdfsdfully2222222");
        return message2.getText();
    }

    public void clickOk(){
        buttonOk.click();
    }

    public boolean forgotPassword() throws InterruptedException {
        boolean status = false;
        clickForgotPassword();
        clickEmail();
        setValueEmail();
        clickSubmit();
       // getTextMessage1();
        Thread.sleep(3000, 30);
        System.out.println("111111");
        String mess1 = getTextMessage1();
        String mess2 = getTextMessage2();
        //Assert.assertEquals(mess1, "Success");
        //androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        if(mess1 == "Success" && mess2 == "Please check your email for a password change link."){
            Thread.sleep(3000, 30);
            System.out.println("222");
            clickOk();
            Thread.sleep(3000, 30);
            if(mainPageIsDisplayed() == true){
                status = true;
                System.out.println("Test 6 - successfully");
            }
        }
        return status;
    }

}
