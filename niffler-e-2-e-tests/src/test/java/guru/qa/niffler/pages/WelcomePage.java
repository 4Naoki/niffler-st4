package guru.qa.niffler.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class WelcomePage {

    private final SelenideElement loginButton = $("a[href*='redirect']");

    @Step("Открываем страницу логина")
    public LoginPage openLoginPage() {
        loginButton.click();

        return new LoginPage();
    }
}
