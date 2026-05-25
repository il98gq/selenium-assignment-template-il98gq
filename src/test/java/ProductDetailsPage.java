import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends PageBase {

    // private By reviewFormBy = By.id("review-form"); // to do: rewrite to be in xpath format
    private By inputNameBy = By.id("name");
    private By inputEmailBy = By.id("email");
    private By textAreaBy = By.id("review");
    private By submitBtnBy = By.id("button-review");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void writeReview(String userName, String email, String review) {
        driver.findElement(inputNameBy).sendKeys(userName);
        driver.findElement(inputEmailBy).sendKeys(email);
        driver.findElement(textAreaBy).sendKeys(review);
        driver.findElement(submitBtnBy).click();
    }
}
