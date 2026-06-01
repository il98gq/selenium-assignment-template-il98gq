import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends PageBase {

    private By inputNameBy = By.xpath("//form[@id='review-form']//input[@id='name']");
    private By inputEmailBy = By.xpath("//form[@id='review-form']//input[@id='email']");
    private By textAreaBy = By.xpath("/form[@id='review-form']//textarea");
    private By submitBtnBy = By.xpath("//form[@id='review-form']//button");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void displayProductInfo() {
        // to do
    }

    public void writeReview(String userName, String email, String review) {
        driver.findElement(inputNameBy).sendKeys(userName);
        driver.findElement(inputEmailBy).sendKeys(email);
        driver.findElement(textAreaBy).sendKeys(review);
        driver.findElement(submitBtnBy).click();
    }
}
