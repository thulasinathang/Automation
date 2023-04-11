package com.amazon.amazon_poc;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import utils.Common;
import utils.Constants;
import utils.Keyword;
import utils.ReadPropertiesFile;
import pom.LoginPage;
import pom.HomeNavigation;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {

	WebDriver driver;
	Common common;
	Keyword kw;
	HomeNavigation navigation;
	LoginPage loginpage;

	// Before activities such as reading properties files and invoking browser
	@Before
	public void setup() {
		ReadPropertiesFile readProperty = new ReadPropertiesFile();
		readProperty.readProperties();
		common = new Common();
		common.invokebrowser(Constants.Browser, "");
		this.driver = common.getDriver();
		kw = new Keyword(driver);

	}

	// After activities such as quitting browser
	@After
	public void tearDown() {
		common.quitBrowser();
	}

	// Redirecting to required URL (testing amzn.in)- url value should be provided in feature file
	@When("User enter the url as {string}")
	public void redirectTo(String url) {

		kw.redirect(url);

	}

	// Validating that page redirected to expected URL (amazon.in)-expectedUrl value should be provided in feature file
	@Then("User validate that URL is redirected to {string}")
	public void urlValidation(String expectedUrl) {
		String failuremsg = "URL validation failed";
		String actualurl = kw.getUrl();
		kw.compareResult(expectedUrl, actualurl, failuremsg);

	}

	// Validating the page title- expectedTitle value should be provided in feature file
	@Then("User validate the page title displayed as {string}")
	public void titleValidation(String expectedTitle) {

		String failuremsg = "Title validation failed";
		String actualTitle = kw.getCurrentTittle();
		kw.compareResult(expectedTitle, actualTitle, failuremsg);

	}

	// Loading amazon home page using the url from properties file
	@Given("User on amazon home page")
	public void homePage() {
		kw.redirect(Constants.URL);
	}

	// Navigating to different pages/module- taregtPage must be provided from feature file
	@When("User click on {string}")
	public void navigationModule(String targetPage) {
		navigation = new HomeNavigation(driver);
		navigation.navigateTo(targetPage);

	}

	// clicking on sign link
	@When("User click on sign in link from home page")
	public void signInLink() {
		navigation = new HomeNavigation(driver);
		navigation.login();

	}

	// Entering credentials and continue- username and password should be provided in feature file

	@When("User enter {string} and click continue button")
	public void enterUsername(String username) {
		loginpage = new LoginPage(driver);
		loginpage.usernameCred(username);

	}

	@When("User enter {string}")
	public void enterPassword(String password) {
		loginpage = new LoginPage(driver);
		loginpage.passwordCred(password);
	}

	// Verifying the error message for different condition - expected values should be provided in feature file
	@Then("User verify the {string} and {string} message for {string} scenario")
	public void verifyErrorMessage(String expectedErrorHeading, String expectedErrorMsg, String scenario) {

		String ErrormsgValidationfailureMsg = "Error validation failed";
		String ErrorHeadingValidationfailureMsg = "Error heading validation failed";
		loginpage = new LoginPage(driver);
		String actualErrorHeading = loginpage.getErrorHeading();
		System.out.println("heading is " + actualErrorHeading);
		String actualErrorMessage = loginpage.getErrorMsg(scenario);
		kw.compareResult(expectedErrorHeading, actualErrorHeading, ErrorHeadingValidationfailureMsg);
		kw.compareResult(expectedErrorMsg, actualErrorMessage, ErrormsgValidationfailureMsg);
		System.out.println("Testing");

	}

}
