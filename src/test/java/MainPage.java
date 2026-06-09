import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

class MainPage extends PageBase {
    private By activeItemBy = By.xpath("//div[contains(@id, 'carousel')]//div[@class='item active']//p");

    public MainPage(WebDriver driver) {
        super(driver);
    }    

    public String getActiveItemText() {
        return this.waitAndReturnElement(activeItemBy).getText();
    }
    
    public ProductDetailsPage getProductDetails(String viewProductByString) {
        driver.findElement(By.xpath(viewProductByString)).click();
        return new ProductDetailsPage(driver);
    }
}
