package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebTest {

    @BeforeAll
    static void configure (){
//        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
//        Configuration.browserSize = "1920x1080";
//        Configuration.headless = true;
    }

    @ValueSource(strings = {"Selenide", "Allure"})
    @ParameterizedTest(name = "Результаты поиска не пустые для запроса {0} ")
     void simpleSearchTest(String testData) {
        open("https://ya.ru");
        $("#text").setValue(testData).pressEnter();
        $$("#search-result").shouldBe(sizeGreaterThan(0));
    }

    @CsvSource(value = {
            "Selenide, is a framework for writing easy-to-read and easy-to-maintain automated tests in Java.",
            "Allure java,  test frameworks. Contribute to  "
    })
    @ParameterizedTest(name = "The results of searching {0} contain {1}")
    void complexSearchTest(String testData, String expectedResult) {
        open("https://ya.ru");
        $("#text").setValue(testData).pressEnter();
        $$("#search-result").filter(text("github.com")).first().shouldHave(text(expectedResult));
    }
}
