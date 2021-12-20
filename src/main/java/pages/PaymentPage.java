package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import utils.ElementUtil;

public class PaymentPage extends BasePage {
	private WebDriver driver;

	// Addresses form
	@FindBy(name ="firstname")
	private WebElement firstnameField;

	@FindBy(name ="lastname")
	private WebElement lastnameField;

	@FindBy(name ="address1")
	private WebElement addressField;	

	@FindBy(name ="postcode")
	private WebElement postcodeField;

	@FindBy(name ="city")
	private WebElement cityField;

	@FindBy(name ="phone")
	private WebElement phoneField;	

	@FindBy(name ="use_same_address")
	private WebElement useSameAddressForBillingCheckbox;
	
	@FindBy(xpath = "//*[@id=\"delivery-address\"]/div/footer/button")
	private WebElement submitDeliveryAdressInfos;
	
	// Delivery mode form
	@FindBy(id = "delivery_option_10")
	private WebElement localPickupOptionRadioBtn;
	
	@FindBy(id = "delivery_option_9")
	private WebElement localDeliveryOptionRadioBtn;
	
	@FindBy(name = "confirmDeliveryOption")
	private WebElement submitDeliveryModeBtn;
	
	// Payment option form
	@FindBy(id = "payment-option-1")
	private WebElement cashOnDeliveryOptionRadioBtn;

	@FindBy(id = "payment-option-2")
	private WebElement cardOnDeliveryOptionRadioBtn;
	
	@FindBy(id = "conditions_to_approve[terms-and-conditions]")
	private WebElement acceptTermsAndConditionsCheckbox;
	
	// Order
	@FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
	private WebElement submitOrderBtn;
	
	

	
	public PaymentPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void order() {
		// Fill address options form
		firstnameField.sendKeys(properties.getProperty("user.firstname"));
		lastnameField.sendKeys(properties.getProperty("user.lastname"));
		addressField.sendKeys(properties.getProperty("user.address"));
		postcodeField.sendKeys(properties.getProperty("user.postcode"));
		cityField.sendKeys(properties.getProperty("user.city"));
		phoneField.sendKeys(properties.getProperty("user.phone"));
		useSameAddressForBillingCheckbox.click();
		submitDeliveryAdressInfos.click();

        ElementUtil.implicitlyWait(driver, 10, TimeUnit.SECONDS);
		
		// Fill delivery options form
		if(properties.getProperty("product.delivery.mode").contains("local pickup"))
			localPickupOptionRadioBtn.click();
		else
			localDeliveryOptionRadioBtn.click();
		
		submitDeliveryModeBtn.click();

        ElementUtil.implicitlyWait(driver, 10, TimeUnit.SECONDS);
        
		// Fill payment options form		
		if(properties.getProperty("product.payment.mode").contains("cash on delivery"))
			cashOnDeliveryOptionRadioBtn.click();
		else
			cardOnDeliveryOptionRadioBtn.click();
		
		acceptTermsAndConditionsCheckbox.click();

        ElementUtil.implicitlyWait(driver, 10, TimeUnit.SECONDS);
        
		// Order
		submitOrderBtn.click();
	}

}
