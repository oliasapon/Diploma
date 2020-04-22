package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class SettingsPage extends PatientsPage{

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]\n")
    private AndroidElement buttonSettings;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_out_text\"]/android.widget.TextView\n")
    private AndroidElement buttonSignOut;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup")
    private AndroidElement buttonChartLineColor;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]\n")
    private AndroidElement buttonChooseChartLineColor;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[9]")
    private AndroidElement buttonSave;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup")
    private AndroidElement buttonChartGridColor;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]")
    private AndroidElement buttonChooseChartGridColor;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ImageView\n")
    private AndroidElement iconUserFoto;

    @AndroidFindBy(id = "user_olia.sapon@gmail.com")
    private AndroidElement titleEmail;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"edit_user_text\"]/android.widget.TextView\n")
    private AndroidElement buttonEdit;

    @AndroidFindBy(id = "female_pick")
    private AndroidElement buttonFemale;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"edit_user_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]/android.widget.TextView[1]\n")
    private AndroidElement buttonOptionalFields;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"edit_user_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView[2]\n")
    private AndroidElement titleWeight;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"edit_user_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[2]\n")
    private AndroidElement titleHeight;

    @AndroidFindBy(id = "create_patient_button")
    private AndroidElement buttonUpdateInformation;

    public SettingsPage(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

     /*@AndroidFindBy(xpath = "")
    private AndroidElement;
    @AndroidFindBy(id = "")
    private AndroidElement;*/


    public void clickButtonSettings(){
        buttonSettings.click();
    }

    public void clickButtonSignOut(){
        buttonSignOut.click();
    }

    public boolean signOut() throws InterruptedException {
        clickButtonSettings();
        clickButtonSignOut();
        //sleepTime(2000);
        if(mainPageIsDisplayed()){
            return true;
        }
        return false;
    }

    public void clickButtonChartLineColor(){
        buttonChartLineColor.click();
    }

    public void clickButtonChooseChartLineColor(){
        buttonChooseChartLineColor.click();
    }

    public void clickButtonSave(){
        buttonSave.click();
    }

    public void clickChartGridColor(){
        buttonChartGridColor.click();
    }

    public void clickChooseChartGridColor(){
        buttonChooseChartGridColor.click();
    }

    public boolean settingsDoctorDemo() throws InterruptedException {
        clickButtonSettings();
        clickButtonChartLineColor();
        //sleepTime(2000);
        clickButtonChooseChartLineColor();
        clickButtonSave();
        clickChartGridColor();
        //sleepTime(2000);
        clickChooseChartGridColor();
        clickButtonSave();
        clickButtonHistoryDoctor();
        clickButtonViewDataFirstPatient();
        sleepTime(2000);
        clickComeBack();
        clickButtonSettings();
        clickButtonSignOut();
        //sleepTime(2000);
        if(mainPageIsDisplayed()){
            return true;
        }
        return false;
    }



    public boolean iconUserFotoIsDisplayed() {
        return iconUserFoto.isDisplayed();
    }

    public String getTextTitleEmail(){
        return titleEmail.getText();
    }

    public boolean titleEmail(){
        Assert.assertEquals(getTextTitleEmail(), "olia.sapon@gmail.com");
        return true;
    }

    public boolean viewSettingsUser() throws InterruptedException {
        clickButtonSettings();
        //sleepTime(2000);
        if(iconUserFotoIsDisplayed() && titleEmail()){
            return true;
        }
        return false;
    }



    public void clickButtonEdit(){
        buttonEdit.click();
    }

    public void clickButtonFemale(){
        buttonFemale.click();
    }

    public void clickButtonOptionalFields(){
        buttonOptionalFields.click();
    }

    public String getTextTitleWeight(){
        return titleWeight.getText();
    }

    public boolean titleWeight(){
        Assert.assertEquals(getTextTitleWeight(), "Weight");
        return true;
    }

    public String getTextTitleHeight(){
        return titleHeight.getText();
    }

    public boolean titleHeight(){
        Assert.assertEquals(getTextTitleHeight(), "Height");
        return true;
    }

    public void clickButtonUpdateInformation(){
        buttonUpdateInformation.click();
    }

    public boolean editInformationPatientUser() throws InterruptedException {
        clickButtonEdit();
        //sleepTime(2000);
        clickButtonFemale();
        clickButtonOptionalFields();
        sleepTime(2000);
        verticalSwipe(500, 1700, 190, 1000);
        //sleepTime(2000);
        if(titleWeight() && titleHeight()){
            horizontalSwipe(310, 235, 1200, 1000);
            sleepTime(2000);
            horizontalSwipe(700, 688, 1450, 1000);
            //sleepTime(2000);
            clickButtonUpdateInformation();
            //sleepTime(2000);
            return true;
        }
        return false;
    }

     /*@AndroidFindBy(xpath = "")
    private AndroidElement;
    @AndroidFindBy(id = "")
    private AndroidElement;*/

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView\n")
    private AndroidElement buttonChangeRoleToDoctor;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView\n")
    private AndroidElement buttonChangeRoleToPatient;

    public void clickButtonChangeRoleToDoctor(){
        buttonChangeRoleToDoctor.click();
    }

    public void clickButtonChangeRoleToPatient(){
        buttonChangeRoleToPatient.click();
    }

    public boolean changeRolePatientUser() throws InterruptedException {
        clickButtonChangeRoleToDoctor();
        //sleepTime(2000);
        if(messagePageDoctor()){
            clickButtonSettings();
            //sleepTime(2000);
            clickButtonChangeRoleToPatient();
            //sleepTime(2000);
            if(messagePageUser()){
                return true;
            }
        }
        return false;
    }

    public String getTextButtonChangeRoleToPatient(){
        return buttonChangeRoleToPatient.getText();
    }

    public boolean buttonChangeRoleToPatient(){
        Assert.assertEquals(getTextButtonChangeRoleToPatient(), "Change role to Patient");
        return true;
    }

    public boolean signOutDoctor() throws InterruptedException {
        clickButtonSettings();
        //sleepTime(2000);
        if(buttonChangeRoleToPatient()){
            clickButtonEdit();
            if(titleEditInformation()){
                clickComeBack();
                //sleepTime(2000);
                clickButtonSignOut();
                //sleepTime(2000);
                if(mainPageIsDisplayed()){
                    return true;
                }
            }
        }
        return false;
    }


}
