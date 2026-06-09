import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageBase {
    private By emptyCartTxtBy = By.xpath("//span[@id='empty_cart']//p");
    private By proceedToCheckoutBy = By.xpath("//a[contains(@class, 'check_out')]");
    
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getEmptyCartTxt() {
        return driver.findElement(emptyCartTxtBy).getText();
    }
    public void removeProductFromCart(String productId) {
        By removeProductBy = By.xpath("//a[contains(@class, 'delete') and @data-product-id='" + productId + "']");
        driver.findElement(removeProductBy).click();
    }
    public void proceedToCheckout() {
        driver.findElement(proceedToCheckoutBy).click();
    }
}
