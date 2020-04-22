package pageSettings;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class DriverPage {
    public static AndroidDriver<AndroidElement> androidDriver;
    public DriverPage(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }



    /*public AppiumDriver<MobileElement> androidDriver;

    public DriverPage(AppiumDriver<MobileElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    }*/



    /*public AppiumDriver<MobileElement> driver;

    public BasePOMpage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }*/

}
