package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AccountsPage {
    private WebDriver driver;

    private By accountSections = By.cssSelector("div#center_column span");
    private By productsSortItem = By.xpath("//select[@class='product_sort_container']");
    private By sortByLowestPrice = By.cssSelector("div#center_column span");
    private By btnAddToCart_01 = By.xpath("//div[@id='inventory_container']/div/div[1]/div/button");
    private By btnAddToCart_02 = By.xpath("//div[@id='inventory_container']/div/div[2]/div/button");
    private By btnAddToCart_03 = By.xpath("//div[@id='inventory_container']/div/div[3]/div/button");
    private By btnAddToCart_06 = By.xpath("//div[@id='inventory_container']/div/div[6]/div/button");
    private By shoppingCartLink = By.xpath("//div[@id='shopping_cart_container']");
    private By btnRemoveAddToCart_01 = By.xpath("//div[@id='cart_contents_container']/div/div[1]/div[3]/div[2]/div[2]/button");
    private By btnRemoveAddToCart_02 = By.xpath("//div[@id='cart_contents_container']/div/div[1]/div[4]/div[2]/div[2]/button");
    private By btnContinueShopping = By.xpath("//a[@class='btn_secondary']");
    private By btnCheckout = By.xpath("//a[@class='btn_action checkout_button']");
    private By lnkTextSauceLabsBackpack = By.xpath("//a[@id='item_4_title_link']/div");
    private By lnkTextSauceLabsBikeLight = By.xpath("//a[@id='item_0_title_link']/div");
    private By lnkTextSauceLabsBoltTshirt = By.xpath("//a[@id='item_1_title_link']/div");
    private By lnkTextTestAllTheThingsTshirtRed = By.xpath("//a[@id='item_3_title_link']/div");
    private By firstNameCheckout = By.xpath("//input[@id='first-name']");
    private By lastNameCheckout = By.xpath("//input[@id='last-name']");
    private By zipCodeCheckout = By.xpath("//input[@id='postal-code']");
    private By btnContinueCheckout = By.xpath("//input[@class='btn_primary cart_button']");
    private By totalCost = By.xpath("//div[@class='summary_total_label']");
    private By btnFinish = By.xpath("//a[@class='btn_action cart_button']");




    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    }

    public String getAccountsPageTitle() {
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        return driver.getTitle();
    }

    public boolean isProductsSortItemExist() {
        return driver.findElement(productsSortItem).isDisplayed();
    }

    public void selectByLowestPrice() {
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        Select selectByLowestPrice = new Select(driver.findElement(productsSortItem));
        selectByLowestPrice.selectByVisibleText("Price (low to high)");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickOnAddToCart() {
        driver.findElement(btnAddToCart_01).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btnAddToCart_02).click();
        driver.findElement(btnAddToCart_03).click();
    }

    public void visitToShoppingCart() {
        driver.findElement(shoppingCartLink).click();
    }

    public boolean isProductsInAddToCartExist() {
        return driver.findElement(lnkTextSauceLabsBackpack).isDisplayed();
    }

    public void removeItemFromCart() {
        driver.findElement(btnRemoveAddToCart_01).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(btnContinueShopping).click();

    }

    public void addItem() {
        driver.findElement(btnAddToCart_06).click();
    }

    public void checkoutCart() {
        driver.findElement(btnCheckout).click();

        driver.findElement(firstNameCheckout).sendKeys("Khaled");
        driver.findElement(lastNameCheckout).sendKeys("Hasan");
        driver.findElement(zipCodeCheckout).sendKeys("06385");

        driver.findElement(btnContinueCheckout).click();

    }

    public boolean isPurchaseSauceLabsBikeLightExist() {
        return driver.findElement(lnkTextSauceLabsBikeLight).isDisplayed();
    }

    public boolean isPurchaseSauceLabsBoltTshirtExist() {
        return driver.findElement(lnkTextSauceLabsBoltTshirt).isDisplayed();
    }

    public boolean isPurchaseTestAllTheThingsTshirtRedExist() {
        return driver.findElement(lnkTextTestAllTheThingsTshirtRed).isDisplayed();
    }

    public boolean totalCost() {
        return driver.findElement(totalCost).getText().equals("Total: $45.33");
    }



    public void clickFinishButton() {
        driver.findElement(btnFinish).click();
    }


}
