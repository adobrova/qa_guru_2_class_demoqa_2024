import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQAJUnitTest {

    @BeforeAll
    static void BeforeAll() {
        System.out.println("###       before all\n");
    }


    @BeforeEach
    void BeforeEach() {
        System.out.println("###       before each");
    }

    @Test
    void successfulSearchTest() {
        System.out.println("###       first circle");
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }

    @Test
    void successfulSearchTest2() {
        System.out.println("###       second circle");
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }

    @Test
    void successfulSearchTest3() {
        System.out.println("###       third circle");
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }
}
