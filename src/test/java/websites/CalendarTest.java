package websites;

import org.testng.annotations.Test;
import factories.WebDriverFactory;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarTest {

	@Test
	public void days() throws IOException, InterruptedException {

		WebDriverFactory web = new WebDriverFactory();
		WebDriver driver = web.getWebDriver();

		driver.get("https://www.path2usa.com/travel-companions");

		// April 23
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();

		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
				.contains("May")) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}

		// Grab common attribute//Put into list and iterate
		int count = driver.findElements(By.className("day")).size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase("21")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}

		}
		
		Thread.sleep(3000);
		driver.close();
	}

}
