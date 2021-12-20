package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import utils.ElementUtil;
import utils.JavaScriptUtil;

public class ProductDetailsPage extends BasePage {
	private WebDriver driver;
	
	@FindBy(id ="quantity-wanted")
	private WebElement quantityInput;
	
	@FindBy(css = "#add-to-cart-or-refresh > div.product-add-to-cart > div > div.add > button")
	private WebElement addToCartBtn;

    @FindBy(css = "#add-to-cart-or-refresh > div.wb-compare-wishlist-button > div:nth-child(2) > div > a")
    private WebElement addToWishListBtn;

    @FindBy(css = "#add-to-cart-or-refresh > div.wb-compare-wishlist-button > div:nth-child(1) > div > a")
    private WebElement addToCompareListBtn;
    
    @FindBy(css = "#blockcart-modal > div > div > div > div.col-xs-12.cart-content > div > div > button")
    private WebElement continueShoppingBtn;
    
    @FindBy(css = "#blockcart-modal > div > div > div > div.col-xs-12.cart-content > div > div > a")
    private WebElement orderBtn;
    

	
	public ProductDetailsPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
    public void addToWishList() {
    	JavaScriptUtil.scrollPageDown(driver, 400);
        addToWishListBtn.click();
    }

    public void addToCompareList() {
        addToCompareListBtn.click();
    }

    public void addToCart() {
        addToCartBtn.click();
    	ElementUtil.waitForElementDisplay(continueShoppingBtn);
        continueShoppingBtn.click();
    }


    public void addToCart(boolean continueShopping) {
        addToCartBtn.click();
    	if(continueShopping == true) {
    		ElementUtil.waitForElementDisplay(continueShoppingBtn);
    		continueShoppingBtn.click();
    	} else {
    		ElementUtil.waitForElementDisplay(orderBtn);
    		orderBtn.click();    		
    	}
    }
    
    public void setQuantity(int quantity) {
    	quantityInput.sendKeys(""+quantity);
    }
    
    public void order() {
    	orderBtn.click();
    }
}
