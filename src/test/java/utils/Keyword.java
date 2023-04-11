package utils;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Keyword {

	WebDriver driver;

	public Keyword(WebDriver driver) {

		this.driver = driver;

	}

	// Redirecting to specific url
	public void redirect(String url) {
		driver.navigate().to(url);
	}

	// getting the current title of the webPage
	public String getCurrentTittle() {

		return driver.getTitle();

	}

	// Getting the URL of the webpage
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	// Getting the error text message
	public String getErrorMsg(WebElement element) {
		
		return element.getText();
	}
	

	// Comparing the text
	public void compareResult(String expected, String actual, String failuremsg) {

		Assertions.assertTrue(actual.equals(expected), failuremsg + ",");

	}
	

}
