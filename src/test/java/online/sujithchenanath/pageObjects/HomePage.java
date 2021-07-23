package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='sorter']")
	private WebElement sortDropDown;
	
	@FindBy(xpath = "//span[@data-price-type='finalPrice']")
	List<WebElement> finalPrice;

	@FindBy(xpath = "//a[@title='Set Descending Direction']")
	private WebElement setDescendingDirection;
	
	@FindBy(xpath = "	//a[@class='product-item-link']")
	List<WebElement> productText;




	public List<WebElement> getProductText() {
		return productText;
	}


	public WebElement getSetDescendingDirection() {
		return setDescendingDirection;
	}


	public List<WebElement> getFinalPrice() {
		return finalPrice;
	}


	public WebElement getSortDropDown() {
		return sortDropDown;
	}


	
}
