package websites;

import org.testng.annotations.Test;
import factories.WebDriverFactory;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AutoSuggestiveTest {

	@Test
	public void autoSugg() throws InterruptedException, IOException {

		WebDriverFactory web = new WebDriverFactory();
		WebDriver driver = web.getWebDriver();

		// System.setProperty("webdriver.chrome.driver",
		// "/Users/Lawson/Downloads/chromedriver");
		// WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Send keys UNI to select United States
		driver.findElement(By.id("autocomplete")).sendKeys("UNI");
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById(\"autocomplete\").value;";
		String text = (String) js.executeScript(script);

		@SuppressWarnings("unused")
		int i = 0;
		int j = 0;

		// United States
		while (!text.equalsIgnoreCase("United States (USA)")) {
			i++;
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);
			j++;
			if (j > 10) {
				break;
			}
		}

		// System.out.println(text);

		if (text.equalsIgnoreCase("United States (USA)")) {
			System.out.println(text);
			System.out.println("United States (USA) was found");
		} else {
			System.out.println("United States (USA) was NOT found");

		}

		Thread.sleep(3000);
		driver.close();
	}
}