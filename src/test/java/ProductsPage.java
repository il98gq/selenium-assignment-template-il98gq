import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


class ProductsPage extends PageBase {
    private By searchBarTogglerBy = By.id("search-box-toggle");
    private By searchBarBy = By.xpath("//div[@id='search-box']//input[@type='search']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    // public SearchResultPage search(String searchQuery) {
    //     this.waitAndReturnElement(searchBarTogglerBy).click();
    //     this.waitAndReturnElement(searchBarBy).sendKeys(searchQuery, Keys.ENTER);
    //     return new SearchResultPage(this.driver);
    // }
}
