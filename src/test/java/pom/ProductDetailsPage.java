package pom;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Keyword;

public class ProductDetailsPage {

	/*
	 * This class file contains the below reusable methods, so that we can use these methods whenever required. 
	 * Getting the product price 
	 * Playing the mobile video
	 * changing the delivery location 
	 * Adding the product to cart 
	 * Closing the cart window
	 */

	WebDriver driver;
	Keyword kw;
	WebDriverWait wait;

	@CacheLookup
	@FindBy(xpath = "//span[@class='a-offscreen']/ancestor::span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")
	WebElement productPrice;

	@CacheLookup
	@FindBy(xpath = "//span[@id='videoCount']")
	WebElement playVideo;

	@CacheLookup
	@FindBy(id = "contextualIngressPtLabel_deliveryShortLine")
	WebElement deliveryLocation;

	@CacheLookup
	@FindBy(id = "GLUXZipUpdateInput")
	WebElement zipCodeBox;

	@CacheLookup
	@FindBy(xpath = "//input[@type='submit']/ancestor::span[@id='GLUXZipUpdate']")
	WebElement zipCodeApplyButton;

	@CacheLookup
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addToCartButton;

	@CacheLookup
	@FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
	WebElement successmsg;

	@CacheLookup
	@FindBy(xpath = "//a[@class='a-link-normal close-button']")
	WebElement closeAddToCart;

	public ProductDetailsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Getting the product price and comparing with expected value- Expected price should be provided from feature file
	public void getProductPrice(String expectedProductPrice) {
		kw = new Keyword(driver);
		String actualProductPrice = productPrice.getText();
		String failuremsg = "Product price validation failed";
		kw.compareResult(expectedProductPrice, actualProductPrice, failuremsg);

	}

	// Playing the video from item image section and closing the video iframe
	public void playVideo() {
		playVideo.click();
		driver.findElement(By.xpath("//i[@class='a-icon a-icon-close']")).click();
	}

	// Changing the delivery location by entering the zip/postal code
	public void changeDeliveryLocation(String zipcode) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(deliveryLocation));
		deliveryLocation.click();
		zipCodeBox.sendKeys(zipcode);
		zipCodeApplyButton.click();

	}

	// Adding the product into cart
	public void addToCart() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		addToCartButton.click();
	}

	// Validating the success message displayed after adding the product into cart
	public void validateSuccessmsg(String expectedSuccessMsg) {
		kw = new Keyword(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(successmsg));
		String actualSuccessmsg = successmsg.getText();
		String failuremsg = "Add to cart message validation failed";
		kw.compareResult(actualSuccessmsg, expectedSuccessMsg, failuremsg);

	}

	// Closing the cart window
	public void closeAddToCartWindow() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(closeAddToCart));
		closeAddToCart.click();
	}
}
