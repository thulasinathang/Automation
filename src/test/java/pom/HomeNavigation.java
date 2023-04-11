package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeNavigation {

	/*
	 * This class file contains the navigation methods to navigate different pages/modules such as 
	 * Create a WishList 
	 * Amazon Pay 
	 * New Releases 
	 * Login 
	 * Logout
	 * Searching product
	 */

	private WebDriver driver;
	Actions action;

	@CacheLookup
	@FindBy(partialLinkText = "Account")
	WebElement accountList;

	@CacheLookup
	@FindBy(partialLinkText = "Create a Wish")
	WebElement createWishList;

	@CacheLookup
	@FindBy(linkText = "New Releases")
	WebElement newRelease;

	@CacheLookup
	@FindBy(partialLinkText = "Amazon Pay")
	WebElement amazonPay;

	@CacheLookup
	@FindBy(partialLinkText = "Sign Out")
	WebElement signout;

	@CacheLookup
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchbox;

	@CacheLookup
	@FindBy(id = "nav-search-submit-button")
	WebElement searchIcon;

	public HomeNavigation(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Navigating to different module
	public void navigateTo(String targetPage) {

		action = new Actions(driver);

		if (targetPage.equalsIgnoreCase("createWishList")) {
			action.moveToElement(accountList).build().perform();
			action.moveToElement(createWishList).click().build().perform();

		} else if (targetPage.equalsIgnoreCase("newRelease")) {
			action.moveToElement(newRelease).click().build().perform();

		} else if (targetPage.equalsIgnoreCase("amazonPay")) {
			action.moveToElement(amazonPay).click().build().perform();

		}

	}

	// Navigating to login page
	public void login() {
		action = new Actions(driver);
		action.moveToElement(accountList).click().build().perform();

	}

	// logging out
	public void logout() {

		action = new Actions(driver);
		action.moveToElement(accountList).build().perform();
		action.moveToElement(signout).click().build().perform();

	}

	// Entering the product in search box and clicking search icon
	public void searchProduct(String product) {

		searchbox.sendKeys(product);
		searchIcon.click();
	}

}
