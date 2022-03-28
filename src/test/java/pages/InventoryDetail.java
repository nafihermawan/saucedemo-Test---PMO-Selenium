package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryDetail {
	WebDriver driver;

	public InventoryDetail(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='inventory_details_name large_size']")
	WebElement itemName;

	@FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
	WebElement itemDesc;

	@FindBy(xpath = "//div[@class='inventory_details_price']")
	WebElement itemPrice;

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement btnAddCart;

	public String getItemName() {
		return itemName.getText();
	}

	public String getItemDesc() {
		return itemDesc.getText();
	}

	public String getItemPrice() {
		return itemPrice.getText();
	}

	public void clickBtnAddCart() {
		btnAddCart.click();
	}

}
