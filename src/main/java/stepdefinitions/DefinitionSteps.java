package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.DataTable;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.List;
import java.util.stream.Collectors;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {
    private WebDriver driver;
    private HomePage homePage;
    private NewsPage newsPage;
    private QuestionsPage questionsPage;
    private SearchResultsPage searchResultsPage;
    private PageFactoryManager pageFactoryManager;
    private Form form;

    private static final int TIME_TO_WAIT = 30;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @When("User click on news button")
    public void userClickOnNewsButton() {
        homePage.clickNewsButton();
        newsPage = pageFactoryManager.getNewsPage();
    }

    @Then("User check correct {string} at Headline")
    public void userCheckCorrectTextAtHeadline(String text) {
        newsPage.waitForPageLoad(TIME_TO_WAIT);
        Assert.assertEquals(text, newsPage.getHeadLineText());
    }

    @And("User check correct text of lines")
    public void userCheckCorrectTextOfLines() {
        newsPage.waitForPageLoad(TIME_TO_WAIT);
        List<String> expectedTextOfLine = newsPage.getLines().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        for (int i = 0; i < newsPage.getLines().size(); i++) {
            Assert.assertEquals(newsPage.getLines().get(i).getText(), expectedTextOfLine.get(i));
        }
    }

    @And("User close signInMessage")
    public void userCloseSignInMessage() {
        newsPage.waitVisibilityOfElement(newsPage.getCloseSignInMessageButton(), TIME_TO_WAIT);
        newsPage.clickCloseSignInMessageButton();
    }

    @And("User make search by category of headline")
    public void userMakeSearchByCategoryOfHeadline() {
        newsPage.waitForPageLoad(TIME_TO_WAIT);
        newsPage.fillSearchField(newsPage.getTextOfHeadlineCategory());
    }

    @Then("User check correct {string} of first line")
    public void userCheckCorrectTextOfFirstLine(String text) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitVisibilityOfElement(searchResultsPage.getFirstSearchedLine(), TIME_TO_WAIT);
        Assert.assertEquals(searchResultsPage.getFirstSearchedLineText(), text);
    }

    @And("User click on coronavirus button")
    public void userClickOnCoronavirusButton() {
        newsPage.clickCoronavirusButton();
    }

    @And("User click on yourStories button")
    public void userClickOnYourStoriesButton() {
        newsPage.waitForPageLoad(TIME_TO_WAIT);
        newsPage.clickYourCoronavirusStoryButton();
    }

    @And("User click on question button")
    public void userClickOnQuestionButton() {
        newsPage.waitVisibilityOfElement(newsPage.getQuestionsButton(), TIME_TO_WAIT);
        newsPage.clickQuestionsButton();
    }

    @Then("User see question error message")
    public void userSeeQuestionErrorMessage() {
        questionsPage.waitForPageLoad(TIME_TO_WAIT);
        questionsPage.waitVisibilityOfElement(questionsPage.getErrorQuestionMessage(), TIME_TO_WAIT);
        Assert.assertTrue(questionsPage.getErrorQuestionMessage().isDisplayed());
    }

    @Then("User see name error message")
    public void userSeeNameErrorMessage() {
        questionsPage.waitVisibilityOfElement(questionsPage.getErrorNameMessage(), TIME_TO_WAIT);
        Assert.assertTrue(questionsPage.getErrorNameMessage().isDisplayed());
    }

    @Then("User see email error message")
    public void userSeeEmailErrorMessage() {
        questionsPage.waitVisibilityOfElement(questionsPage.getErrorEmailMessage(), TIME_TO_WAIT);
        Assert.assertTrue(questionsPage.getErrorEmailMessage().isDisplayed());
    }

    @And("User send incorrect values to form")
    public void userSendIncorrectValuesToForm() {
        questionsPage = pageFactoryManager.getQuestionsPage();
        form = pageFactoryManager.getForm();
        form.fillForm(questionsPage.getMap());
    }
}
