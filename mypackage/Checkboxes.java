package mypackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Leona\\eclipse-workspace\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.get("http://www.echoecho.com/htmlforms09.htm");
//		List<WebElement> checkboxes = driver.findElements(By.name("Checkbox"));
//		System.out.println(checkboxes.size());
//		checkboxes.get(0).click();
//		checkboxes.get(1).click();
//		checkboxes.get(2).click();

		// Homework N1 count the number of links on the webpage
		// shopping.rediff.com

		driver.get("http://www.shopping.rediff.com");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int sum = 0;
		for (int i = 0; i < links.size(); i++) {
			sum = i++;
		}
		System.out.println("Count links" + sum);
	}

}
