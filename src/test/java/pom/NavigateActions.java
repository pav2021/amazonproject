package pom;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigateActions {
	WebDriver driver;

	public NavigateActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "nav-link-accountList")
	private WebElement Accounts;

	@CacheLookup
	@FindBy(xpath = "//span[contains(text(),'Create a Wish List')]")
	private WebElement CreateaWishList;

	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'New Releases')]")
	private WebElement newReleases;

	@CacheLookup
	@FindBy(xpath = "//a[contains(text(), 'Amazon Cash')]")
	private WebElement amazonCash;

	@CacheLookup
	@FindBy(id = "ap_email")
	private WebElement email;

	@CacheLookup
	@FindBy(className = "a-button-input")
	private WebElement contbutton;

	@CacheLookup
	@FindBy(id = "ap_password")
	private WebElement password;

	@CacheLookup
	@FindBy(id = "signInSubmit")
	private WebElement signIn;

	@CacheLookup
	@FindBy(xpath = "(//a[@id='nav-item-signout'])[1]")
	private WebElement signOut;

	@CacheLookup
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@CacheLookup
	@FindBy(id = "nav-search-submit-button")
	private WebElement submitButton;

	@CacheLookup
	@FindBy(xpath = "//div[contains(@class,'a-section a-spacing-small a-spacing-top-small')]")
	private WebElement displaySpace;

	@CacheLookup
	@FindBy(className = "a-link-nav-icon")
	private WebElement amazonIconLink;

	@CacheLookup
	@FindBy(xpath = "//img[contains(@alt,'Samsung Galaxy S10 128GB Prism Black 8GB RAM Canadian Model G973W Unlocked (Renewed)')]")
	private WebElement mobileImage;

	@CacheLookup
	@FindBy(xpath = "(//span[@class='a-offscreen'])[1]")
	private WebElement mobilePrice;

	@CacheLookup
	@FindBy(id = "contextualIngressPtLabel_deliveryShortLine")
	private WebElement deliveryLocationLink;
	// @FindBy(xpath="//div[contains(text(),'Deliver to')]")

	@CacheLookup
	@FindBy(id = "GLUXZipUpdateInput_0")
	private WebElement postalCodeBox1;

	@CacheLookup
	@FindBy(id = "GLUXZipUpdateInput_1")
	private WebElement postalCodeBox2;

	@CacheLookup
	@FindBy(xpath = "//input[contains(@aria-labelledby,'GLUXZipUpdate-announce')]")
	private WebElement applyButton;
	// @FindBy(xpath="(//span[@class='a-button-inner a-declarative'])[3]")

	@CacheLookup
	@FindBy(xpath = "//*[@id='contextualIngressPtLabel_deliveryShortLine']/span[1]")
	private WebElement deliveryPincode;

	@CacheLookup
	@FindBy(xpath = "//*[@id='contextualIngressPtLabel_deliveryShortLine']/span[2]")
	private WebElement deliveryPincode2;
	
	
	@CacheLookup
	@FindBy(id = "ape_Detail_hero-quick-promo_Desktop_iframe")
	private WebElement iframeID;

	@CacheLookup
	@FindBy(xpath = "//a[@class='a-link-normal sp_hqp_shared_adLink a-text-normal']")
	private WebElement iframeIDLink;
	
	@CacheLookup 
	@FindBy(id = "titleSection")
	private WebElement iframeText;
	

	public String accountsAction() {
		String CreateaWishListLink;
		Actions navAction = new Actions(driver);
		navAction.moveToElement(Accounts).build().perform();
		CreateaWishList.click();
		CreateaWishListLink = driver.getCurrentUrl();
		driver.navigate().back();
		return CreateaWishListLink;

	}

	public String newReleasesAction() {
		String newReleasesLink;
		newReleases.click();
		newReleasesLink = driver.getCurrentUrl();
		driver.navigate().back();
		return newReleasesLink;

	}

	public String amazonCashAction() {
		String amazonCashLink;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView;", amazonCash);
		js.executeScript("arguments[0].style.border= '2px solidm yellow'", amazonCash);
		js.executeScript("arguments[0].click()", amazonCash);
		amazonCashLink = driver.getCurrentUrl();
		driver.navigate().back();
		return amazonCashLink;

	}

	public String validEmailValidPassword(String em, String pass) {
		String currentUrl;
		System.out.println(driver.getCurrentUrl());
		Accounts.click();
		email.sendKeys(em);
		contbutton.click();
		password.sendKeys(pass);
		signIn.click();
		currentUrl = driver.getCurrentUrl();

		return currentUrl;

	}

	public String invalidEmailInvalidPassword(String em, String pass) {
		String currentUrl;
		Accounts.click();
		email.sendKeys(em);
		contbutton.click();
		password.sendKeys(pass);
		signIn.click();
		currentUrl = driver.getCurrentUrl();
		amazonIconLink.click();
		return currentUrl;

	}

	/*
	 * public String validateSearchResult() { String textDisplayed;
	 * 
	 * searchBox.sendKeys("samsung galaxy s10"); submitButton.click();
	 * textDisplayed=displaySpace.getText(); System.out.println(textDisplayed);
	 * return textDisplayed;
	 * 
	 * 
	 * }
	 */
	public String mobilePriceAction() {
		Actions navAction = new Actions(driver);
		navAction.moveToElement(Accounts).build().perform();
		signOut.click();
		amazonIconLink.click();
		String getPrice;
		searchBox.sendKeys("samsung galaxy s10");
		submitButton.click();
		mobileImage.click();
		getPrice = mobilePrice.getAttribute("innerHTML");
		System.out.println(getPrice);
		return getPrice;

	}

	public String deliveryLocationAction() {
		String deliveryCodeText;
		// String deliveryCodeText2;
		deliveryLocationLink.click();
		postalCodeBox1.sendKeys("L5M");
		postalCodeBox2.sendKeys("3N3");
		applyButton.click();
		// driver.navigate().refresh();
		deliveryCodeText = deliveryPincode.getText();
		deliveryCodeText = deliveryCodeText.concat(deliveryPincode2.getText());
		System.out.println(deliveryCodeText);
		return deliveryCodeText;
	}
	
	public String iframeClickAction() {
		String verifyIframe;
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(iframeID));
		try {
		driver.switchTo().frame(iframeID);
		iframeIDLink.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}catch (NoSuchFrameException e)
		{
			System.out.println(e);
		}
		
		verifyIframe= iframeText.getText();
		System.out.println(verifyIframe);
		return verifyIframe;
	}

}
