import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends PageBase {

    private String baseXPath = "//section/div/div/div/div/form/";
    // private By middleWareTokenBy = By.xpath("//section/div/div/div/div/form/input[1]");
    private By middleWareTokenBy = By.xpath(baseXPath.concat("input[1]"));
    
    private By mrTitleBy = By.xpath(baseXPath.concat("div[1]/div[1]/label/div/span/input"));
    private By mrsTitleBy = By.xpath(baseXPath.concat("div[1]/div[2]/label/div/span/input"));

    private By userNameBy = By.xpath(baseXPath.concat("div[2]/input[@id, 'name']"));
    private By emailBy = By.xpath(baseXPath.concat("div[3]/input[1]"));
    private By passwordBy = By.xpath(baseXPath.concat("div[4]/input[@id, 'password']"));

    private By dayBy = By.xpath(baseXPath.concat("div[5]/div/div[1]/div/select"));
    private By monthBy = By.xpath(baseXPath.concat("div[5]/div/div[2]/div/select"));
    private By yearBy = By.xpath(baseXPath.concat("div[5]/div/div[3]/div/select"));

    private By newletterCheckboxBy = By.xpath(baseXPath.concat("div[6]/div/span/input"));
    private By specialOfferCheckboxBy = By.xpath(baseXPath.concat("div[7]/div/span/input"));

    private By firstNameBy = By.xpath(baseXPath.concat("p[1]/input[@id, 'first_name']"));
    private By lastNameBy = By.xpath(baseXPath.concat("p[2]/input[@id, 'last_name']"));
    private By companyBy = By.xpath(baseXPath.concat("p[3]/input[@id, 'company']"));
    private By address1By = By.xpath(baseXPath.concat("p[4]/input[@id, 'address1']"));
    private By address2By = By.xpath(baseXPath.concat("p[5]/input[@id, 'address2']"));
    private By countryBy = By.xpath(baseXPath.concat("p[6]/select"));
    private By stateBy = By.xpath(baseXPath.concat("p[75]/input"));
    private By cityBy = By.xpath(baseXPath.concat("p[8]/input"));
    private By zipcodeBy = By.xpath(baseXPath.concat("p[9]/input"));
    private By mobileNumberBy = By.xpath(baseXPath.concat("p[10]/input"));

    private By createAccountBy = By.xpath(baseXPath.concat("button"));

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public String getMiddleWareToken() {
        return driver.findElement(middleWareTokenBy).getCssValue("value");
    }

    public Select getSelector(By locator) {
        WebElement element = driver.findElement(locator);
        return new Select(element);
    }

    public List<WebElement> getSelectoptions(By locator) {
        WebElement element = driver.findElement(locator);
        Select selector = new Select(element);
        return selector.getOptions();
    }

    public void createValidAccount(Dictionary<String, String> inputFields, int[] dobIndexes, int countryIndex) {
        // List<WebElement> dayOptions = getSelectoptions(dayBy);
        // List<WebElement> monthOptions = getSelectoptions(monthBy);
        // List<WebElement> yearOptions = getSelectoptions(yearBy);
        
        Select selectDay = getSelector(dayBy);
        selectDay.selectByIndex(dobIndexes[0]);
        Select selectMonth = getSelector(monthBy);
        selectMonth.selectByIndex(dobIndexes[1]);
        Select selectYear = getSelector(yearBy);
        selectYear.selectByIndex(dobIndexes[2]);

        // to do: newletter checkboxes
        driver.findElement(newletterCheckboxBy);
        driver.findElement(specialOfferCheckboxBy);

        driver.findElement(passwordBy).sendKeys(inputFields.get("password"));
        driver.findElement(firstNameBy).sendKeys(inputFields.get("firstName"));
        driver.findElement(lastNameBy).sendKeys(inputFields.get("lastName"));
        driver.findElement(companyBy).sendKeys(inputFields.get("company"));
        driver.findElement(address1By).sendKeys(inputFields.get("address1"));
        if (!inputFields.get("address2").equals(null) && !inputFields.get("address2").equals("")) {
            driver.findElement(address2By).sendKeys(inputFields.get("address2"));
        }

        Select selectCountry = getSelector(countryBy);
        selectCountry.selectByIndex(countryIndex);

        driver.findElement(stateBy).sendKeys(inputFields.get("state"));
        driver.findElement(cityBy).sendKeys(inputFields.get("city"));
        driver.findElement(zipcodeBy).sendKeys(inputFields.get("zipcode"));
        driver.findElement(mobileNumberBy).sendKeys(inputFields.get("mobileNumber"));

        driver.findElement(createAccountBy).click();
    }
}
