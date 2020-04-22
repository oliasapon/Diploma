package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.testng.Assert;

public class HistoryPageDoctor extends LiveDemoPage{

    Dimension size = androidDriver.manage().window().getSize();

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[1]\n")
    private AndroidElement buttonHistoryDoctor;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"history_record_0\"])[1]")
    private AndroidElement buttonViewDataFirstPatient;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"average_qrs_chart\"]/android.widget.TextView\n")
    private AndroidElement titlePatientFirstPage;

    @AndroidFindBy(id = "container")
    private AndroidElement buttonIncreaseSizeDiagram;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"raw_ecg_screen\"]/android.view.ViewGroup[1]/android.widget.Spinner[1]\n")
    private AndroidElement buttonValueMMs;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]")
    private AndroidElement buttonValueMMs12;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"raw_ecg_screen\"]/android.view.ViewGroup[1]/android.widget.Spinner[2]")
    private AndroidElement buttonValueMMmv;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[5]")
    private AndroidElement buttonValueMMmv50;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"compress_button\"]/android.widget.TextView")
    private AndroidElement buttonClose;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"detailed_report_button\"]/android.widget.TextView\n")
    private AndroidElement buttonViewDetails;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"detailed_report_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n")
    private AndroidElement titleDetail;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"detailed_report_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView[1]\n")
    private AndroidElement buttonOpenOverall;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"detailed_report_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView[2]\n")
    private AndroidElement buttonOpenSearch;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"detailed_report_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]\n")
    private AndroidElement buttonOpenStaminaScore;

    public HistoryPageDoctor(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

    public void clickButtonHistoryDoctor(){
        buttonHistoryDoctor.click();
    }

    public boolean viewHistoryDoctorDemo() throws InterruptedException {
        //Dimension size = androidDriver.manage().window().getSize();
        verticalSwipe((int) (size.width / 2.0), (int) (size.height * 0.8), (int) (size.height * 0.2), 500);
        sleepTime(2000);
        if(scroll(recordsHistoryDateMonth() + " " + recordsHistoryDateDay())) {
            //androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + recordsHistoryDateMonth() + " " + recordsHistoryDateDay() + "\").instance(0))");
            return true;
        }
        return false;
    }

    public void clickButtonViewDataFirstPatient() throws InterruptedException {
        buttonViewDataFirstPatient.click();
    }

    public String getTextTitlePatientFirstPage(){
        return titlePatientFirstPage.getText();
    }

    public boolean titlePatientFirstPage(){
        Assert.assertEquals(getTextTitlePatientFirstPage(), "Average QRS complex");
        return true;
    }


    public boolean viewHistoryDayFirstPatientDoctorDemo() throws InterruptedException {
        clickButtonViewDataFirstPatient();
        sleepTime(2000);
        if(titlePatientFirstPage()){
            return true;
        }
        return false;
    }

    public void clickButtonIncreaseSizeDiagram(){
        buttonIncreaseSizeDiagram.click();
    }

    public void clickButtonValueMMs(){
        buttonValueMMs.click();
    }

    public void clickButtonValueMMs12(){
        buttonValueMMs12.click();
    }

    public void clickButtonValueMMmv(){
        buttonValueMMmv.click();
    }

    public void clickButtonValueMMmv50(){
        buttonValueMMmv50.click();
    }

    public void clickButtonClose(){
        buttonClose.click();
    }

    public boolean viewHistoryDiagramDoctorDemo() throws InterruptedException {
        clickButtonIncreaseSizeDiagram();
        sleepTime(2000);
        clickButtonValueMMs();
        clickButtonValueMMs12();
        //sleepTime(2000);
        clickButtonValueMMmv();
        clickButtonValueMMmv50();
        sleepTime(2000);
        //Dimension size = androidDriver.manage().window().getSize();
        horizontalSwipe((int) (size.width * 0.9), (int) (size.width * 0.1), (int) (size.height / 2.0), 500);
        //sleepTime(2000);
        clickButtonClose();
        //sleepTime(2000);
        if(titlePatientFirstPage()){
            return true;
        }
        return false;
    }

    public boolean viewHistoryDayDoctorDemo() throws InterruptedException {
        //Dimension size = androidDriver.manage().window().getSize();
        verticalSwipe((int) (size.width / 2.0), (int) (size.height * 0.8), (int) (size.height * 0.2), 500);
        sleepTime(3000);
        horizontalSwipe((int) (size.width * 0.8), (int) (size.width * 0.2), (int) (size.height / 2.0), 500);
        sleepTime(3000);
        horizontalSwipe((int) (size.width * 0.8), (int) (size.width * 0.2), (int) (size.height / 2.0), 500);
        sleepTime(3000);
        verticalSwipe((int) (size.width / 2.0), (int) (size.height * 0.7), (int) (size.height * 0.2), 500);
        return true;
    }

    public void clickButtonViewDetails(){
        buttonViewDetails.click();
    }

    public String getTextTitleDetail(){
        return titleDetail.getText();
    }

    public boolean titleDetail(){
        Assert.assertEquals(getTextTitleDetail(), "Detailed report");
        return true;
    }

    public void clickButtonOpenOverall(){
        buttonOpenOverall.click();
    }

    public void clickButtonOpenSearch(){
        buttonOpenSearch.click();
    }

    public void clickButtonOpenStaminaScore(){
        buttonOpenStaminaScore.click();
    }

    public boolean viewHistoryDetailsDoctorDemo() throws InterruptedException {
        clickButtonViewDetails();
        //sleepTime(2000);
        if(titleDetail()){
            clickButtonOpenOverall();
            //sleepTime(2000);
            clickButtonOpenStaminaScore();
            //sleepTime(2000);
            verticalSwipe((int) (size.width / 2.0), (int) (size.height * 0.9), (int) (size.height * 0.2), 500);
            //sleepTime(2000);
            if(scroll("Detailed report")){
                //sleepTime(2000);
                clickComeBack();
                //sleepTime(2000);
                clickComeBack();
                //sleepTime(2000);
                if(titleHistoryDoctor()){
                    return true;
                }
            }
        }
        return false;
    }

     /*@AndroidFindBy(xpath = "")
    private AndroidElement;
    @AndroidFindBy(id = "")
    private AndroidElement;*/

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]\n")
    private AndroidElement titleNotRecords;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]\n")
    private AndroidElement titleCanGo;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView\n")
    private AndroidElement linkRecordPage;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView")
    private AndroidElement titleSelectPatient;

    public String getTextTitleNotRecords(){
        return titleNotRecords.getText();
    }

    public boolean titleNotRecords(){
        Assert.assertEquals(getTextTitleNotRecords(), "Looks like you don't have any records");
        return true;
    }

    public String getTextTitleCanGo(){
        return titleCanGo.getText();
    }

    public boolean titleCanGo(){
        Assert.assertEquals(getTextTitleCanGo(), "You can go to ");
        return true;
    }

    public String getTextLinkRecordPage(){
        return linkRecordPage.getText();
    }

    public boolean linkRecordPage(){
        Assert.assertEquals(getTextLinkRecordPage(), "Record page");
        return true;
    }

    public void clickLinkRecordPage(){
        linkRecordPage.click();
    }

    public String getTextTitleSelectPatient(){
        return titleSelectPatient.getText();
    }

    public boolean titleSelectPatient(){
        Assert.assertEquals(getTextTitleSelectPatient(), "Select patient");
        return true;
    }

    public boolean viewHistoryDoctor() throws InterruptedException {
        if(messagePageDoctor() && titleNotRecords() && titleCanGo() && linkRecordPage()){
            clickLinkRecordPage();
            //sleepTime(2000);
            if(titleSelectPatient()){
                return true;
            }
        }
        return false;
    }


}
