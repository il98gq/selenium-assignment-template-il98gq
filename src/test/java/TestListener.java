import org.testng.*;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

// import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {
    // @Test
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        System.out.println("Test failure. Screenshot captured.");
        if (driver != null) {
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File dest = new File("screenshots/failure-screenshot-" + result.getName() + ".png");
                Files.copy(screenshot, dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
