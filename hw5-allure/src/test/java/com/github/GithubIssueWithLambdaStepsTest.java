package com.github;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class GithubIssueWithLambdaStepsTest {
    private static final String REPOSITORY = "ArinaSaara/qa-guru-hw";
    private static final String ISSUES = "Issues";
    private static final String ISSUE_NUMBER = "#1";
    private static final String BASE_URL = "https://github.com/";

    @Test
    @Owner("Arina")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("web"), @Tag("critical")})
    @Link(name = "Base url", value = BASE_URL)

    @Feature("Issues")
    @Story("Search Issue")
    @DisplayName("Search Issue by number of repo")
    public void testIssueSearch() {
        parameter("Repository", REPOSITORY);
        parameter("Issue Number", ISSUE_NUMBER);
        step("Open main page", () -> {
            open(BASE_URL);
        });

        step("Search for repository: " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Go to the repository: " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Go to the " + ISSUES + " section", () -> {
            $(withText(ISSUES)).click();
        });

        step("Check that Issue with the number " + ISSUE_NUMBER + " exists", () -> {
            $(withText(ISSUE_NUMBER)).should(exist);
        });
    }
}
