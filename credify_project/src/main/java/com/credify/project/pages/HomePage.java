package com.credify.project.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageObject{

	@FindBy(xpath = "//input[@name='desiredAmount']")
	private WebElement loandAmmuntInp;

	@FindBy(xpath = "//button[@data-auto='CheckYourRate']")
	private WebElement checkYourRateBtn;
	
	@FindBy(xpath = "//select[@data-auto='dropLoanPurpose']")
	private WebElement loanPurposeCmb;

	@FindBy(xpath = "//div[@class='sc-dxgOiQ dcokMy']")
	private WebElement inlineError;
	
	//WebDriver driver;
	BasicInformation basicInformationObject;
	public HomePage (WebDriver driver){
		super(driver);
		this.go(driver);
		waitForLoading(driver);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void go(WebDriver driver) {
		driver.get("https://www.credify.tech/phone/nonDMFunnel");
	}
	public void waitForLoading(WebDriver driver) {
		(new WebDriverWait(driver, 60)).until(ExpectedConditions
			.invisibilityOfElementLocated(By.xpath("//div[@class='sc-EHOje gxmzFC']")));
	}

	public void setTextLoandAmmuntInp(String amount) {
		//this.waitForLoading(driver);
		loandAmmuntInp.sendKeys(amount);
	}
	
	public BasicInformation clickCheckYourRateBtn() {
		//Actions action = new Actions(driver);
		//action.moveToElement(driver.findElement(By.xpath("//button[@data-auto='CheckYourRate']"))).click().build().perform();
		checkYourRateBtn.click();
		return new BasicInformation(driver);
		//return new BasicInformation();
	}
	
	public String getTextInlineError() {
		return inlineError.getText();
	}
	
	public void selectLoanPurpose(String purpose) {
		Select select=new Select(loanPurposeCmb); 
		select.selectByVisibleText(purpose); 
		//select.selectByIndex(0); 
		//select.selectByValue("value");
	}
/*	public void clickSignIn() {
		signIn.click();
	}

	public void clickSignOut() {
		signOut.click();
	}

	public void clickbtnSearchFlights() {
		btnSearchFlights.click();
	}
	
	public void clickbtnSearchFlightsAndHotel() {
		btnSearchFlightsAndHotel.click();
	}

	public void clickChkFlightOnly() {
		chkFlightOnly.click();
	}

	public void setTextCmbCityFrom(String codeCityFrom) {
		cmbCityFrom.sendKeys(codeCityFrom);
	}

	public void setTexttxtDateReturn(String DateReturn) {
		txtDateReturn.sendKeys(DateReturn);
	}

	public void setTexttxtDateLeave(String DateLeave) {
		txtDateLeave.sendKeys(DateLeave);
	}

	public void setTextCmbCityTo(String codeCityTo) {
		cmbCityTo.sendKeys(codeCityTo);
	}

	public boolean isLoggedUser(WebDriver driver, String user) {
		int size = 0;
		List<WebElement> aux = driver.findElements(ByAll
				.xpath("//li[@class='welcomeText' and contains(text(),'" + user
						+ "')]"));
		size = aux.size();
		if (size != 0)
			return true;
		else
			return false;
	}

	public void selectCityFrom(WebDriver driver, String codeCityFrom) {
		cmbCityFrom.sendKeys(codeCityFrom);
		waitListOrigin( driver);
		WebElement element;
		try {
			element = driver
					.findElement(By
							.xpath("//div[@data-context='airOriginInput']/descendant::span[text()='"
									+ codeCityFrom + "']"));
			element.click();
		} catch (NoSuchElementException e) {
			System.out.println("Don't find code cityFrom");
		}

	}

	public void selectCityTo(WebDriver driver, String codeCityTo) {
		cmbCityTo.sendKeys(codeCityTo);
		 waitListDestination(driver);
		WebElement element;
		try {
			element = driver
					.findElement(By
							.xpath("//div[@data-context='airDestinationInput']/descendant::span[text()='"
									+ codeCityTo + "']"));
			element.click();
		} catch (NoSuchElementException e) {
			System.out.println("Don't find code cityTo");
		}

	}

	public void waitLoadSearchFlights(WebDriver driver) {
		(new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(btnSearchFlights));
	}
	
	public void waitListOrigin(WebDriver driver) {
		(new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(listCityFrom));
	}
	
	public void waitListDestination(WebDriver driver) {
		(new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(listCityTo));
	}

	public void searchFlights(WebDriver driver, String codeCityFrom,
			String codeCityTo, String DateLeave, String DateReturn,
			String quantityAdults) {

		this.clickChkFlightOnly();
		this.waitLoadSearchFlights(driver);
		this.selectCityFrom(driver, codeCityFrom);
		this.selectCityTo(driver, codeCityTo);
		this.setTexttxtDateLeave(DateLeave);
		this.setTexttxtDateReturn(DateReturn);
		this.clickbtnSearchFlights();
		
	}
	
	public void searchFlightsAndHotel(WebDriver driver, String codeCityFrom,
			String codeCityTo, String DateLeave, String DateReturn,
			String quantityAdults) {

		this.clickChkFlightOnly();
		this.waitLoadSearchFlights(driver);
		this.selectCityFrom(driver, codeCityFrom);
		this.selectCityTo(driver, codeCityTo);
		this.setTexttxtDateLeave(DateLeave);
		this.setTexttxtDateReturn(DateReturn);
		this.clickbtnSearchFlightsAndHotel();
		
	}
	
	public void pausa(int s) {
		try {
			Thread.sleep(s * 1000);
		} catch (InterruptedException e) {
		}
	}
	
	*/

}
