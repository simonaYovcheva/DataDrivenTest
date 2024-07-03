import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BmiCalculation extends BasePage {


    @FindBy(id = "heightCMS")
    @CacheLookup
    private WebElement heightInputField;

    @FindBy(id = "weightKg")
    @CacheLookup
    private WebElement weightInputField;

    @FindBy(id = "Calculate")
    @CacheLookup
    private WebElement calculateButton;

    @FindBy(id = "bmi")
    @CacheLookup
    private WebElement bmiField;

    @FindBy(id = "bmi_category")
    @CacheLookup
    private WebElement bmiCategoryField;

    public BmiCalculation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void writeIntoHeightField(String height) {
        heightInputField.clear();
        heightInputField.sendKeys(height);
    }

    public void writeIntoWeightField(String weight) {
        weightInputField.clear();
        weightInputField.sendKeys(weight);
    }

    public void clickCalculateButton() {
        calculateButton.click();
    }

    public String getBmiAttribute() {
        return bmiField.getAttribute("value");
    }

    public String getAttributeBmiCategory() {
        return bmiCategoryField.getAttribute("value");
    }
}
