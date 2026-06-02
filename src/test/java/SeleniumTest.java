import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openqa.selenium.NoSuchElementException; 
import org.openqa.selenium.support.ui.ExpectedConditions;

// import org.testng.annotations.Listeners;

import java.util.Set;
import java.time.Duration;

import javax.imageio.ImageIO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.awt.image.BufferedImage;
import java.io.File;

// @Listeners(TestListener.class)

public class SeleniumTest {
    public WebDriver driver;
    private MainPage mainPage;
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.get("https://automationexercise.com");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By cookieAcceptBy = By.cssSelector(".fc-cta-consent");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(cookieAcceptBy)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cookieAcceptBy)));
        driver.findElement(cookieAcceptBy).click();

        mainPage = new MainPage(driver);
    }

    @Test
    public void testSearchBar() {
        ProductsPage productsPage = mainPage.toProductsPage();
        productsPage.searchForProduct("Blue");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='advertisement']")));
        String productName = driver.findElement(By.xpath("//section[2]//div[@class='features_items']/div[@class='col-sm-4'][1]//p")).getText();
        Assert.assertTrue(productName.contains("Blue"));
    }
    
    @Test
    public void testFillSignUpAccountInformation() {
        String testTitle = "Mrs";
        String testInputUser = "test signup input values";
        String testInputEmail = "test.values@example.com";
        String testPassword = "test.password";
        String testDay = "5";
        String testMonth = "July";
        String testMonthValue = "7";
        String testYear = "1999";

        LoginPage loginPage = mainPage.toLogIn();
        SignUpPage signUpPage = loginPage.signUpWith(testInputUser, testInputEmail);

        By titleMrsBy = By.xpath("//div[@class='login-form']//input[@type='radio' and @value='Mrs']");
        By nameBy = By.xpath("//div[@class='login-form']//input[@id='name']");
        By emailBy = By.xpath("//div[@class='login-form']//input[@id='email']");
        By passwordBy = By.xpath("//div[@class='login-form']//input[@id='password']");
        By dayBy = By.xpath("//div[@class='login-form']//select[@id='days']");
        By monthBy = By.xpath("//div[@class='login-form']//select[@id='months']");
        By yearBy = By.xpath("//div[@class='login-form']//select[@id='years']");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameBy));

        // title
        signUpPage.selectRadioInput(testTitle);
        assertTrue(driver.findElement(titleMrsBy).isSelected());
        
        // username & email
        assertEquals(testInputUser, driver.findElement(nameBy).getAttribute("value"));
        assertEquals(testInputEmail, driver.findElement(emailBy).getAttribute("value"));

        // password
        signUpPage.fillPasswordInput(testPassword);
        assertEquals(testPassword, driver.findElement(passwordBy).getAttribute("value"));

        // DoB
        assertEquals(testDay, signUpPage.getSelectedDropDownValue(dayBy, testDay));
        assertEquals(testMonth, signUpPage.getSelectedDropDownValue(monthBy, testMonthValue));
        assertEquals(testYear, signUpPage.getSelectedDropDownValue(yearBy, testYear));

        // checkboxes
        WebElement newsCheckBox = signUpPage.getNewsletterCheckBox();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", newsCheckBox);

        assertFalse(newsCheckBox.isSelected());
        signUpPage.selectNewsLetterCheckBox();
        assertTrue(newsCheckBox.isSelected());

        WebElement specialOfferCheckBox = signUpPage.getSpecialOfferCheckBox();
        assertFalse(specialOfferCheckBox.isSelected());
        signUpPage.selectSpecialOfferCheckBox();
        assertTrue(specialOfferCheckBox.isSelected());
    }
    
    @Test
    public void testLoginAndLogoutSuccess() {
        LoginPage loginPage = mainPage.toLogIn();
        loginPage.logInWith("valid.user@correct.com", "correct-password");
        System.out.println("Login successful.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//a[@href='/logout']")));
        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().equals("https://automationexercise.com/"));

        mainPage.toLogOut();
        System.out.println("Logout successful.");
        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().equals("https://automationexercise.com/login"));;
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
        By reviewAckBy = By.xpath("//div[@id='review-section']//span");
        ProductDetailsPage detailsPage = mainPage.getProductDetails("//div[@class='features_items']//a[@href='/product_details/1']");
        detailsPage.writeReview("Test Reviewer", "review@example.com", "This item was reviewed By Test Reviewer.");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement reviewAck = wait.until(ExpectedConditions.visibilityOfElementLocated(reviewAckBy));
        assertEquals("Thank you for your review.", reviewAck.getText());
    }
    
    @Test
    public void testMainPageFooterText() {
        assertTrue(mainPage.getFooterBottomText().contains("Copyright"));
    }

    @Test
    public void testMultiplePagesH2() {
        String[] URLs = {"https://automationexercise.com/", "https://automationexercise.com/products", "https://automationexercise.com/category_products/1"};
        String[] titles = {"FEATURES ITEMS", "ALL PRODUCTS", "WOMEN - DRESS PRODUCTS"};
        for (int i = 0; i < 3; i++) {
            driver.get(URLs[i]);
            String title = driver.findElement(By.xpath("//div[@class='features_items']/h2")).getText();
            System.out.println("Expected: " + titles[i] + ", Actual: " + title);
            assertEquals(titles[i], title);
        }
    }

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
    public void testSetCookie() {
        mainPage.setCookie("im_a_selenium_test_cookie", "selenium_assignment");
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("im_a_selenium_test_cookie")) {
                assertEquals("selenium_assignment", cookie.getValue());
            }
        }
    }

    @Test
    public void testScrollToPageBottom() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement footerBottom = driver.findElement(mainPage.footerBottomBy);
        wait.until(ExpectedConditions.visibilityOf(footerBottom));
        assertTrue(footerBottom.isDisplayed());
    }

    @Test
    public void testDownloadProductImage() {
        String foldername = "saved-images";
        File savedImgFolder = new File(foldername);
        if(savedImgFolder.exists() && savedImgFolder.isDirectory()) {
            savedImgFolder.delete();
        }
        savedImgFolder.mkdir();
        
        try {
            driver.get("https://automationexercise.com/product_details/1");
            WebElement productImage = driver.findElement(By.xpath("//div[@class='view-product']/img"));
            String productImageSrc = productImage.getAttribute("src");
            URL imageURL = new URL(productImageSrc);
            BufferedImage saveImage = ImageIO.read(imageURL);
            String fullImagePath = foldername.concat("/product-1.png");
            ImageIO.write(saveImage, "png", new File(fullImagePath));


            File verifyDownloadedImage = new File(fullImagePath);
            assertTrue(verifyDownloadedImage.exists());
            assertTrue(verifyDownloadedImage.getParentFile().getName().equals(foldername));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
