import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPage extends PageBase {

    private By emailBy = By.name("email");
    // <input name="password" type="password" value="">
    private By passwordBy = By.name("password");
    // <input name="sign_in" type="submit" value="SignIn">
    private By loginBy = By.name("sign_in");
    
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://automationexercise.com/login");
    }

    // public HomePage loginValidUser(String userName, String password) {
    //     driver.findElement(emailBy).sendKeys(userName);
    //     driver.findElement(passwordBy).sendKeys(password);
    //     driver.findElement(loginBy).click();
    //     return new HomePage(driver);
    // }
}
