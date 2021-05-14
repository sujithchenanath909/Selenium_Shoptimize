package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Base;

public class ManageBooking extends Base {

	WebDriver driver;
	public  ManageBooking(WebDriver driver) throws IOException {
		
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[@class='title']")
	private WebElement pageTile;

	public WebElement getPageTile() {
		return pageTile;
	}

	
	
}
