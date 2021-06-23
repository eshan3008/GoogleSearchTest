package googleSearchPackage;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Constants;

public class googleSearchTest {

    WebDriver driver= new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,2);
	
    @Test
	public void GoogleSearchTest() {
    	//GooglePage googlepage= new GooglePage(driver.get());
		driver.get(Constants.GOOGLE_LINK);
		driver.manage().window().maximize();
		//Assertions of google page objects
		WebElement GoogleSearchButton= driver.findElement(By.name("btnK"));
		WebElement FeelingLuckyButton= driver.findElement(By.id("gbqfbb"));

//		Assert.assertEquals(true, GoogleSearchButton.isDisplayed());
//		Assert.assertEquals(true, FeelingLuckyButton.isDisplayed());

		// Searched for Ducks on google search
		WebElement SearchBox= wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		
		//Entered in search box
		SearchBox.sendKeys(Constants.GOOGLE_SEARCH_STRING); 
		List<WebElement> options = new WebDriverWait(driver, 3).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//ul[@role='listbox']//li/descendant::span"), 0));

	    //System.out.println("no. of suggestions:"+options.size());
	    
	    for(int i=0;i<options.size();i++) {
	        
	        System.out.println(options.get(i).getText());
	        options.get(i).getText().contains("ducks");
	        //Assert.assertEquals(true, options.get(i).getText().contains("ducks"));
	        //ASSert options having ducks
	    }
	    
	    SearchBox.sendKeys(Keys.ENTER); 
	    
	 // After Searching
		WebElement nextLink= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#pnnext")));
		
//		List<WebElement> resultEntries = driver.findElements(By.className("LC20lb DKV0Md"));
//		for (WebElement element:resultEntries) {
//			//System.out.println(element.getAttribute("href"));
//			System.out.println(element.getText());	
//		}
		nextLink.click();
		driver.close();
   	}
}
		