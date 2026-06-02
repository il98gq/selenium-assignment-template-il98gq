import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignUpPage extends PageBase {
    private By middleWareTokenBy = By.xpath("//input[1]");
    private By passwordBy = By.xpath("//input[@id='password']");
    private By newsletterCheckboxBy = By.xpath("//input[@type='checkbox' and @name='newsletter']");
    private By specialOfferCheckboxBy = By.xpath("//input[@type='checkbox' and @name='optin']");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public String getMiddleWareToken() {
        return driver.findElement(middleWareTokenBy).getCssValue("value");
    }

    public void selectRadioInput(String title) {
        By radioBtnBy = By.xpath("//input[@type='radio' and @value='" + title + "']");
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
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        
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
