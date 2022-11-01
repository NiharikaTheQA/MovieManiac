package movieManiac.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiLandingPage {
WebDriver driver;
	
	public WikiLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="searchInput")
	WebElement movieTextInput;
	
	@FindBy(id="searchButton")
	WebElement searchButton;
	
	@FindBy(xpath="//div[contains(text(),'Release date')]//parent::th//following-sibling::td//li")
	WebElement wikiDate;
	
	@FindBy(xpath="//th[contains(text(),'Country')]//parent::th//following-sibling::td")
	WebElement wikiCountry;
	
	public String searchMovieWiki(String movieName) {
		movieTextInput.sendKeys(movieName);
		searchButton.click();
		String dateWiki = wikiDate.getText();
		return dateWiki;
		
		
	}
	public String getCountry() {
		String countryWiki=wikiCountry.getText();
		return countryWiki;
		
	}
	

}
