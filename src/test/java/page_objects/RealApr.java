package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RealApr extends NavigationBar{
    private final By HomePrice = By.name("HomeValue");
    private final By DownPayment = By.name("DownPayment");
    private final By DownPaymentInDollar = By.id("DownPaymentSel0");
    private final By InterestRate = By.name("Interest");
    private final By CalculateButton = By.name("calculate");
    private final By ActualAPR = By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong[contains(text(),'Actual APR')]/../../td[2]/strong");

    private static final Logger LOGGER = LogManager.getLogger(RealApr.class);

    public RealApr(WebDriver driver) {
        super(driver);
    }

    public RealApr typeHomePrice(String value) {
        LOGGER.debug("Enter Home Price: " + value);
        ActOn.element(driver, HomePrice).setValue(value);
        return this;
    }

    public RealApr typeDownPayment(String value) {
        LOGGER.debug("Enter Down Payment: " + value);
        ActOn.element(driver, DownPayment).setValue(value);
        return this;
    }

    public RealApr selectDownPaymentInDollar() {
        LOGGER.debug("Click on Down Payment in Dollar");
        ActOn.element(driver, DownPaymentInDollar).click();
        return this;
    }

    public RealApr typeInterestRate(String value) {
        LOGGER.debug("Enter interest rate: " + value);
        ActOn.element(driver, InterestRate).setValue(value);
        return this;
    }

    public RealApr clickOnCalculateButton() {
        LOGGER.debug("Click on Calculate Button");
        ActOn.element(driver, CalculateButton).click();
        return this;
    }

    public RealApr validateAprRate(String expectedValue) {
        String actualAprRate = ActOn.element(driver, ActualAPR).getTextValue();
        LOGGER.debug("Validating the Real APR rate is: " + expectedValue);
        Assert.assertEquals(expectedValue, actualAprRate);
        return this;
    }
}
