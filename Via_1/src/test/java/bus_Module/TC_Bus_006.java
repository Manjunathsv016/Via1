package bus_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Libraries.*;
import pom_repo.HomePage;

public class TC_Bus_006 extends BaseClass {

	@Test
	public void searchFlights() throws InterruptedException {
		explicitWait = new WebDriverWait(driver, 10);
		action = new Actions(driver);
		explicitWait.until(ExpectedConditions.visibilityOf(busPage.getSearchBusButton()));
		// date from calender popup.
		int day = ReadData.dayFromSystem(8);
		String month = ReadData.monthFromSystem(0);
		homePage.getDepartureCalenderTextBox().click();
		//explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='" + month + "']/../../..//div[text()='" + day + "']"))1));
		for (;;) {
			try {
				WebElement date = driver.findElement(By.xpath("//span[text()='" + month + "']/../../..//div[text()='" + day + "']"));
				date.click();
				break;
			} catch (NoSuchElementException e) {
				homePage.getRightCalenderArrowIcon().click();
			}
		}


	}

}
