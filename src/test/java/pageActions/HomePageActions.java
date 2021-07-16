package pageActions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pageObjects.HomePage;
import util.Constants.SortCategory;

public class HomePageActions {
	
	
	public void selectSortDropDown(SortCategory visibleText, WebDriver driver) {
		HomePage homePage = new HomePage(driver);
		Select dropdownSelect = new Select(homePage.getSortDropDown());
		dropdownSelect.selectByVisibleText(formatSortCategory(visibleText));
	}
	
	public void setDescendingValue(WebDriver driver) {
		HomePage homePage = new HomePage(driver);
		homePage.getSetAscendingDirection().click();
	}
	
	public boolean validatePricesortingAscending(WebDriver driver){
		HomePage homePage = new HomePage(driver);
		List<Integer> priceList=new ArrayList<>();
		homePage.getFinalPrice().stream().map(webElement->Integer.parseInt( webElement.getAttribute("data-price-amount"))).
				forEach(price->System.out.println(price));
		priceList=homePage.getFinalPrice().stream().map(webElement->Integer.parseInt( webElement.getAttribute("data-price-amount"))).
				collect(Collectors.toList());
		
		
		List<Integer> sortedPriceList=new ArrayList<>();
		sortedPriceList=homePage.getFinalPrice().stream().map(webElement->Integer.parseInt( webElement.getAttribute("data-price-amount"))).
				collect(Collectors.toList());
		Collections.sort(sortedPriceList);
	
		return priceList.equals(sortedPriceList);
	}
	
	public boolean validatePricesortingDescending(WebDriver driver){
		HomePage homePage = new HomePage(driver);
		List<Integer> priceList=new ArrayList<>();
		//clicking set ascending value button link
		setDescendingValue(driver);
		
	
		priceList=homePage.getFinalPrice().stream().map(webElement->Integer.parseInt( webElement.getAttribute("data-price-amount"))).
				collect(Collectors.toList());
		
		
		List<Integer> sortedReversePriceList=new ArrayList<>();
		sortedReversePriceList=homePage.getFinalPrice().stream().map(webElement->Integer.parseInt( webElement.getAttribute("data-price-amount"))).
				collect(Collectors.toList());
		Collections.sort(sortedReversePriceList,Collections.reverseOrder());
	
		
		return priceList.equals(sortedReversePriceList);
	}
	

	public String formatSortCategory(SortCategory category) {
		return category.toString().replace("_", " ");
	}
}
