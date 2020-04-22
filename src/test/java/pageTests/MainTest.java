package pageTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageSettings.ConnectionSettings;
import pages.*;

public class MainTest extends ConnectionSettings {

    //private AndroidDriver<AndroidElement> androidDriver;
    /*@BeforeClass
    public void init() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.cardiolyse");
        desiredCapabilities.setCapability("appActivity", ".MainActivity");

        androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        Thread.sleep(10000, 30);
    }*/

    OpenPage openPage;
    RegistrationPage registrationPage;
    SignInPage signInPage;
    HistoryPageUser historyPageUser;
    SettingsPage settingsPage;
    LiveDemoPage liveDemoPage;
    GetStartedPage getStartedPage;
    MyDoctorPage myDoctorPage;
    HistoryPageDoctor historyPageDoctor;
    PatientsPage patientsPage;
    GroupsPage groupsPage;

    @Test
    public void test01_openSignPage() {
        //        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(),
//                true);
        openPage = new OpenPage(androidDriver);
        Assert.assertTrue(openPage.mainPageIsDisplayed());
    }

    /*@Test//(enabled = false, priority = 2)
    public void test02_signUpUserWithoutDiabetes() throws InterruptedException {
        //        MobileElement linkSignUp = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_form_sign_up_text\"]/android.widget.TextView\n");
//        linkSignUp.click();
//        Thread.sleep(3000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"role_select_screen\"]/android.widget.TextView[1]\n").getText(),
//                "I am");
//        Thread.sleep(5000, 30);
//        MobileElement buttonUser = (MobileElement) androidDriver.findElementById("sign_up_role_plate_patient");
//        buttonUser.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_role_plate_patient\"]/android.widget.TextView[1]\n").isDisplayed(),
//                true);
//        Thread.sleep(5000, 30);
//        MobileElement buttonContinue1 = (MobileElement) androidDriver.findElementById("role_select_submit_button");
//        buttonContinue1.click();
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"chronic_condition_select_screen\"]/android.widget.TextView[1]\n").getText(),
//                "Diabetes");
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_chronic_condition_absent\"]/android.widget.TextView[1]\n").isDisplayed(),
//                true);
//        MobileElement buttonContinue2 = (MobileElement) androidDriver.findElementById("chronic_condition_select_screen_submit_button");
//        buttonContinue2.click();
//
//        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_up_email");
//        inputEmail.click();
//        String email = newEmail();
//        String name = newName();
//        String surname = newSurname();
//        inputEmail.setValue(name+"."+surname+"@gmail.com");
//        inputEmail.setValue(email);
//        MobileElement inputFirstName = (MobileElement) androidDriver.findElementById("sign_up_firstname");
//        inputFirstName.click();
//        inputFirstName.setValue(name);
//        MobileElement inputLastName = (MobileElement) androidDriver.findElementById("sign_up_lastname");
//        inputLastName.click();
//        inputLastName.setValue(surname);
//        MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_up_password");
//        inputPassword.click();
//        String password = newPassword();
//        inputPassword.setValue(password);
//        MobileElement inputConfirmPassword = (MobileElement) androidDriver.findElementById("sign_up_confirm_password");
//        inputConfirmPassword.click();
//        inputConfirmPassword.setValue(password);
//
//        androidDriver.hideKeyboard();
//        MobileElement buttonAgree = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.Switch");
//        buttonAgree.click();
//        MobileElement buttonSignUp = (MobileElement) androidDriver.findElementById("sign_up_button");
//        buttonSignUp.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementById("android:id/alertTitle").getText(), "Success");
//        Assert.assertEquals(androidDriver.findElementById("android:id/message").getText(), "Your account has been created");
//        MobileElement buttonOk = (MobileElement) androidDriver.findElementById("android:id/button1");
//        buttonOk.click();
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(),
//                true);
        registrationPage = new RegistrationPage(androidDriver);
        Assert.assertTrue(registrationPage.registrationUserWithoutDiabetes());
    }

    //    public String newEmail() {
//        DateFormat pattern = new SimpleDateFormat("ddMMHHmm"); //y
//        Date todayDate = Calendar.getInstance().getTime();
//        String formatDate = pattern.format(todayDate);
//        String newMail = "mailForTest" + formatDate + "@gmail.com";
//        return newMail;
//    }
//
//    public String recordsHistoryDateDay() {
//        GregorianCalendar gCalendar = new GregorianCalendar();
//        String date = String.valueOf(gCalendar.get(Calendar.DATE));
//        return date;
//    }
//
//    public String recordsHistoryDateMonth() {
//        Calendar calendar = Calendar.getInstance();
//        String month = calendar.getDisplayName(Calendar.MONTH,
//                Calendar.LONG_FORMAT, new Locale("eng"));
//        return month;
//    }
//
//    public String newPassword() {
//        Random random = new Random();
//        final String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
//        String newPassword = "";
//        int index = 0;
//        for (int i = 0; i < 8; i++) {
//            index = random.nextInt(symbols.length());
//            newPassword += symbols.charAt(index);
//        }
//        return newPassword;
//    }
//
//    public String newName() {
//        Faker faker = new Faker();
//        return faker.name().firstName();
//    }
//
//    public String newSurname() {
//        Faker faker = new Faker();
//        return faker.name().lastName();
//    }

    @Test
    public void test03_signUpUserWithDiabetesFirstType() throws InterruptedException {
        //        MobileElement linkSignUp = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_form_sign_up_text\"]/android.widget.TextView\n");
//          linkSignUp.click();
//
//          Thread.sleep(5000, 30);
//          Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"role_select_screen\"]/android.widget.TextView[1]\n").getText(),
//                  "I am");
//          MobileElement buttonUser = (MobileElement) androidDriver.findElementById("sign_up_role_plate_patient");
//          buttonUser.click();
//          Thread.sleep(2000, 30);
//          Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_role_plate_patient\"]/android.widget.TextView[1]\n").isDisplayed(),
//                  true);
//          MobileElement buttonContinue1 = (MobileElement) androidDriver.findElementById("role_select_submit_button");
//          buttonContinue1.click();
//          Thread.sleep(5000, 30);
//          Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"chronic_condition_select_screen\"]/android.widget.TextView[1]\n").getText(),
//                  "Diabetes");
//          MobileElement buttonDiabetes = (MobileElement) androidDriver.findElementById("sign_up_chronic_condition_exists");
//          buttonDiabetes.click();
//          Thread.sleep(2000, 30);
//          Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_chronic_condition_exists\"]/android.widget.TextView[1]").isDisplayed(),
//                  true);
//          MobileElement buttonContinue2 = (MobileElement) androidDriver.findElementById("chronic_condition_select_screen_submit_button");
//          buttonContinue2.click();
//          Thread.sleep(5000, 30);
//          Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"chronic_condition_type_select_screen\"]/android.widget.TextView[1]").getText(),
//                  "Type of diabetes");
//          MobileElement buttonTypeDiabetes = (MobileElement) androidDriver.findElementById("diabetes_type_one_plate");
//          buttonTypeDiabetes.click();
//          Thread.sleep(2000, 30);
//          Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"diabetes_type_one_plate\"]/android.widget.TextView[1]").isDisplayed(),
//                  true);
//          MobileElement buttonContinue3 = (MobileElement) androidDriver.findElementById("chronic_condition_type_submit");
//          buttonContinue3.click();
//
//          MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_up_email");
//          inputEmail.click();
//          String email = newEmail();
//          String name = newName();
//          String surname = newSurname();
//          inputEmail.setValue(name+"."+surname+"@gmail.com");
//          inputEmail.setValue(email);
//          MobileElement inputFirstName = (MobileElement) androidDriver.findElementById("sign_up_firstname");
//          inputFirstName.click();
//          inputFirstName.setValue(name);
//          MobileElement inputLastName = (MobileElement) androidDriver.findElementById("sign_up_lastname");
//          inputLastName.click();
//          inputLastName.setValue(surname);
//          MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_up_password");
//          inputPassword.click();
//          String password = newPassword();
//          inputPassword.setValue(password);
//          MobileElement inputConfirmPassword = (MobileElement) androidDriver.findElementById("sign_up_confirm_password");
//          inputConfirmPassword.click();
//          inputConfirmPassword.setValue(password);
//
//          androidDriver.hideKeyboard();
//          MobileElement buttonAgree = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.Switch");
//          buttonAgree.click();
//          MobileElement buttonSignUp = (MobileElement) androidDriver.findElementById("sign_up_button");
//          buttonSignUp.click();
//          Thread.sleep(2000, 30);
//          Assert.assertEquals(androidDriver.findElementById("android:id/alertTitle").getText(), "Success");
//          Assert.assertEquals(androidDriver.findElementById("android:id/message").getText(), "Your account has been created");
//          MobileElement buttonOk = (MobileElement) androidDriver.findElementById("android:id/button1");
//          buttonOk.click();
//          Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(),
//                  true);
        Assert.assertTrue(registrationPage.registrationUserWithDiabetesFirstType());
    }

    @Test
    public void test04_signUpUserWithDiabetesSecondType() throws InterruptedException {
        //        MobileElement linkSignUp = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_form_sign_up_text\"]/android.widget.TextView\n");
//          linkSignUp.click();
//
//          Thread.sleep(5000, 30);
//          Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"role_select_screen\"]/android.widget.TextView[1]\n").getText(),
//                  "I am");
//          MobileElement buttonUser = (MobileElement) androidDriver.findElementById("sign_up_role_plate_patient");
//          buttonUser.click();
//          Thread.sleep(2000, 30);
//          Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_role_plate_patient\"]/android.widget.TextView[1]\n").isDisplayed(),
//                  true);
//          MobileElement buttonContinue1 = (MobileElement) androidDriver.findElementById("role_select_submit_button");
//          buttonContinue1.click();
//          Thread.sleep(5000, 30);
//          Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"chronic_condition_select_screen\"]/android.widget.TextView[1]\n").getText(),
//                  "Diabetes");
//          MobileElement buttonDiabetes = (MobileElement) androidDriver.findElementById("sign_up_chronic_condition_exists");
//          buttonDiabetes.click();
//          Thread.sleep(2000, 30);
//          Assert.assertEquals(androidDriver.findElementByXPath("\t//android.view.ViewGroup[@content-desc=\"sign_up_chronic_condition_exists\"]/android.widget.TextView[1]").isDisplayed(),
//                  true);
//          MobileElement buttonContinue2 = (MobileElement) androidDriver.findElementById("chronic_condition_select_screen_submit_button");
//          buttonContinue2.click();
//          Thread.sleep(5000, 30);
//          Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"chronic_condition_type_select_screen\"]/android.widget.TextView[1]").getText(),
//                  "Type of diabetes");
//          MobileElement buttonTypeDiabetes = (MobileElement) androidDriver.findElementById("diabetes_type_two_plate");
//          buttonTypeDiabetes.click();
//          Thread.sleep(2000, 30);
//          Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"diabetes_type_two_plate\"]/android.widget.TextView[1]\n").isDisplayed(),
//                  true);
//          MobileElement buttonContinue3 = (MobileElement) androidDriver.findElementById("chronic_condition_type_submit");
//          buttonContinue3.click();
//
//          MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_up_email");
//          inputEmail.click();
//          String email = newEmail();
//          String name = newName();
//          String surname = newSurname();
//          inputEmail.setValue(name+"."+surname+"@gmail.com");
//          inputEmail.setValue(email);
//          MobileElement inputFirstName = (MobileElement) androidDriver.findElementById("sign_up_firstname");
//          inputFirstName.click();
//          inputFirstName.setValue(name);
//          MobileElement inputLastName = (MobileElement) androidDriver.findElementById("sign_up_lastname");
//          inputLastName.click();
//          inputLastName.setValue(surname);
//          MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_up_password");
//          inputPassword.click();
//          String password = newPassword();
//          inputPassword.setValue(password);
//          MobileElement inputConfirmPassword = (MobileElement) androidDriver.findElementById("sign_up_confirm_password");
//          inputConfirmPassword.click();
//          inputConfirmPassword.setValue(password);
//
//          androidDriver.hideKeyboard();
//          MobileElement buttonAgree = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.Switch");
//          buttonAgree.click();
//          MobileElement buttonSignUp = (MobileElement) androidDriver.findElementById("sign_up_button");
//          buttonSignUp.click();
//          Thread.sleep(2000, 30);
//          Assert.assertEquals(androidDriver.findElementById("android:id/alertTitle").getText(), "Success");
//          Assert.assertEquals(androidDriver.findElementById("android:id/message").getText(), "Your account has been created");
//          MobileElement buttonOk = (MobileElement) androidDriver.findElementById("android:id/button1");
//          buttonOk.click();
//          Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(),
//                  true);
        Assert.assertTrue(registrationPage.registrationUserWithDiabetesSecondType());
    }

    @Test
    public void test05_signUpDoctor() throws InterruptedException {
        //        MobileElement linkSignUp = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_form_sign_up_text\"]/android.widget.TextView\n");
//        linkSignUp.click();
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"role_select_screen\"]/android.widget.TextView[1]\n").getText(),
//                "I am");
//        MobileElement buttonDoctor = (MobileElement) androidDriver.findElementById("sign_up_role_plate_doctor");
//        buttonDoctor.click();
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_role_plate_doctor\"]/android.widget.TextView[1]\n").isDisplayed(),
//                true);
//        Thread.sleep(3000, 30);
//        MobileElement buttonContinue = (MobileElement) androidDriver.findElementById("role_select_submit_button");
//        buttonContinue.click();
//        Thread.sleep(5000, 30);
//        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_up_email");
//        inputEmail.click();
//        String email = newEmail();
//        String name = newName();
//        String surname = newSurname();
//        inputEmail.setValue(name+"."+surname+"@gmail.com");
//        inputEmail.setValue(email);
//        MobileElement inputFirstName = (MobileElement) androidDriver.findElementById("sign_up_firstname");
//        inputFirstName.click();
//        inputFirstName.setValue(name);
//        MobileElement inputLastName = (MobileElement) androidDriver.findElementById("sign_up_lastname");
//        inputLastName.click();
//        inputLastName.setValue(surname);
//        MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_up_password");
//        inputPassword.click();
//        String password = newPassword();
//        inputPassword.setValue(password);
//        MobileElement inputConfirmPassword = (MobileElement) androidDriver.findElementById("sign_up_confirm_password");
//        inputConfirmPassword.click();
//        inputConfirmPassword.setValue(password);
//
//        androidDriver.hideKeyboard();
//        MobileElement buttonAgree = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.Switch");
//        buttonAgree.click();
//        MobileElement buttonSignUp = (MobileElement) androidDriver.findElementById("sign_up_button");
//        buttonSignUp.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementById("android:id/alertTitle").getText(),
//                "Success");
//        Assert.assertEquals(androidDriver.findElementById("android:id/message").getText(),
//                "Your account has been created");
//        MobileElement buttonOk = (MobileElement) androidDriver.findElementById("android:id/button1");
//        buttonOk.click();
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(),
//                true);
        Assert.assertTrue(registrationPage.registrationDoctor());
    }

    @Test
    public void test06_forgotPassword() throws InterruptedException {
        //        MobileElement linkForgotPassword = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_form_forgot_password_text\"]/android.widget.TextView");
//        linkForgotPassword.click();
//        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("reset_password_form_email_field");
//        inputEmail.click();
//        inputEmail.setValue("vasy_999@gmail.com");
//        MobileElement buttonSubmit = (MobileElement) androidDriver.findElementById("forgot_password_form_submit_button");
//        buttonSubmit.click();
//
//        Assert.assertEquals(androidDriver.findElementById("android:id/alertTitle").getText(), "Success");
//        Assert.assertEquals(androidDriver.findElementById("android:id/message").getText(), "Please check your email for a password change link.");
//        MobileElement buttonOk = (MobileElement) androidDriver.findElementById("android:id/button1");
//        buttonOk.click();
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(),
//                true);
        Assert.assertTrue(registrationPage.forgotPassword());
    }

    @Test
    public void test07_userSignInWithDT1() throws InterruptedException {
        //        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_in_form_email_field");
//        inputEmail.click();
//        inputEmail.setValue("homka6745@gmail.com");
//        MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_in_form_password_field");
//        inputPassword.click();
//        inputPassword.setValue("lovesport");
//
//        MobileElement buttonShowPassword = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]");
//        buttonShowPassword.click();
//        Thread.sleep(5000, 30);
//        buttonShowPassword.click();
//
//        androidDriver.hideKeyboard();
//        MobileElement buttonSignIn = (MobileElement) androidDriver.findElementById("sign_in_form_submit_button");
//        buttonSignIn.click();
//
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.widget.TextView[1]").getText(),
//                "Let's get started");
        signInPage = new SignInPage(androidDriver);
        Assert.assertTrue(signInPage.signInUserWithDiabetesFirstType());
    }

    @Test
    public void test08_userViewHistoryWithDT1() throws InterruptedException {
        //        MobileElement buttonHistory = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[2]\n");
//        buttonHistory.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementById("diabetes_type_di_badge").isDisplayed(),
//                true);
//        MobileElement buttonIconD1 = (MobileElement) androidDriver.findElementById("diabetes_type_di_badge");
//        buttonIconD1.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView\n").getText(),
//                "Diabetes type I");
//        Assert.assertEquals(androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView\n").getText(),
//                "Since you have a chronic condition, we display an adapted version of the application, emphasizing the most important indicators");
//        TouchAction actionOne = new TouchAction(androidDriver);
//        actionOne.tap(PointOption.point(500, 500)).release().perform();
//        Thread.sleep(2000, 30);
//        MobileElement buttonSettings = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]\n");
//        buttonSettings.click();
//        MobileElement buttonSignOut = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_out_text\"]/android.widget.TextView\n");
//        buttonSignOut.click();
        historyPage = new HistoryPage(androidDriver);
        settingsPage = new SettingsPage(androidDriver);
        Assert.assertTrue(historyPage.viewHistoryUserWithDT1());
        Assert.assertTrue(settingsPage.signOut());
    }

    @Test
    public void test09_userSignInWithDT2() throws InterruptedException {
        //        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_in_form_email_field");
//        inputEmail.click();
//        inputEmail.setValue("jin.tok@gmail.com");
//        MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_in_form_password_field");
//        inputPassword.click();
//        inputPassword.setValue("jinnn888");
//
//        MobileElement buttonShowPassword = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]");
//        buttonShowPassword.click();
//        Thread.sleep(5000, 30);
//        buttonShowPassword.click();
//
//        androidDriver.hideKeyboard();
//        MobileElement buttonSignIn = (MobileElement) androidDriver.findElementById("sign_in_form_submit_button");
//        buttonSignIn.click();
//
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.widget.TextView[1]").getText(),
//                "Let's get started");
        Assert.assertTrue(signInPage.signInUserWithDiabetesSecondType());
    }

    @Test
    public void test10_userViewHistoryWithDT2() throws InterruptedException {
        //        MobileElement buttonHistory = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[2]\n");
//        buttonHistory.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementById("diabetes_type_dii_badge").isEnabled(),
//                true);
//        MobileElement buttonIconD2 = (MobileElement) androidDriver.findElementById("diabetes_type_dii_badge");
//        buttonIconD2.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView\n").getText(),
//                "Diabetes type II");
//        Assert.assertEquals(androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView\n").getText(),
//                "Since you have a chronic condition, we display an adapted version of the application, emphasizing the most important indicators");
//        TouchAction actionOne = new TouchAction(androidDriver);
//        actionOne.tap(PointOption.point(500, 500)).release().perform();
//        Thread.sleep(2000, 30);
//        MobileElement buttonSettings = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]\n");
//        buttonSettings.click();
//        MobileElement buttonSignOut = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_out_text\"]/android.widget.TextView\n");
//        buttonSignOut.click();
        Assert.assertTrue(historyPage.viewHistoryUserWithDT2());
        Assert.assertTrue(settingsPage.signOut());
    }

    @Test
    public void test11_liveDemoUser() throws InterruptedException {
        //        MobileElement buttonLiveDemo = (MobileElement) androidDriver.findElementById("live_demo_button");
//        buttonLiveDemo.click();
//        MobileElement buttonUser = (MobileElement) androidDriver.findElementById("sign_up_role_plate_patient");
//        buttonUser.click();
//        Thread.sleep(9000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]\n").isEnabled(), true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n").getText(), "Dashboard");
//        Assert.assertEquals(androidDriver.findElementById("dashboard_week_period_tab").isEnabled(),
//                true);
        liveDemoPage = new LiveDemoPage(androidDriver);
        Assert.assertTrue(liveDemoPage.openDemoUser());
    }

    @Test
    public void test12_userDemoViewDashboard() throws InterruptedException {
        //        TouchAction actionWithTouch = new TouchAction(androidDriver);
//        Dimension size = androidDriver.manage().window().getSize();
//        int anchor = (int) (size.height / 2.0);
//        int startPoint = (int) (size.width * 0.1);
//        int endPoint = (int) (size.width * 0.9);
//        TouchAction horizontalSwipe = actionWithTouch
//                .press(PointOption.point(startPoint, anchor))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                .moveTo(PointOption.point(endPoint, anchor))
//                .release();
//        Thread.sleep(5000, 30);
//        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Energy score" + "\").instance(0))");
//        Thread.sleep(2000, 30);
//        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Overall wellbeing" + "\").instance(0))");
//
//        MobileElement buttonMonth = (MobileElement) androidDriver.findElementById("dashboard_month_period_tab");
//        buttonMonth.click();
//        Thread.sleep(5000, 30);
//        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Energy score" + "\").instance(0))");
//        Thread.sleep(2000, 30);
//        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Overall wellbeing" + "\").instance(0))");
//        horizontalSwipe.perform();
//
//        TouchAction horizontalSwipe1 = actionWithTouch
//                .press(PointOption.point(startPoint, anchor))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                .moveTo(PointOption.point(endPoint, anchor))
//                .release();
//        MobileElement buttonYear = (MobileElement) androidDriver.findElementById("dashboard_year_period_tab");
//        buttonYear.click();
//        Thread.sleep(6000, 30);
//        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Energy score" + "\").instance(0))");
//        Thread.sleep(2000, 30);
//        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(false).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Overall wellbeing" + "\").instance(0))");
//        horizontalSwipe1.perform();
        Assert.assertTrue(liveDemoPage.demoUserViewDashboard());
    }

    @Test
    public void test13_userDemoViewHistory() throws InterruptedException {
        //                MobileElement buttonHistory = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[2]\n");
//        buttonHistory.click();
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.widget.TextView\n").getText(),
//                "Recording history");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[1]\n").getText(),
//                recordsHistoryDateMonth() + " " + recordsHistoryDateDay());
//        Thread.sleep(2000, 30);
//        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Apr 1" + "\").instance(0))");
//        Thread.sleep(2000, 30);
//        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + recordsHistoryDateMonth() + " " + recordsHistoryDateDay() + "\").instance(0))");
        historyPageUser = new HistoryPageUser(androidDriver);
        Assert.assertTrue(historyPageUser.viewHistoryUserDemo());
    }

    @Test
    public void test14_userDemoHistoryViewDay() throws InterruptedException {
        //        MobileElement buttonHistoryForDay = (MobileElement) androidDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"patient_record_0\"])[1]");
//        buttonHistoryForDay.click();
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_record_result_screen\"]/android.view.ViewGroup[1]/android.widget.TextView").getText(),
//                "Result");
//        Thread.sleep(5000, 30);
//        MobileElement buttonComeBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView");
//        buttonComeBack.click();
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.widget.TextView\n").getText(),
//                "Recording history");
        Assert.assertTrue(historyPageUser.viewDayHistoryUserDemo());
    }

    @Test
    public void test15_userDemoGetStartedView() throws InterruptedException {
        //        MobileElement buttonGetStarted = (MobileElement) androidDriver.findElementById("record_screen_bottom_tab");
//        buttonGetStarted.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]\n").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
//                "Hello!");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]\n").getText(),
//                "Let's register your account as a doctor or patient");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"demo_modal_sign_up_button\"]/android.widget.TextView\n").getText(),
//                "Sign up");
        getStartedPage = new GetStartedPage(androidDriver);
        Assert.assertTrue(getStartedPage.viewGetStartedUserDemo());
    }

    @Test
    public void test16_userDemoGetStartedSignUp() throws InterruptedException {
        //        Thread.sleep(2000, 30);
        //        MobileElement buttonSignUp = (MobileElement) androidDriver.findElementById("demo_modal_sign_up_button");
        //        buttonSignUp.click();
        //        Thread.sleep(2000, 30);
        //        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
        //                "I agree to");
        //        MobileElement buttonComeBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView");
        //        buttonComeBack.click();
        Assert.assertTrue(getStartedPage.getStartedSignUpUserDemo());
    }

    @Test
    public void test17_userDemoGetStartedTap() throws InterruptedException {
        //        MobileElement buttonLiveDemo = (MobileElement) androidDriver.findElementById("live_demo_button");
//        buttonLiveDemo.click();
//        MobileElement buttonUser = (MobileElement) androidDriver.findElementById("sign_up_role_plate_patient");
//        buttonUser.click();
//
//        MobileElement buttonGetStarted = (MobileElement) androidDriver.findElementById("record_screen_bottom_tab");
//        buttonGetStarted.click();
//        Thread.sleep(2000, 30);
//        TouchAction actionWithTouch = new TouchAction(androidDriver);
//        actionWithTouch
//                .tap(PointOption.point(100, 100))
//                .release().perform();
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n").getText(),
//                "Dashboard");
        Assert.assertTrue(liveDemoPage.openDemoUser());
        Assert.assertTrue(getStartedPage.viewGetStartedUserDemo());
        Assert.assertTrue(getStartedPage.viewGetStartedTapUserDemo());
    }

    @Test
    public void test18_userDemoMyDoctorView() throws InterruptedException {
        //        MobileElement buttonMyDoctor = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[4]");
//        buttonMyDoctor.click();
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup\n").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView\n").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
//                "My doctor");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]").getText(),
//                "This page is under construction");
        myDoctorPage = new MyDoctorPage(androidDriver);
        Assert.assertTrue(myDoctorPage.viewMyDoctorUserDemo());
    }

    @Test
    public void test19_userDemoSettingsViewSignOut() throws InterruptedException {
        //        MobileElement buttonSettings = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]");
//        buttonSettings.click();
//        MobileElement linkSignOut = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_out_text\"]/android.widget.TextView\n");
//        linkSignOut.click();
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(),
//                true);
        settingsPage = new SettingsPage(androidDriver);
        Assert.assertTrue(settingsPage.signOut());
    }

    @Test
    public void test20_liveDemoDoctor() throws InterruptedException {
        //        MobileElement buttonLiveDemo = (MobileElement) androidDriver.findElementById("live_demo_button");
//        buttonLiveDemo.click();
//        MobileElement buttonDoctor = (MobileElement) androidDriver.findElementById("sign_up_role_plate_doctor");
//        buttonDoctor.click();
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup[1]\n").isEnabled(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.widget.TextView\n").getText(),
//                "Records history");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n").getText(),
//                recordsHistoryDateMonth() + " " + recordsHistoryDateDay());
        liveDemoPage = new LiveDemoPage(androidDriver);
        Assert.assertTrue(liveDemoPage.openDemoDoctor());
    }

    @Test
    public void test21_doctorDemoHistoryView() throws InterruptedException {
        //        Assert.assertEquals(androidDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"history_record_0\"])[1]/android.widget.TextView").getText(),
//                "Edmond Halley");
//        Assert.assertEquals(androidDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"history_record_1\"])[1]/android.widget.TextView").getText(),
//                "Johannes Kepler");
//        Assert.assertEquals(androidDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"history_record_2\"])[1]/android.widget.TextView").getText(),
//                "Sarah Boysen");
//
//        TouchAction actionWithTouch = new TouchAction(androidDriver);
//        Dimension size = androidDriver.manage().window().getSize();
//        int anchor = (int) (size.width / 2.0);
//        int startPoint = (int) (size.height * 0.8);
//        int endPoint = (int) (size.height * 0.2);
//        TouchAction verticalSwipe = actionWithTouch
//                .press(PointOption.point(anchor, startPoint))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                .moveTo(PointOption.point(anchor, endPoint))
//                .release().perform();
//        Thread.sleep(2000, 30);
//        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + recordsHistoryDateMonth() + " " + recordsHistoryDateDay() + "\").instance(0))");
        historyPageDoctor = new HistoryPageDoctor(androidDriver);
        Assert.assertTrue(historyPageDoctor.viewHistoryDoctorDemo());
    }

    @Test
    public void test22_doctorDemoHistoryViewDayFirstPerson() throws InterruptedException {
        //        Thread.sleep(2000, 30);
//
//        MobileElement buttonViewDataFirstPerson = (MobileElement) androidDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"history_record_0\"])[1]");
//        buttonViewDataFirstPerson.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"average_qrs_chart\"]/android.widget.TextView\n").getText(),
//                "Average QRS complex");
//        Thread.sleep(2000, 30);
        Assert.assertTrue(historyPageDoctor.viewHistoryDayFirstPatientDoctorDemo());
    }

    @Test
    public void test23_doctorDemoHistoryViewDiagram() throws InterruptedException {
        //        MobileElement buttonIncreaseSize = (MobileElement) androidDriver.findElementById("container");
//        buttonIncreaseSize.click();
//        Thread.sleep(2000, 30);
//        MobileElement buttonValueMMs = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"raw_ecg_screen\"]/android.view.ViewGroup[1]/android.widget.Spinner[1]\n");
//        buttonValueMMs.click();
//        MobileElement buttonValueMMs12 = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]");
//        buttonValueMMs12.click();
//        Thread.sleep(2000, 30);
//        MobileElement buttonValueMMmv = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"raw_ecg_screen\"]/android.view.ViewGroup[1]/android.widget.Spinner[2]");
//        buttonValueMMmv.click();
//        MobileElement buttonValueMMs50 = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[5]");
//        buttonValueMMs50.click();
//        Thread.sleep(2000, 30);
//        TouchAction actionWithTouch = new TouchAction(androidDriver);
//        Dimension size = androidDriver.manage().window().getSize();
//        int anchor = (int) (size.height / 2.0);
//        int startPoint = (int) (size.width * 0.9);
//        int endPoint = (int) (size.width * 0.1);
//        TouchAction horizontalSwipe = actionWithTouch
//                .press(PointOption.point(startPoint, anchor))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                .moveTo(PointOption.point(endPoint, anchor))
//                .release();
//        horizontalSwipe.perform();
//        Thread.sleep(2000, 30);
//        MobileElement buttonClose = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"compress_button\"]/android.widget.TextView");
//        buttonClose.click();
//        Thread.sleep(1000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"average_qrs_chart\"]/android.widget.TextView\n").getText(),
//                "Average QRS complex");
        Assert.assertTrue(historyPageDoctor.viewHistoryDiagramDoctorDemo());
    }

    @Test
    public void test24_doctorDemoHistoryViewDay() throws InterruptedException {
        //        TouchAction actionWithTouch = new TouchAction(androidDriver);
//        Dimension size = androidDriver.manage().window().getSize();
//        int anchor = (int) (size.width / 2.0);
//        int startPoint = (int) (size.height * 0.8);
//        int endPoint = (int) (size.height * 0.2);
//        TouchAction verticalSwipe = actionWithTouch
//                .press(PointOption.point(anchor, startPoint))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                .moveTo(PointOption.point(anchor, endPoint))
//                .release().perform();
//        anchor = (int) (size.height / 2.0);
//        startPoint = (int) (size.width * 0.8);
//        endPoint = (int) (size.width * 0.2);
//        TouchAction horizontalSwipe1 = actionWithTouch
//                .press(PointOption.point(startPoint, anchor))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                .moveTo(PointOption.point(endPoint, anchor))
//                .release();
//
//        Thread.sleep(2000, 30);
//        horizontalSwipe1.perform();
//        Thread.sleep(2000, 30);
//
//        anchor = (int) (size.width / 2.0);
//        startPoint = (int) (size.height * 0.6);
//        endPoint = (int) (size.height * 0.2);
//        TouchAction verticalSwipe1 = actionWithTouch
//                .press(PointOption.point(anchor, startPoint))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                .moveTo(PointOption.point(anchor, endPoint))
//                .release();
//        verticalSwipe1.perform();
        Assert.assertTrue(historyPageDoctor.viewHistoryDayDoctorDemo());
    }

    @Test
    public void test25_doctorDemoHistoryViewDetails() throws InterruptedException {
        //        MobileElement buttonViewDetails = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"detailed_report_button\"]/android.widget.TextView\n");
//        buttonViewDetails.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"detailed_report_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n").getText(),
//                "Detailed report");
//        MobileElement buttonOpenOverall = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"detailed_report_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView[1]\n");
//        buttonOpenOverall.click();
//
//
//        Thread.sleep(2000, 30);
//        MobileElement buttonOpenSearch = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"detailed_report_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView[2]\n");
//        buttonOpenSearch.click();
//        MobileElement buttonOpenStaminaScore = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"detailed_report_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]\n");
//        buttonOpenStaminaScore.click();
//
//        Thread.sleep(2000, 30);
//        TouchAction actionWithTouch = new TouchAction(androidDriver);
//        Dimension size = androidDriver.manage().window().getSize();
//        int anchor = (int) (size.width / 2.0);
//        int startPoint = (int) (size.height * 0.9);
//        int endPoint = (int) (size.height * 0.2);
//        TouchAction verticalSwipe = actionWithTouch
//                .press(PointOption.point(anchor, startPoint))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                .moveTo(PointOption.point(anchor, endPoint))
//                .release().perform();
//
//        Thread.sleep(3000, 30);
//        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Detailed report" + "\").instance(0))");
//        Thread.sleep(3000, 30);
//        MobileElement buttonComeBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView\n");
//        buttonComeBack.click();
//        MobileElement buttonBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView\n");
//        Thread.sleep(2000, 30);
//        buttonComeBack.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.widget.TextView\n").getText(),
//                "Records history");
        Assert.assertTrue(historyPageDoctor.viewHistoryDetailsDoctorDemo());
    }

    @Test
    public void test26_doctorDemoViewPatients() throws InterruptedException {
        //        MobileElement buttonPatients = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[2]\n");
//        buttonPatients.click();
//        MobileElement buttonFilter = (MobileElement) androidDriver.findElementById("patients_filter_button");
//        buttonFilter.click();
//        MobileElement buttonFemale = (MobileElement) androidDriver.findElementById("female_pick");
//        buttonFemale.click();
//        Thread.sleep(2000, 30);
//        TouchAction actionOne = new TouchAction(androidDriver);
//        actionOne.press(PointOption.point(900, 850)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(600, 850)).release().perform();
//        MobileElement buttonGroup = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patients_filter\"]/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup\n");
//        buttonGroup.click();
//        buttonFilter.click();
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_sarah\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView\n").getText(),
//                "T2DM");
        patientsPage = new PatientsPage(androidDriver);
        Assert.assertTrue(patientsPage.viewPatientsDoctorDemo());
    }

    @Test
    public void test27_doctorDemoViewOnePatient() throws InterruptedException {
        //        MobileElement buttonChoosePatient = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_sarah\"]/android.view.ViewGroup\n");
//        buttonChoosePatient.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_profile_screen\"]/android.widget.TextView[1]\n").getText(),
//                "Sarah Boysen");
//        TouchAction actionOne = new TouchAction(androidDriver);
//        actionOne.press(PointOption.point(500, 1700)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(500, 890)).release().perform();
//        MobileElement buttonChart = (MobileElement) androidDriver.findElementById("patient_chart_tab_button");
//        buttonChart.click();
//        Thread.sleep(2000, 30);
//        actionOne.press(PointOption.point(100, 1200)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(900, 1200)).release().perform();
//        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Flattening of T waves" + "\").instance(0))");
//        MobileElement buttonAbout = (MobileElement) androidDriver.findElementById("patient_about_tab_button");
//        buttonAbout.click();
//        MobileElement buttonComeBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView\n");
//        buttonComeBack.click();
//        Thread.sleep(2000, 30);
        Assert.assertTrue(patientsPage.viewOnePatientDoctorDemo());
    }

    @Test
    public void test28_doctorDemoNewGroupView() throws InterruptedException {
        //        MobileElement buttonGetStarted = (MobileElement) androidDriver.findElementById("record_screen_bottom_tab");
//        buttonGetStarted.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]\n").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
//                "Hello!");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]\n").getText(),
//                "Let's register your account as a doctor or patient");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"demo_modal_sign_up_button\"]/android.widget.TextView\n").getText(),
//                "Sign up");
        getStartedPage = new GetStartedPage(androidDriver);
        groupsPage = new GroupsPage(androidDriver);
        Assert.assertTrue(groupsPage.viewGroupDoctorDemoForCreatGroup());
        Assert.assertTrue(getStartedPage.viewNewGroupDoctorDemo());
    }

    @Test
    public void test29_doctorDemoNewGroupSignUp() throws InterruptedException {
        //        Thread.sleep(2000, 30);
        //        MobileElement buttonSignUp = (MobileElement) androidDriver.findElementById("demo_modal_sign_up_button");
        //        buttonSignUp.click();
        //        Thread.sleep(2000, 30);
        //        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_up_screen\"]/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
        //                "I agree to");
        //        MobileElement buttonComeBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView");
        //        buttonComeBack.click();
        Assert.assertTrue(getStartedPage.getStartedSignUpUserDemo());
    }

    @Test
    public void test30_doctorDemoNewGroupTap() throws InterruptedException {
        //        MobileElement buttonLiveDemo = (MobileElement) androidDriver.findElementById("live_demo_button");
//        buttonLiveDemo.click();
//        MobileElement buttonUser = (MobileElement) androidDriver.findElementById("sign_up_role_plate_patient");
//        buttonUser.click();
//
//        MobileElement buttonGetStarted = (MobileElement) androidDriver.findElementById("record_screen_bottom_tab");
//        buttonGetStarted.click();
//        Thread.sleep(2000, 30);
//        TouchAction actionWithTouch = new TouchAction(androidDriver);
//        actionWithTouch
//                .tap(PointOption.point(100, 100))
//                .release().perform();
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n").getText(),
//                "Dashboard");
        Assert.assertTrue(liveDemoPage.openDemoDoctor());
        Assert.assertTrue(groupsPage.viewGroupDoctorDemoForCreatGroup());
        Assert.assertTrue(getStartedPage.viewNewGroupTapDoctorDemo());
    }

    @Test
    public void test31_doctorDemoViewGroups() throws InterruptedException {
        //        MobileElement buttonGroups = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[4]\n");
//        buttonGroups.click();
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView\n").getText(),
//                "Groups");
//        MobileElement buttonShowPatients = (MobileElement) androidDriver.findElementById("group_T2DM");
//        buttonShowPatients.click();
//        Thread.sleep(2000, 30);
//        TouchAction actionOne = new TouchAction(androidDriver);
//        actionOne.tap(PointOption.point(200, 800)).release().perform();
//        Thread.sleep(2000, 30);
//        MobileElement buttonComeBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView\n");
//        buttonComeBack.click();
//        Thread.sleep(2000, 30);
//        MobileElement buttonCollapseGroups = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.TextView\n");
//        buttonCollapseGroups.click();
//        MobileElement buttonCreateGroup = (MobileElement) androidDriver.findElementById("open_group_creating_button");
//        buttonCreateGroup.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView[2]\n").getText(),
//                "Let's register your account as doctor to create group");
//        actionOne.tap(PointOption.point(200, 200)).release().perform();
//
//        MobileElement inputGroupName = (MobileElement) androidDriver.findElementById("groups_search_field");
//        inputGroupName.click();
//        inputGroupName.setValue("D1");
//        androidDriver.hideKeyboard();
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ImageView\n").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]").getText(),
//                "Did not find groups with name");
        Assert.assertTrue(groupsPage.viewGroupDoctorDemo());
    }


    @Test
    public void test32_doctorDemoSettings() throws InterruptedException {
        //        MobileElement buttonSettings = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]\n");
//        buttonSettings.click();
//        MobileElement buttonChartLineColor = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup");
//        buttonChartLineColor.click();
//        Thread.sleep(2000, 30);
//        MobileElement buttonChooseChartLineColor = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]\n");
//        buttonChooseChartLineColor.click();
//        MobileElement buttonSave = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[9]");
//        buttonSave.click();
//
//        MobileElement buttonChartGridColor = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup");
//        buttonChartGridColor.click();
//        Thread.sleep(2000, 30);
//        MobileElement buttonChooseChartGridColor = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]");
//        buttonChooseChartGridColor.click();
//        buttonSave.click();
//
//        MobileElement buttonHistory = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[1]");
//        buttonHistory.click();
//
//        MobileElement buttonViewDataFirstPerson = (MobileElement) androidDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"history_record_1\"])[1]");
//        buttonViewDataFirstPerson.click();
//        Thread.sleep(4000, 30);
//        MobileElement buttonComeBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView\n");
//        buttonComeBack.click();
//        buttonSettings.click();
//        MobileElement buttonSignOut = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_out_text\"]/android.widget.TextView\n");
//        buttonSignOut.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(),
//                true);
        settingsPage = new SettingsPage(androidDriver);
        Assert.assertTrue(settingsPage.settingsDoctorDemo());

    }

    @Test
    public void test33_signInUser() throws InterruptedException {
        //        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_in_form_email_field");
//        inputEmail.click();
//        inputEmail.setValue("olia.sapon@gmail.com");
//        MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_in_form_password_field");
//        inputPassword.click();
//        inputPassword.setValue("12344321");
//
//        MobileElement buttonShowPassword = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]");
//        buttonShowPassword.click();
//        Thread.sleep(5000, 30);
//        buttonShowPassword.click();
//
//        androidDriver.hideKeyboard();
//        MobileElement buttonSignIn = (MobileElement) androidDriver.findElementById("sign_in_form_submit_button");
//        buttonSignIn.click();
//
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.widget.TextView[1]").getText(),
//                "Let's get started");
        signInPage = new SignInPage(androidDriver);
        Assert.assertTrue(signInPage.signInUserWithout());
    }

    @Test
    public void test34_userViewFirstCentralPage() throws InterruptedException {
        //        Assert.assertEquals(androidDriver.findElementById("base_line_with_0_record").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.widget.TextView[2]\n").getText(),
//                "If you have an ECG device, you can pair it with your phone here.");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[2]\n").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView").getText(),
//                "Start");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.view.ViewGroup[3]/android.widget.TextView[2]\n").getText(),
//                "No connected device");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"connect_text_button\"]/android.widget.TextView\n").getText(),
//                "Connect");
//        MobileElement buttonVisitorMode = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.widget.Switch");
//        buttonVisitorMode.click();
//        Thread.sleep(2000, 30);
//        buttonVisitorMode.click();
//
//        Thread.sleep(3000, 30);
//        MobileElement buttonConnect = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"connect_text_button\"]/android.widget.TextView\n");
//        buttonConnect.click();
//        Thread.sleep(3000, 30);
//
//        MobileElement buttonAllow = (MobileElement) androidDriver.findElementById("com.android.packageinstaller:id/permission_allow_button");
//        buttonAllow.click();
//        Thread.sleep(3000, 30);
//        buttonAllow.click();
//        Thread.sleep(2000, 30);
        getStartedPage = new GetStartedPage(androidDriver);
        Assert.assertTrue(getStartedPage.viewFirstCentralPageUser());
    }

    @Test
    public void test35_userViewDashboard() throws InterruptedException {
        //        MobileElement buttonDashboard = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[1]\n");
//        buttonDashboard.click();
//        Thread.sleep(3000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("\t//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView").getText(),
//                "Dashboard");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ImageView\n").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView").getText(),
//                "You still don't have any recording");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView\n").getText(),
//                "Let's get started!");
//        MobileElement buttonLetsStarted = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_dashboard_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView\n");
//        buttonLetsStarted.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.widget.TextView[1]").getText(),
//                "Let's get started");
        historyPageUser = new HistoryPageUser(androidDriver);
        Assert.assertTrue(historyPageUser.viewDashboardUser());
    }

    @Test
    public void test36_userViewHistory() throws InterruptedException {
        //        MobileElement buttonHistory = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[2]\n");
//        buttonHistory.click();
//        Thread.sleep(3000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.widget.TextView\n").getText(),
//                "Recording history");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ImageView\n").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView").getText(),
//                "You still don't have any recording");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView\n").getText(),
//                "Let's get started!");
//
//        MobileElement buttonLetsStarted2 = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");
//        buttonLetsStarted2.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.widget.TextView[1]").getText(),
//                "Let's get started");
        Assert.assertTrue(historyPageUser.viewHistoryUser());
    }

    @Test
    public void test37_userViewMyDoctor() throws InterruptedException {
        //        MobileElement buttonMyDoctor = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[4]\n");
//        buttonMyDoctor.click();
//        Thread.sleep(3000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.widget.TextView").getText(),
//                "My doctor");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup/android.view.ViewGroup").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup\n").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView\n").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]").getText(),
//                "My doctor");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]\n").getText(),
//                "This page is under construction");
        myDoctorPage = new MyDoctorPage(androidDriver);
        Assert.assertTrue(myDoctorPage.viewMyDoctorUserDemo());
    }

    @Test
    public void test38_userViewSettings() throws InterruptedException {
        //        MobileElement buttonSetting = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]\n");
//        buttonSetting.click();
//        Thread.sleep(3000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ImageView\n").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[1]\n").getText(),
//                "Olia Sapon");
//        Assert.assertEquals(androidDriver.findElementById("user_olia.sapon@gmail.com").getText(),
//                "olia.sapon@gmail.com");
        settingsPage = new SettingsPage(androidDriver);
        Assert.assertTrue(settingsPage.viewSettingsUser());
    }

    //CHANGE in app!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Test
    public void test39_userEditInformationPatient() throws InterruptedException {
        //        MobileElement buttonEdit = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"edit_user_text\"]/android.widget.TextView\n");
//        buttonEdit.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"edit_user_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView\n").isDisplayed(),
//                true);
//        MobileElement buttonFemale = (MobileElement) androidDriver.findElementById("female_pick");
//        buttonFemale.click();
//        MobileElement buttonOptionalFields = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"edit_user_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]/android.widget.TextView[1]\n");
//        buttonOptionalFields.click();
//        Thread.sleep(2000, 30);
//        TouchAction actionOne = new TouchAction(androidDriver);
//        actionOne.press(PointOption.point(500, 1700)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(500, 190)).release().perform();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"edit_user_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView[2]\n").getText(),
//                "Weight");
//        actionOne.press(PointOption.point(310, 1200)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(235, 1200)).release().perform();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"edit_user_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[2]\n").getText(),
//                "Height");
//        actionOne.press(PointOption.point(700, 1450)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(688, 1450)).release().perform();
//        Thread.sleep(2000, 30);
//        MobileElement buttonUpdateInformation = (MobileElement) androidDriver.findElementById("create_patient_button");
//        buttonUpdateInformation.click();
//        Thread.sleep(2000, 30);
        Assert.assertTrue(settingsPage.editInformationPatientUser());
    }

    @Test
    public void test40_userChangeRole() throws InterruptedException {
        //        MobileElement buttonChangeRoleToDoctor = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView\n");
//        buttonChangeRoleToDoctor.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.widget.TextView").getText(),
//                "Records history");
//        MobileElement buttonSetting = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]\n");
//        buttonSetting.click();
//        Thread.sleep(2000, 30);
//        MobileElement buttonChangeRoleToPatient = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView\n");
//        buttonChangeRoleToPatient.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_pre_measurement_screen\"]/android.widget.TextView[1]").getText(),
//                "Let's get started");
        Assert.assertTrue(settingsPage.changeRolePatientUser());
    }

    @Test
    public void test41_signOutUser() throws InterruptedException {
        //        MobileElement buttonSettings = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]");
//        buttonSettings.click();
//        MobileElement linkSignOut = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_out_text\"]/android.widget.TextView");
//        linkSignOut.click();
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(),
//                true);
        Assert.assertTrue(settingsPage.signOut());
    }


    //Doctor with patients!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Test
    public void test42_signInDoctor() throws InterruptedException {
        //        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_in_form_email_field");
//        inputEmail.click();
//        inputEmail.setValue("aria34@gmail.com");
//        MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_in_form_password_field");
//        inputPassword.click();
//        inputPassword.setValue("doctorAria34");
//
//        MobileElement buttonShowPassword = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]");
//        buttonShowPassword.click();
//        Thread.sleep(5000, 30);
//        buttonShowPassword.click();
//
//        androidDriver.hideKeyboard();
//        MobileElement buttonSignIn = (MobileElement) androidDriver.findElementById("sign_in_form_submit_button");
//        buttonSignIn.click();
//
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.widget.TextView\n").getText(),
//                "Records history");
        //signInPage = new SignInPage(androidDriver);
        signInPage = new SignInPage(androidDriver);
        Assert.assertTrue(signInPage.signInDoctorWithPatients());
    }

    @Test
    public void test43_doctorViewHistory() throws InterruptedException {
        //        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
//                "Looks like you don't have any records");
//        Assert.assertEquals(androidDriver.findElementByXPath("\t//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]\n").getText(),
//                "You can go to ");
//        Assert.assertEquals(androidDriver.findElementByXPath("\t//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView\n").getText(),
//                "Record page");
//        MobileElement linkRecordPage = (MobileElement) androidDriver.findElementByXPath("\t//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView\n");
//        linkRecordPage.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView").getText(),
//                "Select patient");
        historyPageDoctor = new HistoryPageDoctor(androidDriver);
        Assert.assertTrue(historyPageDoctor.viewHistoryDoctor());
    }

    @Test
    public void test44_doctorViewPatients() throws InterruptedException {
        //        MobileElement buttonPatients = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[2]\n");
//        buttonPatients.click();
//        Assert.assertEquals(androidDriver.findElementById("patients_filter_button").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patients_screen\"]/android.view.ViewGroup[2]\n").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patients_screen\"]/android.widget.TextView\n").getText(),
//                "Patients");
//        MobileElement buttonFilter = (MobileElement) androidDriver.findElementById("patients_filter_button");
//        buttonFilter.click();
//        Thread.sleep(2000, 30);
//        buttonFilter.click();
        patientsPage = new PatientsPage(androidDriver);
        Assert.assertTrue(patientsPage.viewPatientsDoctor());
    }

    @Test
    public void test45_doctorCreateNewPatient() throws InterruptedException {
        //        MobileElement buttonCreatePatient = (MobileElement) androidDriver.findElementById("open_create_patient_screen_button");
//        buttonCreatePatient.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_creating_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView\n").getText(),
//                "Create new patient");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_creating_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView\n").isDisplayed(),
//                true);
//        MobileElement buttonMale = (MobileElement) androidDriver.findElementById("male_pick");
//        buttonMale.click();
//        Thread.sleep(2000, 30);
//        MobileElement inputPhoneNumber = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_creating_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.widget.EditText\n");
//        inputPhoneNumber.click();
//        inputPhoneNumber.setValue("377000420");
//        androidDriver.hideKeyboard();
//        Thread.sleep(2000, 30);
//        MobileElement inputName = (MobileElement) androidDriver.findElementById("create_patient_firstname_field");
//        inputName.click();
//        inputName.setValue("Elvin");
//        androidDriver.hideKeyboard();
//        MobileElement inputSurname = (MobileElement) androidDriver.findElementById("create_patient_lastname_field");
//        inputSurname.click();
//        inputSurname.setValue("Team");
//        androidDriver.hideKeyboard();
//        Thread.sleep(2000, 30);
//        TouchAction actionOne = new TouchAction(androidDriver);
//        actionOne.press(PointOption.point(700, 1450)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(688, 1450)).release().perform();
//        Thread.sleep(2000, 30);
//        actionOne.press(PointOption.point(400, 1500)).release().perform();
//
//        Thread.sleep(2000, 30);
//        actionOne.press(PointOption.point(700, 1450)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(700, 400)).release().perform();
//        Thread.sleep(2000, 30);
//        MobileElement buttonSelectGroup = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_creating_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.Spinner[1]");
//        buttonSelectGroup.click();
//        MobileElement buttonChooseGroup = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]\n");
//        buttonChooseGroup.click();
//        Thread.sleep(2000, 30);
//        MobileElement buttonSelectChronicCondition = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_creating_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.Spinner[2]/android.widget.TextView");
//        buttonSelectChronicCondition.click();
//        MobileElement buttonSelectDiabetes = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]\n");
//        buttonSelectDiabetes.click();
//        Thread.sleep(2000, 30);
//        MobileElement buttonSelectType = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_creating_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.Spinner[3]/android.widget.TextView");
//        buttonSelectType.click();
//        MobileElement buttonChooseType1 = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]\n");
//        buttonChooseType1.click();
//
//        Thread.sleep(2000, 30);
//        actionOne.press(PointOption.point(700, 1450)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(700, 400)).release().perform();
//        MobileElement buttonAddNewPatient = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"create_patient_button\"]/android.widget.TextView\n");
//        buttonAddNewPatient.click();
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patients_screen\"]/android.widget.TextView\n").getText(),
//                "Patients");
        Assert.assertTrue(patientsPage.createNewPatientDoctor());
    }


    @Test
    public void test46_doctorEditPatient() throws InterruptedException {
        //        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + "Nic Yan" + "\").instance(0))");
//        MobileElement buttonPatient = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_nic\"]/android.view.ViewGroup/android.widget.TextView\n");
//        buttonPatient.click();
//        Thread.sleep(3000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_profile_screen\"]/android.widget.TextView[1]\n").getText(),
//                "Nic Yan");
//        MobileElement buttonEdit = (MobileElement) androidDriver.findElementByXPath("\t//android.view.ViewGroup[@content-desc=\"patient_edit_button\"]/android.widget.TextView");
//        buttonEdit.click();
//        Thread.sleep(3000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"edit_user_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n").getText(),
//                "Edit information");
//        MobileElement buttonFields = (MobileElement) androidDriver.findElementByXPath("\t//android.view.ViewGroup[@content-desc=\"edit_user_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]");
//        buttonFields.click();
//        Thread.sleep(2000, 30);
//        TouchAction actionOne = new TouchAction(androidDriver);
//        actionOne.press(PointOption.point(700, 1450)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(700, 400)).release().perform();
//        Thread.sleep(2000, 30);
//        MobileElement buttonGroup = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"edit_user_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.Spinner[1]\n");
//        buttonGroup.click();
//        MobileElement buttonSelect = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]");
//        buttonSelect.click();   //   /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]
//        Thread.sleep(3000, 30);
//        TouchAction actionOne = new TouchAction(androidDriver);
//        actionOne.press(PointOption.point(700, 1450)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(700, 400)).release().perform();
//        Thread.sleep(2000, 30);
//        MobileElement buttonUpdate = (MobileElement) androidDriver.findElementById("create_patient_button");
//        buttonUpdate.click();
//        Thread.sleep(3000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_profile_screen\"]/android.view.ViewGroup[4]/android.view.ViewGroup").isDisplayed(),
//                true);
//        MobileElement buttonBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView");
//        buttonBack.click();
//        Thread.sleep(3000, 30);
        Assert.assertTrue(patientsPage.editPatientDoctor());
    }

    @Test
    public void test47_doctorViewCentralPage() throws InterruptedException {
        //        MobileElement buttonCentralPage = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[3]\n");
//        buttonCentralPage.click();
//        TouchAction actionOne = new TouchAction(androidDriver);
//        actionOne.tap(PointOption.point(700, 1000)).release().perform();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("\t//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView\n").getText(),
//                "Select patient");
//        MobileElement buttonAllPatient = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.TextView\n");
//        buttonAllPatient.click();
//        MobileElement buttonFilter = (MobileElement) androidDriver.findElementById("record_patient_filter_button");
//        buttonFilter.click();
//        Thread.sleep(2000, 30);
//        MobileElement buttonMale = (MobileElement) androidDriver.findElementById("male_pick");
//        buttonMale.click();
//        buttonFilter.click();
//        Thread.sleep(2000, 30);
//        MobileElement buttonSearch = (MobileElement) androidDriver.findElementById("record_patients_search_field");
//        buttonSearch.click();
//        buttonSearch.setValue("Vasy");
//        androidDriver.hideKeyboard();
//        MobileElement buttonClear = (MobileElement) androidDriver.findElementById("clear_search_field_button");
//        buttonClear.click();
//        Thread.sleep(2000, 30);
//        MobileElement buttonAdd = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]\n");
//        buttonAdd.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_creating_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView\n").getText(),
//                "Create new patient");
//        MobileElement buttonBack = (MobileElement) androidDriver.findElementByXPath("\t//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView\n");
//        buttonBack.click();
//        Thread.sleep(2000, 30);
        getStartedPage = new GetStartedPage(androidDriver);
        Assert.assertTrue(getStartedPage.viewCentralPageDoctor());
    }

    @Test
    public void test48_doctorViewGroup() throws InterruptedException {
        //        MobileElement buttonGroup = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[4]\n");
//        buttonGroup.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView").getText(),
//                "Groups");
//        TouchAction actionOne = new TouchAction(androidDriver);
//        actionOne.press(PointOption.point(700, 1450)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(700, 400)).release().perform();
//        Thread.sleep(2000, 30);
//        MobileElement buttonLookGroup1 = (MobileElement) androidDriver.findElementById("group_DT2");
//        buttonLookGroup1.click();
//        MobileElement buttonPatient = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_petro\"]/android.view.ViewGroup\n");
//        buttonPatient.click();
//        Thread.sleep(2000, 30);
//
//        MobileElement buttonBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView\n");
//        buttonBack.click();
//        Thread.sleep(2000, 30);
//        actionOne.press(PointOption.point(700, 1450)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(700, 400)).release().perform();
//        Thread.sleep(2000, 30);
//        MobileElement buttonLookGroup2 = (MobileElement) androidDriver.findElementById("group_DT1");
//        buttonLookGroup2.click();
//        Thread.sleep(2000, 30);
//        actionOne.press(PointOption.point(700, 400)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(700, 1400)).release().perform();
//        MobileElement buttonCollapseAllGroup = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView\n");
//        buttonCollapseAllGroup.click();
//        Thread.sleep(2000, 30);
        groupsPage = new GroupsPage(androidDriver);
        Assert.assertTrue(groupsPage.viewGroupDoctor());
    }

    @Test
    public void test49_doctorCreateNewGroup() throws InterruptedException {
        //        MobileElement buttonNewGroup = (MobileElement) androidDriver.findElementById("open_group_creating_button");
//        buttonNewGroup.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"create_group_modal\"]/android.widget.TextView[1]\n").getText(),
//                "Create new group");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"create_group_modal\"]/android.widget.TextView[2]\n").getText(),
//                "Enter group name and add patients in new group");
//        MobileElement inputGroupName = (MobileElement) androidDriver.findElementById("create_group_field");
//        inputGroupName.click();
//        inputGroupName.setValue("WODY");
//        androidDriver.hideKeyboard();
//        Thread.sleep(2000, 30);
//        MobileElement buttonPlusPatientToNewGroup = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"create_group_modal\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView\n");
//        buttonPlusPatientToNewGroup.click();
//        Thread.sleep(2000, 30);
//        MobileElement buttonCreate = (MobileElement) androidDriver.findElementById("create_group_button");
//        buttonCreate.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView").getText(),
//                "Groups");
        Assert.assertTrue(groupsPage.createNewGroupDoctor());
    }

    @Test
    public void test50_signOutDoctor() throws InterruptedException {
        //        MobileElement buttonSettings = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]");
//        buttonSettings.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("\t//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[1]").getText(),
//                "Aria Kilton");
//        Assert.assertEquals(androidDriver.findElementById("user_aria34@gmail.com").getText(),
//                "aria34@gmail.com");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[6]/android.widget.TextView\n").getText(),
//                "Change role to Patient");
//        MobileElement buttonEdit = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"edit_user_text\"]/android.widget.TextView\n");
//        buttonEdit.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"edit_user_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView\n").getText(),
//                "Edit information");
//        MobileElement buttonBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView\n");
//        buttonBack.click();
//        Thread.sleep(2000, 30);
//        MobileElement linkSignOut = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_out_text\"]/android.widget.TextView\n");
//        linkSignOut.click();
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(),
//                true);
        settingsPage = new SettingsPage(androidDriver);
        Assert.assertTrue(settingsPage.signOutDoctor());
    }*/

    //Doctor without patients!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Test
    public void test51_signInDoctorWithoutPatients() throws InterruptedException {
        //        MobileElement inputEmail = (MobileElement) androidDriver.findElementById("sign_in_form_email_field");
//        inputEmail.click();
//        inputEmail.setValue("nick.dobr87@gmail.com");
//        MobileElement inputPassword = (MobileElement) androidDriver.findElementById("sign_in_form_password_field");
//        inputPassword.click();
//        inputPassword.setValue("dobr1987");
//
//        MobileElement buttonShowPassword = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]");
//        buttonShowPassword.click();
//        Thread.sleep(5000, 30);
//        buttonShowPassword.click();
//
//        androidDriver.hideKeyboard();
//        MobileElement buttonSignIn = (MobileElement) androidDriver.findElementById("sign_in_form_submit_button");
//        buttonSignIn.click();
//
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.widget.TextView\n").getText(),
//                "Records history");
        //signInPage = new SignInPage(androidDriver);
        signInPage = new SignInPage(androidDriver);
        Assert.assertTrue(signInPage.signInDoctorWithoutPatients());
    }

    @Test
    public void test52_doctorViewHistoryWOP() throws InterruptedException {
        //        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]\n").getText(),
//                "Looks like you don't have any records");
//        Assert.assertEquals(androidDriver.findElementByXPath("\t//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]\n").getText(),
//                "You can go to ");
//        Assert.assertEquals(androidDriver.findElementByXPath("\t//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView\n").getText(),
//                "Record page");
//        MobileElement linkRecordPage = (MobileElement) androidDriver.findElementByXPath("\t//android.view.ViewGroup[@content-desc=\"records_history_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView\n");
//        linkRecordPage.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView").getText(),
//                "Select patient");
        historyPageDoctor = new HistoryPageDoctor(androidDriver);
        Assert.assertTrue(historyPageDoctor.viewHistoryDoctor());
    }

    @Test
    public void test53_doctorViewPatientsWOP() throws InterruptedException {
        //        MobileElement buttonPatients = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[2]\n");
//        buttonPatients.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementById("patients_filter_button").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patients_screen\"]/android.view.ViewGroup[2]\n").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patients_screen\"]/android.widget.TextView\n").getText(),
//                "Patients");
//        Assert.assertEquals(androidDriver.findElementById("patients_search_fields").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"add_patient_text\"]/android.widget.TextView\n").getText(),
//                "Press ");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patients_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView\n").getText(),
//                "to add your first patient");
        patientsPage = new PatientsPage(androidDriver);
        Assert.assertTrue(patientsPage.viewPatientsWOPDoctor());
    }

    @Test
    public void test54_doctorPressAddPatientsWOP() throws InterruptedException {
        //        MobileElement buttonPress = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"add_patient_text\"]/android.widget.TextView\n");
//        buttonPress.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_creating_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView\n").getText(),
//                "Create new patient");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"patient_creating_screen\"]/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView\n").isDisplayed(),
//                true);
//        MobileElement buttonBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView\n");
//        buttonBack.click();
//        Thread.sleep(2000, 30);
        Assert.assertTrue(patientsPage.pressAddPatientWOPDoctor());
    }

    @Test
    public void test55_doctorViewCentralPageWOP() throws InterruptedException {
        //        MobileElement buttonCentralPage = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[3]\n");
//        buttonCentralPage.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView\n").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView").getText(),
//                "Select patient");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView\n").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"record_patients_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView").getText(),
//                "Quick record");
        getStartedPage = new GetStartedPage(androidDriver);
        Assert.assertTrue(getStartedPage.viewCentralPageWOPDoctor());
    }

    @Test
    public void test56_doctorViewCentralPageWOPWithTap() throws InterruptedException {
        Assert.assertTrue(getStartedPage.viewCentralPageTapWOPDoctor());
    }

    @Test
    public void test57_doctorViewGroupsWOP() throws InterruptedException {
        //        MobileElement buttonGroups = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[4]\n");
//        buttonGroups.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[1]").getText(),
//                "Groups");
//        Assert.assertEquals(androidDriver.findElementById("open_group_creating_button").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementById("groups_search_field").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"add_patient_text\"]/android.widget.TextView\n").getText(),
//                "Press ");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]\n").getText(),
//                "to create your first group");
        groupsPage = new GroupsPage(androidDriver);
        Assert.assertTrue(groupsPage.viewGroupsWOPDoctor());
    }

    @Test
    public void test58_doctorCreateGroupsWOP() throws InterruptedException {
        //        MobileElement buttonCreate = (MobileElement) androidDriver.findElementById("open_group_creating_button");
//        buttonCreate.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"create_group_modal\"]/android.widget.TextView[1]\n").getText(),
//                "Create new group");
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"create_group_modal\"]/android.widget.TextView[2]\n").getText(),
//                "Enter group name and add patients in new group");
//        Assert.assertEquals(androidDriver.findElementById("create_group_field").isDisplayed(),
//                true);
//        Assert.assertEquals(androidDriver.findElementById("create_group_button").isDisplayed(),
//                true);
//        MobileElement buttonBack = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView\n");
//        buttonBack.click();
//        Thread.sleep(2000, 30);
        Assert.assertTrue(groupsPage.createGroupsWOPDoctor());
    }

    @Test
    public void test59_doctorViewSettingsWOP() throws InterruptedException {
        //        MobileElement buttonSettings = (MobileElement) androidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[5]\n");
//        buttonSettings.click();
//        Thread.sleep(2000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"settings_screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView[1]\n").getText(),
//                "Nick Dobrov");
//        Assert.assertEquals(androidDriver.findElementById("user_nick.dobr87@gmail.com").getText(),
//                "nick.dobr87@gmail.com");
//        MobileElement linkSignOut = (MobileElement) androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_out_text\"]/android.widget.TextView\n");
//        linkSignOut.click();
//        Thread.sleep(5000, 30);
//        Assert.assertEquals(androidDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView").isDisplayed(),
//                true);
        settingsPage = new SettingsPage(androidDriver);
        Assert.assertTrue(settingsPage.signOutDoctor());
    }
}