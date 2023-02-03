package pom_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusPage {
	
	public BusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[.='Bangalore']") private WebElement BangaloreSearchSuggestion;
	@FindBy(xpath = "//li[.='Goa']") private WebElement GoaSearchSuggestion;
	@FindBy(xpath = "//li[.='Hyderabad']") private WebElement HyderabadSearchSuggestion;
	@FindBy(xpath = "//li[.='Chennai']") private WebElement ChennaiSearchSuggestion;
	@FindBy(xpath = "//li[.='Mumbai']") private WebElement MumbaiSearchSuggestion;
	@FindBy(id="src") private WebElement FromTextBox;
	@FindBy(id="dest") private WebElement toTextBox;
	@FindBy(xpath = "//div[text()='No Source Specified']") private WebElement FromErrorMessage; 
	@FindBy(xpath = "//div[text()='No Destination Specified']") private WebElement ToErrorMessage;
	@FindBy(xpath = "//input[contains(@class,'journey')]") private WebElement SearchBusButton;
	
	public WebElement getBangaloreSearchSuggestion() {
		return BangaloreSearchSuggestion;
	}
	public WebElement getGoaSearchSuggestion() {
		return GoaSearchSuggestion;
	}
	public WebElement getHyderabadSearchSuggestion() {
		return HyderabadSearchSuggestion;
	}
	public WebElement getChennaiSearchSuggestion() {
		return ChennaiSearchSuggestion;
	}
	public WebElement getMumbaiSearchSuggestion() {
		return MumbaiSearchSuggestion;
	}

	public WebElement getFromTextBox() {
		return FromTextBox;
	}
	public WebElement getToTextBox() {
		return toTextBox;
	}
	public WebElement getFromErrorMessage() {
		return FromErrorMessage;
	}
	public WebElement getToErrorMessage() {
		return ToErrorMessage;
	}
	public WebElement getSearchBusButton() {
		return SearchBusButton;
	}
}
