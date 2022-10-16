package guru.qa.fileops;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideTest {
    @Test
    void downloadTest() throws Exception {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File file = $("#raw-url").download();
        try (InputStream is = new FileInputStream(file)){
            byte[] fileContent =  is.readAllBytes();
            assertThat(new String(fileContent, UTF_8)).contains("This repository is the home of the next generation of JUnit, _JUnit 5_.");
        }

    }

    @Test
    void uploadTest(){
        open("https://the-internet.herokuapp.com/upload");
        $("input[type='file'").uploadFromClasspath("files/1.txt");
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(text("1.txt"));
    }
}
