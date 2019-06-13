package com.credify.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    protected WebDriver driver;

    @FindBy(xpath = "//div[@class='sc-EHOje cMgzsF']")
    private WebElement loadingSpinner;

    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void waitForLoading(WebDriver driver) {

        (new WebDriverWait(driver, 60)).until(ExpectedConditions
            .invisibilityOf(loadingSpinner));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean isTrue = loadingSpinner.isDisplayed();
    }
}
