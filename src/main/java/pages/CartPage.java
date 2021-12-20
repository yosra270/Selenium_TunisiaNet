package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class CartPage extends BasePage {
	private WebDriver driver;
	
	@FindBy(css = "#main > div > div > div.card.cart-container > div.cart-overview.js-cart > ul  li.cart-item")
	private List<WebElement> products;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div/div[3]/div/a")
	private WebElement orderBtn;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div/div[2]/a")
	private WebElement continueShoppingBtn;
	
	public CartPage (WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openProductDetails(int index) {
		products.get(index).findElement(By.xpath("//div/div[2]/div[1]/a")).click();
	}
	
	public void order() {
		orderBtn.click();
	}
	
	public void continueShopping() {
		continueShoppingBtn.click();
	}

}
