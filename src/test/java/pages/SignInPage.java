package pages;

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

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.TextView[1]\n")
    private AndroidElement iconStatusEmail;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.TextView[2]\n")
    private AndroidElement iconErrorPassword;

    @AndroidFindBy(id = "error_text_label")
    private AndroidElement labelInvalidEmail;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"error_text_label\"])[1]\n")
    private AndroidElement labelRequiredEmail;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"error_text_label\"])[2]\n")
    private AndroidElement labelRequiredPassword;

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
        sleepTime(4000);
    }

    public boolean messagePageUser(){
        Assert.assertEquals(getTextTitleFirstPageUser(), "Let's get started");
        return true;
    }

    public boolean messagePageDoctor(){
        Assert.assertEquals(getTextTitleFirstPageDoctor(), "Records history");
        return true;
    }

    public boolean iconStatusEmailIsDisplayed() {
        return iconStatusEmail.isDisplayed();
    }

    public String getTextLabelInvalidEmail(){
        return labelInvalidEmail.getText();
    }

    public boolean labelInvalidEmail(){
        Assert.assertEquals(getTextLabelInvalidEmail(), "Invalid email address");
        return true;
    }

    public boolean iconErrorPasswordIsDisplayed() {
        return iconErrorPassword.isDisplayed();
    }

    public String getTextLabelRequiredEmail(){
        return labelRequiredEmail.getText();
    }

    public String getTextLabelRequiredPassword(){
        return labelRequiredPassword.getText();
    }

    public boolean labelRequired(){
        Assert.assertEquals(getTextLabelRequiredEmail(), "Email is required!");
        Assert.assertEquals(getTextLabelRequiredPassword(), "Password is required");
        return true;
    }

    public boolean labelShortPassword(){
        Assert.assertEquals(getTextLabelInvalidEmail(), "Password must be longer than 8 characters");
        return true;
    }

    public boolean labelIncorrectPasswordOrEmail(){
        Assert.assertEquals(getTextLabelInvalidEmail(), "Email or password is incorrect");
        return true;
    }

    public boolean signInUserWithDiabetesFirstType() throws InterruptedException {
        signIn("homka6745@gmail.com", "lovesport");
        if(messagePageUser()){
            return true;
        }
        return false;
    }

    public boolean signInUserWithDiabetesSecondType() throws InterruptedException {
        signIn("jin.tok@gmail.com", "jinnn888");
        sleepTime(3000);
        if(messagePageUser()){
            return true;
        }
        return false;
    }

    public boolean signInUserWithout() throws InterruptedException {
        signIn("olia.sapon@gmail.com", "12344321");
        if(messagePageUser()){
            return true;
        }
        return false;
    }

    public boolean signInDoctorWithPatients() throws InterruptedException {
        signIn("aria34@gmail.com", "doctorAria34");
        if(messagePageDoctor()){
            return true;
        }
        return false;
    }

    public boolean signInDoctorWithoutPatients() throws InterruptedException {
        signIn("nick.dobr87@gmail.com", "dobr1987");
        if(messagePageDoctor()){
            return true;
        }
        return false;
    }

    public boolean signInRequiredEmailAndPassword() throws InterruptedException{
        clickInputEmail();
        clickInputPassword();
        clickInputEmail();
        //sleepTime(3000);
        hideKeyboard();
        if(iconStatusEmailIsDisplayed() && iconErrorPasswordIsDisplayed() && labelRequired()){
            return true;
        }
        return false;
    }

    public boolean signInInvalidEmail() throws InterruptedException {
        setValueEmail("invalid.email@gmail");
        //sleepTime(3000);
        hideKeyboard();
        if(iconStatusEmailIsDisplayed() && labelInvalidEmail()){
            return true;
        }
        return false;
    }

    public boolean signInShortPassword() throws InterruptedException {
        setValueEmail(".com");
        if(iconStatusEmailIsDisplayed()){
            clickInputPassword();
            setValuePassword("1111");
            if(iconErrorPasswordIsDisplayed() && labelShortPassword()){
                return true;
            }
        }
        return false;
    }

    public boolean signInIncorrectPasswordOrEmail() throws InterruptedException {
        setValuePassword("1111");
        hideKeyboard();
        clickButtonSignIn();
        if(labelIncorrectPasswordOrEmail()){
            return true;
        }
        return false;
    }

}
