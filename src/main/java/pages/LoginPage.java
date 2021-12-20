package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class LoginPage extends BasePage {
	private WebDriver driver;

	@FindBy(name = "email")
	private WebElement emailField;

	@FindBy(name = "password")
	private WebElement passwordField;
	
	@FindBy(css ="#login-form button")
	private WebElement showHidePasswdButton;
	
	@FindBy(linkText = "Mot de passe oublié ?")
	private WebElement forgottenPasswdLink;
	
	@FindBy(id = "submit-login")
	private WebElement submitLoginButton;
	
	@FindBy(linkText = "Pas de compte ? Créez-en un")
	private WebElement registerationLink;

	
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login() {
		emailField.sendKeys(properties.getProperty("user.username"));		
		showHidePasswdButton.click();
		passwordField.sendKeys(properties.getProperty("user.password"));
		
		submitLoginButton.click();
	}
	
	public void openRegistrationPage() {
		registerationLink.click();
	}
}
