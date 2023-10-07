package page;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AlertsPage {

    Page page;

    String alertButton = "id=alertButton";
    String promtButton = "id=promtButton";
    String timerAlertButton = "id=timerAlertButton";
    String confirmButton ="id=confirmButton";


    public AlertsPage(Page page) {
        this.page = page;
    }

    public void userClickOnFirstAlert() throws InterruptedException {
        page.onDialog(dialog -> {
            System.out.println("Here is your alert message 1: " + dialog.message());
            dialog.accept();
            assertEquals("You clicked a button", dialog.message());
        });
        page.locator(alertButton).click();
    }


    public void userClickOnSecondAlert() throws InterruptedException {
        page.onDialog(dialog -> {
            System.out.println("Here is your alert message 2: " + dialog.message());
            assertEquals("This alert appeared", dialog.message());
            dialog.accept();
        });
        page.locator(timerAlertButton).click();
        page.waitForTimeout(5000);
//        page.waitForSelector("dialog");
        System.out.println("Here is your alert message 2");
    }


    public void userClickOnThirdAlert(){
        page.onDialog(dialog -> {
            System.out.println("Here is your alert message 3: " + dialog.message());
            dialog.accept();
        });
        page.locator(confirmButton).click();
        assertThat(page.locator("id=confirmResult")).containsText("You selected Ok");
    }


    public void userClickOnFourthAlert(){
            page.onDialog(dialog -> {
                dialog.accept("test data send");
            });
            page.locator(promtButton).click();
    }

}
