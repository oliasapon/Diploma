package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class GetStartedPage extends PatientsPage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[3]\n")
    private AndroidElement buttonGetStarted;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]\n")
    private AndroidElement iconViewDemo;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]\n")
    private AndroidElement titleHello;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]\n")
    private AndroidElement titleLetsRegistration;

    @AndroidFindBy(id = "demo_modal_sign_up_button")
    private AndroidElement buttonSignUpDemo;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]\n")
    private AndroidElement titleAgree;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n")
    private AndroidElement iconViewDemoDoctor;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]")
    private AndroidElement titleHelloDoctor;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]\n")
    private AndroidElement titleLetsRegistrationDoctor;

    public GetStartedPage(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

    public void clickButtonGetStarted(){
        buttonGetStarted.click();
    }

    public boolean iconViewDemoIsDisplayed() {
        return iconViewDemo.isDisplayed();
    }

    public String getTextTitleHello(){
        return titleHello.getText();
    }

    public boolean titleHello(){
        Assert.assertEquals(getTextTitleHello(), "Hello!");
        return true;
    }

    public String getTextTitleLetsRegistration(){
        return titleLetsRegistration.getText();
    }

    public boolean titleLetsRegistration(){
        Assert.assertEquals(getTextTitleLetsRegistration(), "Let's register your account as a doctor or patient");
        return true;
    }

    public void clickButtonSignUpDemo(){
        buttonSignUpDemo.click();
    }

    public String getTextTitleAgree(){
        return titleAgree.getText();
    }

    public boolean titleAgree(){
        Assert.assertEquals(getTextTitleAgree(), "I agree to");
        return true;
    }

    public boolean  viewGetStartedUserDemo() throws InterruptedException {
        boolean status = false;
        clickButtonGetStarted();
        sleepTime(2000);
        if(iconViewDemoIsDisplayed() && titleHello() &&  titleLetsRegistration()) {
            status = true;
        }
        return status;
    }

    public boolean  getStartedSignUpUserDemo() throws InterruptedException {
        clickButtonSignUpDemo();
        sleepTime(2000);
        if(titleAgree()) {
            clickComeBack();
            if(mainPageIsDisplayed()){
                return true;
            }
        }
        return false;
    }

    public boolean  viewGetStartedTapUserDemo() throws InterruptedException {
        boolean status = false;
        tap(100, 100);
        sleepTime(2000);
        if(titleDashboard()) {
            status = true;
        }
        return status;
    }

    public boolean iconViewDemoDoctorIsDisplayed() {
        return iconViewDemoDoctor.isDisplayed();
    }

    public String getTextTitleHelloDoctor(){
        return titleHelloDoctor.getText();
    }

    public boolean titleHelloDoctor(){
        Assert.assertEquals(getTextTitleHelloDoctor(), "Hello!");
        return true;
    }

    public String getTextTitleLetsRegistrationDoctor(){
        return titleLetsRegistrationDoctor.getText();
    }

    public boolean titleLetsRegistrationDoctor(){
        Assert.assertEquals(getTextTitleLetsRegistrationDoctor(), "Let's register your account as doctor to create group");
        return true;
    }

    public boolean  viewNewGroupDoctorDemo() throws InterruptedException {
        sleepTime(2000);
        if(iconViewDemoDoctorIsDisplayed() && titleHelloDoctor() &&  titleLetsRegistrationDoctor()) {
            return true;
        }
        return false;
    }

    public boolean  viewNewGroupTapDoctorDemo() throws InterruptedException {
        sleepTime(2000);
        tap(100, 100);
        sleepTime(2000);
        return true;
    }



    @AndroidFindBy(id = "base_line_with_0_record")
    private AndroidElement lineRecord;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.widget.TextView[2]\n")
    private AndroidElement titleECGdevice;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[2]\n")
    private AndroidElement iconStart;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[3]/android.widget.TextView[2]\n")
    private AndroidElement titleNoDevice;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.widget.Switch")
    private AndroidElement buttonVisitorMode;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"connect_text_button\"]/android.widget.TextView\n")
    private AndroidElement buttonConnect;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private AndroidElement buttonAllow;

    public boolean lineRecordIsDisplayed() {
        return lineRecord.isDisplayed();
    }

    public String getTextTitleECGdevice(){
        return titleECGdevice.getText();
    }

    public boolean titleECGdevice(){
        Assert.assertEquals(getTextTitleECGdevice(), "If you have an ECG device, you can pair it with your phone here.");
        return true;
    }

    public boolean iconStartIsDisplayed() {
        return iconStart.isDisplayed();
    }

    public String getTextTitleNoDevice(){
        return titleNoDevice.getText();
    }

    public boolean titleNoDevice(){
        Assert.assertEquals(getTextTitleNoDevice(), "No connected device");
        return true;
    }

    public void clickButtonVisitorMode(){
        buttonVisitorMode.click();
    }

    public void clickButtonConnect(){
        buttonConnect.click();
    }

    public void clickAllow(){
        buttonAllow.click();
    }

    public boolean  viewFirstCentralPageUser() throws InterruptedException {
        if(lineRecordIsDisplayed() && titleECGdevice() && iconStartIsDisplayed() && titleNoDevice()){
            clickButtonVisitorMode();
            sleepTime(2000);
            clickButtonVisitorMode();
            clickButtonConnect();
            clickAllow();
            sleepTime(2000);
            clickAllow();
            return true;
        }
        return false;
    }




    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView\n")
    private AndroidElement titleCentralPageWithTap;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.TextView\n")
    private AndroidElement buttonAllPatient;

    @AndroidFindBy(id = "record_patient_filter_button")
    private AndroidElement buttonFilter;

    @AndroidFindBy(id = "record_patients_search_field")
    private AndroidElement buttonSearch;

    @AndroidFindBy(id = "clear_search_field_button")
    private AndroidElement buttonClear;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]\n")
    private AndroidElement buttonAddPatient;

    public String getTextTitleCentralPageWithTap(){
        return titleCentralPageWithTap.getText();
    }

    public boolean titleCentralPageWithTap(){
        Assert.assertEquals(getTextTitleCentralPageWithTap(), "Select patient");
        return true;
    }

    public void clickButtonAllPatient(){
        buttonAllPatient.click();
    }

    @Override
    public void clickButtonFilter(){
        buttonFilter.click();
    }

    public void clickButtonSearch(){
        buttonSearch.click();
    }

    public void setValueButtonSearch(String name){
        buttonSearch.setValue(name);
    }

    public void clickButtonClear(){
        buttonClear.click();
    }

    public void clickButtonAddPatient(){
        buttonAddPatient.click();
    }

    public boolean  viewCentralPageDoctor() throws InterruptedException {
        clickButtonGetStarted();
        tap(700, 1000);
        sleepTime(2000);
        if(titleCentralPageWithTap()){
            clickButtonAllPatient();
            clickButtonFilter();
            //sleepTime(2000);
            clickButtonMale();
            clickButtonFilter();
            //sleepTime(2000);
            clickButtonSearch();
            setValueButtonSearch("Kory");
            hideKeyboard();
            clickButtonClear();
            sleepTime(2000);
            clickButtonAddPatient();
            sleepTime(3000);
            if(titleCreatePatient()){
                clickComeBack();
                //sleepTime(2000);
                return true;
            }
        }
        return false;
    }


 /*@AndroidFindBy(xpath = "")
    private AndroidElement;
    @AndroidFindBy(id = "")
    private AndroidElement;*/

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView\n")
    private AndroidElement iconSelectPatient;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement titleSelectPatient;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView")
    private AndroidElement iconQuickRecord;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    private AndroidElement titleQuickRecord;

    public boolean iconSelectPatientIsDisplayed() {
        return iconSelectPatient.isDisplayed();
    }

    public boolean iconQuickRecordIsDisplayed() {
        return iconQuickRecord.isDisplayed();
    }

    @Override
    public String getTextTitleSelectPatient(){
        return titleSelectPatient.getText();
    }

    @Override
    public boolean titleSelectPatient(){
        Assert.assertEquals(getTextTitleSelectPatient(), "Select patient");
        return true;
    }

    public String getTextTitleQuickRecord(){
        return titleQuickRecord.getText();
    }

    public boolean titleQuickRecord(){
        Assert.assertEquals(getTextTitleQuickRecord(), "Quick record");
        return true;
    }

    public boolean  viewCentralPageWOPDoctor() throws InterruptedException {
        clickButtonGetStarted();
        sleepTime(3000);
        if(iconSelectPatientIsDisplayed() && iconQuickRecordIsDisplayed() && titleSelectPatient() && titleQuickRecord()){
            return true;
        }
        return false;
    }

    public boolean  viewCentralPageTapWOPDoctor() throws InterruptedException {
        tap(700, 1000);
        sleepTime(2000);
        if(titleCentralPageWithTap()){
            clickButtonFilter();
            sleepTime(2000);
            clickButtonFilter();
            //sleepTime(2000);
            clickButtonAddPatient();
            sleepTime(3000);
            if(titleCreatePatient()){
                clickComeBack();
                //sleepTime(2000);
                return true;
            }
        }
        return false;
    }

}
