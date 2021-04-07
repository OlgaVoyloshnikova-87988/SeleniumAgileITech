package mypackage;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Leona\\eclipse-workspace\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.get("http://www.echoecho.com/htmlforms11.htm");
		// to choose one element in the dropdown menu we can put just the name in the
		// sendKeys
//		driver.findElement(By.name("dropdownmenu")).sendKeys("Cheese");

		// to find all elements of the dropdown menu we find the particular menu first
		// then we create a list and print out elements of the list
//		WebElement w = driver.findElement(By.name("dropdownmenu"));
//		List<WebElement> l = w.findElements(By.tagName("option"));
//		for (int i = 0; i < l.size(); i++) {
//			System.out.println(l.get(i).getText());
//		}

		// ---------------Homework N3-------------------------
		// Go to rediff.com there is a country dropdown
		// we should select any country where you live from the dropdown
		// extract all the elements from the dropdown
		// design aSeleniumcode to select a random country in the dropdown
		// each time we run the code the country will be different
		// Print out this random value in the console
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");

		// select any country where you live from the dropdown

		driver.findElement(By.id("country")).sendKeys("Canada");

		// extract all values in dropdown
		WebElement dropdown = driver.findElement(By.id("country"));
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();

		System.out.println("Dropdown values are ");
		for (WebElement item : options) {

			System.out.println(item.getText());

		}
		System.out.println("In total countries" + options.size());

		// random country
		Random random = new Random();

		int index = random.nextInt(options.size());
		String countryName = options.get(index).getText();
		System.out.print(countryName + "Random country name ");

		driver.findElement(By.id("country")).sendKeys(countryName);

	}
}
