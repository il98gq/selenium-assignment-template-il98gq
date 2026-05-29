// import org.junit.*;
// import org.openqa.selenium.JavascriptExecutor;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openqa.selenium.support.ui.ExpectedConditions;

// import org.openqa.selenium.By;
// import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
// import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;


class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Duration duration = Duration.ofSeconds(10);

    protected By bodyBy = By.tagName("body");
    protected By footerBottomBy = By.xpath("//div[contains(@class, 'footer-bottom')]/div/div/p");
    protected By footerWidgetBy = By.xpath("//div[contains(@class, 'footer-widget')]/div/div/div[contains(@class, 'col')]/div/h2");
    
    protected By navBarBy = By.xpath("//header//div[contains(@class, 'row')]/div[2]//ul/li");
    
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, duration);
    }
    
    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    } 

    public List<WebElement> getNavBarElements() {
        return (List<WebElement>) driver.findElements(navBarBy);
    }
    
    public String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(bodyBy);
        return bodyElement.getText();
    }

    public String getFooterBottomText() {
        return this.waitAndReturnElement(footerBottomBy).getText();
    }

    public LoginPage navigateToLoginPage() {
        this.getNavBarElements().get(3).click();
        return new LoginPage(driver);
    }
   
}
