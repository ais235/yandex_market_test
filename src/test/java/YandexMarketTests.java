import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class YandexMarketTests {

    @Test
    public void selenideSearchTest(){
        step("Открываем главную страницу яндекса", () -> {
            open("https://yandex.ru");
        });

        step("Переходим в яндекс «Маркет»", () -> {
            $("a[data-id='market']").click();
        });

        step("переход на соседнюю вкладку", () -> {
            switchTo().window(1);
        });

        step("В поле поиска ввести «ноутбуки»", () -> {
            $("#header-search").setValue("ноутбуки");
        });

        step("Проверить что поле поиска содержит «ноутбуки»", () -> {
            $("#header-search").shouldHave(Condition.value("ноутбуки"));
        });

        step("Нажать «Найти»", () -> {
            $("button[type='submit']").click();
        });
        step("Проверяем что нашлись ноутбуки", () -> {
            $("div[data-apiary-widget-name='@MarketNode/SearchHeadline']").shouldHave(Condition.text("Ноутбуки"));
        });
    }

}
