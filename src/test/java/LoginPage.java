import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {

    private By logInEmailBy = By.xpath("//div[1]//form/input[@name='email']");
    private By logInPasswordBy = By.xpath("//div[1]//form/input[@name='password']");
    private By logInBtnBy = By.xpath("//div[1]//form/button[@type='submit']");
    
    private By signUpUserNameBy = By.xpath("//div[3]//form/input[@name='name']");
    private By signUpEmailBy =  By.xpath("//div[3]//form/input[@name='email']");
    private By signUpBtnBy = By.xpath("//div[3]//form/button[@type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage logInWith(String userName, String password) {
        driver.findElement(logInEmailBy).sendKeys(userName);
        driver.findElement(logInPasswordBy).sendKeys(password);
        driver.findElement(logInBtnBy).click();
        return new MainPage(driver);
    }

    public SignUpPage signUpWith(String userName, String email) {
        driver.findElement(signUpUserNameBy).sendKeys(userName);
        driver.findElement(signUpEmailBy).sendKeys(email);
        driver.findElement(signUpBtnBy).click();
        return new SignUpPage(driver);
    }
}
