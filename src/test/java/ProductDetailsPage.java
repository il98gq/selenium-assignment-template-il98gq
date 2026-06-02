import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends PageBase {

    private By reviewNameBy = By.xpath("//form[@id='review-form']//input[@id='name']");
    private By reviewEmailBy = By.xpath("//form[@id='review-form']//input[@id='email']");
    private By reviewTextAreaBy = By.xpath("//form[@id='review-form']//textarea");
    private By submitBtnBy = By.xpath("//form[@id='review-form']//button");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void displayProductInfo() {
        // to do
    }

    public void writeReview(String userName, String email, String review) {
        driver.findElement(reviewNameBy).sendKeys(userName);
        driver.findElement(reviewEmailBy).sendKeys(email);
        driver.findElement(reviewTextAreaBy).sendKeys(review);
        driver.findElement(submitBtnBy).click();
    }
}
