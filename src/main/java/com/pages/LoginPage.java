package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // 1. By Locators: OR
    private By emailId = By.id("user-name");
    private By password = By.id("password");
    private By signInButton = By.id("login-button");
    private By loginLogo = By.xpath("//div[@class='login_logo']");
    private By forgotPwdLink = By.xpath("//div[@class='login-box']//h3");


    // 2. Constructor of the page class:
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. page actions: features(behavior) of the page the form of methods:

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean isLoginLogoExist() {
        return driver.findElement(loginLogo).isDisplayed();
    }

    public boolean isForgotPwdLinkExist() {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUserName(String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin() {
        driver.findElement(signInButton).click();
    }

    public AccountsPage doLogin(String un, String pwd) {
        System.out.println("login with: " + un + " and " + pwd);
        driver.findElement(emailId).sendKeys(un);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInButton).click();
        return new AccountsPage(driver);
    }

    public String getMyAccountPageTitle() {
        return driver.getTitle();
    }
}
