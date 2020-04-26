package websites;

import org.testng.annotations.Test;
import factories.WebDriverFactory;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitwaitTest {

	@Test
	public void waits() throws IOException, InterruptedException {

		WebDriverFactory web = new WebDriverFactory();
		WebDriver driver = web.getWebDriver();
		WebDriverWait w = new WebDriverWait(driver, 5);

		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");

		// driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via
		// Ajax!')]")).click();
		driver.findElement(By.cssSelector("a[href*='loadAjax']")).click();

		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='results']")));
		System.out.println(driver.findElement(By.xpath("//div[@id='results']")).getText());
		
		Thread.sleep(3000);
		driver.close();

	}

}
