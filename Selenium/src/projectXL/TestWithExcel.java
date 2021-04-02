package projectXL;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestWithExcel {
	WebDriver driver;
	TableXL tbl;

	@BeforeClass
	public void initStep() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Leona\\eclipse-workspace\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void launchBrowser() {

		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");

	}

	@Test
	public void inputData() throws IOException {
		tbl = new TableXL();
		// identify element on the page
		WebElement fullName = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input"));
		WebElement id = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[9]/td[3]/input"));
		WebElement retypePassword = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[11]/td[3]/input"));

		tbl.setExcelFile("C:\\Users\\Leona\\eclipse-workspace\\Selenium\\MyExcelData.xlsx", "Sheet1");
		// int rowCount = tbl.sheet.getLastRowNum() - TableXL.sheet.getFirstRowNum();
		int i = 0;
		int j = 0;

		// Enter the values read from Excel in fullname,id password,password
		fullName.sendKeys(tbl.getCellData(i, j));
		id.sendKeys(tbl.getCellData(i, 1));
		password.sendKeys(tbl.getCellData(i, 2));
		retypePassword.sendKeys(tbl.getCellData(i, 3));
		// https://github.com/OlgaVoyloshnikova-87988/SeleniumAgileITech.git
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
