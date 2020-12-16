import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class YandexMarketTests {

    @Test
    void selenideSearchTest(){
        //открыть яндекс 321
        open("https://yandex.ru");
        //Кликнуть на «Маркет»
        $("a[data-id='market']").click();
        //переход на соседнюю вкладку
        switchTo().window(1);
        //В поле поиска ввести «ноутбуки»
        $("#header-search").setValue("ноутбуки");
        //Проверить что поле поиска содержит «ноутбуки»
        $("#header-search").shouldHave(Condition.value("ноутбуки"));
        //Нажать «Найти»
        $("button[type='submit']").click();
        //Проверяем что нашлись ноутбуки
        $("div[data-apiary-widget-name='@MarketNode/SearchHeadline']").shouldHave(Condition.text("Ноутбуки"));
    }

}
