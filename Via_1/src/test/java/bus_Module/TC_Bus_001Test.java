package bus_Module;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Libraries.BaseClass;

public class TC_Bus_001Test extends BaseClass {
	@Test
public void clickOnBusNaviBar() {
	WebElement busNaviBar = homePage.getBusNavBar();
	//Clicking on Bus Navigation Bar;
	busNaviBar.click();
	Reporter.log("Clicked on Bus Navi Bar Successfully",true);
}
}
