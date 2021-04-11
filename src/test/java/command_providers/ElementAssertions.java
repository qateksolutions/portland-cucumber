package command_providers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ElementAssertions {
    private By locator;
    private WebDriver driver;

    public ElementAssertions(By locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
    }

    public ElementAssertions elementExist() {
       Boolean element  = driver.findElements(locator).size() > 0 ;
        Assert.assertTrue("The expected element does not exist", element);
        return this;
    }
}
