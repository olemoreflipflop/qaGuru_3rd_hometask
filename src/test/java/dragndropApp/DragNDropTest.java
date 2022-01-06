package dragndropApp;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DragNDropTest {

    @Test
    void checkSquaresDraggable() {
        // Открыть https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Перенести прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));
        //check: прямоугольники действительно поменялись
        $("#column-a").$("header").shouldHave(text("B"));
        $("#column-b").$("header").shouldHave(text("A"));
    }
}
