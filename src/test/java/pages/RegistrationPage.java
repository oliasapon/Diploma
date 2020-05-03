package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class RegistrationPage extends OpenPage{

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_in_form_sign_up_text\"]/android.widget.TextView\n")
    private AndroidElement linkSingUp;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"role_select_screen\"]/android.widget.TextView[1]\n")
    private AndroidElement titleChooseRole;

    @AndroidFindBy(id = "sign_up_role_plate_patient")
    private AndroidElement buttonUser;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_up_role_plate_patient\"]/android.widget.TextView[1]\n")
    private AndroidElement checkMarkUser;

    @AndroidFindBy(id = "role_select_submit_button")
    private AndroidElement buttonContinue1;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"chronic_condition_select_screen\"]/android.widget.TextView[1]\n")
    private AndroidElement titleDiabetes;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_up_chronic_condition_absent\"]/android.widget.TextView[1]\n")
    private AndroidElement checkMarkWithoutDiabetes;

    @AndroidFindBy(id = "chronic_condition_select_screen_submit_button")
    private AndroidElement buttonContinue2;

    @AndroidFindBy(id = "sign_up_email")
    private AndroidElement inputEmail;

    @AndroidFindBy(id = "sign_up_firstname")
    private AndroidElement inputName;

    @AndroidFindBy(id = "sign_up_lastname")
    private AndroidElement inputSurname;

    @AndroidFindBy(id = "sign_up_password")
    private AndroidElement inputPassword;

    @AndroidFindBy(id = "sign_up_confirm_password")
    private AndroidElement inputConfirmPassword;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.Switch")
    private AndroidElement buttonAgree;

    @AndroidFindBy(id = "sign_up_button")
    private AndroidElement buttonSignUp;

    @AndroidFindBy(id = "android:id/alertTitle")
    private AndroidElement message1;

    @AndroidFindBy(id = "android:id/message")
    private AndroidElement message2;

    @AndroidFindBy(id = "android:id/button1")
    private AndroidElement buttonOk;

    @AndroidFindBy(id = "sign_up_chronic_condition_exists")
    private AndroidElement buttonDiabetes;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_up_chronic_condition_exists\"]/android.widget.TextView[1]")
    private AndroidElement checkMarkWithDiabetes;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"chronic_condition_type_select_screen\"]/android.widget.TextView[1]")
    private AndroidElement titleTypeDiabetes;

    @AndroidFindBy(id = "diabetes_type_one_plate")
    private AndroidElement buttonFirstTypeDiabetes;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"diabetes_type_one_plate\"]/android.widget.TextView[1]")
    private AndroidElement checkMarkDiabetesFirstType;

    @AndroidFindBy(id = "chronic_condition_type_submit")
    private AndroidElement buttonContinue3;

    @AndroidFindBy(id = "diabetes_type_two_plate")
    private AndroidElement buttonSecondTypeDiabetes;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"diabetes_type_two_plate\"]/android.widget.TextView[1]\n")
    private AndroidElement checkMarkDiabetesSecondType;

    @AndroidFindBy(id = "sign_up_role_plate_doctor")
    private AndroidElement buttonDoctor;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_up_role_plate_doctor\"]/android.widget.TextView[1]\n")
    private AndroidElement checkMarkDoctor;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_in_form_forgot_password_text\"]/android.widget.TextView")
    private AndroidElement linkForgotPassword;

    @AndroidFindBy(id = "reset_password_form_email_field")
    private AndroidElement inputEmailFormNewPassword;

    @AndroidFindBy(id = "forgot_password_form_submit_button")
    private AndroidElement buttonSubmit;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"error_text_label\"])[1]\n")
    private AndroidElement labelIncorrectName;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"error_text_label\"])[2]\n")
    private AndroidElement labelIncorrectSurname;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]\n")
    private AndroidElement iconIncorrectName;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]\n")
    private AndroidElement iconIncorrectSurname;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"error_text_label\"])[3]\n")
    private AndroidElement labelDontMatchPassword;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[6]\n")
    private AndroidElement iconDontMatchPassword;

    public RegistrationPage(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

    public void clickLinkSignUp(){
        linkSingUp.click();
    }

    public String getTextTitleChooseRole(){
        return titleChooseRole.getText();
    }

    public boolean titleChooseRole(){
        Assert.assertEquals(getTextTitleChooseRole(), "I am");
        return true;
    }

    public void clickButtonUser(){
        buttonUser.click();
    }

    public boolean checkMarkUserIsDisplayed(){
        return checkMarkUser.isDisplayed();
    }

    public void clickButtonContinue1(){
        buttonContinue1.click();
    }

    public String getTextTitleDiabetes(){
        return titleDiabetes.getText();
    }

    public boolean titleDiabetes(){
        Assert.assertEquals(getTextTitleDiabetes(), "Diabetes");
        return true;
    }

    public boolean checkMarkWithoutDiabetesIsDisplayed(){
        return checkMarkWithoutDiabetes.isDisplayed();
    }

    public void clickButtonContinue2(){
        buttonContinue2.click();
    }

    public void clickInputEmail(){
        inputEmail.click();
    }

    public void setValueEmail(String name, String surname){
        inputEmail.setValue(name+"."+surname+"@gmail.com");
    }

    public void clickInputName(){
        inputName.click();
    }

    public void clickInputSurname(){
        inputSurname.click();
    }

    public void setValueName(String name){
        inputName.setValue(name);
    }

    public void setValueSurname(String surname){
        inputSurname.setValue(surname);
    }

    public void clickInputPassword(){
        inputPassword.click();
    }

    public void setValuePassword(String password){
        inputPassword.setValue(password);
    }

    public void clickInputConfirmPassword(){
        inputConfirmPassword.click();
    }

    public void setValueConfirmPassword(String password){
        inputConfirmPassword.setValue(password);
    }

    public void hideKeyboard(){
        androidDriver.hideKeyboard();
    }

    public void clickButtonAgree(){
        buttonAgree.click();
    }

    public void clickButtonSignUp(){
        buttonSignUp.click();
    }

    public String getTextMessage1(){
        return message1.getText();
    }

    public boolean textMessage1(){
        Assert.assertEquals(getTextMessage1(), "Success");
        return true;
    }

    public String getTextMessage2(){
        return message2.getText();
    }

    public boolean textMessage2(){
        Assert.assertEquals(getTextMessage2(), "Your account has been created");
        return true;
    }

    public boolean textMessage2ForgotPassword(){
        Assert.assertEquals(getTextMessage2(), "Please check your email for a password change link.");
        return true;
    }

    public void clickOk(){
        buttonOk.click();
    }

    public void clickButtonDiabetes(){
        buttonDiabetes.click();
    }

    public boolean checkMarkWithDiabetesIsDisplayed(){
        return checkMarkWithDiabetes.isDisplayed();
    }

    public String getTextTitleTypeDiabetes(){
        return titleTypeDiabetes.getText();
    }

    public boolean titleTypeDiabetes(){
        Assert.assertEquals(getTextTitleTypeDiabetes(), "Type of diabetes");
        return true;
    }

    public void clickButtonFirstTypeDiabetes(){
        buttonFirstTypeDiabetes.click();
    }

    public boolean checkMarkDiabetesFirstTypeIsDisplayed(){
        return checkMarkDiabetesFirstType.isDisplayed();
    }

    public void clickButtonContinue3(){
        buttonContinue3.click();
    }

    public void clickButtonSecondTypeDiabetes(){
        buttonSecondTypeDiabetes.click();
    }

    public boolean checkMarkDiabetesSecondTypeIsDisplayed(){
        return checkMarkDiabetesSecondType.isDisplayed();
    }

    public void clickButtonDoctor(){
        buttonDoctor.click();
    }

    public boolean checkMarkDoctorIsDisplayed(){
        return checkMarkDoctor.isDisplayed();
    }

    public void clickForgotPassword() {
        linkForgotPassword.click();
    }

    public void clickEmail() {
        inputEmailFormNewPassword.click();
    }

    public void setValueEmailForForgotPassword() {
        inputEmailFormNewPassword.setValue("vasy_999@gmail.com");
    }

    public void clickSubmit() {
        buttonSubmit.click();
    }

    public String getTextLabelIncorrectName(){
        return labelIncorrectName.getText();
    }

    public boolean labelIncorrectName(){
        Assert.assertEquals(getTextLabelIncorrectName(), "Enter valid name");
        return true;
    }

    public String getTextLabelIncorrectSurname(){
        return labelIncorrectSurname.getText();
    }

    public boolean labelIncorrectSurname(){
        Assert.assertEquals(getTextLabelIncorrectSurname(), "Enter valid surname");
        return true;
    }

    public String getTextLabelDontMatchPassword(){
        return labelDontMatchPassword.getText();
    }

    public boolean labelDontMatchPassword(){
        Assert.assertEquals(getTextLabelDontMatchPassword(), "Passwords do not match");
        return true;
    }

    public boolean iconIncorrectNameIsDisplayed() {
        return iconIncorrectName.isDisplayed();
    }

    public boolean iconIncorrectSurnameIsDisplayed() {
        return iconIncorrectSurname.isDisplayed();
    }

    public boolean iconDontMatchPasswordIsDisplayed() {
        return iconDontMatchPassword.isDisplayed();
    }

    public boolean inputDataForRegistration(){
        String email = newEmail();
        String name = newName();
        String surname = newSurname();
        String password = newPassword();

        clickInputEmail();
        setValueEmail(name, surname);
        clickInputName();
        setValueName(name);
        clickInputSurname();
        setValueSurname(surname);
        clickInputPassword();
        setValuePassword(password);
        clickInputConfirmPassword();
        setValueConfirmPassword(password);
        hideKeyboard();
        clickButtonAgree();
        clickButtonSignUp();
        //sleepTime(2000);
        if(textMessage1() && textMessage2()){
            clickOk();
            if (mainPageIsDisplayed()) {
                return true;
            }
        }
        return false;
    }

    public boolean registrationUserWithoutDiabetes() throws InterruptedException {
        clickLinkSignUp();
        //sleepTime(2000);
        if(titleChooseRole()){
            //sleepTime(2000);
            clickButtonUser();
            //sleepTime(2000);
            if(checkMarkUserIsDisplayed()) {
                clickButtonContinue1();
                //sleepTime(2000);
                if(titleDiabetes() && checkMarkWithoutDiabetesIsDisplayed()){
                    //sleepTime(2000);
                    clickButtonContinue2();
                    if(inputDataForRegistration()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean registrationUserWithDiabetesFirstType() throws InterruptedException {
        clickLinkSignUp();
        //sleepTime(2000);
        if(titleChooseRole()){
            //sleepTime(2000);
            clickButtonUser();
            //sleepTime(2000);
            if(checkMarkUserIsDisplayed()){
                clickButtonContinue1();
                //sleepTime(2000);
               if(titleDiabetes()){
                   clickButtonDiabetes();
                   //sleepTime(2000);
                   if(checkMarkWithDiabetesIsDisplayed()){
                       clickButtonContinue2();
                       //sleepTime(3000);
                       if(titleTypeDiabetes()){
                           clickButtonFirstTypeDiabetes();
                           //sleepTime(2000);
                           if(checkMarkDiabetesFirstTypeIsDisplayed()) {
                               clickButtonContinue3();
                               if(inputDataForRegistration()){
                                   return true;
                               }
                           }
                       }
                   }
               }
            }
        }
        return false;
    }

    public boolean registrationUserWithDiabetesSecondType() throws InterruptedException {
        clickLinkSignUp();
        //sleepTime(2000);
        if(titleChooseRole()){
            //sleepTime(2000);
            clickButtonUser();
            //sleepTime(2000);
            if(checkMarkUserIsDisplayed()) {
                clickButtonContinue1();
                //sleepTime(2000);
                if(titleDiabetes()){
                    //sleepTime(2000);
                    clickButtonDiabetes();
                    //sleepTime(2000);
                    if (checkMarkWithDiabetesIsDisplayed()) {
                        clickButtonContinue2();
                        //sleepTime(3000);
                        if(titleTypeDiabetes()){
                            clickButtonSecondTypeDiabetes();
                            //sleepTime(2000);
                            if (checkMarkDiabetesSecondTypeIsDisplayed()) {
                                clickButtonContinue3();
                                if(inputDataForRegistration()){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean registrationDoctor() throws InterruptedException {
        clickLinkSignUp();
        //sleepTime(2000);
        if(titleChooseRole()){
            //sleepTime(2000);
            clickButtonDoctor();
            //sleepTime(2000);
            if(checkMarkDoctorIsDisplayed()){
                clickButtonContinue1();
                //sleepTime(2000);
                if(inputDataForRegistration()){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean forgotPassword() throws InterruptedException {
        clickForgotPassword();
        clickEmail();
        setValueEmailForForgotPassword();
        clickSubmit();
        if(textMessage1()){
            if(textMessage2ForgotPassword()){
                //sleepTime(3000);
                clickOk();
                //sleepTime(2000);
                if(mainPageIsDisplayed()){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean invalidNameAndSurnameRegistration(){
        clickLinkSignUp();
        if(titleChooseRole()){
            clickButtonDoctor();
            if(checkMarkDoctorIsDisplayed()) {
                clickButtonContinue1();
                clickInputName();
                setValueName("Tom34");
                clickInputSurname();
                setValueSurname("Nelson34");
                clickInputPassword();
                hideKeyboard();
                if(labelIncorrectName() && labelIncorrectSurname() && iconIncorrectNameIsDisplayed() &&iconIncorrectSurnameIsDisplayed()){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dontMatchPasswordRegistration(){
        setValuePassword("12345678");
        clickInputConfirmPassword();
        setValueConfirmPassword("12345677");
        hideKeyboard();
        clickButtonAgree();
        if(iconDontMatchPasswordIsDisplayed() && labelDontMatchPassword()){
            return true;
        }
        return false;
    }
}
