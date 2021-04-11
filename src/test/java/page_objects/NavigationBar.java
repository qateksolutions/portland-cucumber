package page_objects;

import command_providers.ActOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    public WebDriver driver;
    private final By MortgageCalculatorLogo = By.xpath("//a/img[@alt='Logo']");
    private final By Rates = By.linkText("Rates");
    private final By RealApr = By.linkText("Real APR");

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    public NavigationBar mouseHoverToRates() {
        ActOn.element(driver, Rates).mouseHover();
        return this;
    }

    public RealApr navigateToRealApr() {
        ActOn.element(driver, RealApr).click();
        return new RealApr(driver);
    }
}
