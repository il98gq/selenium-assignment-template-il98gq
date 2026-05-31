import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openqa.selenium.NoSuchElementException;
// import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import java.time.Duration;


class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Duration duration = Duration.ofSeconds(10);

    protected By bodyBy = By.tagName("body");
    protected By footerBottomBy = By.xpath("//footer/div[2]//p");
    protected By footerWidgetBy = By.xpath("//footer/div[1]//h2");
    protected By featuredItemsTitleBy = By.xpath("//section//div[@class='features_items']/h2");
    
    protected String navBarRootXPath = "//header//div[contains(@class, 'row')]/div[2]//ul/li/a";
    
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, duration);
    }
    
    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    } 
    
    public String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(bodyBy);
        return bodyElement.getText();
    }
    public String getFooterBottomText() {
        return this.waitAndReturnElement(footerBottomBy).getText();
    }
    public String getFeaturedItemsTitleText() {
        return this.waitAndReturnElement(featuredItemsTitleBy).getText();
    }

    public MainPage toMainPage() {
        driver.findElement(By.xpath(navBarRootXPath.concat("[@href='/']"))).click();
        return new MainPage(driver);
    }
    public ProductsPage toProductsPage() {
        driver.findElement(By.xpath(navBarRootXPath.concat("[@href='/products']"))).click();
        return new ProductsPage(driver);
    }
    public CartPage toCartPage() {
        driver.findElement(By.xpath(navBarRootXPath.concat("[@href='/view_cart']"))).click();
        return new CartPage(driver);
    }
    public LoginPage toLogIn() {
        driver.findElement(By.xpath(navBarRootXPath.concat("[@href='/login']"))).click();
        return new LoginPage(driver);
    }
    public LoginPage toLogOut() {
        driver.findElement(By.xpath(navBarRootXPath.concat("[@href='/logout']"))).click();
        return new LoginPage(driver);
    }
   
}
