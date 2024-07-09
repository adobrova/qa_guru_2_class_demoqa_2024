import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void fillFormTest() {
        System.out.println("###       first circle");
        open("/automation-practice-form");
        $("#firstName").setValue("Albina");
        $("#lastName").setValue("Dobrova");
        $("#userEmail").setValue("rezolventa86@rambler.ru");

        //   $("[name=q]").setValue("selenide");

        $("#userNumber").setValue("9872552206");
        //  $("#dateOfBirthInput").setValue("selenide");

        //    $("[name=q]").setValue("selenide");
        //    $("[name=q]").setValue("selenide");

        //    $("#uploadPicture").setValue("selenide");
        $("#currentAddress").setValue("Ufa, Russia");

        //   $("[name=q]").setValue("selenide");
        //   $("[name=q]").setValue("selenide");

        $("#submit").click();

        $("Student Name").shouldHave(text("Albina Dobrova"));
        $("Student Email").shouldHave(text("rezolventa86@rambler.ru"));
        $("Gender").shouldHave(text("Female"));
        $("Mobile").shouldHave(text("9872552206"));
        $("Date of Birth").shouldHave(text("02 January,1986"));
        $("Subjects").shouldHave(text("qa automation"));
        $("Hobbies").shouldHave(text("Sports, Reading"));
        $("Picture").shouldHave(text("cat.jpg"));
        $("Address").shouldHave(text("Ufa, Russia"));
        $("State and City").shouldHave(text("NCR Delhi"));
    }


}
