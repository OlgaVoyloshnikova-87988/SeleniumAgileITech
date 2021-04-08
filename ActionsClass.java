package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	public static void main(String[] args) throws InterruptedException {
		// -------------ActionsClass-------------------------------------------
		// Selenium provides simulation of mivements with Action class
		// simulation of left click, right click, double click, scrolling catch an item
		// and drop it
		// keyboard actions: up, down, left, keys
		// we need to import this class for being able to do this operations
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Leona\\eclipse-workspace\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.snapdeal.com/");
//		WebElement allOffers = driver
//				.findElement(By.xpath("//*[@id=\"leftNavMenuRevamp\"]/div[1]/div[2]/ul/li[1]/a/span[2]"));
		// we import Actions class for selenium and create an instance of this class
//		Actions a = new Actions(driver);

		// we say here we move to the element , build the action that the user wants and
		// perform the action
//		a.moveToElement(allOffers).build().perform();
//		WebElement crocs = driver.findElement(By.xpath("//*[@id=\"category1Data\"]/div[3]/div/div/p[11]/a/span"));
//		a.moveToElement(crocs).click().build().perform();
//
//		Thread.sleep(5000);
//		
//		//we find  slider's left point that defines the desired price 
//		WebElement slider = driver.findElement(
//				By.xpath("//*[@id=\"content_wrapper\"]/div[9]/div[1]/div/div[1]/div[2]/div[2]/div[3]/div/div[1]/a[1]"));
//
//		//we slide indicating what we use, how much percent we want to move by "x" axis and 0 is for "y" axis
//		a.dragAndDropBy(slider, 50, 0).build().perform();

		// -----------------Homework-----------------
		// on BestBuy go to any category
		// open any filtering options
		// check one option( the one that is closed)

		driver.get("https://www.bestbuy.ca/en-ca");
		WebElement shop = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[4]/header/div/div/div[2]/div/div/div[1]/div[2]/div/ul/li[1]/div/button/span"));
		driver.manage().window().maximize();

		shop.click();
		WebElement appliances = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[4]/header/div/div/div[2]/div/div/div[1]/div[2]/div/ul/li[1]/div/div[2]/div/ul/li[2]/a"));
		Actions a = new Actions(driver);
		a.moveToElement(appliances).build().perform();
		WebElement refrig = driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[4]/header/div/div/div[2]/div/div/div[1]/div[2]/div/ul/li[1]/div/div[2]/div/div[2]/div[2]/div[1]/ul/li[2]/a"));
		a.moveToElement(refrig).click().build().perform();
		Thread.sleep(10000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,2000)");

		WebElement currentOffers = driver.findElement(
				By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div/main/div[1]/div[3]/div[1]/div[2]/div[1]"));
		currentOffers.click();

		WebElement onSale = driver.findElement(By.xpath(
				"//*[@id='root']/div/div[3]/div[1]/div/main/div[1]/div[2]/div[1]/div[2]/div[1]/div/div/div/li[1]/div[1]/div/div/div"));
		//// *[@id="facetFilter-On Sale"]
		onSale.click();

	}

}
