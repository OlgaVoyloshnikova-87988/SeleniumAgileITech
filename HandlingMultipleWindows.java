package mypackage;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Leona\\eclipse-workspace\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.echoecho.com/htmllinks10.htm");

		// ----------Homework--count all links on the page----------------
		int sum = 0;
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for (WebElement l : allLinks) {
			sum++;

		}
		System.out.println("All links on the page " + sum);

		String Mainwindow = driver.getWindowHandle();

		driver.switchTo().window(Mainwindow)
				.findElement(
						By.xpath("/html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/div/a/span"))
				.click();
		// -----getting all handles of the windows and store them in the
		// set--------------
		Set<String> s1 = driver.getWindowHandles();
		// we save window handles in the table and iterate with the help of iterator
		// through that table
		Iterator<String> i = s1.iterator();
		while (i.hasNext()) {
			System.out.println("We are inthe iterator");
			String childs = i.next();
			if (!Mainwindow.equalsIgnoreCase(childs)) {

				driver.switchTo().window(childs).findElement(By.xpath("//*[@id=\"header-signin-link\"]/span")).click();
				// -------Homework----getting to yahoo mail and filling username and password
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.findElement(By.name("username")).sendKeys("alenaolga");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.findElement(By.id("login-signin")).click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.findElement(By.className("password")).sendKeys("..........");
				driver.findElement(By.id("login-signin")).click();
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				// -----Homework-------closing both windows------------------------
				driver.close();
				driver.switchTo().window(Mainwindow).close();

			}
		}

	}

}

//---------------Homework---------------------
//in the first windows the same that we used,  count avalable links on this webpage, then....go to the second
// on yahoo sign in page , put username, click on next and close both of the tabs
