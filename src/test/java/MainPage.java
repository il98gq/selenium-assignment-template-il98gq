// import org.junit.*;
// import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
// import org.openqa.selenium.Keys;
// import org.openqa.selenium.NoSuchElementException;


class MainPage extends PageBase {
    private By firstProductInfoBy = By.xpath("");
    private By viewFirstProductBy = By.xpath("");
    // private By activeElementBy = By.xpath("//section[@id, 'slider']/div/div[@class, 'row]/div/div[contains(@id, 'carousel')]/div/div[@class, 'item active']");
    private By activeItemBy = By.xpath("//section/div/div/div/div[contains(@id, 'carousel')]/div/div[@class, 'item-active']/div/p");

    public MainPage(WebDriver driver) {
        super(driver);
    }    

    public String getRecommendedProductInfo() {
        return this.waitAndReturnElement(firstProductInfoBy).getText();
    }

    public String getActiveItemText() {
        return this.waitAndReturnElement(activeItemBy).getText();
    }
    
    // redirect to ProductDetailsPage
    public ProductDetailsPage getFirstProductDetails() {
        // click on product 
        return new ProductDetailsPage(driver);
    }
}
