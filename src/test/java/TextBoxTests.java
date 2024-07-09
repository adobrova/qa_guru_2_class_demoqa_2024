import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://demoqa.com";

        // перед коммитом удалить/закомментировать/поменять на false
        // при удалённом запуске тестов - браузер останется висеть открытым и будет занимать ресурсы
        //Configuration.holdBrowserOpen = true;
    }


    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        //после открытия страницы скрываем рекламу и футер
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //заполняем таблицу
        $("#firstName").setValue("Albina");
        $("#lastName").setValue("Dobrova");
        $("#userEmail").setValue("rezolventa86@rambler.ru");
        $("label[for=gender-radio-2]").click();                //здесь выбор пола
        $("#userNumber").setValue("9872552206");


     // нижеописанный метод рабочий, но на странице баг и при очищении поля календаря
     // возникает белый экране
     // здесь поле очищаем
     //   $("#dateOfBirthInput").sendKeys(Keys.CONTROL + "A");
     //   $("#dateOfBirthInput").sendKeys(Keys.BACK_SPACE);
     // а здесь ставим свое значение
     //   $("#dateOfBirthInput").sendKeys(Keys."02 Jan 1986");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1986");
        $(".react-datepicker__day--002").click();


         $("#subjectsInput").setValue("Comp").pressEnter();
        $("label[for=hobbies-checkbox-1]").click();  //здесь выбор хобби
        $("label[for=hobbies-checkbox-2]").click();

        $("#uploadPicture").uploadFromClasspath("cat.jpg");
        $("#currentAddress").setValue("Ufa, Russia");

        $("#state").click();
        $("#state").$(byText("NCR")).click();

        $("#city").click();
        $("#city").$(byText("Delhi")).click();





      //  $("#city").setValue("Del").pressEnter();        //выбор города в выбранном штате в индии

        $("#submit").click();

        //проверка на все заполненные поля в финальной таблице
        //проверим, что полей всего 10
        $$("[class~=table] tbody tr").shouldHave(size(10));

        //проверка на все заполненные поля в финальной таблице
        $(byText("Albina Dobrova")).shouldBe(visible);
        $(byText("rezolventa86@rambler.ru")).shouldBe(visible);
        $(byText("Female")).shouldBe(visible);
        $(byText("9872552206")).shouldBe(visible);
        $(byText("02 January,1986")).shouldBe(visible);
        $(byText("Computer Science")).shouldBe(visible);
        $(byText("Sports, Reading")).shouldBe(visible);
        $(byText("cat.jpg")).shouldBe(visible);
        $(byText("Ufa, Russia")).shouldBe(visible);
        $(byText("NCR Delhi")).shouldBe(visible);






    }


}
