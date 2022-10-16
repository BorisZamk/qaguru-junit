package guru.qa.fileops;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FileParseTest {

    @Test
    void pdfTest() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        $("a[href*='junit-user-guide-5.9.1.pdf']").download();

    }

    @Test
    void xlsTest(){

    }

    @Test
    void csvTest(){

    }

    @Test
    void zipTest(){

    }

    @Test
    void jsonTest(){

    }

}
