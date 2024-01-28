package guru.qa.niffler.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement table = $(".spendings-table tbody");
    private final SelenideElement deleteButton = $(byText("Delete selected"));

    @Step("Выбираем первый элемент в таблице расходов")
    public MainPage clickFirstElementInTable(String description) {
        table.$$("tr")
                .find(text(description))
                .$$("td")
                .first()
                .scrollTo()
                .click();

        return this;
    }

    @Step("Удаляем выбранные элементы")
    public MainPage deleteSelectedElements() {
        deleteButton.click();

        return this;
    }

    @Step("Проверяем, что таблица расходов пустая")
    public MainPage spendingsTableShouldBeEmpty() {
        table.$$("tr")
                .shouldHave(size(0));

        return this;
    }
}
