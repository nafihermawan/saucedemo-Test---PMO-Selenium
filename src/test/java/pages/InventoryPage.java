package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	WebDriver driver;

	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "inventory_item_name")
	List<WebElement> itemsName;
	
	@FindBy(className = "inventory_item_desc")
	List<WebElement> itemsDesc;
	
	@FindBy(className = "inventory_item_price")
	List<WebElement> itemsPrice;
	
	@FindBy(className = "btn btn_primary btn_small btn_inventory")
	List<WebElement> itemsAddCart;
	
	public void clickItemName(int index) {
		itemsName.get(index).click();
	}
	
	public void clickBtnAddCart(int index) {
		itemsAddCart.get(index).click();
	}
	
	public String getItemName(int index) {
		return itemsName.get(index).getText();
	}
	
	public String getItemPrice(int index) {
		return itemsPrice.get(0).getText();
	}
}
