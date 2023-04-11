package pom;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Keyword;

public class ProductResultPage {
	
	/*This class file contains below reusable methods
	 * Validating the search results
	 * Filtering the result based on different ratings
	 * Selecting the first item from result and changing the focus to new product window
	 */

	WebDriver driver;
	Keyword kw;
	WebDriverWait wait;

	@CacheLookup
	@FindBy(xpath = "//span[contains (text(),'results')]")
	WebElement searchResultNumber;

	@CacheLookup
	@FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
	WebElement searchResultProduct;

	@CacheLookup
	@FindBy(xpath = "//i[@class='a-icon a-icon-star-medium a-star-medium-1']")
	WebElement reviewRating1star;

	@CacheLookup
	@FindBy(xpath = "//i[@class='a-icon a-icon-star-medium a-star-medium-2']")
	WebElement reviewRating2stars;

	@CacheLookup
	@FindBy(xpath = "//i[@class='a-icon a-icon-star-medium a-star-medium-3']")
	WebElement reviewRating3stars;

	@CacheLookup
	@FindBy(xpath = "//i[@class='a-icon a-icon-star-medium a-star-medium-4']")
	WebElement reviewRating4stars;

	@CacheLookup
	@FindBy(xpath = "//img[@data-image-index='1']")
	WebElement firstItemFromResult;

	public ProductResultPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Validating the search result
	public void searchResultValidation(String expectedSearchResult) {
		kw = new Keyword(driver);
		String actualSearchResult;
		actualSearchResult = searchResultNumber.getText() + " " + searchResultProduct.getText();
		String failureMsg = "result validation failed";
		kw.compareResult(expectedSearchResult, actualSearchResult, failureMsg);

	}

	// filtering the result based on rating- star value should be provided from feature file
	public void filterByReview(String rating) {

		if (rating.equalsIgnoreCase("1 Star")) {

			reviewRating1star.click();

		} else if (rating.equalsIgnoreCase("2 Stars")) {

			reviewRating2stars.click();

		} else if (rating.equalsIgnoreCase("3 Stars")) {

			reviewRating3stars.click();

		} else if (rating.equalsIgnoreCase("4 Stars")) {

			reviewRating4stars.click();

		}

	}

	// Selecting the first item from the search result and changing the focus to new window
	public void selectingProduct() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(firstItemFromResult));
		firstItemFromResult.click();
		ArrayList<String> winHandle = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(winHandle.get(1));
	}

}
