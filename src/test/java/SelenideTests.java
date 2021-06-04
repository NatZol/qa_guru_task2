import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SelenideTests {

    @BeforeEach
    void config() {
        Configuration.startMaximized = true;
    }

    @Test
    void findSelenide() {
        open("https://github.com");

        $("[name=q]").setValue("selenide").pressEnter();
        $("a[href='/selenide/selenide']").click();
        $("a[href='/selenide/selenide/wiki']").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(byText("SoftAssertions")).click();

        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));

    }

    @Test
    void dragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").dragAndDropTo("#column-b");
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }
}
