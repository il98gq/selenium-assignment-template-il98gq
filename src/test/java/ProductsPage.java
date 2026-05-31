// import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
// import org.openqa.selenium.NoSuchElementException;


class ProductsPage extends PageBase {
    private By searchBarBy = By.xpath("//section[@id='advertisement']//input[@name='search']");
    private By searchBarBtnBy = By.xpath("//section[@id='advertisement']//button[@id='submit_search']");

    private String categoriesBaseXPath = "//section[2]//div[contains(@class, 'category-products')]//";
    // //section[2]//div[contains(@class, 'category-products')]//div[@id='Women']//ul/li/a[contains(@href, '/1')]
    private String brandsBaseXPath = "//section[2]//div[contains(@class, 'brand-products')]//";
    // //section[2]//div[contains(@class, 'brands_products')]//a[contains(@href, 'Polo')]
    

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage searchForProduct(String searchQuery) {
        this.waitAndReturnElement(searchBarBy).sendKeys(searchQuery);
        driver.findElement(searchBarBtnBy).click();
        return new ProductsPage(driver);
    }
    public void searchByCategory(String category, String subcategory) { // pl.: searchByCategory(Women, 1)
        // Women: //div[@id='Women']//ul/li
        // Men:   //div[@id='Men']//ul/li
        // Kids:  //div[@id='Kids']//ul/li
        By categoryBy = By.xpath(categoriesBaseXPath + "div[@id='" + category + "']//ul/li/a[contains(@href, '/" + subcategory + "')]");
        driver.findElement(categoryBy).click();
    }
    public void searchByBrand(String brand) {
        // Polo: //a[contains(@href, 'Polo')]
        // H&M:   //a[contains(@href, 'H&M')]
        // Madame:  //a[contains(@href, 'Madame')]
        // Mast & Harbour: //a[contains(@href, 'Mast & Harbour')]
        // Babyhug: //a[contains(@href, 'Babyhug')]
        // Kookie Kids: //a[contains(@href, 'Kookie Kids')]
        // Biba: //a[contains(@href, 'Biba')]
    }
    public ProductDetailsPage goToProductDetails() {
        // to do
        return new ProductDetailsPage(driver);
    }
}
