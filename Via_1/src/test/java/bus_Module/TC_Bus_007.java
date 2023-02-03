package bus_Module;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Libraries.*;
import pom_repo.HomePage;

public class TC_Bus_007 extends BaseClass{
	@Test
	public void searchButton() {
		explicitWait.until(ExpectedConditions.elementToBeClickable(homePage.getBusNavBar()));
		homePage.getBusNavBar().click();;
		explicitWait.until(ExpectedConditions.elementToBeClickable(busPage.getSearchBusButton()));
		Reporter.log("Clicking on Search Button without entering any data into textfield");
		busPage.getSearchBusButton().click();
		String errormessage = busPage.getFromErrorMessage().getText();
		Assert.assertEquals(errormessage, ReadData.fromPropertyFile("errorMessageForFromTextField"),"Error Message is not properly displayed");
		Reporter.log("Error message is displayed");
	}
	

}
