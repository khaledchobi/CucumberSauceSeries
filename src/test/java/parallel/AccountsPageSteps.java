package parallel;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountsPageSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable credTable) {

        List<Map<String, String>> credList = credTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        DriverFactory.getDriver()
                .get("https://www.saucedemo.com");
        accountsPage = loginPage.doLogin(userName, password);


    }

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
        String title = accountsPage.getAccountsPageTitle();
        System.out.println("Accounts Page title is: " + title);
    }

    @Then("user displayed products sort items")
    public void user_displayed_products_sort_items() {
        Assert.assertTrue(accountsPage.isProductsSortItemExist());
    }

    @Then("user select lowest price sort from products sort items")
    public void user_select_lowest_price_sort_from_products_sort_items() {
        accountsPage.selectByLowestPrice();
    }

    @Then("user add items to the shopping cart")
    public void user_add_items_to_the_shopping_cart() {
        accountsPage.clickOnAddToCart();
    }

    @Then("visit to the shopping cart")
    public void visit_to_the_shopping_cart() {
        accountsPage.visitToShoppingCart();
        Assert.assertTrue(accountsPage.isProductsInAddToCartExist());

    }

    @Then("remove an item and then continue shopping")
    public void remove_an_item_and_then_continue_shopping() {
        accountsPage.removeItemFromCart();

    }

    @Then("add another item")
    public void add_another_item() {
        accountsPage.addItem();
        accountsPage.visitToShoppingCart();

    }

    @Then("checkout")
    public void checkout() {
        accountsPage.checkoutCart();
        Assert.assertTrue(accountsPage.isPurchaseSauceLabsBikeLightExist());
        Assert.assertTrue(accountsPage.isPurchaseSauceLabsBoltTshirtExist());
        Assert.assertTrue(accountsPage.isPurchaseTestAllTheThingsTshirtRedExist());

        Assert.assertTrue(accountsPage.totalCost());

        accountsPage.clickFinishButton();

    }

    /*@Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable sectionsTable) {

        List<String> expAccountSectionsList = sectionsTable.asList();

        System.out.println("Expected accounts section list: " + expAccountSectionsList);

        List<String> actualAccountSectionsList = accountsPage.getAccountsSectionsList();
        System.out.println("Actual accounts section list: " + actualAccountSectionsList);

        Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));

    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer expectedSectionCount) {
        Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
    }*/
}
