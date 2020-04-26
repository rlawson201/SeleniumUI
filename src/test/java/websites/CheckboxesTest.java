package websites;

import org.testng.annotations.Test;
import factories.WebDriverFactory;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxesTest {

	@Test
	public void check() throws IOException, InterruptedException {
		
		WebDriverFactory web = new WebDriverFactory();
		WebDriver driver = web.getWebDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Check option 1 Box and check verify
		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());

		// Uncheck Option 1 Box and verify
		driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());

		// Count the # of checkboxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkBox']")).size());
		
		Thread.sleep(3000);
		driver.close();

	}
}