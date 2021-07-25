package online.sujithchenanath.pageactions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import online.sujithchenanath.pageObjects.HomePage;
import online.sujithchenanath.util.base.GlobalConstants.SortCategory;

public class HomePageActions {

	public void selectSortDropDown(SortCategory visibleText, WebDriver driver) {
		HomePage homePage = new HomePage(driver);
		Select dropdownSelect = new Select(homePage.getSortDropDown());
		dropdownSelect.selectByVisibleText(formatSortCategory(visibleText));
	}

	public void setDescendingValue(WebDriver driver) {
		HomePage homePage = new HomePage(driver);
		homePage.getSetDescendingDirection().click();
	}

	public boolean validatePricesortingAscending(WebDriver driver) {
		HomePage homePage = new HomePage(driver);
		List<Integer> priceList = new ArrayList<>();
		priceList = homePage.getFinalPrice().stream()
				.map(webElement -> Integer.parseInt(webElement.getAttribute("data-price-amount")))
				.collect(Collectors.toList());

		List<Integer> sortedPriceList = new ArrayList<>();
		sortedPriceList = homePage.getFinalPrice().stream()
				.map(webElement -> Integer.parseInt(webElement.getAttribute("data-price-amount")))
				.collect(Collectors.toList());
		Collections.sort(sortedPriceList);

		return priceList.equals(sortedPriceList);
	}

	public boolean validatePricesortingDescending(WebDriver driver) {
		HomePage homePage = new HomePage(driver);
		List<Integer> priceList = new ArrayList<>();
		// clicking set ascending value button link
		setDescendingValue(driver);

		priceList = homePage.getFinalPrice().stream()
				.map(webElement -> Integer.parseInt(webElement.getAttribute("data-price-amount")))
				.collect(Collectors.toList());

		List<Integer> sortedReversePriceList = new ArrayList<>();
		sortedReversePriceList = homePage.getFinalPrice().stream()
				.map(webElement -> Integer.parseInt(webElement.getAttribute("data-price-amount")))
				.collect(Collectors.toList());
		Collections.sort(sortedReversePriceList, Collections.reverseOrder());

		return priceList.equals(sortedReversePriceList);
	}

	public boolean validateProductNamesortingAscending(WebDriver driver) {
		HomePage homePage = new HomePage(driver);
		List<String> productNames = new ArrayList<>();
		productNames = homePage.getProductText().stream().map(webElement -> webElement.getText())
				.collect(Collectors.toList());

		List<String> sortedProductNames = new ArrayList<>();
		sortedProductNames = homePage.getProductText().stream().map(webElement -> webElement.getText())
				.collect(Collectors.toList());
		Collections.sort(sortedProductNames);

		return productNames.equals(sortedProductNames);
	}

	public boolean validateProductNamesortingDescending(WebDriver driver) {
		HomePage homePage = new HomePage(driver);
		List<String> productNames = new ArrayList<>();
		setDescendingValue(driver);

		productNames = homePage.getProductText().stream().map(webElement -> webElement.getText())
				.collect(Collectors.toList());

		List<String> sortedReverseProductNames = new ArrayList<>();
		sortedReverseProductNames = homePage.getProductText().stream().map(webElement -> webElement.getText())
				.collect(Collectors.toList());
		Collections.sort(sortedReverseProductNames, Collections.reverseOrder());

		return productNames.equals(sortedReverseProductNames);
	}
	
	public void EnterSearchBox(WebDriver driver) {
		
		HomePage homePage = new HomePage(driver);
		homePage.getInputSearhBox().sendKeys("SAMPLETEXT");
	}

	public String formatSortCategory(SortCategory category) {
		return category.toString().replace("_", " ");
	}
}
