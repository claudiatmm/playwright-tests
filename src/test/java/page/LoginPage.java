package page;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertEquals;


public class LoginPage {

    Page page;

    String firstname = "First Name";
    String lastname = "Last Name";
    String email = "//*[@id=\"eid\"]/input";
    String phone = "//*[@id=\"basicBootstrapForm\"]/div[4]/div/input";
    String gender ="[value='FeMale']";


    public LoginPage(Page page) {
        this.page = page;
    }


    public void userCompleteRegistrationForm(String name, String lastN, String emailL, String phoneL) throws InterruptedException {
        page.getByPlaceholder(firstname).fill(name);
        page.getByPlaceholder(lastname).fill(lastN);
        page.locator(email).fill(emailL);
        page.locator(phone).fill(phoneL);
        page.check(gender);
    }

}
