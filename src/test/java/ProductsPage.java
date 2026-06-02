import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.NoSuchElementException;


class ProductsPage extends PageBase {
    private By searchBarBy = By.xpath("//section[@id='advertisement']//input[@name='search']");
    private By searchBarBtnBy = By.xpath("//section[@id='advertisement']//button[@id='submit_search']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage searchForProduct(String searchQuery) {
        this.waitAndReturnElement(searchBarBy).sendKeys(searchQuery);
        driver.findElement(searchBarBtnBy).click();
        return new ProductsPage(driver);
    }
    
    public ProductDetailsPage goToProductDetails() {
        return new ProductDetailsPage(driver);
    }
}
