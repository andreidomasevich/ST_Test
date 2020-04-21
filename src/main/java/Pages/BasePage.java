package Pages;

import com.codeborne.selenide.Selenide;

// Демонстрация PageObject Pattern
class BasePage {

    void wait(int seconds){
        Selenide.sleep(seconds * 1000);

    }
}
