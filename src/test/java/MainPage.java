import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;


class MainPage extends PageBase {

    private By productInfoBy = By.xpath("");

    public MainPage(WebDriver driver) {
        super(driver);
    }    

    public String getProductInfo() {
        return this.waitAndReturnElement(productInfoBy).getText();
    }
    
    // redirect to ProductDetailsPage
    public ProductDetailsPage getProductDetails() {
        // 
        return new ProductDetailsPage(driver);
    }
}
