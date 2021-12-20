package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class SearchResultPage extends BasePage {
	private WebDriver driver;

	@FindBy(css = "#js-product-list > div  div")
	private List<WebElement> productsFound;
	
	
	public SearchResultPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void openProductPageDetails(){
		productsFound.get(0).click();
    }

}
