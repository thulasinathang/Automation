package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Keyword;

public class LoginPage {

	// This class file contains positive login and Negative login error validation

	private WebDriver driver;
	Keyword kw;

	@CacheLookup
	@FindBy(id = "ap_email")
	WebElement usernameElement;

	@CacheLookup
	@FindBy(id = "continue")
	WebElement continueBtn;

	@CacheLookup
	@FindBy(id = "ap_password")
	WebElement passwordElement;

	@CacheLookup
	@FindBy(xpath = "//h4[@class='a-alert-heading']")
	WebElement errorHeading;

	@CacheLookup
	@FindBy(xpath = "//span[@class='a-list-item']")
	WebElement invalidUsernameError;

	@CacheLookup
	@FindBy(xpath = "//div[@class='a-alert-content']/ancestor::div[@id='auth-email-missing-alert']")
	WebElement blankUsernameError;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Entering Username and continue
	public void usernameCred(String username) {

		usernameElement.clear();
		usernameElement.sendKeys(username);
		continueBtn.click();

	}

	// Entering Password
	public void passwordCred(String password) {
		passwordElement.clear();
		passwordElement.sendKeys(password);

	}

	// capturing the error heading
	public String getErrorHeading() {
		return errorHeading.getText();
	}

	// capturing the error message
	public String getErrorMsg(String scenario) {

		kw = new Keyword(driver);

		String errorMsg = null;

		if (scenario.equalsIgnoreCase("blankUserName")) {
			errorMsg = kw.getErrorMsg(blankUsernameError);

		} else {
			errorMsg = kw.getErrorMsg(invalidUsernameError);

		}

		return errorMsg;
	}

}
