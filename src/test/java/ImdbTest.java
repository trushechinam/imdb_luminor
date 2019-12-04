import org.junit.Test;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ImdbTest {

    @Test
    public void openImtb() {
        DateFormat dateFormat = new SimpleDateFormat("ddmmyyyyhms");
        Date date = new Date();
        open("https://www.imdb.com/");
        $(By.id("suggestion-search")).setValue("games of thrones");
        $(By.id("suggestion-search-button")).click();
        $(By.linkText("Video Game")).click();
        $(By.id("findSubHeaderLabel")).shouldHave(text("Search category:"));
        $(By.id("findSubHeader")).shouldHave(text("Video Game Titles"));
        $$(By.xpath("//table[contains(@class, 'findList')]/tbody/tr")).shouldHave(size(3));
        screenshot("myScreenshot" + dateFormat.format(date));
    }
}
