import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends PageBase {
    private String detailBaseXPath = "//div[@class='product-information']";
    private By reviewNameBy = By.xpath("//form[@id='review-form']//input[@id='name']");
    private By reviewEmailBy = By.xpath("//form[@id='review-form']//input[@id='email']");
    private By reviewTextAreaBy = By.xpath("//form[@id='review-form']//textarea");
    private By submitBtnBy = By.xpath("//form[@id='review-form']//button");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void displayProductInfo() {
        String productName = driver.findElement(By.xpath(detailBaseXPath + "/h2")).getText();
        String productCategory = driver.findElement(By.xpath(detailBaseXPath + "/p[1]")).getText();
        String productPrice = driver.findElement(By.xpath(detailBaseXPath + "/span/span")).getText();
        String productAvailability = driver.findElement(By.xpath(detailBaseXPath + "/p[2]")).getText();
        String productCondition = driver.findElement(By.xpath(detailBaseXPath + "/p[3]")).getText();
        String productBrand = driver.findElement(By.xpath(detailBaseXPath + "/p[4]")).getText();
        
        System.out.println("Product name: " + productName + "\nCategory: " + productCategory + "\nPrice: " + productPrice);
        System.out.println("Availability: " + productAvailability + "\nCondition: " + productCondition + "\nBrand: " + productBrand);
    }

    public void writeReview(String userName, String email, String review) {
        driver.findElement(reviewNameBy).sendKeys(userName);
        driver.findElement(reviewEmailBy).sendKeys(email);
        driver.findElement(reviewTextAreaBy).sendKeys(review);
        driver.findElement(submitBtnBy).click();
    }
}
