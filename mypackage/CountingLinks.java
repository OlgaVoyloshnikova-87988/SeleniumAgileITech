package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountingLinks {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Leona\\eclipse-workspace\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://shopping.rediff.com");
//		WebElement box = driver.findElement(By.id("popular_cat"));

//		List<WebElement> l = box.findElements(By.tagName("a"));
//		System.out.println(l.size());
//		for (int i = 0; i < l.size(); i++) {
//
//			System.out.println(l.get(i).getText());
//		}

		// Homework N2
		// cklick on any link on a webpage
		// Get the text from the link cklicked
		// I choose to click on Womens Wear link on this page

		WebElement link = driver.findElement(By.xpath("//*[@id=\"home_page\"]/div[2]/div/ul/li[2]/a/div/div"));
		System.out.println(link.getText());

	}

}
