package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Common {

	private WebDriver driver;

	public void invokebrowser(String browser, String url) {

		// basic system properties to find the drivers path and OS name
		String fs = System.getProperty("file.separator");
		String curdir = System.getProperty("user.dir");
		String path = curdir + fs + "drivers" + fs;
		String os = System.getProperty("os.name").toLowerCase();

		// Chrome browser selection
		if (browser.equalsIgnoreCase("Chrome")) {
			if (os.contains("mac")) {
				System.setProperty("webdriver.chrome.driver", path + "chromedriver");
			} else if (os.contains("win")) {
				System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
			}
			driver = new ChromeDriver();
		}

		// Firefox browser selection
		else if (browser.equalsIgnoreCase("firefox")) {
			if (os.contains("mac")) {
				System.setProperty("webdriver.gecko.driver", path + "geckodriver");
			} else if (os.contains("win")) {
				System.setProperty("webdriver.gecko.driver", path + "chromedriver.exe");
			}
			driver = new FirefoxDriver();
		}

		// Edge browser selection
		else if (browser.equalsIgnoreCase("edge")) {
			if (os.contains("mac")) {
				System.setProperty("webdriver.edge.driver", path + "msedgedriver");
			} else if (os.contains("win")) {
				System.setProperty("webdriver.edge.driver", path + "msedgedriver.exe");

			}
			driver = new EdgeDriver();
		}

		// Safari browser selection
		else if (browser.equalsIgnoreCase("safari")) {

			driver = new SafariDriver();
		}

		// Headless browser selection
		else if (browser.equalsIgnoreCase("headless")) {
			if (os.contains("mac")) {
				System.setProperty("webdriver.chrome.driver", path + "chromedriver");
			} else if (os.contains("win")) {
				System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
			}
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
		}

		// With invalid browser names
		else {
			System.out.println("Valid browser was not provided");
			System.exit(0);
		}

		// Maximizing the window
		driver.manage().window().maximize();

		// loading the URL
		if (url != "") {
			driver.get(url);
		} else {
			driver.get("about:blank");
		}

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void closeTab() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
