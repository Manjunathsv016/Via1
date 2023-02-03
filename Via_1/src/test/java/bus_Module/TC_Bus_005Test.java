package bus_Module;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Libraries.*;
import pom_repo.HomePage;

public class TC_Bus_005Test extends BaseClass{

	@Test
	public void negativeToTextField(){
		explicitWait.until(ExpectedConditions.elementToBeClickable(homePage.getBusNavBar()));
		homePage.getBusNavBar().click();
		
		busPage.getToTextBox().click();
		System.out.println("hello");
		
		// Step1:Clicking on ToTextField.
		busPage.getToTextBox().clear();
		
		// Step2:Typing Invalid Data.
		String invalidData = ReadData.fromPropertyFile("invalidToData").toString();
		busPage.getToTextBox().sendKeys(invalidData);
		String enteredValue = busPage.getToTextBox().getAttribute("value");
		
		Assert.assertEquals(enteredValue, invalidData,"FromTextField data is not entered properly");
		Reporter.log("Data Entered Successfully in fromTextField in homePage", true);
		busPage.getSearchBusButton().click();
		String errormessage = busPage.getToErrorMessage().getText();
		Assert.assertEquals(errormessage, ReadData.fromPropertyFile("errorMessageForFromTextField"),"Error Message is not properly displayed");
		busPage.getSearchBusButton().click();
	}
}