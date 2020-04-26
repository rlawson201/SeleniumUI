package websites;

import org.testng.annotations.Test;
import factories.WebDriverFactory;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MarsairTest {

	@Test
	public void interview() throws IOException, InterruptedException {

		WebDriverFactory web = new WebDriverFactory();
		WebDriver driver = web.getWebDriver();

		driver.get("https://marsair.thoughtworks-labs.net/Raymond_Lawson"); // Raul Practice Website

		// Departing July
		Select s = new Select(driver.findElement(By.id("departing")));
		s.selectByValue("0");

		// Returning December(two years from now)
		Select r = new Select(driver.findElement(By.id("returning")));
		r.selectByValue("5");

		// Enter valid Promo code
		driver.findElement(By.id("promotional_code")).sendKeys("AF3-FJK-418");

		// Click on search button
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd/input")).click();

		// Assertion to validate Promo code string "Promotional code AF3-FJK-418 used:
		// 30% discount!"
		
		String actualText = (driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText());
		String expectedText = ("Promotional code AF3-FJK-418 used: 30% discount!");
		
		assertTrue(actualText.equals(expectedText));;
		
		Thread.sleep(3000);
		driver.close();

	}

}
