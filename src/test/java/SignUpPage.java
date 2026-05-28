import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends PageBase {
    // //section//div//div//div//div//form
    // middleware token?
    private By middleWareTokenBy = By.xpath("//section//div//div//div//div//form//input[contains(@name, 'token')]");
    
    // title (radio)
    private By mrTitleBy = By.xpath("//section/div/div/div/div/form/div[1]/div[1]/label/div/span/input");
    private By mrsTitleBy = By.xpath("//section/div/div/div/div/form/div[1]/div[2]/label/div/span/input");
    
    // username (input)
    private By userNameBy = By.xpath("//section/div/div/div/div/form/div[2]/input[@id, 'name']");
    // email (input)
    private By emailBy = By.xpath("//section/div/div/div/div/form/div[3]/input[1]");
    // password (input)
    private By passwordBy = By.xpath("//section/div/div/div/div/form/div[4]/input[@id, 'password']");
    // dob (dd.mm.yy)
    private By dayBy = By.xpath("//section/div/div/div/div/form/div[5]/div/div[1]/div/select");
    private By monthBy = By.xpath("//section/div/div/div/div/form/div[5]/div/div[2]/div/select");
    private By yearBy = By.xpath("//section/div/div/div/div/form/div[5]/div/div[3]/div/select");

    // newsletter (checkbox)
    private By newletterCheckboxBy = By.xpath("//section/div/div/div/div/form/div[6]/div/span/input");
    // special offer (checkbox)
    private By specialOfferCheckboxBy = By.xpath("//section/div/div/div/div/form/div[7]/div/span/input");

    // firstname (input)
    private By firstNameBy = By.xpath("//section/div/div/div/div/form/p[1]/input[@id, 'first_name']");
    // lastname (input)
    private By lastNameBy = By.xpath("//section/div/div/div/div/form/p[2]/input[@id, 'last_name']");
    // company (input)
    private By companyBy = By.xpath("//section/div/div/div/div/form/p[3]/input[@id, 'company']");
    // address (input)
    private By address1By = By.xpath("//section/div/div/div/div/form/p[4]/input[@id, 'address1']");
    // address2 (input)
    private By address2By = By.xpath("//section/div/div/div/div/form/p[5]/input[@id, 'address2']");
    // country (dropdown)
    private By countryBy = By.xpath("//section/div/div/div/div/form/p[6]/select");
    // state (input)
    private By stateBy = By.xpath("//section/div/div/div/div/form/p[75]/input");
    // city (input)
    private By cityBy = By.xpath("//section/div/div/div/div/form/p[8]/input");
    // zipcode (input)
    private By zipcodeBy = By.xpath("//section/div/div/div/div/form/p[9]/input");
    // mobile number (input)
    private By mobileNumberBy = By.xpath("//section/div/div/div/div/form/p[10]/input");

    private By createAccountBy = By.xpath("//section/div/div/div/div/form/button");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void createValidAccount(String userName, String email, String password, 
                                String firstName, String lastName, String company, String address, String address2,
                                String state, String city, int zipcode, String mobileNumber) {
        
        // to do
        WebElement selectDayElement = driver.findElement(dayBy);
        Select selectDay = new Select(selectDayElement);
        List<WebElement> dayOptions = selectDay.getOptions();
    }
}
