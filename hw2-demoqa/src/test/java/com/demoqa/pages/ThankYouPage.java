package com.demoqa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ThankYouPage {

    private final SelenideElement pageTitle = $(".modal-title");

    public void checkPageTitle(String text) {
        pageTitle.shouldHave(Condition.text(text));
    }

    public void verifyRowValue(String key, String value) {
        $x(String.format("//td[text()=\"%s\"]", key)).sibling(0).shouldHave(exactText(value));
    }
}
