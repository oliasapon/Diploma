package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class SignInPage extends OpenPage{

    @AndroidFindBy(id = "sign_in_form_email_field")
    private AndroidElement inputEmail;

    @AndroidFindBy(id = "sign_in_form_password_field")
    private AndroidElement inputPassword;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]")
    private AndroidElement buttonShowPassword;

    @AndroidFindBy(id = "sign_in_form_submit_button")
    private AndroidElement buttonSignIn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.widget.TextView[1]")
    private AndroidElement titleFirstPageUser;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.widget.TextView\n")
    private AndroidElement titleFirstPageDoctor;

    public SignInPage(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }


    public void clickInputEmail(){
        inputEmail.click();
    }

    public void setValueEmail(String email){
        inputEmail.setValue(email);
    }

    public void clickInputPassword(){
        inputPassword.click();
    }

    public void setValuePassword(String password){
        inputPassword.setValue(password);
    }

    public void clickShowPassword(){
        buttonShowPassword.click();
    }

    public void hideKeyboard(){
        androidDriver.hideKeyboard();
    }

    public void clickButtonSignIn(){
        buttonSignIn.click();
    }

    public String getTextTitleFirstPageUser(){
        return titleFirstPageUser.getText();
    }

    public String getTextTitleFirstPageDoctor(){
        return titleFirstPageDoctor.getText();
    }

    public void signIn(String email, String password) throws InterruptedException {
        clickInputEmail();
        setValueEmail(email);
        clickInputPassword();
        setValuePassword(password);
        clickShowPassword();
        sleepTime(3000);
        clickShowPassword();
        hideKeyboard();
        clickButtonSignIn();
        //sleepTime(2000);
    }

    public boolean messagePageUser(){
        Assert.assertEquals(getTextTitleFirstPageUser(), "Let's get started");
        return true;
    }

    public boolean messagePageDoctor(){
        Assert.assertEquals(getTextTitleFirstPageDoctor(), "Records history");
        return true;
    }

    public boolean signInUserWithDiabetesFirstType() throws InterruptedException {
        boolean status = false;
        signIn("homka6745@gmail.com", "lovesport");
        if(messagePageUser()){
            status = true;
        }
        return status;
    }

    public boolean signInUserWithDiabetesSecondType() throws InterruptedException {
        boolean status = false;
        signIn("jin.tok@gmail.com", "jinnn888");
        sleepTime(3000);
        if(messagePageUser()){
            status = true;
        }
        return status;
    }

    public boolean signInUserWithout() throws InterruptedException {
        boolean status = false;
        signIn("olia.sapon@gmail.com", "12344321");
        if(messagePageUser()){
            status = true;
        }
        return status;
    }

    public boolean signInDoctorWithPatients() throws InterruptedException {
        boolean status = false;
        signIn("aria34@gmail.com", "doctorAria34");
        if(messagePageDoctor()){
            status = true;
        }
        return status;
    }

    public boolean signInDoctorWithoutPatients() throws InterruptedException {
        boolean status = false;
        signIn("nick.dobr87@gmail.com", "dobr1987");
        if(messagePageDoctor()){
            status = true;
        }
        return status;
    }

}
