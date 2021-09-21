package pageSettings;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class DriverPage {
    public static AndroidDriver<AndroidElement> androidDriver;
    public DriverPage(AndroidDriver<AndroidElement> androidDriver){
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
    } 
}
