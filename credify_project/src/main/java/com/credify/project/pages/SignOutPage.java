package com.credify.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignOutPage extends PageObject{
	
	@FindBy(xpath = "//h1[@data-auto='logoutMessage']")
	private WebElement lblLogoutMessage;

	public SignOutPage(WebDriver driver){
		super(driver);
	}

	public boolean isPageLoaded(){
		return lblLogoutMessage.isDisplayed();
	}


	public void waitCheckoutPageLoad(WebDriver driver) {
		(new WebDriverWait(driver, 60)).until(ExpectedConditions
				.visibilityOf(lblLogoutMessage));
	}
	

}
