package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class MyAccountPage extends BasePage {
	private WebDriver driver;
	
	@FindBy(id = "identity-link")
	private WebElement informationsLink;
	
	@FindBy(id = "address-link")
	private WebElement addNewAddressLink;
	
	@FindBy(id = "history-link")
	private WebElement historyLink;

	@FindBy(id = "mywishlist-link")
	private WebElement wishListLink;
	
	
	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openInformationsPage() {
		informationsLink.click();
	}
	
	public void openAddNewAddressPage() {
		addNewAddressLink.click();
	}
	
	public void openHistoryPage() {
		historyLink.click();
	}
	
	public void openWishlistPage() {
		wishListLink.click();
	}
}
