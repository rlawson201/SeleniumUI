package websites;

import org.testng.annotations.Test;
import factories.WebDriverFactory;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ExerTest {

	@Test
	public void alerts() throws IOException, InterruptedException {

		WebDriverFactory web = new WebDriverFactory();
		WebDriver driver = web.getWebDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input[id='checkBoxOption2']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='checkbox-example']//label[2]")).getText());
		String label = driver.findElement(By.xpath("//div[@id='checkbox-example']//label[2]")).getText();

		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText(label);

		driver.findElement(By.cssSelector("input#name")).sendKeys(label);
		driver.findElement(By.id("alertbtn")).click();

		String message = driver.switchTo().alert().getText();

		if (message.contains(label)) {
			System.out.println("Alert message contains " + label);
		}

		else
			System.out.println("Alert message DOES NOT contain " + label);

		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.close();
	}

}