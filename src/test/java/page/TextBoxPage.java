package page;

import com.microsoft.playwright.Page;

public class TextBoxPage {

    Page page;

    //Locators
    String userName = "id=userName";
    String userEmail = "id=userEmail";
    String currentAddress = "id=currentAddress";
    String permanentAddress = "id=permanentAddress";
    String submitButton = "id=submit";


    public TextBoxPage(Page page) {
        this.page = page;
    }

    public void sendUserDataForTextBox(String username, String email, String address, String permanentA){
        page.fill(userName, username);
        page.fill(userEmail, email);
        page.fill(currentAddress, address);
        page.fill(permanentAddress, permanentA);
    }

    public void clickOnSubmitButton(){
        page.click(submitButton);
    }


}
