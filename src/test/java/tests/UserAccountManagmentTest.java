package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

@Epic("Epic 1 : Define user account managment test features")
public class UserAccountManagmentTest extends BaseTest {
	HomePage homePage;
    RegistrationPage userRegistrationPage;
    LoginPage loginPage;

	
	@BeforeClass
	public void initialization() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		userRegistrationPage = new RegistrationPage(driver);
	}

    @Story("US 1 : As a user, I want to create an account successfully")
    @Description("Verifying the user registration test")
    @Severity(SeverityLevel.BLOCKER)
	@Test(priority = 1)
    public void userCanRegisterSuccessfully() {
        /*
         * 1- User Registration
         * */
        homePage.openLoginPage();
        loginPage.openRegistrationPage();
        userRegistrationPage.register();
        /*
         * 2- User logout
         * */
        homePage.userLogout();
    }

    @Story("US 2 : As a user, I want to change my password")
    @Description("Verifying chnaging password functionality")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2, dependsOnMethods = {"userCanRegisterSuccessfully"})
    public void userCanChangePassword() {
        // To implement
    }
    
    @Story("US 3 : As a user, I want to sign in to my account successfully")
    @Description("Verifying the user login test")
    @Severity(SeverityLevel.BLOCKER)
	@Test(priority = 2, dependsOnMethods = {"userCanRegisterSuccessfully"}, groups = {"UserAccountManagmentTest.userCanLoginSucessfully"})
    public void userCanLoginSucessfully() {
        /*
         * 1- login with a registered user
         * */
        homePage.openLoginPage();
        loginPage.login();
        /*
         * 2- User logout
         * */
        homePage.userLogout();
    }
    
    @Story("US 4 : As a user, I want to modify ma personal informations")
    @Description("Verifying personal infos modification feature")
    @Severity(SeverityLevel.MINOR)
	@Test(priority = 3, dependsOnMethods = {"userCanLoginSucessfully"})
    public void userCanModifyPersonalInfosTest() {
        // To do
    }
    
    // ..
}
