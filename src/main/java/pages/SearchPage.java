package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import utils.ElementUtil;

public class SearchPage extends BasePage {
	private WebDriver driver;

    @FindBy(id = "search_query_top")
    private WebElement searchTxtBox;
    
    @FindBy(id = "sp-btn-search")
    private WebElement searchBtn;

    @FindBy(css = "#wbsearch_data > div > ul  li")
    private List<WebElement> autoSuggestSearchMenu;
	
	public SearchPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
    public void searchProduct(String product) {
    	searchTxtBox.clear();
    	searchTxtBox.sendKeys(product);
    	searchBtn.click();
    }
    public void searchProductByAutoSuggest(String product) {
    	searchTxtBox.clear();
    	searchTxtBox.sendKeys(product);
    	ElementUtil.implicitlyWait(driver, 15, TimeUnit.SECONDS);
        autoSuggestSearchMenu.get(0).click();
    }

}
