package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageActions.HomePageActions;
import util.Base;
import util.Constants;


@Listeners(listners.CommonListners.class)

public class HomePageTestCases extends Base {

	public WebDriver driver;
	public static Logger log=LogManager.getLogger(HomePageTestCases.class.getName());
	@BeforeTest
	public void initialiseDriver() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
	}

	
	public void homePageNavigation() throws IOException {
		//initialiseDriver();
		driver.get(getUrl("url"));
	}

	@Test
	public void VerifyPriceSort() throws IOException, InterruptedException {

		homePageNavigation();
		HomePageActions homePageActions = new HomePageActions();
		
		log.info("selecting sort drop down for Price");
		homePageActions.selectSortDropDown(Constants.SortCategory.Price, driver);
		log.info("selected sort drop down for Price");

		log.info("Validating Ascending sort based on price");
		Assert.assertTrue(homePageActions.validatePricesortingAscending(driver), "Price sort Ascending failed ");
		
		log.info("Validating Descending sort based on price");
		Assert.assertTrue(homePageActions.validatePricesortingDescending(driver), "Price sort Descending failed ");
	}
	
	@Test
	public void VerifyProductNameSort() throws IOException, InterruptedException {

		homePageNavigation();
		HomePageActions homePageActions = new HomePageActions();
		
		log.info("selecting sort drop down for Product Name");
		homePageActions.selectSortDropDown(Constants.SortCategory.Product_Name, driver);
		log.info("selected sort drop down for Product Name");

		log.info("Validating Ascending sort based on Product Name");
		Assert.assertTrue(homePageActions.validateProductNamesortingAscending(driver), "Product Name sort Ascending failed ");
		log.info(" Ascending sort based on Product Name validated successfully");
		
		log.info("Validating Descending sort based on Product Name");
		Assert.assertTrue(homePageActions.validateProductNamesortingDescending(driver), "Product Name Descending failed ");
		log.info(" Descending sort based on Product Name validated successfully");
	}
	
	@AfterTest
	public void TearDown() {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		
		driver.close();
	}

}
