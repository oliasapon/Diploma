package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import pageSettings.DriverPage;

public class MyDoctorPage extends DriverPage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[4]")
    private AndroidElement buttonMyDoctor;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup\n")
    private AndroidElement titleComingSoon;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView\n")
    private AndroidElement iconDoctor;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]\n")
    private AndroidElement titleDoctor;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"my_doctor_screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]")
    private AndroidElement titleConstruction;

     /*@AndroidFindBy(xpath = "")
    private AndroidElement;
    @AndroidFindBy(id = "")
    private AndroidElement;*/

    public MyDoctorPage(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

    public void clickButtonMyDoctor(){
        buttonMyDoctor.click();
    }

    public boolean titleComingSoonIsDisplayed() {
        return titleComingSoon.isDisplayed();
    }

    public boolean iconDoctorIsDisplayed() {
        return iconDoctor.isDisplayed();
    }

    public String getTextTitleDoctor(){
        return titleDoctor.getText();
    }

    public boolean titleDoctor(){
        Assert.assertEquals(getTextTitleDoctor(), "My doctor");
        return true;
    }

    public String getTextTitleConstruction(){
        return titleConstruction.getText();
    }

    public boolean titleConstruction(){
        Assert.assertEquals(getTextTitleConstruction(), "This page is under construction");
        return true;
    }

    public boolean viewMyDoctorUserDemo(){
        boolean status = false;
        clickButtonMyDoctor();
        if(titleComingSoonIsDisplayed() && iconDoctorIsDisplayed() && titleDoctor() && titleConstruction()) {
            status = true;
        }
        return status;
    }

}
