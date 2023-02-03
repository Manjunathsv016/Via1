package bus_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Libraries.*;
import pom_repo.HomePage;

public class TC_Bus_003Test extends BaseClass {

	@Test
	public void negativeFromTextField(){
		explicitWait.until(ExpectedConditions.elementToBeClickable(homePage.getBusNavBar()));
		homePage.getBusNavBar().click();;

		// Step1:Clicking on FromTextField.
		busPage.getFromTextBox().clear();
		
		// Step2:Entering Invalid Data.
		String invalidFromData = ReadData.fromPropertyFile("invalidFromData").toString();
		busPage.getFromTextBox().sendKeys(ReadData.fromPropertyFile("invalidFromData").toString());
		String enteredData = busPage.getFromTextBox().getAttribute("value");
		
		Assert.assertEquals(enteredData, invalidFromData,"FromTextField data is not entered properly");
		Reporter.log("Data Entered Successfully in fromTextField in busPage", true);
		busPage.getSearchBusButton().click();
		String errorMessageFromTextField = ReadData.fromPropertyFile("errorMessageForFromTextField");
		String errormessage = busPage.getFromErrorMessage().getText();
		Assert.assertEquals(errormessage, errorMessageFromTextField,"Error Message is not properly displayed");
		Reporter.log("Error message is matching correctly",true);
	}
}
