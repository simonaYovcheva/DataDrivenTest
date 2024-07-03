import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BmiCalculationTest extends BaseTest {
    private BmiCalculation bmiCalculation;

    @BeforeMethod
    public void setup() {
        super.setup();
        bmiCalculation = new BmiCalculation(driver);
    }

    @DataProvider()
    public Object[][] bmiDataProvider() {
        String[][] testData = {
                {"160", "45", "17.6", "Underweight"},
                {"168", "70", "24.8", "Normal"},
                {"181", "89", "27.2", "Overweight"},
                {"178", "100", "31.6", "Obesity"}
        };
        return testData;
    }


    @Test(dataProvider = "bmiDataProvider")
    public void testBmiCalculator(String height, String weight, String expectedBmi, String expectedBmiCategory) {

        bmiCalculation.writeIntoHeightField(height);
        bmiCalculation.writeIntoWeightField(weight);
        bmiCalculation.clickCalculateButton();

        String actualBmi = bmiCalculation.getBmiAttribute();
        String actualBmiCategory = bmiCalculation.getAttributeBmiCategory();

        Assert.assertEquals(actualBmi, expectedBmi);
        Assert.assertEquals(actualBmiCategory, expectedBmiCategory);
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

}
