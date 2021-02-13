package com.github;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.steps.BaseSteps;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class GithubIssueWithMethodStepsTest {

    public BaseSteps steps = new BaseSteps();

    private static final String REPOSITORY = "ArinaSaara/qa-guru-hw";
    private static final String ISSUE_NUMBER = "#1";


    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepositoryFromSearch(REPOSITORY);
        steps.openRepositoryIssues();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
