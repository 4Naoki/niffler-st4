package guru.qa.niffler.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import guru.qa.niffler.jupiter.GenerateCategory;
import guru.qa.niffler.jupiter.GenerateSpend;
import guru.qa.niffler.model.CurrencyValues;
import guru.qa.niffler.model.SpendJson;
import guru.qa.niffler.pages.WelcomePage;
import org.junit.jupiter.api.Test;

public class SpendingTest {

    static {
        Configuration.browserSize = "1980x1024";
    }

    private final WelcomePage welcomePage = new WelcomePage();
    private static final String WELCOME_PAGE_URL = "http://127.0.0.1:3000/main";

    @GenerateCategory(
            username = "duck",
            description = "Обучение"
    )
    @GenerateSpend(
            username = "duck",
            description = "QA.GURU Advanced 4",
            amount = 72500.00,
            category = "Обучение",
            currency = CurrencyValues.RUB
    )
    @Test
    void spendingShouldBeDeletedByButtonDeleteSpending(SpendJson spend) {
        Selenide.open(WELCOME_PAGE_URL);

        welcomePage
                .openLoginPage()
                .loginByUser("duck", "12345")
                .clickFirstElementInTable(spend.description())
                .deleteSelectedElements()
                .spendingsTableShouldBeEmpty();
    }
}
