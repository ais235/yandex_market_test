import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class YandexMarketTests {


    @Test
    @DisplayName("Тест на поиск ")
    public void selenideSearchTest() {
        step("Открываем главную страницу яндекса", () -> {
            open("https://yandex.ru");
        });

        step("Переходим в яндекс «Маркет»", () -> {
            $("a[data-id='market']").click();
        });

        step("Переход на соседнюю вкладку", () -> {
            switchTo().window(1);
        });

        step("Выбираем раздел Компьютеры", () -> {
            $$("[role='tablist'] span").findBy(text("Компьютеры")).click();
        });

        step("Выбираем раздел Ноутбуки", () -> {
//            $$("div[data-apiary-widget-name='@MarketNode/NavigationTree'] a").findBy(linkText("Ноутбуки")).click();
            $(By.linkText("Ноутбуки")).click();
        });

        step("Выбираем цену от до", () -> {
            $("input[name='Цена от']").setValue("10000");
            $("input[name='Цена до']").setValue("30000");
        });

        step("Выбрать производителя HP и Lenovo", () -> {
            $x("//fieldset//span[contains(text(),'HP')]").click();
            $x("//fieldset//span[contains(text(),'Lenovo')]").click();
        });
    }
}