package websites;

import org.testng.annotations.Test;
import factories.WebDriverFactory;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultiplewindowsTest {

	@Test
	public void windows() throws IOException, InterruptedException {
		
		WebDriverFactory web = new WebDriverFactory();
		WebDriver driver = web.getWebDriver();

		driver.get("https://the-internet.herokuapp.com");

		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

		Set<String> s = driver.getWindowHandles();
		Iterator<String> t = s.iterator();
		String parentid = t.next();
		String childid = t.next();
		driver.switchTo().window(childid);
		System.out.println(driver.getTitle());

		driver.switchTo().window(parentid);
		String r = (driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]"))).getText();
		System.out.println(r);
		
		Thread.sleep(3000);
		driver.quit();

	}

}
