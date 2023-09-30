//package org.example;
//
//import com.microsoft.playwright.*;
//
//public class App {
//    public static void main(String[] args) {
//        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
////                    .setChannel("msedge")
//            );
//            Page page = browser.newPage();
//            page.navigate("https://demoqa.com/text-box");
//            System.out.println(page.title());
//            page.locator("id=userName").fill("Clau");
//            page.locator("id=userEmail").fill("tt");
//            page.locator("id=currentAddress").fill("adress 123A");
//            page.locator("id=permanentAddress").fill("permanent Address Test");
//            page.locator("id=submit").click();
//
//            page.close();
//            browser.close();
//            playwright.close();
//        }
//    }
//}
