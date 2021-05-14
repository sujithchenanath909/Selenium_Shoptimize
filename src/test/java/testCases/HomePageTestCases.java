package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ManageBooking;
import util.Base;
import util.Constants;

public class HomePageTestCases extends Base {

	public WebDriver driver;
	public static Logger log=LogManager.getLogger(HomePageTestCases.class.getName());
	@BeforeTest
	public void initialiseDriver() throws IOException {

		driver = initializeDriver();
		
	}

	@Test
	public void homePageNavigation() throws IOException {

		//initialiseDriver();
		driver.get(getUrl("url"));
	}

	@Test
	public void clickMyBookingsLink() throws IOException {

		homePageNavigation();
		HomePage homePageObject = new HomePage(driver);
		ManageBooking managePageObject = new ManageBooking(driver);

		log.info("Clicking MyBookings Link");
		homePageObject.getMyBookingsLink().click();

		// veriify Link Click
		Assert.assertEquals(managePageObject.getPageTile().getText().trim(), Constants.PAGETITLE);
	}
	
	@AfterTest
	public void TearDown() {
		
		driver.close();
	}

}
