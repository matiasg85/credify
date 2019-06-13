package com.credify.project.pages;

import com.credify.project.ui_objects.MenuUI;
import com.credify.project.utils.LoanDetails;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OfferPage extends PageObject{

	@FindBy(xpath = "//h2[@class='title--secondary text--weight-light text--color-primary section']")
	private WebElement pageHeader;

	@FindBy(xpath = "//label[@class='header-nav__toggle']")
	private WebElement menuBtn;

	@FindBy(xpath = "//span[@data-auto='userLoanAmount']")
	private WebElement loanAmount;

	@FindBy(xpath = "//span[@data-auto='defaultMonthlyPayment']")
	private WebElement monthlyPayment;
	
	@FindBy(xpath = "//div[@data-auto='defaultLoanTerm']")
	private WebElement term;
	
	@FindBy(xpath = "//div[@data-auto='defaultLoanInterestRate']")
	private WebElement interestRate;

	@FindBy(xpath = "//div[@data-auto='defaultMoreInfoAPR']")
	private WebElement APR;

	public MenuUI menuUI;

	public OfferPage(WebDriver driver){
		super(driver);
		//super.waitForLoading(driver);
		//Boolean isPresent = new WebElement(By.xpath("//label[@class='header-nav__toggle']"))
		waitForLoading(driver);
	}
	public void waitForLoading(WebDriver driver) {
		(new WebDriverWait(driver, 60)).until(ExpectedConditions
				.visibilityOfElementLocated((By.xpath("//div[@data-auto='defaultMoreInfoAPR']"))));

		
	}
	
	
	public LoanDetails getOfferDetails(LoanDetails loanDetails) {
		String a = loanAmount.getText();
		loanDetails.setLoanAmount(loanAmount.getText());
		loanDetails.setMonthlyPayment(monthlyPayment.getText());
		loanDetails.setTerm(term.getText());
		loanDetails.setInterestRate(interestRate.getText());
		loanDetails.setAPR(APR.getText());
		return loanDetails;
		}

		public String getPageHeader(){
		return pageHeader.getText();

		}

		public MenuUI clickMenuBtn(){
		//super.waitForLoading(driver);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='sc-EHOje cMgzsF']")));
			try {
				Thread.sleep(1200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			menuBtn.click();
		menuUI = new MenuUI(driver);
		return menuUI;
		}

		public Boolean IsOfferMatching(LoanDetails loanDetails){
		return loanDetails.getAPR().equals(APR.getText()) &&
			loanDetails.getInterestRate().equals(interestRate.getText()) &&
			loanDetails.getLoanAmount().equals(loanAmount.getText()) &&
			loanDetails.getMonthlyPayment().equals(monthlyPayment.getText()) &&
			loanDetails.getTerm().equals(term.getText());

		}

}
