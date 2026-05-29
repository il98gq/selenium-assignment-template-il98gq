import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {

    private By emailBy = By.xpath("//section//div[contains(@class, 'login')]/form/input[2]");
    private By passwordBy = By.name("password");
    private By loginBy = 
        By.xpath(
            "//div[@class='container']/div[@class='row']/div[contains(@class, 'offset-1')]/div[@class='login-form']/form/button[@data-qa='login-button']"
        );
    
    // signup
    private String baseXPath = "//section/div/div/div/div/form/";
    private By signUpUserNameBy = By.xpath(baseXPath.concat("div[2]/input[@id, 'name']"));
    private By signUpEmailBy = By.xpath(baseXPath.concat("div[3]/input[1]"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage loginValidUser(String userName, String password) {
        driver.findElement(emailBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginBy).click();
        return new MainPage(driver);
    }

    public SignUpPage redirectUserToSignUpPage(String userName, String email) {
        driver.findElement(signUpUserNameBy).sendKeys(userName);
        driver.findElement(signUpEmailBy).sendKeys(email);
        // click the create account button
        return new SignUpPage(driver);
    }
}
