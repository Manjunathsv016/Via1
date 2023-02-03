package bus_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Libraries.*;
import pom_repo.HomePage;

public class TC_Bus_004Test extends BaseClass{
	@Test
	public void busToTextField() {
		explicitWait.until(ExpectedConditions.elementToBeClickable(homePage.getBusNavBar()));
		homePage.getBusNavBar().click();
		
		//Step1:Clicking on ToTextField.
		String toPlace = Generic_Libraries.ReadData.fromPropertyFile("toData").toString();
		busPage.getToTextBox().sendKeys(toPlace);
		String enteredData = busPage.getToTextBox().getAttribute("value");
		busPage.getGoaSearchSuggestion().click();
		
		Assert.assertEquals(enteredData, toPlace,"FromTextField data is not entered properly");
		Reporter.log("Data Entered Successfully in fromTextField in busPage", true);
	}
}
