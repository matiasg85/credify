package com.credify.project.ui_objects;

import com.credify.project.pages.PageObject;
import com.credify.project.pages.SignOutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuUI extends PageObject{

    @FindBy(xpath = "//a[@href='/phone/logout']")
    private WebElement signOutBtn;

    @FindBy(xpath = "//a[@href='https://www.credify.tech/portal/documents']")
    private WebElement documentsBtn;


    public MenuUI(WebDriver driver){
        super(driver);
        waitForLoading(driver);
    }
    public void waitForLoading(WebDriver driver) {
        (new WebDriverWait(driver, 60)).until(ExpectedConditions
            .invisibilityOfElementLocated(By.xpath("//div[@class='sc-EHOje gxmzFC']")));

    }

    public SignOutPage ClickSignOutBtn(){
        this.waitForLoading(driver);
        signOutBtn.click();
        return new SignOutPage(driver);
    }

}
