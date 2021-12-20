package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class RegistrationPage extends BasePage {
	private WebDriver driver;

	@FindBy(linkText = "Connectez-vous !")
	private WebElement loginLink;
	
	// Registration form elements
	@FindBy(name = "id_gender")
	private List<WebElement> genderRadioInputs;
	
	@FindBy(name = "firstname")
	private WebElement firstnameField;

	@FindBy(name = "lastname")
	private WebElement lastnameField;

	@FindBy(name = "email")
	private WebElement emailField;

	@FindBy(name = "password")
	private WebElement passwordField;
	
	@FindBy(xpath ="//*[@id=\"customer-form\"]/section/div[5]/div[1]/div/span/button")
	private WebElement showHidePasswdButton;

	@FindBy(name = "birthday")
	private WebElement birthdayField;
	
	@FindBy(xpath = "//*[@id=\"customer-form\"]/footer/button")
	private WebElement submitButton;
	
	
	public RegistrationPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void register() {
		
		if(properties.getProperty("user.gender").trim().equalsIgnoreCase("lady"))
			genderRadioInputs.get(1).click();
		else
			genderRadioInputs.get(0).click();
		firstnameField.sendKeys(properties.getProperty("user.firstname"));
		lastnameField.sendKeys(properties.getProperty("user.lastname"));
		emailField.sendKeys(properties.getProperty("user.username"));        
		showHidePasswdButton.click();
		passwordField.sendKeys(properties.getProperty("user.password"));		
        birthdayField.sendKeys(properties.getProperty("user.birthday"));
        
        submitButton.click();
	}
	
}
