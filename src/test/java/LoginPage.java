import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPage extends PageBase {

    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By loginBy = 
        By.xpath(
            "//div[@class='container']/div[@class='row']/div[contains(@class, 'offset-1')]/div[@class='login-form']/form/button[@data-qa='login-button']"
        );
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage loginValidUser(String userName, String password) {
        driver.findElement(emailBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginBy).click();
        return new MainPage(driver);
    }
}
