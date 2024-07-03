import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://pragmatic.bg/automation/lecture15/bmicalculator.html");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
//    public BmiCalculation bmiCalculation() {
//        if (bmiCalculation == null) {
//            bmiCalculation = new BmiCalculation(driver);
//        }
//        return bmiCalculation;
//    }

    public void clickOnWebElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }

    public void typeInWebElement(WebElement webElement, String text) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }
}
