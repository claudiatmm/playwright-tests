package step;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page.AlertsPage;
import page.DropdownPage;
import page.LoginPage;
import page.TextBoxPage;

public class Steps {

    TextBoxPage textBoxPage;
    DropdownPage dropdownPage;
    AlertsPage alertsPage;
    LoginPage loginPage;

    Playwright playwright = Playwright.create();
    BrowserType chrome = playwright.chromium();
    Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page page = browser.newPage();


    @Given("User navigate to {string} page")
    public void setUp(String pageNameSelected){
        page.navigate(pageNameSelected);
        textBoxPage = new TextBoxPage(page);
        dropdownPage = new DropdownPage(page);
        alertsPage = new AlertsPage(page);
        loginPage = new LoginPage(page);
    }

    @When("User complete all the fields with data: {string}, {string}, {string}, {string}")
    public void completAllFieldsForTextBox(String username, String email, String address, String permanentA){
        textBoxPage.sendUserDataForTextBox(username, email, address,permanentA);
    }

    @And("User click on submit button")
    public void userClickOnSubmitButton(){
        textBoxPage.clickOnSubmitButton();
    }


    @When("User choose a value from dropdown with number {string}")
    public void userChooseValueDropdown(String numberValue){
        dropdownPage.userSelectValueFromDropdown(numberValue);
    }


    @When("User click on first Alert")
    public void userClickOnFirstAlert() throws InterruptedException {
        alertsPage.userClickOnFirstAlert();
    }

    @And("User click on second Alert")
    public void userClickOnSecondAlert() throws InterruptedException {
        alertsPage.userClickOnSecondAlert();
    }

    @And("User click on fourth Alert")
    public void userClickOnFourthAlert(){
        alertsPage.userClickOnFourthAlert();
    }

    @And("User click on third Alert")
    public void userClickOnThirdAlert(){
        alertsPage.userClickOnThirdAlert();
    }


    @And("User complete the registration form with data: {string}, {string}, {string}, {string}")
    public void completeRegistrationForm(String nameF, String nameL, String email, String phonne) throws InterruptedException {
        loginPage.userCompleteRegistrationForm(nameF, nameL, email, phonne);
    }

}
