package page;

import com.microsoft.playwright.Page;


public class YouTubePage {

    Page page;

    String cookiesButton ="//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-renderer[2]/yt-button-shape/button/yt-touch-feedback-shape/div";
    String searchBox = "Search";
    String searchButton = "//*[@id=\"video-title\"]";


    public YouTubePage(Page page) {
        this.page = page;
    }


    public void userClickOnDialog() throws InterruptedException {
        page.waitForTimeout(1000);
        page.locator(cookiesButton).click();
        System.out.println("click on cookies button");
        page.waitForTimeout(1000);
    }

    public void userTypeValueOnSearchBox(String text){
        page.getByPlaceholder(searchBox).fill(text);
    }

    public void userClickOnSearchButton() throws InterruptedException {
      page.keyboard().press("Enter");
    }


    public  void clickOnSecondPage(){
     page.locator(searchButton).nth(1).click();
     page.waitForTimeout(10000);
     page.click("video");
     page.waitForTimeout(10000);
    }


}
