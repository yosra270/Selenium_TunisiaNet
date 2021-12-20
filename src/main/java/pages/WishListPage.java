package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class WishListPage extends BasePage {
	private WebDriver driver;
	
	@FindBy(css = "#mywishlist > div.probg > div.list-wishlist.table-responsive.clearfix > table > tbody  tr")
	private List<WebElement> wishlists;
	
	// Add WishList form
	@FindBy(id = "wishlist_name")
	private WebElement newWishListNameField;
	
	@FindBy(xpath = "//*[@id=\"mywishlist\"]/div[2]/div[1]/button")
	private WebElement submitNewWishlistButton;
	
	public WishListPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void openWishlist(int index) {
		wishlists.get(index).findElement(By.xpath("//td[1]")).click();
	}
	
	public void addNewWishList(String newWishlistName) {
		newWishListNameField.sendKeys(newWishlistName);
		submitNewWishlistButton.click();
	}
}
