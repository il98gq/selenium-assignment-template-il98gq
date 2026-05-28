import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;  

import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;


public class SeleniumTest {
    public WebDriver driver;
    private PageBase mainPage;
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.get("https://automationexercise.com");
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);
    }

    @Test
    public void testLoginAndLogout() {
        // "Fill a simple form and submit it (e.g. login with username and password)"
        LoginPage login = new LoginPage(driver);
        login.loginValidUser("null", "null");
        // "Log out from the application and verify it"

    }

    @Test
    public void testForms() {
        // "Fill an input field (text, radio, checkbox, date, etc.) — each different type counts as one" - The whole sign up page does this
        // "Fill or read the content of a textarea element"
        // "Select or verify a radio button"
        // "Submit a form (each distinct form counts as one)" - signup, login, review (3)
        // "Submit a form that requires a registered/logged-in user" - (probably paying for the cart)
    }

    @Test
    public void testStaticPage() {
        // "Test a static page (verify text content, element presence, etc.)"
        assertTrue(mainPage.getFooterBottomText().contains("Subscription"));

    }

    @Test
    public void testMultiplePages() {
        // "Define an array of URLs or page data, iterate over them and verify something on each page 
        // (e.g. check title or a specific element on 5 different pages using a loop)"
        String[] URLs = {"", "", "", ""};
    }

    @Test
    public void testDropDown() {
        // "Select an option from a drop-down (using Select class or similar)"
    }

    @Test
    public void testExplicitWait() {
        // "Use explicit wait (WebDriverWait with ExpectedConditions)"
    }

    @Test
    public void testPageTitle() {
        // "Read and verify the page title using getTitle()"
        assertTrue(driver.getTitle().contains("Automation Exercise"));
    }
    
    // @Test
    // public void testSearch() {
    //     MainPage mainPage = new MainPage(this.driver);
    //     Assert.assertTrue(mainPage.getFooterText().contains("Eötvös Loránd University"));

    //     SearchResultPage searchResultPage = mainPage.search("Student guide 2025");
    //     String bodyText = searchResultPage.getBodyText();
    //     Assert.assertTrue(bodyText.contains("Searched content"));
    //     Assert.assertTrue(bodyText.contains("Student guide 2025/26"));
    // }

    // @Test
    // public void testSearch2() {
    //     String[] searchQueries={"something","asd","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"};
    //     for(String searchQuery : searchQueries) {
    //         MainPage mainPage = new MainPage(this.driver);
    //         SearchResultPage searchResultPage = mainPage.search(searchQuery);
    //         String bodyText = searchResultPage.getBodyText();
    //         Assert.assertTrue(bodyText.contains("Searched content"));
    //     }  
    // }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
