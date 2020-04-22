package pages;

import com.github.javafaker.Faker;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import pageSettings.DriverPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class Action extends DriverPage {

    TouchAction actionWithTouch = new TouchAction(androidDriver);

    public Action(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

    public void tap(int pointX, int pointY){
        actionWithTouch
                .tap(PointOption.point(pointX, pointY))
                .release()
                .perform();
    }

    public void horizontalSwipe(int startPointX, int endPointX, int pointY, int time){
        actionWithTouch
                .press(PointOption.point(startPointX, pointY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(time)))
                .moveTo(PointOption.point(endPointX, pointY))
                .release()
                .perform();
    }

    public void verticalSwipe(int pointX, int startPointY, int endPointY, int time){
        actionWithTouch
                .press(PointOption.point(pointX, startPointY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(time)))
                .moveTo(PointOption.point(pointX, endPointY))
                .release()
                .perform();
    }

    public boolean scroll(String toPlace){
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + toPlace + "\").instance(0))");
        return true;
    }

    public void sleepTime(int time) throws InterruptedException {
        Thread.sleep(time, 30);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"back_button\"]/android.widget.ImageView")
    private AndroidElement buttonComeBack;

    public void clickComeBack(){
        buttonComeBack.click();
    }

    public String recordsHistoryDateDay() {
        GregorianCalendar gCalendar = new GregorianCalendar();
        String date = String.valueOf(gCalendar.get(Calendar.DATE));
        return date;
    }

    public String recordsHistoryDateMonth() {
        Calendar calendar = Calendar.getInstance();
        String month = calendar.getDisplayName(Calendar.MONTH,
                Calendar.LONG_FORMAT, new Locale("eng"));
        return month;
    }

    public void hideKeyboard(){
        androidDriver.hideKeyboard();
    }

    public String newNumber() {
        Random random = new Random();
        final String symbols = "0123456789";
        String newPhoneNumber = "";
        int index = 0;
        for (int i = 0; i < 9; i++) {
            index = random.nextInt(symbols.length());
            newPhoneNumber += symbols.charAt(index);
        }
        return newPhoneNumber;
    }

    public String newEmail() {
        DateFormat pattern = new SimpleDateFormat("ddMMHHmm"); //y
        Date todayDate = Calendar.getInstance().getTime();
        String formatDate = pattern.format(todayDate);
        String newMail = "mailForTest" + formatDate + "@gmail.com";
        return newMail;
    }

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

    public String newGroupName() {
        Random random = new Random();
        final String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String newGroupName = "";
        int index = 0;
        for (int i = 0; i < 3; i++) {
            index = random.nextInt(symbols.length());
            newGroupName += symbols.charAt(index);
        }
        return newGroupName;
    }

    public String newName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public String newSurname() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }




}
