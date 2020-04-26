package websites;

import org.testng.annotations.Test;
import factories.WebDriverFactory;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableAssignmentTest {

	@Test
	public void getTableInfo() throws IOException, InterruptedException {
		
		WebDriverFactory web = new WebDriverFactory();
		WebDriver driver = web.getWebDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement table = driver.findElement(By.cssSelector("#product"));
		int rowCount = table.findElements(By.xpath("//div[@class='block large-row-spacer']//tr")).size();
		System.out.println("Number of rows = " + rowCount);
		System.out.print("Number of columns = ");
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

		List<WebElement> secondRow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		 
		int secondRowSize = secondRow.size();

		for (int i = 0; i < secondRowSize; i++) {
			System.out.println(secondRow.get(i).getText());
		}
		
		Thread.sleep(3000);
		driver.close();

	}
}
