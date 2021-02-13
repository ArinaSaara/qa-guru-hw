package com.github.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class BaseSteps {

    private static final String BASE_URL = "https://github.com/";

    @Step("Open main page")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Search for {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repo);
        $(".header-search-input").submit();
    }

    @Step("Go to the {repo}")
    public void goToRepositoryFromSearch(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Go to the Issues section")
    public void openRepositoryIssues() {
        $(withText("Issues")).click();
    }

    @Step("Check that Issue with the number {number} exists")
    public void shouldSeeIssueWithNumber(String number) {
        $(withText(number)).should(exist);
    }
}
