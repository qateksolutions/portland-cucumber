package step_definitions;

import command_providers.ActOn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_objects.Home;
import page_objects.RealApr;

public class MortgageSteps {
    WebDriver driver = Hooks.driver;

    @Given("^user is in Mortgage Calculator Home page$")
    public void navigateToMortgageCalculatorHomePage() {
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }

    @And("^user navigate to Real Apr page$")
    public void navigateToRealAprPage() {
        new Home(driver)
                .mouseHoverToRates()
                .navigateToRealApr();
    }

    @When("^user click on calculate button upon entering \"(.+?)\", \"(.+?)\" and \"(.+?)\"$")
    public void enterRealAprData(String homePrice, String downPayment, String interestRate) {
        new RealApr(driver)
                .typeHomePrice(homePrice)
                .typeDownPayment(downPayment)
                .typeInterestRate(interestRate)
                .clickOnCalculateButton();
    }

    @Then("^validate that Real APR is \"(.+?)\"$")
    public void validateThatRealAPRIs(String realApr) {
        new RealApr(driver)
                .validateAprRate(realApr);
    }
}
