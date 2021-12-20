package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class HomePage extends BasePage {
	private WebDriver driver;

	@FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/ul/li/a/span")
    private WebElement userIcon;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/ul/li/a")
    private WebElement loginLink;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/ul/li[2]/a")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/ul/li[1]/a")
    private WebElement myAccountLink;

    @FindBy(id = "_desktop_cart")
    private WebElement shoppingCart;
	
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    public void openHomePage() {
    	driver.navigate().to(properties.getProperty("driver.base-url"));
    }
    
    public void openLoginPage() {
    	loginLink.click();
    }
    
    public void userLogout() {
    	logoutLink.click();
    }
    
    public void openMyAccountPage() {
    	myAccountLink.click();
    }
    
    public void openCartPage() {
    	shoppingCart.click();
    }

}
