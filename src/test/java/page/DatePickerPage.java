package page;

import com.microsoft.playwright.Page;
import io.cucumber.datatable.internal.difflib.StringUtills;
import org.apache.commons.text.StringEscapeUtils;

import java.time.Month;
import java.util.Locale;

import static org.junit.Assert.assertEquals;


public class DatePickerPage {

    Page page;

    String datepicker1 = "id=datepicker1";
    String month = "//*[@id=\"ui-datepicker-div\"]/div/div/span[1]";
    String year = "//*[@id=\"ui-datepicker-div\"]/div/div/span[2]";
    String prevButton = "Prev";
    String nextButton = "Next";
    String datepickerTitle = "//*[@id=\"ui-datepicker-div\"]/div/div";


    public DatePickerPage(Page page) {
        this.page = page;
    }

    public void userClickOnDatePickerField() throws InterruptedException {
        page.locator(datepicker1).click();
    }


    public DatePickerPage selectDateAndYear(String monthInputAtString, int yearInput) throws InterruptedException {
        String currentMonthAtString = page.locator(month).textContent();
        int currentYear = Integer.parseInt(page.locator(year).textContent());

        Thread.sleep(1000);

        while (!(currentMonthAtString.equals(monthInputAtString) && currentYear == yearInput)) {
            if (yearInput > currentYear) {
                page.getByText(nextButton).click();
            }
            if (yearInput < currentYear) {
                page.getByText(prevButton).click();
            }

            if (yearInput == currentYear) {
                Month targetMonth = Month.valueOf(monthInputAtString.toUpperCase(Locale.ROOT));
                Month currentMonth = Month.valueOf(currentMonthAtString.toUpperCase(Locale.ROOT));
                int r = targetMonth.compareTo(currentMonth);
                if (r > 0) {
                    page.getByText(nextButton).click();
                }

                if (r < 0) {
                    page.getByText(prevButton).click();
                }
            }
            Thread.sleep(1000);

            currentMonthAtString = page.locator(month).textContent();
            currentYear = Integer.parseInt(page.locator(year).textContent());
        }

//        String escapedHTML = StringEscapeUtils.unescapeHtml4(page.locator(datepickerTitle).textContent()); ? decodare html
//        assertEquals((monthInputAtString +" " +yearInput), escapedHTML);
        return this;
    }


    public DatePickerPage selectDay(int day) {
        String xPathWithVariable = null;
        for (int i = 1; i <= day; i++) {
            xPathWithVariable = "//td[@data-handler='selectDay']/a[text()=" + "'" + i + "'" + "]";
        }
        page.locator(xPathWithVariable).click();
        assertEquals(String.valueOf(day), page.locator(xPathWithVariable).textContent());
        return this;
    }

}
