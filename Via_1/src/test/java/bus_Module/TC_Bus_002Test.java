package bus_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Libraries.*;
import pom_repo.HomePage;

public class TC_Bus_002Test extends BaseClass{

	@Test
	public void busFromTextField() throws InterruptedException {
		explicitWait.until(ExpectedConditions.elementToBeClickable(homePage.getBusNavBar()));
		homePage.getBusNavBar().click();

		//Step1:Clicking on FromTextField.
		busPage.getFromTextBox().clear();
		String fromData = ReadData.fromPropertyFile("fromData").toString();
		busPage.getFromTextBox().sendKeys(fromData);
		String enteredData = busPage.getFromTextBox().getAttribute("value");
		busPage.getBangaloreSearchSuggestion().click();

		Assert.assertEquals(enteredData,fromData,"FromTextField data is not entered properly");
		Reporter.log("Data Entered Successfully in fromTextField in busPage", true);
		//hp.getFromTextBox().sendKeys(Keys.TAB);
	}
}
