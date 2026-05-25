import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends PageBase {

    private By reviewFormBy = By.id("review-form"); // to do: rewrite to be in xpath format
    private By inputNameBy = By.id("name");
    private By inputEmailBy = By.id("email");
    private By textAreaBy = By.id("review");
    private By submitBtnBy = By.id("button-review");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void writeReview() {
        // to do
    }
}
