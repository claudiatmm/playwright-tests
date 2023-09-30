package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class DropdownPage {

    Page page;

    String oldSelectMenu = "id=oldSelectMenu";


    public DropdownPage(Page page) {
        this.page = page;
    }

    public void userSelectValueFromDropdown(String number){
        page.selectOption(oldSelectMenu, number);
//        Assert.assertEquals(number, value);
        Locator value = page.locator(oldSelectMenu);
        assertThat(value).containsText("Green");

    }



}
