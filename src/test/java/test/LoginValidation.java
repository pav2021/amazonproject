package test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom.NavigateActions;

public class LoginValidation extends Baseclass {

	@Test(priority = 1)
	public void validateURL() {
		String expected = "https://www.amazon.ca/";
		String actual = driver.getCurrentUrl();
		assertTrue(expected.equalsIgnoreCase(actual), "this is not the valid URL>>" + actual);
		Reporter.log("this is the correct URL>>" + actual);
	}

	@Test(priority = 2)
	public void validateTitle() {
		String expected = "Amazon.ca: Low Prices – Fast Shipping – Millions of Items";
		String actual = driver.getTitle();
		assertTrue(expected.equalsIgnoreCase(actual), "this is not the valid Title>>" + actual);
		Reporter.log("this is the correct Title>>" + actual);
	}

	@Test(priority = 3)
	public void validateCreateaWishList() {
		String expected = "https://www.amazon.ca/hz/wishlist/intro";
		NavigateActions nav = new NavigateActions(driver);
		String actual = nav.accountsAction();
		assertTrue(expected.equalsIgnoreCase(actual), "this is a not a valid page ");
		Reporter.log("this is a valid Create a wishlist page " + actual);
	}

	@Test(priority = 4)
	public void validateNewReleases() {
		String expected = "https://www.amazon.ca/gp/new-releases/?ref_=nav_cs_newreleases";
		NavigateActions nav = new NavigateActions(driver);
		String actual = nav.newReleasesAction();
		assertTrue(expected.equalsIgnoreCase(actual), "this is a not a valid page ");
		Reporter.log("this is a valid Create a wishlist page " + actual);
	}

	@Test(priority = 5)

	public void validateAmazonCash() {
		String expected = "https://www.amazon.ca/gp/browse.html?node=17321486011&ref_=footer_cash_ca_en";
		NavigateActions nav = new NavigateActions(driver);
		String actual = nav.amazonCashAction();
		assertTrue(expected.equalsIgnoreCase(actual), "this is a not a valid page ");
		Reporter.log("this is a valid Create a wishlist page " + actual);
	}

	@Parameters({ "validemail", "validpassword" })
	@Test(priority = 7)

	public void validEmailValidPassword(String em, String pass) {
		String signInUrl = "https://www.amazon.ca/ap/signin";
		System.out.println(signInUrl);
		NavigateActions nav = new NavigateActions(driver);
		String actual = nav.validEmailValidPassword(em, pass);
		System.out.println(driver.getCurrentUrl());
		assertNotEquals(signInUrl.equalsIgnoreCase(actual), "this is a not a valid page ");

		Reporter.log("the login is successful " + actual);
	}

	@Parameters({ "invalidemail", "invalidpassword" })
	@Test(priority = 6)
	public void invalidEmailInvalidPassword(String em, String pass) {
		String signInUrl = "https://www.amazon.ca/ap/signin";
		NavigateActions nav = new NavigateActions(driver);
		String actual = nav.invalidEmailInvalidPassword(em, pass);
		assertTrue(signInUrl.equalsIgnoreCase(actual), "this is a not a valid page ");
		Reporter.log("this is a valid Create a wishlist page " + actual);
	}

	/*
	 * @Test(priority=8,dependsOnMethods = {"validEmailValidPassword"} )
	 * 
	 * public void validateSearchResults() { String
	 * expected="1-48 of 318 results for \"samsung galaxy s10\"";
	 * System.out.println(expected); NavigateActions nav = new
	 * NavigateActions(driver); String actual=nav.validateSearchResult();
	 * assertTrue(expected.equalsIgnoreCase(actual),
	 * "this is not a valid displayresult");
	 * Reporter.log("this is the actual display result"+actual);
	 * 
	 * }
	 */

	@Test(priority = 8)

	public void validateMobilePrice() {
		String expected = "$429.00";
		NavigateActions nav = new NavigateActions(driver);
		String actual = nav.mobilePriceAction();
		assertTrue(expected.equalsIgnoreCase(actual), "this is not the price");
		Reporter.log("this is the actual price" + actual);

	}

	@Test(priority = 9)
	public void validateDeliveryPincode() {
		String expected = "Deliver to L5M 3N3";
		System.out.println(expected);
		NavigateActions nav = new NavigateActions(driver);
		String actual = nav.deliveryLocationAction();
		// System.out.println(actual+"abc");
		boolean check = expected.equalsIgnoreCase(actual);
		System.out.println(check);
		assertTrue(expected.equalsIgnoreCase(actual), "this is not the pin");
		Reporter.log("this is the delivery pin" + actual);

	}
	@Test(priority = 10)
	
	
	public void validateIframe() {
		String expected = "5G Rugged Smartphone Canada, Ulefone Armor 12 Unlocked Cell Phones Android, Upgraded IP68 Waterproof Mobile Phone, 48MP Quad Rear Camera, 8GB+128GB, 6.52” HD+, 5180mAh Dual SIM Phone Rogers (Black)";
		System.out.println(expected);
		NavigateActions nav = new NavigateActions(driver);
		String actual = nav.iframeClickAction();
		assertTrue(expected.equalsIgnoreCase(actual), "this is not the right iframe");
		Reporter.log("this is the correct iframe" + actual);
	
	}
}
