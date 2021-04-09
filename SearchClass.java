package mypackage;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchClass {
	public String companyName;
	public String group;
	public double previousClose;
	public double currentPrice;
	public double percentChange;
	public static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Leona\\eclipse-workspace\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");

		Scanner sc = new Scanner(System.in); // System.in is a standard input stream.
		System.out.println("Enter the company name");

		String str = sc.nextLine(); // reads string.Scanner sc= new

		List<WebElement> company = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		List<WebElement> group = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[2]"));
		List<WebElement> previousClose = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[3]"));
		List<WebElement> currPrice = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		List<WebElement> percentChange = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[5]"));

		System.out.println("Total number of companies" + company.size());

		for (int i = 0; i < company.size(); i++) {

			String name = company.get(i).getText();
			if (name.contentEquals(str)) {

				System.out.println("Company name             " + "Group " + "PreviousClose" + "  Current Price"
						+ "   Percent Changes");
				System.out.println(company.get(i).getText() + "      " + group.get(i).getText() + "       "
						+ previousClose.get(i).getText() + "           " + currPrice.get(i).getText()
						+ "                " + percentChange.get(i).getText());

				System.out.println("Company name " + company.get(i).getText());
				System.out.println("Group " + group.get(i).getText());
				System.out.println("Preious Close " + previousClose.get(i).getText());
				System.out.println("Current Price " + currPrice.get(i).getText());
				System.out.println("Persent Changes " + percentChange.get(i).getText());
			}

		}
	}
}
