package bus_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Libraries.BaseClass;
import Generic_Libraries.ReadData;
import pom_repo.HomePage;

public class TC_Bus_008 extends BaseClass{

	@Test(priority = 1)
	public void oneWayFromTextField() throws InterruptedException {
		//Step1:Clicking on FromTextField.
		explicitWait.until(ExpectedConditions.elementToBeClickable(homePage.getBusNavBar()));
		homePage.getBusNavBar().click();;
		explicitWait.until(ExpectedConditions.elementToBeClickable(busPage.getSearchBusButton()));
		busPage.getFromTextBox().clear();
		//explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@class=\"search-btn search-journey\"]"))));
		busPage.getFromTextBox().sendKeys(ReadData.fromPropertyFile("fromData").toString());
		String enteredValue = busPage.getFromTextBox().getAttribute("value");
		busPage.getBangaloreSearchSuggestion().click();


		Assert.assertEquals(enteredValue, ReadData.fromPropertyFile("fromData").toString(),
				"FromTextField data is not entered properly");
		Reporter.log("Data Entered Successfully in fromTextField in homePage", true);
	}

	@Test(priority = 2)
	public void oneWayToTextField() {
		//Step1:Clicking on FromTextField.'
		String toPlace = Generic_Libraries.ReadData.fromPropertyFile("toData").toString();
		System.out.println(toPlace);

		busPage.getToTextBox().sendKeys(toPlace);
		String enteredValue = busPage.getToTextBox().getAttribute("value");
		busPage.getMumbaiSearchSuggestion().click();


		Assert.assertEquals(enteredValue, toPlace,
				"FromTextField data is not entered properly");
		Reporter.log("Data Entered Successfully in toTextField in homePage", true);
	}


	@Test(priority = 3)
	public void searchBus() throws InterruptedException {
		action = new Actions(driver);
		explicitWait.until(ExpectedConditions.visibilityOf(busPage.getSearchBusButton()));
		// date from calender popup.
		int day = ReadData.dayFromSystem(8);
		String month = ReadData.monthFromSystem(2);
		homePage.getDepartureCalenderTextBox().click();
		//explicitWait.until(ExpectedConditions.elementToBeClickable(homePage.getRightCalenderArrowIcon()));
		System.out.println(day+"-"+month);
		for (;;) {
			try {
				WebElement calendar = driver.findElement(By.xpath("//span[text()='" + month + "']/../../..//div[text()='" + day + "']"));
				explicitWait.until(ExpectedConditions.elementToBeClickable(calendar));
				//calendar.click();
				action.moveToElement(calendar).doubleClick().perform();
				driver.findElement(By.id("vc-close")).click();
				//
				//action.moveByOffset(0, 0).click().perform();
				break;
			} catch (Exception e) {
				homePage.getRightCalenderArrowIcon().click();
				homePage.getRightCalenderArrowIcon().click();
			}
		}
	}

	@Test(priority = 4)
	public void searchButton() {
		explicitWait.until(ExpectedConditions.visibilityOf(busPage.getSearchBusButton()));
		busPage.getSearchBusButton().click();
	}
}