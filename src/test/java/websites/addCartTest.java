package websites;

import org.testng.annotations.Test;
import factories.WebDriverFactory;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class addCartTest {

	@Test
	public void addVeggies() throws IOException, InterruptedException {

		// Get browser version
		WebDriverFactory web = new WebDriverFactory();
		WebDriver driver = web.getWebDriver();
		// Thread.sleep(3000);

		// Raul Practice Website
		driver.get("https://rahulshettyacademy.com");
		driver.findElement(By.linkText("Practice Projects")).click();

		// Get registration info
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Raymond Lawson");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("raymondlawsonjr@hotmail.com");
		driver.findElement(By.id("form-submit")).click();
		Thread.sleep(3000);

		// Choose Practice 1 Example
		driver.findElement(By.linkText("Automation Practise - 1")).click();

		// Declare array
		String[] veggieNames = { "Brocolli", "Cauliflower", "Cucumber", "Beetroot", "Cashews" };

		additems(driver, veggieNames);

		// Add Veggies to Cart
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		Thread.sleep(7000);
		String s = (driver.findElement(By.cssSelector("span.promoInfo")).getText());

		if ("Code applied ..!".equals(s)) {
			System.out.println("PROMOTION CODE EXCEPTED");
		} else {
			System.out.println("PROMO CODE NOT APPLIED");

			System.out.println("test completed");
			Thread.sleep(3000);
			driver.close();
		}

		Thread.sleep(3000);
		driver.close();

	}

	public static void additems(WebDriver driver, String[] veggieNames) throws InterruptedException {

		// Select Veggies
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String[] veggie = products.get(i).getText().split("-");
			String formattedVeggieName = veggie[0].trim();

			List<String> veggieNamesList = Arrays.asList(veggieNames);

			int j = 0;

			if (veggieNamesList.contains(formattedVeggieName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == veggieNames.length) {
					break;
				}
			}

		}

	}
}
