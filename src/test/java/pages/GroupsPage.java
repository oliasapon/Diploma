package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class GroupsPage extends PatientsPage{

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.Button[4]\n")
    private AndroidElement buttonGroups;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView\n")
    private AndroidElement titleGroup;

    @AndroidFindBy(id = "group_T2DM")
    private AndroidElement buttonShowPatients;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.TextView\n")
    private AndroidElement buttonCollapseGroups;

    @AndroidFindBy(id = "groups_search_field")
    private AndroidElement inputGroupName;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.ImageView\n")
    private AndroidElement iconNotFindGroup;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]")
    private AndroidElement titleNotFindGroup;

    @AndroidFindBy(id = "open_group_creating_button")
    private AndroidElement buttonCreateGroup;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"expand_all_groups_button\"]/android.widget.TextView")
    private AndroidElement buttonExpandAllGroup;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView\n")
    private AndroidElement buttonCollapseAllGroup;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"create_group_modal\"]/android.widget.TextView[1]\n")
    private AndroidElement titleNewGroup;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"create_group_modal\"]/android.widget.TextView[2]\n")
    private AndroidElement titleInstructionNewGroup;

    @AndroidFindBy(id = "create_group_field")
    private AndroidElement inputNewGroupName;

    @AndroidFindBy(id = "create_group_button")
    private AndroidElement buttonCreateNewGroup;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"groups_screen\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]\n")
    private AndroidElement titleAddFirstGroup;

    public GroupsPage(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

    public void clickButtonGroup(){
        buttonGroups.click();
    }

    public String getTextTitleGroup(){
        return titleGroup.getText();
    }

    public boolean titleGroup(){
        Assert.assertEquals(getTextTitleGroup(), "Groups");
        return true;
    }

    public void clickButtonShowPatients(){
        buttonShowPatients.click();
    }

    public void clickButtonCollapseGroups(){
        buttonCollapseGroups.click();
    }

    public void clickInputGroupName(){
        inputGroupName.click();
    }

    public void setValueGroupName(){
        inputGroupName.setValue("D1");
    }

    public boolean iconNotFindGroupIsDisplayed(){
        return iconNotFindGroup.isDisplayed();
    }

    public String getTextTitleNotFindGroup(){
        return titleNotFindGroup.getText();
    }

    public boolean titleNotFindGroup(){
        Assert.assertEquals(getTextTitleNotFindGroup(), "Did not find groups with name");
        return true;
    }

    public void clickButtonCreateGroup(){
        buttonCreateGroup.click();
    }

    public void clickButtonExpandAllGroup(){
        buttonExpandAllGroup.click();
    }

    public void clickButtonCollapseAllGroup() {
        buttonCollapseAllGroup.click();
    }

    public String getTextTitleNewGroup(){
        return titleNewGroup.getText();
    }

    public boolean titleNewGroup(){
        Assert.assertEquals(getTextTitleNewGroup(), "Create new group");
        return true;
    }

    public String getTextTitleInstructionNewGroup(){
        return titleInstructionNewGroup.getText();
    }

    public boolean titleInstructionNewGroup(){
        Assert.assertEquals(getTextTitleInstructionNewGroup(), "Enter group name and add patients in new group");
        return true;
    }

    public void clickInputNewGroupName() {
        inputNewGroupName.click();
    }

    public void setValueInputNewGroupName(String groupName) {
        inputNewGroupName.setValue(groupName);
    }

    public void clickButtonCreateNewGroup(){
        buttonCreateNewGroup.click();
    }

    public boolean buttonCreateGroupIsDisplayed(){
        return buttonCreateGroup.isDisplayed();
    }

    public String getTextTitleAddFirstGroup(){
        return titleAddFirstGroup.getText();
    }

    public boolean titleAddFirstGroup(){
        Assert.assertEquals(getTextTitleAddFirstGroup(), "to create your first group");
        return true;
    }

    public boolean viewGroupDoctorDemoForCreatGroup() throws InterruptedException {
        clickButtonGroup();
        if(titleGroup()) {
            clickButtonCreateGroup();
            //sleepTime(2000);
            return true;
        }
        return false;
    }

    public boolean viewGroupDoctorDemo() throws InterruptedException {
        clickButtonGroup();
        //sleepTime(2000);
        if(titleGroup()){
            clickButtonShowPatients();
            sleepTime(2000);
            tap(500, 900);
            sleepTime(2000);
            clickComeBack();
            //sleepTime(2000);
            clickButtonCollapseGroups();
            clickInputGroupName();
            setValueGroupName();
            hideKeyboard();
            if (iconNotFindGroupIsDisplayed() && titleNotFindGroup()) {
                return true;
            }
        }
        return false;
    }

    public boolean viewGroupDoctor() throws InterruptedException {
        clickButtonGroup();
        //sleepTime(2000);
        if(titleGroup()){
            clickButtonExpandAllGroup();
            verticalSwipe(700, 1450, 400, 500);
            sleepTime(2000);
            verticalSwipe(700, 300, 1450, 500);
            sleepTime(2000);
            clickButtonCollapseAllGroup();
            return true;
        }
        return false;
    }

    public boolean createNewGroupDoctor() throws InterruptedException {
        clickButtonCreateGroup();
        sleepTime(2000);
        if(titleNewGroup() && titleInstructionNewGroup()){
            clickInputNewGroupName();
            setValueInputNewGroupName(newGroupName());
            hideKeyboard();
            sleepTime(2000);
            tap(1000, 600);
            tap(1000, 600);
            //sleepTime(2000);
            clickButtonCreateNewGroup();
            //sleepTime(2000);
            if(titleGroup()){
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean viewGroupsWOPDoctor() throws InterruptedException {
        clickButtonGroup();
        sleepTime(5000);
        if(titleGroup() && buttonCreateGroupIsDisplayed() /*&& linkPress() && titleAddFirstGroup()*/){
            return true;
        }
        return false;
    }

    public boolean createGroupsWOPDoctor() throws InterruptedException {
        clickButtonCreateGroup();
        //sleepTime(2000);
        if(titleNewGroup() && titleInstructionNewGroup()){
            clickComeBack();
            //sleepTime(2000);
            if(titleGroup()){
                return true;
            }
        }
        return false;
    }

}
