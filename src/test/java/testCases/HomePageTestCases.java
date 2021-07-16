package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageActions.HomePageActions;
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
	public void VerifyPriceSort() throws IOException, InterruptedException {

		homePageNavigation();
		HomePageActions homePageActions = new HomePageActions();
		
		log.info("selecting sort drop down for Product Name");
		homePageActions.selectSortDropDown(Constants.SortCategory.Price, driver);
		log.info("selected sort drop down for Price");
		System.out.println(homePageActions.validatePricesortingAscending(driver));
		
		log.info("Validating Ascending sort based on price");
		Assert.assertTrue(homePageActions.validatePricesortingAscending(driver), "Price sort Ascending failed ");
		
		log.info("Validating Descending sort based on price");
		Assert.assertTrue(homePageActions.validatePricesortingDescending(driver), "Price sort Descending failed ");
	}
	
	
	
	@AfterTest
	public void TearDown() {
		
		driver.close();
	}

}
