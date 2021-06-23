package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends BasePage {
	
	/** The searchinput. */
	@FindBy(name = "q")
	public  WebElement searchinput;
	
//	private final By usernameLabel = By.xpath("//div[@class='header_user_info']//span");
//    private final By searchTextBox = By.id("search_query_top");
//    private final By searchButton = By.cssSelector("button[name='submit_search']");


	/**
	 * Instantiates a new google page.
	 *
	 * @param driver the driver
	 */
	public GooglePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Searches the given text.
	 *
	 * @param key the key
	 */
	public void searchText(String key) {
		searchinput.sendKeys(key + Keys.ENTER);
	}

}
