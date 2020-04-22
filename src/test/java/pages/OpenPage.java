package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class OpenPage extends Action{

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sign_in_screen\"]/android.view.ViewGroup/android.widget.ImageView")
    private AndroidElement mainPage;

    public OpenPage(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

    public boolean mainPageIsDisplayed() {
        return mainPage.isDisplayed();
    }

}
