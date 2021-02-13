package com.github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GithubIssueTest {

    private static final String REPOSITORY = "t0kke/PracticeInDemoQA";
    private static final String ISSUE_NAME = "Test Issue";

    @Test
    public void testIssueSearch() {
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").setValue(REPOSITORY);

        $(".header-search-input").submit();
        $(linkText(REPOSITORY)).click();
        $(withText("Issues")).click();
        $(withText(ISSUE_NAME)).should(exist);

    }
}
