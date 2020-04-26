package websites;

import org.testng.annotations.Test;
import factories.WebDriverFactory;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CleartripTest {

	@Test
	public void travel() throws InterruptedException, IOException {

		WebDriverFactory web = new WebDriverFactory();
		WebDriver driver = web.getWebDriver();

		driver.get("https://www.cleartrip.com/"); // Practice Example
		Thread.sleep(3000);

		// Select current date on Calendar
		driver.findElement(By.id("DepartDate")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		// Select 2 Adults
		Select s = new Select(driver.findElement(By.id("Adults")));
		s.selectByValue("2");

		// Select 1 Child
		Select c = new Select(driver.findElement(By.id("Childrens")));
		c.selectByValue("1");

		// Select More Option Link
		driver.findElement(By.id("MoreOptionsLink")).click();

		// Enter Airline Name
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Ray Airlines");

		// Click on Search
		driver.findElement(By.id("SearchBtn")).click();

		// Print Error Message
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
		
		Thread.sleep(3000);
		driver.close();

	}

}
