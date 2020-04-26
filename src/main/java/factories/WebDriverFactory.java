package factories;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;

public class WebDriverFactory {

	private static WebDriver driver = null;

	public WebDriver getWebDriver() throws IOException {
		// Access Property file
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//resources//Data.properties");
		prop.load(file);

		// Get browser version
		String browserName = prop.getProperty("browser");

		if (browserName.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "//Users//Lawson//Work//chromedriver");
			ChromeOptions options = new ChromeOptions();

			if (browserName.contains("headless")) {
				options.addArguments("--headless");
			}

			driver = new ChromeDriver(options);

		} else if (browserName.equals("FireFox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new InternetExplorerDriver();
		}

		return driver;
	}

	public void getScreenshot() throws IOException {

		// Takes screenshot on all failed test cases
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("//Users//Lawson//Work//Screenshots//screenshot.png"));

	}
}
