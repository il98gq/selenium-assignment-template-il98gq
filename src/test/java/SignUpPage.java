import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SignUpPage extends PageBase {

    // title (radio)
    // username (input)
    // email (input)
    // password (input)
    // dob (dd.mm.yy)
    // newsletter (checkbox)
    // special offer (checkbox)
    // firstname (input)
    // lastname (input)
    // company (input)
    // address (input)
    // address2 (input)
    // country (dropdown)
    // state (input)
    // city (input)
    // zipcode (input)
    // mobile number (input)

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void signUpValidUser(String userName, String vemail, String password, 
                                String firstName, String lastName, String company, String address, String address2,
                                String state, String city, int zipcode, String mobileNumber) {
        
        // to do
    }
}
