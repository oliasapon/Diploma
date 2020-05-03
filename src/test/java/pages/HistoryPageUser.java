package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;


public class HistoryPageUser extends SignInPage{

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[2]\n")
    private AndroidElement buttonHistory;

    @AndroidFindBy(id = "diabetes_type_di_badge")
    private AndroidElement iconDiabetesFirstType;

    @AndroidFindBy(id = "diabetes_type_di_badge")
    private AndroidElement buttonIconD1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView\n")
    private AndroidElement messageD1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView\n")
    private AndroidElement messageInfoWithD;

    @AndroidFindBy(id = "diabetes_type_dii_badge")
    private AndroidElement iconDiabetesSecondType;

    @AndroidFindBy(id = "diabetes_type_dii_badge")
    private AndroidElement buttonIconD2;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView\n")
    private AndroidElement messageD2;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.widget.TextView\n")
    private AndroidElement titleHistory;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[1]\n")
    private AndroidElement titleDayToday;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"patient_record_0\"])[1]")
    private AndroidElement buttonDayToday;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.widget.TextView")
    private AndroidElement titleViewDay;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[1]\n")
    private AndroidElement buttonDashboard;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n")
    private AndroidElement titleDashboard;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ImageView\n")
    private AndroidElement iconDashboardWithoutRecord;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView")
    private AndroidElement titleDashboardWithoutRecord;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView\n")
    private AndroidElement buttonLetsStarted;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ImageView\n")
    private AndroidElement iconHistoryWithoutRecords;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView")
    private AndroidElement titleHistoryWithoutRecords;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    private AndroidElement buttonLetsStarted2;




    public HistoryPageUser(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

    public void clickButtonHistory(){
        buttonHistory.click();
    }

    public boolean iconDiabetesFirstTypeIsDisplayed() {
        return iconDiabetesFirstType.isDisplayed();
    }

    public void clickButtonIconD1(){
        buttonIconD1.click();
    }

    public String getTextMessageD1(){
        return messageD1.getText();
    }

    public String getTextMessageInfoWithD(){
        return messageInfoWithD.getText();
    }

    public boolean messageD1(){
        Assert.assertEquals(getTextMessageD1(), "Diabetes type I");
        return true;
    }

    public boolean messageInfoWithD(){
        Assert.assertEquals(getTextMessageInfoWithD(), "Since you have a chronic condition, we display an adapted version of the application, emphasizing the most important indicators");
        return true;
    }

    public void action(){
        tap(500, 500);
    }

    public boolean iconDiabetesSecondTypeIsDisplayed() {
        return iconDiabetesSecondType.isDisplayed();
    }

    public void clickButtonIconD2(){
        buttonIconD2.click();
    }

    public String getTextMessageD2(){
        return messageD2.getText();
    }

    public boolean messageD2(){
        Assert.assertEquals(getTextMessageD2(), "Diabetes type II");
        return true;
    }

    public String getTextTitleHistory(){
        return titleHistory.getText();
    }

    public boolean titleHistory(){
        Assert.assertEquals(getTextTitleHistory(), "Recording history");
        return true;
    }

    public String getTextTitleDayToday(){
        return titleDayToday.getText();
    }

    public boolean titleDayToday(){
        Assert.assertEquals(getTextTitleDayToday(), recordsHistoryDateMonth() + " " + recordsHistoryDateDay());
        return true;
    }

    public void clickButtonDayToday(){
        buttonDayToday.click();
    }

    public String getTextTitleViewDay(){
        return titleViewDay.getText();
    }

    public boolean titleViewDay(){
        Assert.assertEquals(getTextTitleViewDay(), "Result");
        return true;
    }

    public void clickButtonDashboard(){
        buttonDashboard.click();
    }

    public String getTextTitleDashboard(){
        return titleDashboard.getText();
    }

    public boolean titleDashboard(){
        Assert.assertEquals(getTextTitleDashboard(), "Dashboard");
        return true;
    }

    public boolean iconDashboardWithoutRecordIsDisplayed() {
        return iconDashboardWithoutRecord.isDisplayed();
    }

    public String getTextTitleDashboardWithoutRecord(){
        return titleDashboardWithoutRecord.getText();
    }

    public boolean titleDashboardWithoutRecord(){
        Assert.assertEquals(getTextTitleDashboardWithoutRecord(), "You still don't have any recording");
        return true;
    }

    public void clickButtonLetsStarted(){
        buttonLetsStarted.click();
    }

    public boolean iconHistoryWithoutRecordsIsDisplayed() {
        return iconHistoryWithoutRecords.isDisplayed();
    }

    public String getTextTitleHistoryWithoutRecords(){
        return titleHistoryWithoutRecords.getText();
    }

    public boolean titleHistoryWithoutRecords(){
        Assert.assertEquals(getTextTitleHistoryWithoutRecords(), "You still don't have any recording");
        return true;
    }

    public void clickButtonLetsStarted2(){
        buttonLetsStarted2.click();
    }

    public boolean viewHistoryUserWithDT1() throws InterruptedException {
        clickButtonHistory();
        //sleepTime(2000);
        if(iconDiabetesFirstTypeIsDisplayed()) {
            clickButtonIconD1();
            //sleepTime(2000);
            if(messageD1() && messageInfoWithD()){
                action();
                //sleepTime(2000);
                return true;
            }
        }
        return false;
    }

    public boolean viewHistoryUserWithDT2() throws InterruptedException {
        clickButtonHistory();
        //sleepTime(2000);
        if(iconDiabetesSecondTypeIsDisplayed()) {
            clickButtonIconD2();
            //sleepTime(2000);
            if(messageD2() && messageInfoWithD()){
                action();
                //sleepTime(2000);
                return true;
            }
        }
        return false;
    }

    public boolean  viewHistoryUserDemo() throws InterruptedException {
        clickButtonHistory();
        sleepTime(2000);
        if(titleHistory() && titleDayToday()) {
            sleepTime(2000);
            verticalSwipe(400, 1200, 400, 500);
            sleepTime(2000);
            scroll(recordsHistoryDateMonth() + " " + recordsHistoryDateDay());
            //verticalSwipe(400, 400, 1300, 500);
            return true;
        }
        return false;
    }

    public boolean  viewDayHistoryUserDemo() throws InterruptedException {
        clickButtonDayToday();
        sleepTime(2000);
        if(titleViewDay()) {
            sleepTime(2000);
            clickComeBack();
            sleepTime(2000);
            if(titleHistory()) {
                return true;
            }
        }
        return false;
    }

    public boolean  viewDashboardUser() throws InterruptedException {
        clickButtonDashboard();
        //sleepTime(2000);
        if(titleDashboard() && iconDashboardWithoutRecordIsDisplayed() && titleDashboardWithoutRecord()){
            clickButtonLetsStarted();
            //sleepTime(2000);
            if(messagePageUser()){
                return true;
            }
        }
        return false;
    }

    public boolean  viewHistoryUser() throws InterruptedException {
        clickButtonHistory();
        //sleepTime(2000);
        if(titleHistory() && iconHistoryWithoutRecordsIsDisplayed() && titleHistoryWithoutRecords()){
            clickButtonLetsStarted2();
            //sleepTime(2000);
            if(messagePageUser()){
                return true;
            }
        }
        return false;
    }

}
