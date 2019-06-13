package com.credify.project.tests;


import com.credify.project.pages.BasicInformation;
import com.credify.project.pages.HomePage;

import com.credify.project.pages.LoginPage;
import com.credify.project.pages.OfferPage;
import com.credify.project.pages.SignOutPage;
import com.credify.project.utils.LoanDetails;
import com.credify.project.utils.PersonDetails;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Tests {

	WebDriver driver;
	HomePage objHomePage;
	BasicInformation objBasicInformation;
	PersonDetails personDetails;
	OfferPage objOfferPage;
	LoanDetails loanDetails;


	@BeforeMethod
	public void Before() {
		driver = new FirefoxDriver();
	    //driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}

	@AfterMethod
	public void After() {
		driver.close();
	}


	public void waitPage() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	/*@Test(priority = 1, description = "Enter loan amount and check your rate")
	public void verifySignIn() {
	personDetails = new PersonDetails();
		objHomePage = PageFactory.initElements(driver, HomePage.class);
		objHomePage.go(driver);
		objHomePage.setTextLoandAmmuntInp("2000");
		objHomePage.selectLoanPurpose("Other");
		objHomePage.clickCheckYourRateBtn();
		pausa(5);
		objBasicInformation = PageFactory.initElements(driver, BasicInformation.class);
		Assert.assertTrue(objBasicInformation.isbtnCheckYourRatePresent());
		//objBasicInformation.go(driver);
		//objBasicInformation.FillBasicInformation(personDetails.randomNameGenerator(), personDetails.randomNameGenerator(),personDetails.randomStreetGenerator(), "Villa Allende", "CA", personDetails.randomZipCodeGenerator(), personDetails.randomDateGenerator(), personDetails.randomIncomeGenerator(), personDetails.randomAdditionalIncomeGenerator());
		personDetails = new PersonDetails();
		objBasicInformation.FillBasicInformation(personDetails);
		objBasicInformation.CreateAnAccount(personDetails);
		objBasicInformation.clickChkAgreeTermsOfUse();
		objBasicInformation.SubmitPersonalInfo();
		pausa(10);
		objOfferPage = PageFactory.initElements(driver, OfferPage.class);
		String a = objOfferPage.getPageHeader();


		loanDetails = objOfferPage.getOfferDetails(loanDetails);


		//Assert.assertEquals(objHomePage.getTextInlineError(),"Select a purpose");
	}*/

	@Test(priority = 1, description = "Enter loan amount and check your rate")
	public void verifyLoanProcess() {
		Reporter.log("Opening main page");
		objHomePage = new HomePage(driver);
		Reporter.log("Setting Loan Purpose");
		objHomePage.setTextLoandAmmuntInp("2000");
		objHomePage.selectLoanPurpose("Other");
		objBasicInformation = objHomePage.clickCheckYourRateBtn();
		Assert.assertTrue(objBasicInformation.isbtnCheckYourRatePresent());
		personDetails = new PersonDetails();
		Reporter.log("Creating user by entering personal information");
		objBasicInformation.FillBasicInformation(personDetails);
		objBasicInformation.CreateAnAccount(personDetails);
		objBasicInformation.clickChkAgreeTermsOfUse();
		Reporter.log("Clicking on Submit personal Info");
		objOfferPage = objBasicInformation.SubmitPersonalInfo();
		loanDetails = new LoanDetails();
		loanDetails = objOfferPage.getOfferDetails(loanDetails);
		Reporter.log("Singing out");
		objOfferPage.clickMenuBtn();
		SignOutPage signOutPage = objOfferPage.menuUI.ClickSignOutBtn();
		Assert.assertTrue(signOutPage.isPageLoaded());
		Reporter.log("Opening Log in page and log in again");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.go(driver);
		objOfferPage = loginPage.Login(personDetails.getEmail(), personDetails.getPassword());
		Reporter.log("Verifying loan offer is matching");
		Assert.assertTrue(objOfferPage.IsOfferMatching(loanDetails));
		Reporter.log("Test Passed");

	}



}
