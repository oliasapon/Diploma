import com.github.javafaker.Faker;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class MainTest {
    private AndroidDriver<AndroidElement> androidDriver;

    @BeforeClass
    public void init() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.cardiolyse");
        desiredCapabilities.setCapability("appActivity", ".MainActivity");

        androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(10000, 30);
    }

    @Test
    public void test1_openSignPage() {
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(), true);
    }

    public String newEmail() {
        DateFormat pattern = new SimpleDateFormat("ddMMHHmm"); //y
        Date todayDate = Calendar.getInstance().getTime();
        String formatDate = pattern.format(todayDate);
        String newMail = "mailForTest" + formatDate + "@gmail.com";
        return newMail;
    }

    public String recordsHistoryDateDay() {
        /*DateFormat pattern = new SimpleDateFormat("dd"); //y
        Date todayDate = Calendar.getInstance().getTime();
        String formatDate = pattern.format(todayDate);
        String historyDate = formatDate;
        String newHistoryDate;
        char[] chArray = historyDate.toCharArray();
            if(chArray[0] == '0') {
                newHistoryDate = historyDate.substring(1);
            }
            else {
                newHistoryDate = historyDate;
            }*/

        GregorianCalendar gcalendar = new GregorianCalendar();
        String date = String.valueOf(gcalendar.get(Calendar.DATE));
        return date;
    }

    public String recordsHistoryDateMonth() {
        Calendar calendar = Calendar.getInstance();
        String month = calendar.getDisplayName(Calendar.MONTH,
                Calendar.LONG_FORMAT, new Locale("eng"));
        return month;
    }

    /*int Date;
    int Month;
    int Year;

    public static void main(String args[]) {

        Calendar calendar = Calendar.getInstance();

        Date = calendar.get(Calendar.DAY_OF_MONTH);
        Month = calendar.get(Calendar.MONTH);
        Year = calendar.get(Calendar.YEAR);*/

    public String newPassword() {
        Random random = new Random();
        final String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        String newPassword = "";
        int index = 0;
        for (int i = 0; i < 8; i++) {
            index = random.nextInt(symbols.length());
            newPassword += symbols.charAt(index);
        }
        return newPassword;
    }

    public String newName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public String newSurname() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    @Test//(enabled = false/*, priority = 2*/)
    public void test2_signUpUserWithoutDiabetes() throws InterruptedException {
        MobileElement linkSignUp = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_form_sign_up_text\"]/android.widget.TextView\n");
        linkSignUp.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"role_select_screen\"]/android.widget.TextView[1]\n").getText(), "I am");

        MobileElement buttonUser = (MobileElement) androidDriver.findElementById("sign_up_role_plate_patient");
        buttonUser.click();
        MobileElement buttonContinue1 = (MobileElement) androidDriver.findElementById("role_select_submit_button");
        buttonContinue1.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"chronic_condition_select_screen\"]/android.widget.TextView[1]\n").getText(), "Diabetes");
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_chronic_condition_absent\"]/android.widget.TextView[1]\n").isDisplayed(), true);

        MobileElement buttonContinue2 = (MobileElement) androidDriver.findElementById("chronic_condition_select_screen_submit_button");
        buttonContinue2.click();

        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_up_email");
        inputEmail.click();
        String email = newEmail();
        String name = newName();
        String surname = newSurname();
        //inputEmail.setValue(name+"."+surname+"@gmail.com");
        inputEmail.setValue(email);
        MobileElement inputFirstName = (MobileElement) androidDriver.findElementById("sign_up_firstname");
        inputFirstName.click();
        inputFirstName.setValue(name);
        MobileElement inputLastName = (MobileElement) androidDriver.findElementById("sign_up_lastname");
        inputLastName.click();
        inputLastName.setValue(surname);
        MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_up_password");
        inputPassword.click();
        String password = newPassword();
        inputPassword.setValue(password);
        MobileElement inputConfirmPassword = (MobileElement) androidDriver.findElementById("sign_up_confirm_password");
        inputConfirmPassword.click();
        inputConfirmPassword.setValue(password);

        androidDriver.hideKeyboard();
        MobileElement buttonAgree = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.Switch");
        buttonAgree.click();
        MobileElement buttonSignUp = (MobileElement) androidDriver.findElementById("sign_up_button");
        buttonSignUp.click();

        Assert.assertEquals(androidDriver.findElementById("android:id/alertTitle").getText(), "Success");
        Assert.assertEquals(androidDriver.findElementById("android:id/message").getText(), "Your account has been created");
        MobileElement buttonOk = (MobileElement) androidDriver.findElementById("android:id/button1");
        buttonOk.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(), true);
    }

    @Test
    public void test3_signUpUserWithDiabetesFirstType() throws InterruptedException {
        MobileElement linkSignUp = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_form_sign_up_text\"]/android.widget.TextView\n");
        linkSignUp.click();

        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"role_select_screen\"]/android.widget.TextView[1]\n").getText(), "I am");

        MobileElement buttonUser = (MobileElement) androidDriver.findElementById("sign_up_role_plate_patient");
        buttonUser.click();
        MobileElement buttonContinue1 = (MobileElement) androidDriver.findElementById("role_select_submit_button");
        buttonContinue1.click();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"chronic_condition_select_screen\"]/android.widget.TextView[1]\n").getText(), "Diabetes");

        MobileElement buttonDiabetes = (MobileElement) androidDriver.findElementById("sign_up_chronic_condition_exists");
        buttonDiabetes.click();
        MobileElement buttonContinue2 = (MobileElement) androidDriver.findElementById("chronic_condition_select_screen_submit_button");
        buttonContinue2.click();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"chronic_condition_type_select_screen\"]/android.widget.TextView[1]").getText(), "Type of diabetes");
        MobileElement buttonTypeDiabetes = (MobileElement) androidDriver.findElementById("diabetes_type_one_plate");
        buttonTypeDiabetes.click();
        MobileElement buttonContinue3 = (MobileElement) androidDriver.findElementById("chronic_condition_type_submit");
        buttonContinue3.click();

        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_up_email");
        inputEmail.click();
        String email = newEmail();
        String name = newName();
        String surname = newSurname();
        inputEmail.setValue(email);
        MobileElement inputFirstName = (MobileElement) androidDriver.findElementById("sign_up_firstname");
        inputFirstName.click();
        inputFirstName.setValue(name);
        MobileElement inputLastName = (MobileElement) androidDriver.findElementById("sign_up_lastname");
        inputLastName.click();
        inputLastName.setValue(surname);
        MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_up_password");
        inputPassword.click();
        String password = newPassword();
        inputPassword.setValue(password);
        MobileElement inputConfirmPassword = (MobileElement) androidDriver.findElementById("sign_up_confirm_password");
        inputConfirmPassword.click();
        inputConfirmPassword.setValue(password);

        androidDriver.hideKeyboard();
        MobileElement buttonAgree = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.Switch");
        buttonAgree.click();
        MobileElement buttonSignUp = (MobileElement) androidDriver.findElementById("sign_up_button");
        buttonSignUp.click();

        Assert.assertEquals(androidDriver.findElementById("android:id/alertTitle").getText(), "Success");
        Assert.assertEquals(androidDriver.findElementById("android:id/message").getText(), "Your account has been created");
        MobileElement buttonOk = (MobileElement) androidDriver.findElementById("android:id/button1");
        buttonOk.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(), true);
    }

    @Test
    public void test4_signUpUserWithDiabetesSecondType() throws InterruptedException {
        MobileElement linkSignUp = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_form_sign_up_text\"]/android.widget.TextView\n");
        linkSignUp.click();

        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"role_select_screen\"]/android.widget.TextView[1]\n").getText(), "I am");

        MobileElement buttonUser = (MobileElement) androidDriver.findElementById("sign_up_role_plate_patient");
        buttonUser.click();
        MobileElement buttonContinue1 = (MobileElement) androidDriver.findElementById("role_select_submit_button");
        buttonContinue1.click();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"chronic_condition_select_screen\"]/android.widget.TextView[1]\n").getText(), "Diabetes");

        MobileElement buttonDiabetes = (MobileElement) androidDriver.findElementById("sign_up_chronic_condition_exists");
        buttonDiabetes.click();
        MobileElement buttonContinue2 = (MobileElement) androidDriver.findElementById("chronic_condition_select_screen_submit_button");
        buttonContinue2.click();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"chronic_condition_type_select_screen\"]/android.widget.TextView[1]").getText(), "Type of diabetes");
        MobileElement buttonTypeDiabetes = (MobileElement) androidDriver.findElementById("diabetes_type_two_plate");
        buttonTypeDiabetes.click();
        MobileElement buttonContinue3 = (MobileElement) androidDriver.findElementById("chronic_condition_type_submit");
        buttonContinue3.click();

        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_up_email");
        inputEmail.click();
        String email = newEmail();
        String name = newName();
        String surname = newSurname();
        inputEmail.setValue(email);
        MobileElement inputFirstName = (MobileElement) androidDriver.findElementById("sign_up_firstname");
        inputFirstName.click();
        inputFirstName.setValue(name);
        MobileElement inputLastName = (MobileElement) androidDriver.findElementById("sign_up_lastname");
        inputLastName.click();
        inputLastName.setValue(surname);
        MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_up_password");
        inputPassword.click();
        String password = newPassword();
        inputPassword.setValue(password);
        MobileElement inputConfirmPassword = (MobileElement) androidDriver.findElementById("sign_up_confirm_password");
        inputConfirmPassword.click();
        inputConfirmPassword.setValue(password);

        androidDriver.hideKeyboard();
        MobileElement buttonAgree = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.Switch");
        buttonAgree.click();
        MobileElement buttonSignUp = (MobileElement) androidDriver.findElementById("sign_up_button");
        buttonSignUp.click();

        Assert.assertEquals(androidDriver.findElementById("android:id/alertTitle").getText(), "Success");
        Assert.assertEquals(androidDriver.findElementById("android:id/message").getText(), "Your account has been created");
        MobileElement buttonOk = (MobileElement) androidDriver.findElementById("android:id/button1");
        buttonOk.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(), true);
    }

    @Test
    public void test5_forgotPassword() {
        MobileElement linkForgotPassword = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_form_forgot_password_text\"]/android.widget.TextView");
        linkForgotPassword.click();

        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("reset_password_form_email_field");
        inputEmail.click();
        inputEmail.setValue("vasy_999@gmail.com");
        MobileElement buttonSubmit = (MobileElement) androidDriver.findElementById("forgot_password_form_submit_button");
        buttonSubmit.click();

        Assert.assertEquals(androidDriver.findElementById("android:id/alertTitle").getText(), "Success");
        Assert.assertEquals(androidDriver.findElementById("android:id/message").getText(), "Please check your email for a password change link.");
        MobileElement buttonOk = (MobileElement) androidDriver.findElementById("android:id/button1");
        buttonOk.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(), true);
    }

    @Test
    public void test6_signInUser() throws InterruptedException {
        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_in_form_email_field");
        inputEmail.click();
        inputEmail.setValue("olia.sapon@gmail.com");
        MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_in_form_password_field");
        inputPassword.click();
        inputPassword.setValue("12344321");

        MobileElement buttonShowPassword = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n");
        buttonShowPassword.click();
        Thread.sleep(5000, 30);
        buttonShowPassword.click();

        androidDriver.hideKeyboard();
        MobileElement buttonSignIn = (MobileElement) androidDriver.findElementById("sign_in_form_submit_button");
        buttonSignIn.click();

        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.widget.TextView[1]").getText(), "Let's get started");
    }

    @Test
    public void test7_signOutUser() throws InterruptedException {
        MobileElement buttonSettings = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]");
        buttonSettings.click();
        MobileElement linkSignOut = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_out_text\"]/android.widget.TextView");
        linkSignOut.click();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(), true);
    }

    @Test
    public void test8_signUpDoctor() throws InterruptedException {
        MobileElement linkSignUp = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_form_sign_up_text\"]/android.widget.TextView\n");
        linkSignUp.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"role_select_screen\"]/android.widget.TextView[1]\n").getText(), "I am");

        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_role_plate_doctor\"]/android.widget.TextView[1]\n").isDisplayed(), true);
        MobileElement buttonContinue = (MobileElement) androidDriver.findElementById("role_select_submit_button");
        buttonContinue.click();

        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_up_email");
        inputEmail.click();
        String email = newEmail();
        String name = newName();
        String surname = newSurname();
        inputEmail.setValue(email);
        MobileElement inputFirstName = (MobileElement) androidDriver.findElementById("sign_up_firstname");
        inputFirstName.click();
        inputFirstName.setValue(name);
        MobileElement inputLastName = (MobileElement) androidDriver.findElementById("sign_up_lastname");
        inputLastName.click();
        inputLastName.setValue(surname);
        MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_up_password");
        inputPassword.click();
        String password = newPassword();
        inputPassword.setValue(password);
        MobileElement inputConfirmPassword = (MobileElement) androidDriver.findElementById("sign_up_confirm_password");
        inputConfirmPassword.click();
        inputConfirmPassword.setValue(password);

        androidDriver.hideKeyboard();
        MobileElement buttonAgree = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.Switch");
        buttonAgree.click();
        MobileElement buttonSignUp = (MobileElement) androidDriver.findElementById("sign_up_button");
        buttonSignUp.click();

        Assert.assertEquals(androidDriver.findElementById("android:id/alertTitle").getText(), "Success");
        Assert.assertEquals(androidDriver.findElementById("android:id/message").getText(), "Your account has been created");
        MobileElement buttonOk = (MobileElement) androidDriver.findElementById("android:id/button1");
        buttonOk.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(), true);
    }

    @Test
    public void test9_signInDoctor() throws InterruptedException {
        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_in_form_email_field");
        inputEmail.click();
        inputEmail.setValue("aria34@gmail.com");
        MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_in_form_password_field");
        inputPassword.click();
        inputPassword.setValue("doctorAria34");

        MobileElement buttonShowPassword = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n");
        buttonShowPassword.click();
        Thread.sleep(5000, 30);
        buttonShowPassword.click();

        androidDriver.hideKeyboard();
        MobileElement buttonSignIn = (MobileElement) androidDriver.findElementById("sign_in_form_submit_button");
        buttonSignIn.click();

        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.widget.TextView\n").getText(), "Records history");

        MobileElement buttonSettings = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]");
        buttonSettings.click();
        MobileElement linkSignOut = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_out_text\"]/android.widget.TextView\n");
        linkSignOut.click();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(), true);

    }

    @Test
    public void test10_signOutDoctor() throws InterruptedException {
        MobileElement buttonSettings = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]");
        buttonSettings.click();
        MobileElement linkSignOut = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_out_text\"]/android.widget.TextView\n");
        linkSignOut.click();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(), true);
    }

    @Test
    public void test11_liveDemoUser() throws InterruptedException {
        MobileElement buttonLiveDemo = (MobileElement) androidDriver.findElementById("live_demo_button");
        buttonLiveDemo.click();
        MobileElement buttonUser = (MobileElement) androidDriver.findElementById("sign_up_role_plate_patient");
        buttonUser.click();
        Thread.sleep(9000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]\n").isEnabled(), true);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n").getText(), "Dashboard");
        Assert.assertEquals(androidDriver.findElementById("dashboard_week_period_tab").isEnabled(), true);
    }

    @Test
    public void test12_userDemoViewDashboard() throws InterruptedException {
        //DELETE
        MobileElement buttonLiveDemo = (MobileElement) androidDriver.findElementById("live_demo_button");
        buttonLiveDemo.click();
        MobileElement buttonUser = (MobileElement) androidDriver.findElementById("sign_up_role_plate_patient");
        buttonUser.click();
        //----------------------------------------------------
        Thread.sleep(2000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+"Energy score"+"\").instance(0))");

        /*String uiSelector = "new UiSelector().textMatches(\"" + "Energy score" + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ uiSelector + ");";
        Thread.sleep(5000, 30);
        androidDriver.findElementByAndroidUIAutomator(command);
        uiSelector = "new UiSelector().textMatches(\"" + "Overall wellbeing" + "\")";
        String command1 = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ uiSelector + ");";
        Thread.sleep(5000, 30);
        androidDriver.findElementByAndroidUIAutomator(command1);*/

        Thread.sleep(2000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().textContains(\""+"Overall wellbeing"+"\").instance(0))");

        MobileElement buttonMonth = (MobileElement) androidDriver.findElementById("dashboard_month_period_tab");
        buttonMonth.click();
        Thread.sleep(2000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+"Energy score"+"\").instance(0))");
        Thread.sleep(2000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().textContains(\""+"Overall wellbeing"+"\").instance(0))");

        MobileElement buttonYear = (MobileElement) androidDriver.findElementById("dashboard_year_period_tab");
        buttonYear.click();
        Thread.sleep(5000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+"Energy score"+"\").instance(0))");
        Thread.sleep(2000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().textContains(\""+"Overall wellbeing"+"\").instance(0))");

        //androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Risk of heart disorders" + "\").instance(0))");
        //androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().textContains(\""+"Sep"+"\").instance(0))");
        //androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "87" + "\").instance(0))");
    }

    @Test
    public void test13_userDemoViewHistory() throws InterruptedException {
        MobileElement buttonHistory = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[2]\n");
        buttonHistory.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.widget.TextView\n").getText(),
                "Recording history");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n").getText(),
                recordsHistoryDateMonth() + " " + recordsHistoryDateDay());
    }

    @Test
    public void test14_userDemoHistoryNormalState() throws InterruptedException {
        //DELETE
        MobileElement buttonLiveDemo = (MobileElement) androidDriver.findElementById("live_demo_button");
        buttonLiveDemo.click();
        MobileElement buttonUser = (MobileElement) androidDriver.findElementById("sign_up_role_plate_patient");
        buttonUser.click();
        //----------------------------------------------------
        Thread.sleep(10000, 30);
        MobileElement buttonHistory = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[2]\n");
        buttonHistory.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.widget.TextView\n").getText(),
                "Recording history");
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+"Apr 6"+"\").instance(0))");
        MobileElement buttonHistoryForNormalApr6 = (MobileElement) androidDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"patient_record_0\"])[1]");
        buttonHistoryForNormalApr6.click();

        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.widget.TextView").getText(),
                "Result");
        MobileElement buttonOverallWellbeing78Info = (MobileElement) androidDriver.findElementById("overall_plate_78");
        buttonOverallWellbeing78Info.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
                "Overall heart wellbeing score is a general estimation of your current physical and emotional wellbeing on the scale from ideal state (100-75%) to a bit imbalanced (75-50%) and moderately imbalanced (50-25%).");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]").getText(),
                "Heart general conditions and your functional conditions (ANS) are normal.");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]\n").getText(),
                "Enjoy your life and please take the measurements on a regular basis.");
        //MobileElement buttonGetOutOfInfo = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.widget.ScrollView/android.view.ViewGroup");
        //buttonGetOutOfInfo.click();

        /*TouchAction action = new TouchAction(androidDriver);
        action.press(50, 50);
        action.release();
        action.perform();*/
        new TouchAction(androidDriver).tap(PointOption.point(50,50)).perform();


        //ok

    }


    @Test
    public void test1_liveDemoDoctor() throws InterruptedException {
        MobileElement buttonLiveDemo = (MobileElement) androidDriver.findElementById("live_demo_button");
        buttonLiveDemo.click();
        MobileElement buttonDoctor = (MobileElement) androidDriver.findElementById("sign_up_role_plate_doctor");
        buttonDoctor.click();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup[1]\n").isEnabled(), true);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.widget.TextView\n").getText(), "Records history");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n").getText(), recordsHistoryDateMonth() + " " + recordsHistoryDateDay());
    }


}
