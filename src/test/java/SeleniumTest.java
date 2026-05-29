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
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;


public class SeleniumTest {
    public WebDriver driver;
    private MainPage mainPage;
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://automationexercise.com");
        driver.manage().window().maximize();

        System.out.println("mainPage: " + mainPage);
        mainPage = new MainPage(driver);
    }

    // @Test
    // public void testLoginAndLogout() {
    //     // "Fill a simple form and submit it (e.g. login with username and password)"
    //     // LoginPage login = new LoginPage(driver);
    //     // login.loginValidUser("null", "null");
    //     // "Log out from the application and verify it"

    // }

    // @Test
    // public void submitSignUpForm() {
    //     // "Fill an input field (text, radio, checkbox, date, etc.) — each different type counts as one" - The whole sign up page does this
    //     // "Select or verify a radio button"
    //     // "Submit a form (each distinct form counts as one)" - signup, login, review (3)
    //     // "Submit a form that requires a registered/logged-in user" - (probably paying for the cart)
    //     LoginPage loginPage = mainPage.navigateToLoginPage();
    //     SignUpPage signUpPage = loginPage.redirectUserToSignUpPage("newuser", "new.user@example.com");
    //     int[] dob = {7, 11, 5};
    //     Dictionary<String, String> inputFields = new Hashtable<>();
    //     inputFields.put("password", "password");
    //     inputFields.put("firstname", "New");
    //     inputFields.put("lastName", "User");
    //     inputFields.put("company", "Some Company Kft.");
    //     inputFields.put("address1", "Adress Street 11");
    //     inputFields.put("address2", "");
    //     inputFields.put("state", "Kansas");
    //     inputFields.put("city", "Kansas City");
    //     inputFields.put("zipcode", "1111");
    //     inputFields.put("mobileNumber", "12 345 6789");

    //     signUpPage.createValidAccount(inputFields, dob, 2);
    //     System.out.println("Account successfully created.");
    // }
    // @Test
    // public void submitLogInForm() {
    //     // to do
    // }
    // @Test
    // public void submitReviewForm() {
    //     // "Fill or read the content of a textarea element"
    // }
    // @Test
    // public void payForCart() {
    //     // to do
    // }

    // @Test
    // public void testStaticPage() {
    //     // "Test a static page (verify text content, element presence, etc.)"
    //     assertTrue(mainPage.getFooterBottomText().contains("Subscription"));

    // }

    // @Test
    // public void testMultiplePages() {
    //     // "Define an array of URLs or page data, iterate over them and verify something on each page 
    //     // (e.g. check title or a specific element on 5 different pages using a loop)"
    //     String[] URLs = {"", "", "", ""};
    // }

    // @Test
    // public void testDropDown() {
    //     // "Select an option from a drop-down (using Select class or similar)"
    // }

    @Test
    public void testExplicitWait() {
        mainPage.navigateToLoginPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userNameElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section//div[contains(@class, 'login')]/form/input[2]")));
        userNameElement.sendKeys("Explicit wait testing.");
        System.out.println("Username successfully entered in the input field.");
    }

    @Test
    public void testPageTitle() {
        assertTrue("Title should contain 'Automation Exercise'.", driver.getTitle().contains("Automation Exercise"));
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
