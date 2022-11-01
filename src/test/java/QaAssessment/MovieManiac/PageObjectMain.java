package QaAssessment.MovieManiac;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import movieManiac.pageObject.DetailPage;
import movieManiac.pageObject.LandingPage;
import movieManiac.pageObject.WikiLandingPage;

public class PageObjectMain {
	

	@Test
	public void searchAndCompareMovie() throws IOException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		 Properties prop;
		 prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		
			prop.load(fis);
			
			String movieName= prop.getProperty("movie");
			String imdbUrl=prop.getProperty("IMDBUrl");
			String wikiUrl=prop.getProperty("wikiURL");
			
		
	
		
		driver.get(imdbUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.searchMovie(movieName);
		
		DetailPage detailPage = new DetailPage(driver);
		String imdbCountryName=detailPage.fetchCountry();
		String imdbDate=detailPage.fetchDate();
			
		driver.navigate().to(wikiUrl);
		WikiLandingPage wikiLandingPage = new WikiLandingPage(driver);
		String wikiDate=wikiLandingPage.searchMovieWiki(movieName);
		String wikiCountry=wikiLandingPage.getCountry();
		
		Assert.assertEquals(imdbCountryName, wikiCountry);
		Assert.assertEquals(imdbDate, wikiDate);
		
		driver.quit();

}
	}
