package com.credify.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject{
    @FindBy(xpath = "//input[@data-auto='username']")
    private WebElement userNameInp;

    @FindBy(xpath = "//input[@data-auto='password']")
    private WebElement passwordInp;

    @FindBy(xpath = "//button[@data-auto='login']")
    private WebElement btnSignIn;

    public LoginPage(WebDriver driver){
        super(driver);
        //waitForLoading(driver);
    }

    public void go(WebDriver driver) {
        driver.get("https://www.credify.tech/portal/login");
    }

    public OfferPage Login(String userName, String password){
        userNameInp.sendKeys(userName);
        passwordInp.sendKeys(password);
        btnSignIn.click();
        return new OfferPage(driver);
    }

}
