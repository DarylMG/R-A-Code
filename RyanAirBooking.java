package ryanAirBooking;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class RyanAirBooking {
	private WebDriver driver = new InternetExplorerDriver();
	WebDriverWait wait = new WebDriverWait(driver, 60);
	
	@Test
	public void ryanAirBooking(){
		//Navigating to Ryan Air website
	    driver.get("https://www.ryanair.com/ie/en/");
	    //Selecting the "depart from" airport
	    driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
	    driver.findElement(By.xpath("//div[@id='search-container']/div/div/form/div/div[2]/div/div/div[3]/div/div/div[2]/popup-content/core-linked-list/div[2]/div/div[3]/span")).click();
	    //Selecting the "destination" airport
	    driver.findElement(By.xpath("//div[@id='search-container']/div/div/form/div/div[2]/div/div[2]/div[3]/div/div/div[2]/popup-content/core-linked-list/div/div/div[11]")).click();
	    driver.findElement(By.xpath("//div[@id='search-container']/div/div/form/div/div[2]/div/div[2]/div[3]/div/div/div[2]/popup-content/core-linked-list/div[2]/div/div[9]/span")).click();
	    //Selecting the "fly out" date
	    driver.findElement(By.xpath("//div[@id='row-dates-pax']/div/div/div/div/div[2]/div[2]/div/div")).click();
	    //Navigating to March 2017
	    driver.findElement(By.cssSelector("button.arrow.right")).click();
	    driver.findElement(By.cssSelector("button.arrow.right")).click();
	    //Selecting the 20th March 2017
	    driver.findElement(By.xpath("//div[@id='row-dates-pax']/div/div/div/div/div[3]/div/div/div[2]/popup-content/core-datepicker/div/div/ul/li[4]/ul[2]/li[22]/span")).click();
	    //Selecting the "fly back" date
	    driver.findElement(By.xpath("//div[@id='row-dates-pax']/div/div/div[2]/div/div[2]/div[2]/div/div")).click();
	    //Selecting 27th March 2017
	    driver.findElement(By.xpath("//div[@id='row-dates-pax']/div/div/div[2]/div/div[3]/div/div/div[2]/popup-content/core-datepicker/div/div/ul/li[2]/ul[2]/li[29]/span")).click();
	    //Opening the passengers drop down
	    driver.findElement(By.cssSelector("div.dropdown-handle > core-icon.chevron > div > svg")).click();
	    //Adding a second adult
	    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	    //Adding two children
	    driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
	    driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
	    //Clicking on the "Let's Go" button
	    driver.findElement(By.xpath("//div[@id='search-container']/div/div/form/div[3]/button[2]")).click();
	    //Waiting for the popup to display
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.core-btn-primary.core-btn-phone-full")));
	    //Clicking on the continue to search button on the resulting popup
	    driver.findElement(By.cssSelector("button.core-btn-primary.core-btn-phone-full")).click();
		//Choosing the first avaiable flight time for flying out
	    driver.findElement(By.cssSelector("span.price > label > span")).click();
	    //Choosing the first available flight time for flying back
	    driver.findElement(By.xpath("//flight-list[@id='inbound']/div/div[3]/div/flights-table/div[2]/div/div/div[2]/div/div/span/label/span")).click();
	    //Clicking on the continue button
	    driver.findElement(By.id("continue")).click();
	    //Waiting for the popup to display
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.core-btn-primary.same-seats")));
	    //Clicking "OK got it" on the resulting popup
	    driver.findElement(By.cssSelector("button.core-btn-primary.same-seats")).click();
	    //Choosing the seats for the passengers
	    driver.findElement(By.xpath("//div[@id='scrollable']/div/div/div[2]/div[14]/div[3]/span/span")).click();
	    driver.findElement(By.xpath("//div[@id='scrollable']/div/div/div[2]/div[14]/div[5]/span/span")).click();
	    driver.findElement(By.xpath("//div[@id='scrollable']/div/div/div[2]/div[14]/div[6]/span/span")).click();
	    driver.findElement(By.xpath("//div[@id='scrollable']/div/div/div[2]/div[14]/div[7]/span/span")).click();
	    //Clicking on the next button
	    driver.findElement(By.cssSelector("button.core-btn-primary.next")).click();
	    //Waiting for the popup to display
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.core-btn-primary.same-seats")));
	    //Clicking "Yes, please" on the resulting popup
	    driver.findElement(By.cssSelector("button.core-btn-primary.same-seats")).click();
	    //Clicking on the "Confirm" button
	    driver.findElement(By.cssSelector("button.core-btn-primary.next")).click();
	    //Waiting for the popup to display
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.priority-boarding-prompt > div.action > button.core-btn-primary")));
	    //Selecting to add priority boarding on the resulting popup
	    driver.findElement(By.cssSelector("div.priority-boarding-prompt > div.action > button.core-btn-primary")).click();
	    //Clicking on the "Confirm" button again
	    driver.findElement(By.cssSelector("button.core-btn-primary.next")).click();
	    //Clicking on the "Check Out" button
	    driver.findElement(By.xpath("//button[@type='button']")).click();
	    //Waiting for the next page to load
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phoneNumberCountry")));
	    //The drop down's and text boxes in this section are given a small numeric code attached to the end
	    //of their identifiers, in order to link to these elements without being able to hard code the identifier
	    //I will be using a while loop to increment i to search for the elements, using a boolean to identify when
	    //the element has been located
	    int i = 0;
	    boolean elementIdentifier = false;
	    while(elementIdentifier = false){
	    	i++;
	    	try{
	    	elementIdentifier = driver.findElement(By.id("title" + i)).isDisplayed();
	    	}catch(ElementNotFoundException e){
	    		elementIdentifier = false;
	    	}
	    }
	    //Selecting "Mr" as the first title
	    new Select(driver.findElement(By.id("title" + i))).selectByVisibleText("Mr");
	    //Second while loop to look for the text boxes
	    int i2 = 0;
	    elementIdentifier = false;
	    while(elementIdentifier = false){
	    	i2++;
	    	try{
	    	elementIdentifier = driver.findElement(By.id("firstName" + i2)).isDisplayed();
	    	}catch(ElementNotFoundException e){
	    		elementIdentifier = false;
	    	}
	    }
	    //Entering the first passengers first and last names
	    driver.findElement(By.id("firstName" + i2)).clear();
	    driver.findElement(By.id("firstName" + i2)).sendKeys("John");
	    driver.findElement(By.id("lastName" + i2)).clear();
	    driver.findElement(By.id("lastName" + i2)).sendKeys("Smith");
	    //Using a third while loop to identify the next drop down
	    elementIdentifier = false;
	    while(elementIdentifier = false){
	    	i++;
	    	try{
	    	elementIdentifier = driver.findElement(By.id("title" + i)).isDisplayed();
	    	}catch(ElementNotFoundException e){
	    		elementIdentifier = false;
	    	}
	    }
	    //Selecting "Mrs" as the second passengers identifier and entering their first and last names
	    new Select(driver.findElement(By.id("title" + 1))).selectByVisibleText("Mrs");
	    driver.findElement(By.id("firstName" + (i2 + 1))).clear();
	    driver.findElement(By.id("firstName" + (i2 + 1))).sendKeys("Sarah");
	    driver.findElement(By.id("lastName" + (i2 + 1))).clear();
	    driver.findElement(By.id("lastName" + (i2 + 1))).sendKeys("Smith");
	    driver.findElement(By.id("firstName" + (i2 + 2))).clear();
	    //Entering the third passengers first and last names
	    driver.findElement(By.id("firstName" + (i2 + 2))).sendKeys("Adam");
	    driver.findElement(By.id("lastName" + (i2 + 2))).clear();
	    driver.findElement(By.id("lastName" + (i2 + 2))).sendKeys("Smith");
	    driver.findElement(By.id("firstName" + (i2 + 3))).clear();
	    //Entering the fourth passengers first and last names
	    driver.findElement(By.id("firstName" + (i2 + 3))).sendKeys("Samantha");
	    driver.findElement(By.id("lastName" + (i2 + 3))).clear();
	    driver.findElement(By.id("lastName" + (i2 + 3))).sendKeys("Smith");
	    //Setting the phone number country code as Ireland's code
	    new Select(driver.findElement(By.name("phoneNumberCountry"))).selectByVisibleText("Ireland");
	    //Entering the mobile phone number for this booking
	    driver.findElement(By.name("phoneNumber")).clear();
	    driver.findElement(By.name("phoneNumber")).sendKeys("0851234567");
	    //Using a fourth while loop to locate the element for entering the card number and card type
	    int i3 = 0;
	    elementIdentifier = false;
	    while(elementIdentifier = false){
	    	i3++;
	    	try{
	    	elementIdentifier = driver.findElement(By.id("cardNumber" + i3)).isDisplayed();
	    	}catch(ElementNotFoundException e){
	    		elementIdentifier = false;
	    	}
	    }
	    //Entering the credit card number for the transaction
	    driver.findElement(By.id("cardNumber" + i3)).clear();
	    driver.findElement(By.id("cardNumber" + i3)).sendKeys("9473351785296544");
	    //Setting the type of credit card used as a Visa
	    new Select(driver.findElement(By.id("cardType" + i3))).selectByVisibleText("Visa");
	    //Setting the expiry month for the transaction
	    new Select(driver.findElement(By.id("expiryMonth" + i3))).selectByVisibleText("11");
	    //Setting the expiry year for the transaction
	    new Select(driver.findElement(By.id("expiryYear"))).selectByVisibleText("2022");
	    //Entering the card holders name
	    driver.findElement(By.name("cardHolderName")).sendKeys("John Smith");
	    //Entering the billing address
	    driver.findElement(By.id("sa.nameAddressLine1")).sendKeys("10 Main Street");
	    //Entering the city name
	    driver.findElement(By.id("sa.nameCity")).sendKeys("Dublin");
	    //Entering the postcode
	    driver.findElement(By.id("sa.namePostcode")).sendKeys("12345");
	    //Using a fifth while loop to locate the element for accepting the terms
	    int i4 = 0;
	    elementIdentifier = false;
	    while(elementIdentifier = false){
	    	i4++;
	    	try{
	    	elementIdentifier = driver.findElement(By.id("cardNumber" + i4)).isDisplayed();
	    	}catch(ElementNotFoundException e){
	    		elementIdentifier = false;
	    	}
	    }
	    //Clicking on the accept terms check box
	    driver.findElement(By.id("acceptTerms" + i4)).click();
	    //Clicking on the "Pay Now" button
	    driver.findElement(By.cssSelector("button.core-btn-primary.core-btn-medium")).click();
	    //Asserting that the error is displaying and the transaction did not proceed
	    assert(driver.findElement(By.cssSelector("")).isDisplayed() == true);
	}

}
