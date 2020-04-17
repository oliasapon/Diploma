package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class OpenPage extends DriverPage{

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView")
    private AndroidElement mainPage;

    public OpenPage(AppiumDriver<MobileElement> androidDriver) {
        super(androidDriver);
    }

    public boolean mainPageIsDisplayed() {
        /*if(mainPage.isDisplayed()) {
            System.out.println("Test 1 - successfully");
            return true;
        }
        else{
            return false;
        }*/
        return mainPage.isDisplayed();
    }

    public void sleepTime(int time) throws InterruptedException {
        Thread.sleep(time, 30);
    }
}
