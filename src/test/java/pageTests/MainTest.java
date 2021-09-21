package pageTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageSettings.ConnectionSettings;
import pages.*;

public class MainTest extends ConnectionSettings {

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
    public void test01_openSignPage() throws InterruptedException {
        openPage = new OpenPage(androidDriver);
        Assert.assertTrue(openPage.mainPageIsDisplayed());
    }

    @Test//(enabled = false, priority = 2)
    public void test02_signUpUserWithoutDiabetes() throws InterruptedException {
        registrationPage = new RegistrationPage(androidDriver);
        Assert.assertTrue(registrationPage.registrationUserWithoutDiabetes());
    }

    @Test
    public void test03_signUpUserWithDiabetesFirstType() throws InterruptedException {
        Assert.assertTrue(registrationPage.registrationUserWithDiabetesFirstType());
    }

    @Test
    public void test04_signUpUserWithDiabetesSecondType() throws InterruptedException {
        Assert.assertTrue(registrationPage.registrationUserWithDiabetesSecondType());
    }

    @Test
    public void test05_signUpDoctor() throws InterruptedException {
        Assert.assertTrue(registrationPage.registrationDoctor());
    }

    @Test
    public void test06_forgotPassword() throws InterruptedException {
        Assert.assertTrue(registrationPage.forgotPassword());
    }

    @Test
    public void test07_userSignInWithDT1() throws InterruptedException {
        signInPage = new SignInPage(androidDriver);
        Assert.assertTrue(signInPage.signInUserWithDiabetesFirstType());
    }

    @Test
    public void test08_userViewHistoryWithDT1() throws InterruptedException {
        historyPageUser = new HistoryPageUser(androidDriver);
        settingsPage = new SettingsPage(androidDriver);
        Assert.assertTrue(historyPageUser.viewHistoryUserWithDT1());
        Assert.assertTrue(settingsPage.signOut());
    }

    @Test
    public void test09_userSignInWithDT2() throws InterruptedException {
        Assert.assertTrue(signInPage.signInUserWithDiabetesSecondType());
    }

    @Test
    public void test10_userViewHistoryWithDT2() throws InterruptedException {
        Assert.assertTrue(historyPageUser.viewHistoryUserWithDT2());
        Assert.assertTrue(settingsPage.signOut());
    }

    @Test
    public void test11_liveDemoUser() throws InterruptedException {
        liveDemoPage = new LiveDemoPage(androidDriver);
        Assert.assertTrue(liveDemoPage.openDemoUser());
    }

    @Test
    public void test12_userDemoViewDashboard() throws InterruptedException {
        Assert.assertTrue(liveDemoPage.demoUserViewDashboard());
    }

    @Test
    public void test13_userDemoViewHistory() throws InterruptedException {
       Assert.assertTrue(historyPageUser.viewHistoryUserDemo());
    }

    @Test
    public void test14_userDemoHistoryViewDay() throws InterruptedException {
        Assert.assertTrue(historyPageUser.viewDayHistoryUserDemo());
    }

    @Test
    public void test15_userDemoGetStartedView() throws InterruptedException {
        getStartedPage = new GetStartedPage(androidDriver);
        Assert.assertTrue(getStartedPage.viewGetStartedUserDemo());
    }

    @Test
    public void test16_userDemoGetStartedSignUp() throws InterruptedException {
        Assert.assertTrue(getStartedPage.getStartedSignUpUserDemo());
    }

    @Test
    public void test17_userDemoGetStartedTap() throws InterruptedException {
        Assert.assertTrue(liveDemoPage.openDemoUser());
        Assert.assertTrue(getStartedPage.viewGetStartedUserDemo());
        Assert.assertTrue(getStartedPage.viewGetStartedTapUserDemo());
    }

    @Test
    public void test18_userDemoMyDoctorView() throws InterruptedException {
        myDoctorPage = new MyDoctorPage(androidDriver);
        Assert.assertTrue(myDoctorPage.viewMyDoctorUserDemo());
    }

    @Test
    public void test19_userDemoSettingsViewSignOut() throws InterruptedException {
        Assert.assertTrue(settingsPage.signOut());
    }

    @Test
    public void test20_liveDemoDoctor() throws InterruptedException {
        Assert.assertTrue(liveDemoPage.openDemoDoctor());
    }

    @Test
    public void test21_doctorDemoHistoryView() throws InterruptedException {
        historyPageDoctor = new HistoryPageDoctor(androidDriver);
        Assert.assertTrue(historyPageDoctor.viewHistoryDoctorDemo());
    }

    @Test
    public void test22_doctorDemoHistoryViewDayFirstPerson() throws InterruptedException {
        Assert.assertTrue(historyPageDoctor.viewHistoryDayFirstPatientDoctorDemo());
    }

    @Test
    public void test23_doctorDemoHistoryViewDiagram() throws InterruptedException {
        Assert.assertTrue(historyPageDoctor.viewHistoryDiagramDoctorDemo());
    }

    @Test
    public void test24_doctorDemoHistoryViewDay() throws InterruptedException {
        Assert.assertTrue(historyPageDoctor.viewHistoryDayDoctorDemo());
    }

    @Test
    public void test25_doctorDemoHistoryViewDetails() throws InterruptedException {
        Assert.assertTrue(historyPageDoctor.viewHistoryDetailsDoctorDemo());
    }

    @Test
    public void test26_doctorDemoViewPatients() throws InterruptedException {
        patientsPage = new PatientsPage(androidDriver);
        Assert.assertTrue(patientsPage.viewPatientsDoctorDemo());
    }

    @Test
    public void test27_doctorDemoViewOnePatient() throws InterruptedException {
        Assert.assertTrue(patientsPage.viewOnePatientDoctorDemo());
    }

    @Test
    public void test28_doctorDemoNewGroupView() throws InterruptedException {
        groupsPage = new GroupsPage(androidDriver);
        Assert.assertTrue(groupsPage.viewGroupDoctorDemoForCreatGroup());
        Assert.assertTrue(getStartedPage.viewNewGroupDoctorDemo());
    }

    @Test
    public void test29_doctorDemoNewGroupSignUp() throws InterruptedException {
        Assert.assertTrue(getStartedPage.getStartedSignUpUserDemo());
    }

    @Test
    public void test30_doctorDemoNewGroupTap() throws InterruptedException {
        Assert.assertTrue(liveDemoPage.openDemoDoctor());
        Assert.assertTrue(groupsPage.viewGroupDoctorDemoForCreatGroup());
        Assert.assertTrue(getStartedPage.viewNewGroupTapDoctorDemo());
    }

    @Test
    public void test31_doctorDemoViewGroups() throws InterruptedException {
        Assert.assertTrue(groupsPage.viewGroupDoctorDemo());
    }


    @Test
    public void test32_doctorDemoSettings() throws InterruptedException {
        Assert.assertTrue(settingsPage.settingsDoctorDemo());

    }

    @Test
    public void test33_signInUser() throws InterruptedException {
        Assert.assertTrue(signInPage.signInUserWithout());
    }

    @Test
    public void test34_userViewFirstCentralPage() throws InterruptedException {
        Assert.assertTrue(getStartedPage.viewFirstCentralPageUser());
    }

    @Test
    public void test35_userViewDashboard() throws InterruptedException {
        Assert.assertTrue(historyPageUser.viewDashboardUser());
    }

    @Test
    public void test36_userViewHistory() throws InterruptedException {
        Assert.assertTrue(historyPageUser.viewHistoryUser());
    }

    @Test
    public void test37_userViewMyDoctor() throws InterruptedException {
        Assert.assertTrue(myDoctorPage.viewMyDoctorUserDemo());
    }

    @Test
    public void test38_userViewSettings() throws InterruptedException {
        Assert.assertTrue(settingsPage.viewSettingsUser());
    }

    @Test
    public void test39_userEditInformationPatient() throws InterruptedException {
        Assert.assertTrue(settingsPage.editInformationPatientUser());
    }

    @Test
    public void test40_userChangeRole() throws InterruptedException {
        Assert.assertTrue(settingsPage.changeRolePatientUser());
    }

    @Test
    public void test41_signOutUser() throws InterruptedException {
        Assert.assertTrue(settingsPage.signOut());
    }


    //Doctor with patients!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Test
    public void test42_signInDoctor() throws InterruptedException {
        Assert.assertTrue(signInPage.signInDoctorWithPatients());
    }

    @Test
    public void test43_doctorViewHistory() throws InterruptedException {
        Assert.assertTrue(historyPageDoctor.viewHistoryDoctor());
    }

    @Test
    public void test44_doctorViewPatients() throws InterruptedException {
        Assert.assertTrue(patientsPage.viewPatientsDoctor());
    }

    @Test
    public void test45_doctorCreateNewPatient() throws InterruptedException {
        Assert.assertTrue(patientsPage.createNewPatientDoctor());
    }


    @Test
    public void test46_doctorEditPatient() throws InterruptedException {
        Assert.assertTrue(patientsPage.editPatientDoctor());
    }

    @Test
    public void test47_doctorViewCentralPage() throws InterruptedException {
        Assert.assertTrue(getStartedPage.viewCentralPageDoctor());
    }

    @Test
    public void test48_doctorViewGroup() throws InterruptedException {
        Assert.assertTrue(groupsPage.viewGroupDoctor());
    }

    @Test
    public void test49_doctorCreateNewGroup() throws InterruptedException {
        Assert.assertTrue(groupsPage.createNewGroupDoctor());
    }

    @Test
    public void test50_signOutDoctor() throws InterruptedException {
        Assert.assertTrue(settingsPage.signOutDoctor());
    }

    //Doctor without patients!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Test
    public void test51_signInDoctorWithoutPatients() throws InterruptedException {
        Assert.assertTrue(signInPage.signInDoctorWithoutPatients());
    }

    @Test
    public void test52_doctorViewHistoryWOP() throws InterruptedException {
        Assert.assertTrue(historyPageDoctor.viewHistoryDoctor());
    }

    @Test
    public void test53_doctorViewPatientsWOP() throws InterruptedException {
        Assert.assertTrue(patientsPage.viewPatientsWOPDoctor());
    }

    @Test
    public void test54_doctorPressAddPatientsWOP() throws InterruptedException {
        Assert.assertTrue(patientsPage.pressAddPatientWOPDoctor());
    }

    @Test
    public void test55_doctorViewCentralPageWOP() throws InterruptedException {
        Assert.assertTrue(getStartedPage.viewCentralPageWOPDoctor());
    }

    @Test
    public void test56_doctorViewCentralPageWOPWithTap() throws InterruptedException {
        Assert.assertTrue(getStartedPage.viewCentralPageTapWOPDoctor());
    }

    @Test
    public void test57_doctorViewGroupsWOP() throws InterruptedException {
        Assert.assertTrue(groupsPage.viewGroupsWOPDoctor());
    }

    @Test
    public void test58_doctorCreateGroupsWOP() throws InterruptedException {
        Assert.assertTrue(groupsPage.createGroupsWOPDoctor());
    }

    @Test
    public void test59_doctorViewSettingsWOP() throws InterruptedException {
        Assert.assertTrue(settingsPage.signOutDoctor());
    }

    @Test
    public void test60_requiredEmailAndPasswordSignIn() throws InterruptedException {
        Assert.assertTrue(signInPage.signInRequiredEmailAndPassword());
    }

    @Test
    public void test61_invalidEmailSignIn() throws InterruptedException {
        Assert.assertTrue(signInPage.signInInvalidEmail());
    }

    @Test
    public void test62_shortPasswordSignIn() throws InterruptedException {
        Assert.assertTrue(signInPage.signInShortPassword());
    }

    @Test
    public void test63_incorrectPasswordOrEmailSignIn() throws InterruptedException {
        Assert.assertTrue(signInPage.signInIncorrectPasswordOrEmail());
    }

    @Test
    public void test64_invalidNameAndSurnameSignUp() throws InterruptedException {
        Assert.assertTrue(registrationPage.invalidNameAndSurnameRegistration());
    }

    @Test
    public void test65_dontMatchPasswordSignUp() throws InterruptedException {
        Assert.assertTrue(registrationPage.dontMatchPasswordRegistration());
    }

}
