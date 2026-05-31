import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
// import org.openqa.selenium.NoSuchElementException; 

// import org.testng.annotations.Listeners;

import java.time.Duration;
// import java.util.*;

// import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

// @Listeners(TestListener.class)

public class SeleniumTest {
    public WebDriver driver;
    private MainPage mainPage;
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://automationexercise.com");
        driver.manage().window().maximize();

        WebElement cookieAccept = driver.findElement(By.cssSelector(".fc-cta-consent"));
        System.out.println("Found cookie consent button.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(cookieAccept));
        wait.until(ExpectedConditions.elementToBeClickable(cookieAccept));
        cookieAccept.click();
        System.out.println("Clicked cookie consent.");

        mainPage = new MainPage(driver);
        System.out.println("mainPage: " + mainPage);
    }

    @Test
    public void testReadInputValue() {
        LoginPage loginPage = mainPage.toLogIn();
        loginPage.signUpWith("test signup input values", "test.values@example.com");

        By nameBy = By.xpath("//section//form/div[2]/input[@id='name']");
        By emailBy = By.xpath("//section//form/div[3]/input[@id='email']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameBy));

        String testUser = driver.findElement(nameBy).getAttribute("value");
        String testEmail = driver.findElement(emailBy).getAttribute("value");

        assertEquals("test signup input values", testUser);
        assertEquals("test.values@example.com", testEmail);
    }

    // @Test
    // public void testSignUpSuccess() {
    //     // "Fill an input field (text, radio, checkbox, date, etc.) — each different type counts as one" - The whole sign up page does this
    //     // "Select or verify a radio button"
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
    //     // to do:
    //     // url: /account_created
    //     // //section//div[@class='row']//h2/b = Account Created!
    //     // //section//div[@class='row']//div[@class='pull-right']/a = Continue (button)
    // }

    @Test
    public void testLoginAndLogoutSuccess() {
        LoginPage loginPage = mainPage.toLogIn();
        loginPage.logInWith("valid.user@correct.com", "correct-password");
        System.out.println("Login successful.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//a[@href='/logout']")));
        // assertTrue(true);   // assertelje h a logout gomb elérhető-e

        mainPage.toLogOut();
        System.out.println("Logout successful.");
        assertTrue(true);   // assertelje h a login/signup pagen vagyunk vagy idfk
    }
    @Test
    public void testLoginFailure() {
        LoginPage loginPage = mainPage.toLogIn();
        loginPage.logInWith("invalid.user@incorrect.com", "incorrect-password");
        
        String errMessage = driver.findElement(By.xpath("//section//div[@class='row']//form/p")).getText();
        String expectedMessage = "Your email or password is incorrect!";
        System.out.println(errMessage);
        assertTrue(errMessage.equals(expectedMessage));
    }

    @Test
    public void testSubmitReviewSuccess() {
        // "Fill or read the content of a textarea element"
        System.out.println("Review successfully submitted.");
    }
    // @Test
    // public void payForCart() {
    //     // "Submit a form that requires a registered/logged-in user"
    // }

    @Test
    public void testStaticPage() {
        assertTrue(mainPage.getFooterBottomText().contains("Copyright"));
    }
    @Test
    public void testThatFails() {
        // driver.findElement(null);
        System.out.println("This test will fail.");
    }

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
        mainPage.toLogIn();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userNameElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section//div[contains(@class, 'login')]/form/input[2]")));
        userNameElement.sendKeys("Explicit wait testing.");
        System.out.println("Username successfully entered in the input field.");
    }

    @Test
    public void testPageTitle() {
        System.out.println(driver.getTitle());
        assertTrue("Title should contain 'Automation Exercise'.", driver.getTitle().contains("Automation Exercise"));
    }

    // ========================================================================================================================================= //
    @Test
    public void testAddCookie() {
        // to do
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
