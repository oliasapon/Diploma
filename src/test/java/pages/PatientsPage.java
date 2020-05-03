package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class PatientsPage extends HistoryPageDoctor{

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[2]\n")
    private AndroidElement buttonPatients;

    @AndroidFindBy(id = "patients_filter_button")
    private AndroidElement buttonFilter;

    @AndroidFindBy(id = "female_pick")
    private AndroidElement buttonFemale;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patients_filter\"]/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup\n")
    private AndroidElement buttonChooseGroup;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_sarah\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView\n")
    private AndroidElement iconGroupT2DM;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_sarah\"]/android.view.ViewGroup\n")
    private AndroidElement buttonChoosePatient;

    @AndroidFindBy(id = "patient_chart_tab_button")
    private AndroidElement buttonChart;

    @AndroidFindBy(id = "patient_about_tab_button")
    private AndroidElement buttonAbout;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patients_screen\"]/android.widget.TextView\n")
    private AndroidElement titlePatients;

    @AndroidFindBy(id = "open_create_patient_screen_button")
    private AndroidElement buttonCreatePatient;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_creating_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView")
    private AndroidElement titleCreatePatient;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_creating_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.widget.EditText\n")
    private AndroidElement inputNumberPhone;

    @AndroidFindBy(id = "create_patient_firstname_field")
    private AndroidElement inputName;

    @AndroidFindBy(id = "create_patient_lastname_field")
    private AndroidElement inputSurname;

    @AndroidFindBy(id = "create_patient_button")
    private AndroidElement buttonAddNewPatient;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_alan\"]/android.view.ViewGroup\n")
    private AndroidElement buttonFirstPatient;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_edit_button\"]/android.widget.TextView")
    private AndroidElement buttonEditPatient;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"edit_user_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n")
    private AndroidElement titleEditInformation;

    @AndroidFindBy(id = "male_pick")
    private AndroidElement buttonMale;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"add_patient_text\"]/android.widget.TextView")
    private AndroidElement linkPress;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patients_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView\n")
    private AndroidElement titleAddFirstPatient;

    public PatientsPage(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

    public void clickButtonPatients(){
        buttonPatients.click();
    }

    public void clickButtonFilter(){
        buttonFilter.click();
    }

    public void clickButtonFemale(){
        buttonFemale.click();
    }

    public void clickButtonChooseGroup(){
        buttonChooseGroup.click();
    }

    public String getTextIconGroupT2DM(){
        return iconGroupT2DM.getText();
    }

    public boolean iconGroupT2DM(){
        Assert.assertEquals(getTextIconGroupT2DM(), "T2DM");
        return true;
    }

    public void clickButtonChoosePatient(){
        buttonChoosePatient.click();
    }

    public void clickButtonChart(){
        buttonChart.click();
    }

    public void clickButtonAbout(){
        buttonAbout.click();
    }

    public String getTextTitlePatients(){
        return titlePatients.getText();
    }

    public boolean titlePatients(){
        Assert.assertEquals(getTextTitlePatients(), "Patients");
        return true;
    }

    public boolean buttonFilterIsDisplayed(){
        return buttonFilter.isDisplayed();
    }

    public void clickButtonCreatePatient(){
        buttonCreatePatient.click();
    }

    public String getTextTitleCreatePatient(){
        return titleCreatePatient.getText();
    }

    public boolean titleCreatePatient(){
        Assert.assertEquals(getTextTitleCreatePatient(), "Create new patient");
        return true;
    }

    public void clickInputNumberPhone(){
        inputNumberPhone.click();
    }

    public void setValueInputNumberPhone(String number){
        inputNumberPhone.setValue(number);
    }

    public void clickInputName(){
        inputName.click();
    }

    public void setValueInputName(String name){
        inputName.setValue(name);
    }

    public void clickInputSurname(){
        inputSurname.click();
    }

    public void setValueInputSurname(String surname){
        inputSurname.setValue(surname);
    }

    public void clickButtonAddNewPatient(){
        buttonAddNewPatient.click();
    }

    public void clickButtonFirstPatient(){
        buttonFirstPatient.click();
    }

    public void clickButtonEditPatient(){
        buttonEditPatient.click();
    }

    public String getTextTitleEditInformation(){
        return titleEditInformation.getText();
    }

    public boolean titleEditInformation(){
        Assert.assertEquals(getTextTitleEditInformation(), "Edit information");
        return true;
    }

    public void clickButtonMale(){
        buttonMale.click();
    }

    public String getTextLinkPress(){
        return linkPress.getText();
    }

    public boolean linkPress(){
        Assert.assertEquals(getTextLinkPress(), "Press ");
        return true;
    }

    public String getTextTitleAddFirstPatient(){
        return titleAddFirstPatient.getText();
    }

    public boolean titleAddFirstPatient(){
        Assert.assertEquals(getTextTitleAddFirstPatient(), "to add your first patient");
        return true;
    }

    public void clickLinkPress(){
        linkPress.click();
    }

    public boolean viewPatientsDoctorDemo() throws InterruptedException {
        clickButtonPatients();
        clickButtonFilter();
        clickButtonFemale();
        //sleepTime(2000);
        horizontalSwipe(900, 600, 850, 1000);
        clickButtonChooseGroup();
        clickButtonFilter();
        if(iconGroupT2DM()){
            return true;
        }
        return false;
    }

    public boolean viewOnePatientDoctorDemo() throws InterruptedException {
        clickButtonChoosePatient();
        //sleepTime(2000);
        verticalSwipe(500, 1700, 890, 1000);
        clickButtonChart();
        //sleepTime(2000);
        horizontalSwipe(100, 900, 1200, 1000);
        if(scroll("Flattening of T waves")){
            clickButtonAbout();
            clickComeBack();
            //sleepTime(2000);
            return true;
        }
        return false;
    }

    public boolean viewPatientsDoctor() throws InterruptedException {
        clickButtonPatients();
        if(titlePatients() && buttonFilterIsDisplayed()){
            clickButtonFilter();
            sleepTime(2000);
            clickButtonFilter();
            return true;
        }
        return false;
    }

    public boolean createNewPatientDoctor() throws InterruptedException {
        clickButtonCreatePatient();
        sleepTime(2000);
        if(titleCreatePatient()){
            clickInputNumberPhone();
            setValueInputNumberPhone(newNumber());
            hideKeyboard();
            //sleepTime(2000);
            clickInputName();
            setValueInputName(newName());
            hideKeyboard();
            clickInputSurname();
            setValueInputSurname(newSurname());
            hideKeyboard();
            sleepTime(2000);
            verticalSwipe(700, 1450, 400, 500);
            sleepTime(2000);
            tap(100, 1520);
            tap(100, 1520);
            verticalSwipe(700, 1450, 400, 500);
            //sleepTime(2000);
            clickButtonAddNewPatient();
            if(titlePatients()){
                return true;
            }
        }
        return false;
    }

    public boolean editPatientDoctor() throws InterruptedException {
        clickButtonFirstPatient();
        //sleepTime(2000);
        clickButtonEditPatient();
        //sleepTime(2000);
        if(titleEditInformation()){
            clickButtonMale();
            //sleepTime(2000);
            clickButtonAddNewPatient();
            sleepTime(2000);
            clickComeBack();
            sleepTime(2000);
            return true;
        }
        return false;
    }

    public boolean viewPatientsWOPDoctor() throws InterruptedException {
        clickButtonPatients();
        //sleepTime(2000);
        if(titlePatients() && buttonFilterIsDisplayed() && linkPress() && titleAddFirstPatient()){
            return true;
        }
        return false;
    }

    public boolean pressAddPatientWOPDoctor() throws InterruptedException {
        clickLinkPress();
        //sleepTime(2000);
        if(titleCreatePatient()){
            clickComeBack();
            //sleepTime(2000);
            return true;
        }
        return false;
    }


}
