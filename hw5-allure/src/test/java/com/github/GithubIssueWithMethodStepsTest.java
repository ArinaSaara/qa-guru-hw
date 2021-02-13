package com.github;

import com.github.steps.BaseSteps;
import org.junit.jupiter.api.Test;

public class GithubIssueWithMethodStepsTest {

    public BaseSteps steps = new BaseSteps();

    private static final String REPOSITORY = "ArinaSaara/qa-guru-hw";
    private static final String ISSUE_NUMBER = "#1";


    @Test
    public void testIssueSearch() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepositoryFromSearch(REPOSITORY);
        steps.openRepositoryIssues();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
