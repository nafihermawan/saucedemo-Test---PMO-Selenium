package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import pages.InventoryDetail;
import pages.InventoryPage;
import pages.LoginPage;

public class SeleniumTest {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.navigate().to("https://www.saucedemo.com/");
	}

	@Test
	public void test() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername("standard_user");
		loginPage.setPassword("secret_sauce");
		loginPage.clickBtnLogin();

		InventoryPage inventoryPage = new InventoryPage(driver);
		String expectedItemName = inventoryPage.getItemName(0);
		String expectedItemPrice = inventoryPage.getItemPrice(0);
		inventoryPage.clickItemName(0);

		InventoryDetail inventoryDetail = new InventoryDetail(driver);
		String actualItemName = inventoryDetail.getItemName();
		String actualItemPrice = inventoryDetail.getItemPrice();

		Assert.assertEquals(expectedItemName, actualItemName);
		Assert.assertEquals(expectedItemPrice, actualItemPrice);

		System.out.println(actualItemName);
		System.out.println(actualItemPrice);
	}

	@AfterSuite
	public void close() {
//		driver.quit();
	}
}