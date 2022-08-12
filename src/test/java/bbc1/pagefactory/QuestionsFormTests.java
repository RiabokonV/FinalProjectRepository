package bbc1.pagefactory;

import org.junit.Assert;
import org.junit.Test;

public class QuestionsFormTests extends BaseTest {
    private static final int TIME_TO_WAIT = 30;

    @Test
    public void checkInvalidQuestionText() {
        getHomePage().clickNewsButton();
        getNewsPage().waitForPageLoad(TIME_TO_WAIT);
        getNewsPage().waitVisibilityOfElement(getNewsPage().getCloseSignInMessageButton(), TIME_TO_WAIT);
        getNewsPage().clickCloseSignInMessageButton();
        getNewsPage().clickCoronavirusButton();
        getNewsPage().clickYourCoronavirusStoryButton();
        getNewsPage().clickQuestionsButton();
//        getQuestionsPage().clickSubmitButton();
        getQuestionsPage().waitVisibilityOfElement(getQuestionsPage().getErrorQuestionMessage(), TIME_TO_WAIT);
        Assert.assertTrue(getQuestionsPage().getErrorQuestionMessage().isDisplayed());
    }

    @Test
    public void checkInvalidNameText() {
        getHomePage().clickNewsButton();
        getNewsPage().waitForPageLoad(TIME_TO_WAIT);
        getNewsPage().waitVisibilityOfElement(getNewsPage().getCloseSignInMessageButton(), TIME_TO_WAIT);
        getNewsPage().clickCloseSignInMessageButton();
        getNewsPage().clickCoronavirusButton();
        getNewsPage().clickYourCoronavirusStoryButton();
        getNewsPage().clickQuestionsButton();
        getQuestionsPage().waitForPageLoad(TIME_TO_WAIT);
//        getForm().fillForm(getQuestionsPage().getMap());
        getQuestionsPage().waitVisibilityOfElement(getQuestionsPage().getErrorNameMessage(), TIME_TO_WAIT);
        Assert.assertTrue(getQuestionsPage().getErrorNameMessage().isDisplayed());
    }

    @Test
    public void checkInvalidEmailText() {
        getHomePage().clickNewsButton();
        getNewsPage().waitForPageLoad(TIME_TO_WAIT);
        getNewsPage().waitVisibilityOfElement(getNewsPage().getCloseSignInMessageButton(), TIME_TO_WAIT);
        getNewsPage().clickCloseSignInMessageButton();
        getNewsPage().clickCoronavirusButton();
        getNewsPage().clickYourCoronavirusStoryButton();
        getNewsPage().clickQuestionsButton();
        getQuestionsPage().waitForPageLoad(TIME_TO_WAIT);
//        getForm().fillForm(getQuestionsPage().getMap());
        getQuestionsPage().waitVisibilityOfElement(getQuestionsPage().getErrorEmailMessage(), TIME_TO_WAIT);
        Assert.assertTrue(getQuestionsPage().getErrorEmailMessage().isDisplayed());
    }
}
