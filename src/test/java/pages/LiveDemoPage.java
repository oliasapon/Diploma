package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.testng.Assert;

public class LiveDemoPage extends SignInPage{

    @AndroidFindBy(id = "live_demo_button")
    private AndroidElement buttonLiveDemo;

    @AndroidFindBy(id = "sign_up_role_plate_patient")
    private AndroidElement buttonUser;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]\n")
    private AndroidElement iconLiveDemo;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n")
    private AndroidElement titleDashboard;

    @AndroidFindBy(id = "dashboard_week_period_tab")
    private AndroidElement iconDashboardWeek;

    @AndroidFindBy(id = "dashboard_month_period_tab")
    private AndroidElement buttonMonth;

    @AndroidFindBy(id = "dashboard_year_period_tab")
    private AndroidElement buttonYear;

    @AndroidFindBy(id = "sign_up_role_plate_doctor")
    private AndroidElement buttonDoctor;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup[1]\n")
    private AndroidElement iconLiveDemoDoctor;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.widget.TextView\n")
    private AndroidElement titleHistoryDoctorDemo;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n")
    private AndroidElement titleDayTodayDoctor;

    public LiveDemoPage(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

    public void clickButtonLiveDemo(){
        buttonLiveDemo.click();
    }

    public void clickButtonUser(){
        buttonUser.click();
    }

    public boolean iconLiveDemoIsDisplayed() {
        return iconLiveDemo.isDisplayed();
    }

    public String getTextTitleDashboard(){
        return titleDashboard.getText();
    }

    public boolean titleDashboard(){
        Assert.assertEquals(getTextTitleDashboard(), "Dashboard");
        return true;
    }

    public boolean iconDashboardWeekIsDisplayed() {
        return iconDashboardWeek.isDisplayed();
    }

    public void scrollDashboardDemoUser() throws InterruptedException {
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Energy score" + "\").instance(0))");
        sleepTime(2000);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Overall wellbeing" + "\").instance(0))");
    }

    public void clickButtonMonth(){
        buttonMonth.click();
    }

    public void horizontalSwipeForDashboardDemoUser(){
        Dimension size = androidDriver.manage().window().getSize();
        horizontalSwipe((int) (size.width * 0.1), (int) (size.width * 0.9), (int) (size.height / 2.0), 500);
    }

    public void clickButtonYear(){
        buttonYear.click();
    }

    public void clickButtonDoctor(){
        buttonDoctor.click();
    }

    public boolean iconLiveDemoDoctorIsDisplayed() {
        return iconLiveDemoDoctor.isDisplayed();
    }

    public String getTextTitleHistoryDoctor(){
        return titleHistoryDoctorDemo.getText();
    }

    public boolean titleHistoryDoctor(){
        Assert.assertEquals(getTextTitleHistoryDoctor(), "Records history");
        return true;
    }

    public String getTextTitleDayTodayDoctor(){
        return titleDayTodayDoctor.getText();
    }

    public boolean titleDayTodayDoctor(){
        Assert.assertEquals(getTextTitleDayTodayDoctor(), recordsHistoryDateMonth() + " " + recordsHistoryDateDay());
        return true;
    }

    public boolean openDemoUser() throws InterruptedException {
        clickButtonLiveDemo();
        clickButtonUser();
        sleepTime(3000);
        if(iconLiveDemoIsDisplayed() && titleDashboard() && iconDashboardWeekIsDisplayed()){
            return true;
        }
        return false;
    }

    public boolean demoUserViewDashboard() throws InterruptedException {
        scrollDashboardDemoUser();
        clickButtonMonth();
        sleepTime(3000);
        scrollDashboardDemoUser();
        horizontalSwipeForDashboardDemoUser();
        clickButtonYear();
        sleepTime(3000);
        scrollDashboardDemoUser();
        horizontalSwipeForDashboardDemoUser();
        return true;
    }

    public boolean openDemoDoctor() throws InterruptedException {
        clickButtonLiveDemo();
        clickButtonDoctor();
        sleepTime(3000);
        if(iconLiveDemoDoctorIsDisplayed() && titleHistoryDoctor() && titleDayTodayDoctor()){
            return true;
        }
        return false;
    }

}
