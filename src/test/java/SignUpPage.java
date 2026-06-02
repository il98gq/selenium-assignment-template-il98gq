import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends PageBase {

    private String baseXPath = "//div[@class='login-form']//";

    private By middleWareTokenBy = By.xpath(baseXPath.concat("input[1]"));
    
    private By passwordBy = By.xpath(baseXPath.concat("input[@id='password']"));

    private By newsletterCheckboxBy = By.xpath(baseXPath.concat("input[@type='checkbox' and @name='newsletter']"));
    private By specialOfferCheckboxBy = By.xpath(baseXPath.concat("input[@type='checkbox' and @name='optin']"));

    // private By firstNameBy = By.xpath(baseXPath.concat("p[1]/input[@id, 'first_name']"));
    // private By lastNameBy = By.xpath(baseXPath.concat("p[2]/input[@id, 'last_name']"));
    // private By companyBy = By.xpath(baseXPath.concat("p[3]/input[@id, 'company']"));
    // private By address1By = By.xpath(baseXPath.concat("p[4]/input[@id, 'address1']"));
    // private By address2By = By.xpath(baseXPath.concat("p[5]/input[@id, 'address2']"));
    // private By countryBy = By.xpath(baseXPath.concat("p[6]/select"));
    // private By stateBy = By.xpath(baseXPath.concat("p[75]/input"));
    // private By cityBy = By.xpath(baseXPath.concat("p[8]/input"));
    // private By zipcodeBy = By.xpath(baseXPath.concat("p[9]/input"));
    // private By mobileNumberBy = By.xpath(baseXPath.concat("p[10]/input"));

    // private By createAccountBy = By.xpath(baseXPath.concat("button"));

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public String getMiddleWareToken() {
        return driver.findElement(middleWareTokenBy).getCssValue("value");
    }

    public void selectRadioInput(String title) {
        By radioBtnBy = By.xpath("//div[@class='login-form']//input[@type='radio' and @value='" + title + "']");
        WebElement radioBtn = driver.findElement(radioBtnBy);
        if (radioBtn.isDisplayed() && !radioBtn.isSelected()) {
            radioBtn.click();
        }
        System.out.println("Radiobutton '" + title + "' is selected.");
    }

    public void fillPasswordInput(String password) {
        driver.findElement(passwordBy).sendKeys(password);
    }

    public String getSelectedDropDownValue(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);

        String option = select.getFirstSelectedOption().getText();
        return option;
    }

    public WebElement getNewsletterCheckBox() { return driver.findElement(newsletterCheckboxBy); }
    public void selectNewsLetterCheckBox() {
        WebElement checkbox = this.getNewsletterCheckBox();
        if (checkbox.isDisplayed() && !checkbox.isSelected()) {
            checkbox.click();
            System.out.println("Newsletter checkbox selected.");
        }
    }

    public WebElement getSpecialOfferCheckBox() { return driver.findElement(specialOfferCheckboxBy); }
    public void selectSpecialOfferCheckBox() {
        WebElement checkbox = this.getSpecialOfferCheckBox();
        if (checkbox.isDisplayed() && !checkbox.isSelected()) {
            checkbox.click();
            System.out.println("Special offer checkbox selected.");
        }
    }
}
