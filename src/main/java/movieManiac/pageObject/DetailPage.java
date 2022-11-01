package movieManiac.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailPage {
	
WebDriver driver;
	
	public DetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

	
	@FindBy(xpath="//li[@data-testid=\"title-details-origin\"]//li/a")
	WebElement imdbCountryName;	
	
	@FindBy(xpath="//li[@data-testid=\"title-details-releasedate\"]//li/a")
	WebElement dateUrl;	
	
	@FindBy(xpath="//a[contains(text(),'India')]//parent::td//following-sibling::td[1]")
	WebElement imdbDateData;	
	
	public String fetchCountry() {
		
		String imdbCountry=imdbCountryName.getText();
		return imdbCountry;
		
	}
	
public String fetchDate() {
	dateUrl.click();
	String imdbDate=imdbDateData.getText();
	return imdbDate;
	
		
		
	}
	
	
	
//a[contains(text(),'India')]//parent::td//following-sibling::td[1]
	//li[@data-testid=\"title-details-releasedate\"]//li/a
}
