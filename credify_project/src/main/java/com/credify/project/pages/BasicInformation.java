package com.credify.project.pages;

/*import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;*/
import com.credify.project.utils.PersonDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicInformation extends PageObject{

	@FindBy(xpath = "//input[@name='borrowerFirstName']")
	private WebElement firstNameInp;

	@FindBy(xpath = "//input[@name='borrowerLastName']")
	private WebElement lastNameInp;

	@FindBy(xpath = "//input[@name='borrowerStreet']")
	private WebElement borrowerStreetInp;

	@FindBy(xpath = "//input[@name='borrowerCity']")
	private WebElement borrowerCityInp;

	@FindBy(xpath = "//input[@name='borrowerState']")
	private WebElement borrowerStateInp;

	@FindBy(xpath = "//input[@name='borrowerZipCode']")
	private WebElement borrowerZipCodeInp;

	@FindBy(xpath = "//input[@name='borrowerDateOfBirth']")
	private WebElement borrowerDateOfBirthInp;

	@FindBy(xpath = "//input[@name='borrowerIncome']")
	private WebElement borrowerIncomeInp;

	@FindBy(xpath = "//input[@name='borrowerAdditionalIncome']")
	private WebElement borrowerAdditionalIncomeInp;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameInp;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordInp;

	@FindBy(xpath = "//div[@class='sc-hwwEjo sc-kPVwWT kPmyvl']")
	private WebElement chkAgreeTermsOfUse;

	@FindBy(xpath = "//button[@data-auto='submitPersonalInfo']")
	private WebElement checkYourRateBtn;


	
	
	public void waitBasicInformation(WebDriver driver) {
		(new WebDriverWait(driver, 60)).until(ExpectedConditions
				.titleIs("Check your rate for a personal loan | Upgrade"));
		
	}
	public BasicInformation(WebDriver driver){
		super(driver);
		waitBasicInformation(driver);
	}
	public void waitForLoading(WebDriver driver) {
		(new WebDriverWait(driver, 60)).until(ExpectedConditions
			.invisibilityOfElementLocated(By.xpath("//div[@class='sc-EHOje gxmzFC']")));
	}

	public void FillBasicInformation(PersonDetails personDetails){
		firstNameInp.sendKeys(personDetails.getFirstName());
		lastNameInp.sendKeys(personDetails.getLastName());
		borrowerStreetInp.sendKeys(personDetails.getStreetAddress());
		borrowerStateInp.sendKeys(personDetails.getState());
		borrowerCityInp.sendKeys(personDetails.getCity());
		borrowerZipCodeInp.sendKeys(personDetails.getZipCode());
		borrowerDateOfBirthInp.sendKeys(personDetails.getDOB());
		borrowerIncomeInp.sendKeys(personDetails.getAnnualIncome());
		borrowerAdditionalIncomeInp.sendKeys(personDetails.getAdditionalIncome());
	}

	public void CreateAnAccount(PersonDetails personDetails){
		usernameInp.sendKeys(personDetails.getEmail());
		passwordInp.sendKeys(personDetails.getPassword());
	}

	public void clickChkAgreeTermsOfUse() {

		chkAgreeTermsOfUse.click();
	}

	public OfferPage SubmitPersonalInfo(){
		checkYourRateBtn.click();
		return new OfferPage(driver);
	}



	public Boolean isbtnCheckYourRatePresent() {
		if (checkYourRateBtn != null) {
			return true;
		} else {
			return false;
		}
	}


}
