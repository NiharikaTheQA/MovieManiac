package movieManiac.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="suggestion-search")
	WebElement movieTextInput;
	
	@FindBy(id="iconContext-magnify")
	WebElement searchButton;
	
	@FindBy(linkText="Pushpa: The Rise - Part 1")
	WebElement movieLink;
	
	@FindBy(xpath="//li[@data-testid=\\\"title-details-origin\\\"]//li/a")
	WebElement imdbCountryName;
	
	public void searchMovie(String movieName) {
		movieTextInput.sendKeys(movieName);
		searchButton.click();
		movieLink.click();
		
	}
	

}
