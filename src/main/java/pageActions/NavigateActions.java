package pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NavigateActions {
	WebDriver driver;
	public NavigateActions(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(id="nav-link-accountList")
	private WebElement Accounts;
	
	@CacheLookup
	@FindBy (xpath="//span[contains(text(),'Create a Wish List')]")
	private WebElement CreateaWishList;
	
	
	
	public String accountsAction() {
		String CreateaWishListLink;
		Actions navAction = new Actions(driver);
		navAction.moveToElement(Accounts).build().perform();
		CreateaWishList.click();
		CreateaWishListLink = driver.getCurrentUrl();
		return CreateaWishListLink;
		
		
	}
	
}
