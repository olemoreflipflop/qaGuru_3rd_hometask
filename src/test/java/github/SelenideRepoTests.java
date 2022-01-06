package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepoTests {

    //class example
    @Test
    void searchSelenideRepositoryOnGithub() {
        // открыть страницу github.com
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // нажимаем на линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click();
        // check: в заголовке встречается selenide/selenide
        $("h1").shouldHave(text("selenide / selenide"));
    }

    @Test
    void searchJUnitSnippetInSelenideRepository() {
        // Открыть репозиторий Selenide в Github
        open("https://github.com/selenide/selenide");
        // Перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        // Убедиться, что в списке страниц (Pages) есть страница SoftAssertions и перейти к ней
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(byLinkText("SoftAssertions")).click();
        // check: внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
