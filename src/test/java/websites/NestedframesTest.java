package websites;

import org.testng.annotations.Test;
import factories.WebDriverFactory;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedframesTest {

	@Test
	public void frames() throws IOException, InterruptedException {

		WebDriverFactory web = new WebDriverFactory();
		WebDriver driver = web.getWebDriver();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();

		// System.out.println(driver.findElements(By.tagName("frame")).size());

		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		System.out.println(driver.findElement(By.id("Content")).getText());
		
		Thread.sleep(3000);
		driver.close();

	}

}
