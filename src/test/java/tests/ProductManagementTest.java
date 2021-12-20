package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pages.*;

@Epic("Epic 1 : Define product managment test features")
public class ProductManagementTest extends BaseTest {
	HomePage homePage;
	LoginPage loginPage;
	SearchPage searchPage;
	SearchResultPage searchResultPage;
	ProductDetailsPage productDetailsPage;
	CartPage cartPage;
	PaymentPage paymentPage;
	MyAccountPage myAccountPage;
	WishListPage wishlistPage;
	
	@BeforeClass
	public void initialization() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		searchPage = new SearchPage(driver);
		searchResultPage = new SearchResultPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		cartPage = new CartPage(driver);
		paymentPage = new PaymentPage(driver);
		myAccountPage = new MyAccountPage(driver);
		wishlistPage = new WishListPage(driver);
	}

    
    @Story("US 1 : As a user, I want to search a product")
    @Severity(SeverityLevel.BLOCKER)
	@Test(priority = 1)
	public void userCanSearchProductTest() {
		homePage.openHomePage();
		searchPage.searchProduct(properties.getProperty("product.name"));
		searchResultPage.openProductPageDetails();
	}
    
    @Story("US 1 : As a user, I want to search a product")
    @Description("User can search a product by autosuggest")
    @Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void userCanSearchProductByAutoSuggestTest() {
		homePage.openHomePage();
		searchPage.searchProductByAutoSuggest(properties.getProperty("product.name"));
	}
    

    @Story("US 5 : As a user, I want to change the product i'm purchasing quantity")
    @Description("User can chnage product's quantity")
    @Severity(SeverityLevel.NORMAL)
	@Test(priority = 2, dependsOnMethods = {"userCanSearchProductTest"}, dependsOnGroups = {"UserAccountManagmentTest.userCanLoginSucessfully"})
    public void userCanChangeProductQuantity() {
    	// To implement
    }

    @Story("US 2 : As a user, I want to add a product to the cart")
    @Severity(SeverityLevel.BLOCKER)
	@Test(priority = 2, dependsOnMethods = {"userCanSearchProductTest"}, dependsOnGroups = {"UserAccountManagmentTest.userCanLoginSucessfully"})
	public void userCanAddProductToCartTest() {
		homePage.openHomePage();
		homePage.openLoginPage();
		loginPage.login();
		searchPage.searchProduct(properties.getProperty("product.name"));
		searchResultPage.openProductPageDetails();
		productDetailsPage.addToCart();
	}

    @Story("US 3 : As a user, I want to add a product to my wishlist")
    @Severity(SeverityLevel.NORMAL)
	@Test(priority = 2, dependsOnMethods = {"userCanSearchProductTest"}, dependsOnGroups = {"UserAccountManagmentTest.userCanLoginSucessfully"})
	public void userCanAddProductToWishlistTest() {
		homePage.openHomePage();
		searchPage.searchProduct(properties.getProperty("product.name"));
		searchResultPage.openProductPageDetails();
		productDetailsPage.addToWishList();		
	}
    
    @Story("US 3 : As a user, I want to add a product to a compare list")
    @Severity(SeverityLevel.NORMAL)
	@Test(priority = 2, dependsOnMethods = {"userCanSearchProductTest"}, dependsOnGroups = {"UserAccountManagmentTest.userCanLoginSucessfully"})
	public void userCanAddProductToComparelistTest() {
		homePage.openHomePage();
		searchPage.searchProduct(properties.getProperty("product.name"));
		searchResultPage.openProductPageDetails();
		productDetailsPage.addToCompareList();		
	}

    @Story("US 4 : As a user, I want to purchase a product")
    @Severity(SeverityLevel.BLOCKER)
	@Test(priority = 3, dependsOnMethods = {"userCanAddProductToCartTest"})
	public void userCanPurchaseProductTest() {
		homePage.openHomePage();
		homePage.openLoginPage();
		loginPage.login();
		searchPage.searchProduct(properties.getProperty("product.name"));
		searchResultPage.openProductPageDetails();
		productDetailsPage.addToCart();
		homePage.openCartPage();
		cartPage.order();
		paymentPage.order();
		
	}
    

    @Story("US 6 : As a user, I want to create wishlists")
    @Severity(SeverityLevel.NORMAL)
	@Test(priority = 1, dependsOnGroups = {"UserAccountManagmentTest.userCanLoginSucessfully"})
    public void userCanAddNewWishlistTest() {
		homePage.openHomePage();
		homePage.openLoginPage();
		loginPage.login();
		homePage.openMyAccountPage();
		myAccountPage.openWishlistPage();
		wishlistPage.addNewWishList("new wishlist");
    }
    

    @Story("US 7 : As a user, I want to consult wishlists")
    @Severity(SeverityLevel.NORMAL)
	@Test(priority = 1, dependsOnGroups = {"UserAccountManagmentTest.userCanLoginSucessfully"})
    public void userCanConsultWishlistTest() {
		homePage.openHomePage();
		homePage.openLoginPage();
		loginPage.login();
		homePage.openMyAccountPage();
		myAccountPage.openWishlistPage();
		wishlistPage.openWishlist(0); // consult first wishlist in the list
    }
    
    // ..

}
