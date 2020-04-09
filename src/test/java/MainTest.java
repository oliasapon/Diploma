import com.github.javafaker.Faker;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import io.appium.java_client.touch.WaitOptions;
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
    String overallEdmondHalley;

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
    public void test01_openSignPage() {
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
        //System.out.print(date);
        return date;
    }

    public String recordsHistoryDateMonth() {
        Calendar calendar = Calendar.getInstance();
        String month = calendar.getDisplayName(Calendar.MONTH,
                Calendar.LONG_FORMAT, new Locale("eng"));
        //System.out.print(month);
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

    /*  @Test//(enabled = false, priority = 2)
      public void test02_signUpUserWithoutDiabetes() throws InterruptedException {
          MobileElement linkSignUp = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_form_sign_up_text\"]/android.widget.TextView\n");
          linkSignUp.click();
          Thread.sleep(3000, 30);
          Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"role_select_screen\"]/android.widget.TextView[1]\n").getText(), "I am");

          Thread.sleep(5000, 30);
          MobileElement buttonUser = (MobileElement) androidDriver.findElementById("sign_up_role_plate_patient");
          buttonUser.click();
          Thread.sleep(5000, 30);
          MobileElement buttonContinue1 = (MobileElement) androidDriver.findElementById("role_select_submit_button");
          buttonContinue1.click();
          Thread.sleep(5000, 30);
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
      public void test03_signUpUserWithDiabetesFirstType() throws InterruptedException {
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
      public void test04_signUpUserWithDiabetesSecondType() throws InterruptedException {
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
      public void test05_forgotPassword() {
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
  */
    @Test
    public void test06_signInUser() throws InterruptedException {
        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_in_form_email_field");
        inputEmail.click();
        inputEmail.setValue("olia.sapon@gmail.com");
        MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_in_form_password_field");
        inputPassword.click();
        inputPassword.setValue("12344321");

        MobileElement buttonShowPassword = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]");
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
    public void test07_signOutUser() throws InterruptedException {
        MobileElement buttonSettings = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]");
        buttonSettings.click();
        MobileElement linkSignOut = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_out_text\"]/android.widget.TextView");
        linkSignOut.click();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(), true);
    }

    @Test
    public void test08_signUpDoctor() throws InterruptedException {
        MobileElement linkSignUp = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_form_sign_up_text\"]/android.widget.TextView\n");
        linkSignUp.click();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"role_select_screen\"]/android.widget.TextView[1]\n").getText(), "I am");
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_role_plate_doctor\"]/android.widget.TextView[1]\n").isDisplayed(), true);
        MobileElement buttonContinue = (MobileElement) androidDriver.findElementById("role_select_submit_button");
        buttonContinue.click();
        Thread.sleep(5000, 30);
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
    public void test09_signInDoctor() throws InterruptedException {
        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_in_form_email_field");
        inputEmail.click();
        inputEmail.setValue("aria34@gmail.com");
        MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_in_form_password_field");
        inputPassword.click();
        inputPassword.setValue("doctorAria34");


        MobileElement buttonShowPassword = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]");
        buttonShowPassword.click();
        Thread.sleep(5000, 30);
        buttonShowPassword.click();

        androidDriver.hideKeyboard();
        MobileElement buttonSignIn = (MobileElement) androidDriver.findElementById("sign_in_form_submit_button");
        buttonSignIn.click();

        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.widget.TextView\n").getText(), "Records history");

    }

    @Test
    public void test10_signOutDoctor() throws InterruptedException {
        MobileElement buttonSettings = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]");
        buttonSettings.click();
        MobileElement linkSignOut = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_out_text\"]/android.widget.TextView\n");
        linkSignOut.click();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(), true);
        Thread.sleep(5000, 30);
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
        //-------------------------------------
        /*String uiSelector = "new UiSelector().textMatches(\"" + "Energy score" + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ uiSelector + ");";
        Thread.sleep(5000, 30);
        androidDriver.findElementByAndroidUIAutomator(command);
        uiSelector = "new UiSelector().textMatches(\"" + "Overall wellbeing" + "\")";
        String command1 = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("+ uiSelector + ");";
        Thread.sleep(5000, 30);
        androidDriver.findElementByAndroidUIAutomator(command1);*/
//----------------------------------

        TouchAction actionWithTouch = new TouchAction(androidDriver);
        Dimension size = androidDriver.manage().window().getSize();
        int anchor = (int) (size.height / 2.0);
        int startPoint = (int) (size.width * 0.1);
        int endPoint = (int) (size.width * 0.9);
        TouchAction horizontalSwipe = actionWithTouch
                .press(PointOption.point(startPoint, anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endPoint, anchor))
                .release();
        Thread.sleep(5000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Energy score" + "\").instance(0))");
        Thread.sleep(2000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Overall wellbeing" + "\").instance(0))");

        MobileElement buttonMonth = (MobileElement) androidDriver.findElementById("dashboard_month_period_tab");
        buttonMonth.click();
        Thread.sleep(5000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Energy score" + "\").instance(0))");
        Thread.sleep(2000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Overall wellbeing" + "\").instance(0))");
        horizontalSwipe.perform();

        TouchAction horizontalSwipe1 = actionWithTouch
                .press(PointOption.point(startPoint, anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endPoint, anchor))
                .release();
        MobileElement buttonYear = (MobileElement) androidDriver.findElementById("dashboard_year_period_tab");
        buttonYear.click();
        Thread.sleep(5000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Energy score" + "\").instance(0))");
        Thread.sleep(2000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Overall wellbeing" + "\").instance(0))");
        horizontalSwipe1.perform();
    }

    @Test
    public void test13_userDemoViewHistory() throws InterruptedException {

        MobileElement buttonHistory = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[2]\n");
        buttonHistory.click();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.widget.TextView\n").getText(),
                "Recording history");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[1]\n").getText(),
                recordsHistoryDateMonth() + " " + recordsHistoryDateDay());
        Thread.sleep(2000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Apr 1" + "\").instance(0))");
        Thread.sleep(2000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + recordsHistoryDateMonth() + " " + recordsHistoryDateDay() + "\").instance(0))");
    }

    @Test
    public void test14_userDemoHistoryViewDay() throws InterruptedException {
        MobileElement buttonHistoryForDay = (MobileElement) androidDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"patient_record_0\"])[1]");
        buttonHistoryForDay.click();
        //overallEdmondHalley = androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"overall_plate_78\"]/android.widget.TextView[3]\n").getText();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.widget.TextView").getText(),
                "Result");
        Thread.sleep(5000, 30);
        MobileElement buttonComeBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView");
        buttonComeBack.click();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.widget.TextView\n").getText(),
                "Recording history");
    }

    /*@Test
    public void test14_userDemoHistoryNormalState() throws InterruptedException {

        MobileElement buttonHistoryForNormal = (MobileElement) androidDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"patient_record_0\"])[1]");
        buttonHistoryForNormal.click();
        //overallEdmondHalley = androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"overall_plate_78\"]/android.widget.TextView[3]\n").getText();
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

        TouchAction actionWithTouch = new TouchAction(androidDriver);
        actionWithTouch.tap(PointOption.point(100,100)).release().perform();

        MobileElement buttonEnergyScore75Info = (MobileElement) androidDriver.findElementById("stamina_plate_75");
        buttonEnergyScore75Info.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
                "Stamina is a measure of the total adaptive capacities of your body. This indicator is based on various parameters of Heart Rate Variability. Heart Rate Variability (HRV) - multilevel autonomic regulation of heart rate.");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]").getText(),
                "There are no alarm symptoms.");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]\n").getText(),
                "Please take the measurements on a regular basis.");
        actionWithTouch.tap(PointOption.point(100,100)).release().perform();

        MobileElement buttonMyocardiumScore84Info = (MobileElement) androidDriver.findElementById("myocardium_plate_84");
        buttonMyocardiumScore84Info.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]\n").getText(),
                "No heart muscle disturbance is revealed. Good news.");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[4]\n").getText(),
                "Please take the measurements on the regular basis.");
        actionWithTouch.tap(PointOption.point(100,100)).release().perform();

        MobileElement buttonEmotionScoreSignificantDisorderInfo = (MobileElement) androidDriver.findElementById("emotional_plate_22");
        buttonEmotionScoreSignificantDisorderInfo.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView\n").getText(),
                "Emotional Score reflects the state of your unconscious emotions.");
        actionWithTouch.tap(PointOption.point(100,100)).release().perform();

        MobileElement buttonRiskOfHearDisordersVeryLowInfo = (MobileElement) androidDriver.findElementById("heart_risk_plate_1");
        buttonRiskOfHearDisordersVeryLowInfo.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
                "Risk of heart disorders is an integral score reflecting the probability of sudden cardiac death based on HRV and ECG time and amplitude parameters.");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]").getText(),
                "Probability of heart disorders is very low.");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]\n").getText(),
                "Enjoy your life and please take the measurements on a regular basis.");
        actionWithTouch.tap(PointOption.point(100,100)).release().perform();

        MobileElement buttonStressLevelNormalInfo = (MobileElement) androidDriver.findElementById("stress_plate_82");
        buttonStressLevelNormalInfo.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
                "Stress is a physical, mental, or emotional factor that causes bodily or mental tension. Stress Index measures physiological stress, which has proven to be a reliable predictor of future health problems in cases of prolonged high physiological stress levels.");
        actionWithTouch.tap(PointOption.point(100,100)).release().perform();

        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"heart_age_plate_27_37\"]/android.widget.TextView[1]\n").getText(),
                "Heart biological age");

        Thread.sleep(2000, 30);
        MobileElement buttonComeBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView");
        buttonComeBack.click();

        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.widget.TextView\n").getText(),
                "Recording history");
    }*/

    /*@Test
    public void test15_userDemoHistoryMildDisorderState() throws InterruptedException {
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+"Apr 5"+"\").instance(0))");
        MobileElement buttonHistoryForNormalApr5 = (MobileElement) androidDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"patient_record_0\"])[2]");
        buttonHistoryForNormalApr5.click();

        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.widget.TextView").getText(),
                "Result");


        MobileElement buttonOverallWellbeing64Info = (MobileElement) androidDriver.findElementById("overall_plate_64");
        buttonOverallWellbeing64Info.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
                "Overall heart wellbeing score is a general estimation of your current physical and emotional wellbeing on the scale from ideal state (100-75%) to a bit imbalanced (75-50%) and moderately imbalanced (50-25%).");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]").getText(),
                "Heart general conditions and your functional conditions (ANS) are slightly decreased.");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]\n").getText(),
                "Take the measurements at least once per day when you do your routine actions or activities.");


        TouchAction actionWithTouch = new TouchAction(androidDriver);
        //action.press(50, 50);
        actionWithTouch.tap(PointOption.point(100,100)).release().perform();
        //new TouchAction(androidDriver).tap(PointOption.point(200,200)).release().perform();

        MobileElement buttonEnergyScore35Info = (MobileElement) androidDriver.findElementById("stamina_plate_35");
        buttonEnergyScore35Info.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
                "Stamina is a measure of the total adaptive capacities of your body. This indicator is based on various parameters of Heart Rate Variability. Heart Rate Variability (HRV) - multilevel autonomic regulation of heart rate.");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]").getText(),
                "Abnormalities are revealed that may indicate cardiac disease.");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]\n").getText(),
                "You need to schedule a visit to the doctor within a short time. Please send your ECG to your doctor ASAP. Take the measurements not less than twice per day.");
        actionWithTouch.tap(PointOption.point(100,100)).release().perform();

        MobileElement buttonMyocardiumScore82Info = (MobileElement) androidDriver.findElementById("myocardium_plate_82");
        buttonMyocardiumScore82Info.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]\n").getText(),
                "No heart muscle disturbance is revealed. Good news.");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[4]\n").getText(),
                "Please take the measurements on the regular basis.");
        actionWithTouch.tap(PointOption.point(100,100)).release().perform();


        //MobileElement buttonRiskOfHearDisordersInfo = (MobileElement) androidDriver.findElementById("heart_risk_plate_1");
        //buttonRiskOfHearDisordersInfo.click();
        //Assert.assertEquals(androidDriver.findElementByXPath("").getText(),
        //        "");
        //Assert.assertEquals(androidDriver.findElementByXPath("").getText(),
        //        "");
        //Assert.assertEquals(androidDriver.findElementByXPath("").getText(),
        //        "");
        //actionWithTouch.tap(PointOption.point(100,100)).release().perform();


        MobileElement buttonEmotionScoreNormalInfo = (MobileElement) androidDriver.findElementById("emotional_plate_100");
        buttonEmotionScoreNormalInfo.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
                "Emotional Score reflects the state of your unconscious emotions.");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]").getText(),
                "You are in good balance of mind. Congratulations!");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]\n").getText(),
                "Enjoy your life and please take the measurements on a regular basis.");
        actionWithTouch.tap(PointOption.point(100,100)).release().perform();


        MobileElement buttonRiskOfHearDisordersVeryLowInfo = (MobileElement) androidDriver.findElementById("heart_risk_plate_1");
        buttonRiskOfHearDisordersVeryLowInfo.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
                "Risk of heart disorders is an integral score reflecting the probability of sudden cardiac death based on HRV and ECG time and amplitude parameters.");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]").getText(),
                "Probability of heart disorders is very low.");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]\n").getText(),
                "Enjoy your life and please take the measurements on a regular basis.");
        actionWithTouch.tap(PointOption.point(100,100)).release().perform();



        MobileElement buttonStressLevelSevereDisorderInfo = (MobileElement) androidDriver.findElementById("stress_plate_1073");
        buttonStressLevelSevereDisorderInfo.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
                "Stress is a physical, mental, or emotional factor that causes bodily or mental tension. Stress Index measures physiological stress, which has proven to be a reliable predictor of future health problems in cases of prolonged high physiological stress levels.");
        actionWithTouch.tap(PointOption.point(100,100)).release().perform();

        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"heart_age_plate_18_29\"]/android.widget.TextView[1]\n").getText(),
                "Heart biological age");

        Thread.sleep(2000, 30);
        MobileElement buttonComeBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView");
        buttonComeBack.click();

        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.widget.TextView\n").getText(),
                "Recording history");
    }*/

    @Test
    public void test16_userDemoGetStartedView() throws InterruptedException {
        MobileElement buttonGetStarted = (MobileElement) androidDriver.findElementById("record_screen_bottom_tab");
        buttonGetStarted.click();
        Thread.sleep(2000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]\n").isDisplayed(),
                true);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
                "Hello!");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]\n").getText(),
                "Let's register your account as a doctor or patient");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"demo_modal_sign_up_button\"]/android.widget.TextView\n").getText(),
                "Sign up");
    }

    @Test
    public void test17_userDemoGetStartedSignUp() throws InterruptedException {
        Thread.sleep(2000, 30);
        MobileElement buttonSignUp = (MobileElement) androidDriver.findElementById("demo_modal_sign_up_button");
        buttonSignUp.click();
        Thread.sleep(2000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
                "I agree to");
        MobileElement buttonComeBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView");
        buttonComeBack.click();
    }

    @Test
    public void test18_userDemoGetStartedTap() throws InterruptedException {
        MobileElement buttonLiveDemo = (MobileElement) androidDriver.findElementById("live_demo_button");
        buttonLiveDemo.click();
        MobileElement buttonUser = (MobileElement) androidDriver.findElementById("sign_up_role_plate_patient");
        buttonUser.click();

        MobileElement buttonGetStarted = (MobileElement) androidDriver.findElementById("record_screen_bottom_tab");
        buttonGetStarted.click();
        Thread.sleep(2000, 30);
        TouchAction actionWithTouch = new TouchAction(androidDriver);
        actionWithTouch
                .tap(PointOption.point(100, 100))
                .release().perform();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n").getText(),
                "Dashboard");
    }

    @Test
    public void test19_userDemoMyDoctorView() throws InterruptedException {
        MobileElement buttonMyDoctor = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[4]");
        buttonMyDoctor.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup\n").isDisplayed(),
                true);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView\n").isDisplayed(),
                true);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
                "My doctor");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]").getText(),
                "This page is under construction");
    }

    @Test
    public void test20_userDemoSettingsViewLognOut() throws InterruptedException {
        //Thread.sleep(2000, 30);
        MobileElement buttonSettings = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]");
        buttonSettings.click();
        MobileElement linkSignOut = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_out_text\"]/android.widget.TextView\n");
        linkSignOut.click();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(),
                true);
    }

    @Test
    public void test21_liveDemoDoctor() throws InterruptedException {
        MobileElement buttonLiveDemo = (MobileElement) androidDriver.findElementById("live_demo_button");
        buttonLiveDemo.click();
        MobileElement buttonDoctor = (MobileElement) androidDriver.findElementById("sign_up_role_plate_doctor");
        buttonDoctor.click();
        Thread.sleep(5000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup[1]\n").isEnabled(),
                true);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.widget.TextView\n").getText(),
                "Records history");
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n").getText(),
                recordsHistoryDateMonth() + " " + recordsHistoryDateDay());
    }

    @Test
    public void test22_doctorDemoHistoryView() throws InterruptedException {
        Assert.assertEquals(androidDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"history_record_0\"])[1]/android.widget.TextView").getText(),
                "Edmond Halley");
        Assert.assertEquals(androidDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"history_record_1\"])[1]/android.widget.TextView").getText(),
                "Johannes Kepler");
        Assert.assertEquals(androidDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"history_record_2\"])[1]/android.widget.TextView").getText(),
                "Sarah Boysen");

        TouchAction actionWithTouch = new TouchAction(androidDriver);
        Dimension size = androidDriver.manage().window().getSize();
        int anchor = (int) (size.width / 2.0);
        int startPoint = (int) (size.height * 0.8);
        int endPoint = (int) (size.height * 0.2);
        TouchAction verticalSwipe = actionWithTouch
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();
        Thread.sleep(2000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + recordsHistoryDateMonth() + " " + recordsHistoryDateDay() + "\").instance(0))");
    }

    @Test
    public void test23_doctorDemoHistoryViewDayFirstPerson() throws InterruptedException {
        MobileElement buttonViewDataFirstPerson = (MobileElement) androidDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"history_record_0\"])[1]");
        buttonViewDataFirstPerson.click();
        Thread.sleep(2000, 30);

        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"average_qrs_chart\"]/android.widget.TextView\n").getText(),
                "Average QRS complex");

    }

    @Test
    public void test24_doctorDemoHistoryViewDiagram() throws InterruptedException {

        MobileElement buttonIncreaseSize = (MobileElement) androidDriver.findElementById("container");
        buttonIncreaseSize.click();
        Thread.sleep(2000, 30);
        MobileElement buttonValueMMs = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"raw_ecg_screen\"]/android.view.ViewGroup[1]/android.widget.Spinner[1]\n");
        buttonValueMMs.click();
        MobileElement buttonValueMMs12 = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]");
        buttonValueMMs12.click();
        MobileElement buttonValueMMmv = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"raw_ecg_screen\"]/android.view.ViewGroup[1]/android.widget.Spinner[2]");
        buttonValueMMmv.click();
        MobileElement buttonValueMMs50 = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[5]");
        buttonValueMMs50.click();
        Thread.sleep(2000, 30);
        TouchAction actionWithTouch = new TouchAction(androidDriver);
        Dimension size = androidDriver.manage().window().getSize();
        int anchor = (int) (size.height / 2.0);
        int startPoint = (int) (size.width * 0.9);
        int endPoint = (int) (size.width * 0.1);
        TouchAction horizontalSwipe = actionWithTouch
                .press(PointOption.point(startPoint, anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endPoint, anchor))
                .release();
        horizontalSwipe.perform();
        Thread.sleep(2000, 30);
        MobileElement buttonClose = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"compress_button\"]/android.widget.TextView");
        buttonClose.click();
        Thread.sleep(1000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"average_qrs_chart\"]/android.widget.TextView\n").getText(),
                "Average QRS complex");
    }

    @Test
    public void test25_doctorDemoHistoryViewDay() throws InterruptedException {
        TouchAction actionWithTouch = new TouchAction(androidDriver);
        Dimension size = androidDriver.manage().window().getSize();
        int anchor = (int) (size.width / 2.0);
        int startPoint = (int) (size.height * 0.8);
        int endPoint = (int) (size.height * 0.2);
        TouchAction verticalSwipe = actionWithTouch
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();
        anchor = (int) (size.height / 2.0);
        startPoint = (int) (size.width * 0.8);
        endPoint = (int) (size.width * 0.2);
        TouchAction horizontalSwipe1 = actionWithTouch
                .press(PointOption.point(startPoint, anchor))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endPoint, anchor))
                .release();

        Thread.sleep(2000, 30);
        horizontalSwipe1.perform();
        Thread.sleep(2000, 30);

        anchor = (int) (size.width / 2.0);
        startPoint = (int) (size.height * 0.6);
        endPoint = (int) (size.height * 0.2);
        TouchAction verticalSwipe1 = actionWithTouch
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release();
        verticalSwipe1.perform();
    }

    @Test
    public void test26_doctorDemoHistoryViewDetails() throws InterruptedException {

        MobileElement buttonViewDetails = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"detailed_report_button\"]/android.widget.TextView\n");
        buttonViewDetails.click();
        Thread.sleep(2000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"detailed_report_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n").getText(),
                "Detailed report");
        //MobileElement buttonOpenOverall = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"detailed_report_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView[1]\n");
        //buttonOpenOverall.click();

        /*Thread.sleep(2000, 30);
        MobileElement inputSearch = (MobileElement) androidDriver.findElementById("detailed_report_search_field");
        inputSearch.click();
        inputSearch.setValue("Emotional index");
        androidDriver.hideKeyboard();
        Thread.sleep(2000, 30);
        TouchAction actionWithTouch = new TouchAction(androidDriver);
        actionWithTouch
                .tap(PointOption.point(110,510))
                .release().perform();
        //MobileElement buttonOpenSearch = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"detailed_report_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView[2]\n");
        //buttonOpenSearch.click();
        MobileElement buttonOpenEmotionalScore = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"detailed_report_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]\n");
        buttonOpenEmotionalScore.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"detailed_report_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView").getText(),
                "Emotional index");
        Thread.sleep(2000, 30);
        MobileElement buttonClearSearch = (MobileElement) androidDriver.findElementById("clear_search_field_button");
        buttonClearSearch.click();*/

        Thread.sleep(2000, 30);
        MobileElement buttonOpenSearch = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"detailed_report_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView[2]\n");
        buttonOpenSearch.click();
        MobileElement buttonOpenStaminaScore = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"detailed_report_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]\n");
        buttonOpenStaminaScore.click();

        Thread.sleep(2000, 30);
        TouchAction actionWithTouch = new TouchAction(androidDriver);
        Dimension size = androidDriver.manage().window().getSize();
        int anchor = (int) (size.width / 2.0);
        int startPoint = (int) (size.height * 0.9);
        int endPoint = (int) (size.height * 0.2);
        TouchAction verticalSwipe = actionWithTouch
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();

        Thread.sleep(2000, 30);
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Detailed report" + "\").instance(0))");

        MobileElement buttonComeBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView\n");
        buttonComeBack.click();
        //MobileElement buttonBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView\n");
        Thread.sleep(2000, 30);
        buttonComeBack.click();
        Thread.sleep(2000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.widget.TextView\n").getText(),
                "Records history");

    }

    @Test
    public void test27_doctorDemoViewPatients() throws InterruptedException {
        MobileElement buttonPatients = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[2]\n");
        buttonPatients.click();
        MobileElement buttonFilter = (MobileElement) androidDriver.findElementById("patients_filter_button");
        buttonFilter.click();
        MobileElement buttonFemale = (MobileElement) androidDriver.findElementById("female_pick");
        buttonFemale.click();
        Thread.sleep(2000, 30);
        TouchAction actionOne = new TouchAction(androidDriver);
        actionOne.press(PointOption.point(900, 850)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(600, 850)).release().perform();
        MobileElement buttonGroup = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patients_filter\"]/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup\n");
        buttonGroup.click();
        buttonFilter.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_sarah\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView\n").getText(),
                "T2DM");
    }

    @Test
    public void test28_doctorDemoViewOnePatient() throws InterruptedException {
        MobileElement buttonChoosePatient = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_sarah\"]/android.view.ViewGroup\n");
        buttonChoosePatient.click();
        Thread.sleep(2000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_profile_screen\"]/android.widget.TextView[1]\n").getText(),
                "Sarah Boysen");
        TouchAction actionOne = new TouchAction(androidDriver);
        actionOne.press(PointOption.point(500, 1700)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(500, 890)).release().perform();
        MobileElement buttonChart = (MobileElement) androidDriver.findElementById("patient_chart_tab_button");
        buttonChart.click();
        Thread.sleep(2000, 30);
        actionOne.press(PointOption.point(100, 1200)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(900, 1200)).release().perform();
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Flattening of T waves" + "\").instance(0))");
        MobileElement buttonAbout = (MobileElement) androidDriver.findElementById("patient_about_tab_button");
        buttonAbout.click();
        MobileElement buttonComeBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView\n");
        buttonComeBack.click();
    }

    @Test
    public void test29_doctorDemoViewGroups() throws InterruptedException {
        MobileElement buttonGroups = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[4]\n");
        buttonGroups.click();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView\n").getText(),
                "Groups");

        MobileElement buttonShowPatients = (MobileElement) androidDriver.findElementById("group_T2DM");
        buttonShowPatients.click();
        Thread.sleep(2000, 30);
        TouchAction actionOne = new TouchAction(androidDriver);
        actionOne.tap(PointOption.point(200, 800)).release().perform();
        /*MobileElement buttonShowPatient = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_sarah\"]/android.view.ViewGroup\n");
        buttonShowPatient.click();*/
        Thread.sleep(2000, 30);
        MobileElement buttonComeBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView\n");
        buttonComeBack.click();
        Thread.sleep(2000, 30);
        MobileElement buttonCollapseGroups = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.TextView\n");
        buttonCollapseGroups.click();
        MobileElement buttonCreateGroup = (MobileElement) androidDriver.findElementById("open_group_creating_button");
        buttonCreateGroup.click();
        Thread.sleep(2000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]\n").getText(),
                "Let's register your account as doctor to create group");
        actionOne.tap(PointOption.point(200, 200)).release().perform();

        MobileElement inputGroupName = (MobileElement) androidDriver.findElementById("groups_search_field");
        inputGroupName.click();
        inputGroupName.setValue("D1");
        androidDriver.hideKeyboard();
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ImageView\n").isDisplayed(),
                true);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]").getText(),
                "Did not find groups with name");
        /*Thread.sleep(1000, 30);
        inputGroupName.clear();
        androidDriver.hideKeyboard();
        Thread.sleep(2000, 30);*/

        /* MobileElement button = (MobileElement) androidDriver.findElementByXPath("");
        button.click(); */
    }

    @Test
    public void test30_doctorSetting() throws InterruptedException {
        //DELETE
        MobileElement buttonLiveDemo = (MobileElement) androidDriver.findElementById("live_demo_button");
        buttonLiveDemo.click();
        MobileElement buttonDoctor = (MobileElement) androidDriver.findElementById("sign_up_role_plate_doctor");
        buttonDoctor.click();
        Thread.sleep(5000, 30);
        //--------------------------------------------------------------
        MobileElement buttonSettings = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]\n");
        buttonSettings.click();
        MobileElement buttonChartLineColor = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup");
        buttonChartLineColor.click();
        Thread.sleep(2000, 30);
        MobileElement buttonChooseChartLineColor = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]\n");
        buttonChooseChartLineColor.click();
        MobileElement buttonSave = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[9]");
        buttonSave.click();

        MobileElement buttonChartGridColor = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup");
        buttonChartGridColor.click();
        Thread.sleep(2000, 30);
        MobileElement buttonChooseChartGridColor = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]");
        buttonChooseChartGridColor.click();
        //buttonSave = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[9]");
        buttonSave.click();

        MobileElement buttonHistory = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[1]");
        buttonHistory.click();

        MobileElement buttonViewDataFirstPerson = (MobileElement) androidDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"history_record_1\"])[1]");
        buttonViewDataFirstPerson.click();
        Thread.sleep(4000, 30);
        MobileElement buttonComeBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView\n");
        buttonComeBack.click();
        buttonSettings.click();
        MobileElement buttonSignOut = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_out_text\"]/android.widget.TextView\n");
        buttonSignOut.click();
        Thread.sleep(2000, 30);
        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(), true);

    }
}