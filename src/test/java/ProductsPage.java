// import org.junit.*;
// import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
// import org.openqa.selenium.NoSuchElementException;


class ProductsPage extends PageBase {
    // private By searchBarTogglerBy = By.id("search-box-toggle");
    // private By searchButtonBy = By.xpath("//section[@id='advertisement']//div[@class='container']//button[@id='submit_search']");
    
    private By searchBarBy = By.xpath("//section[@id='advertisement']//div[@class='container']//input[@id='search_product']");
    private By productCathegoriesBy = 
        By.xpath(
            "//section//div[@class='container']//div[@class='row']//div[contains(@class, 'col')]//div//div[contains(@class, 'cathegory')]"
        );

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void searchForProduct(String searchQuery) {
        // this.waitAndReturnElement(searchBarTogglerBy).click();
        this.waitAndReturnElement(searchBarBy).sendKeys(searchQuery, Keys.ENTER);
        // return new SearchResultPage(this.driver);
    }

    public void searchByCathegory() {
        // to do
    }
}
