package bbc1.pagefactory;

import org.junit.Assert;
import org.junit.Test;

public class NewsLinesTests extends BaseTest{
    private static final int TIME_TO_WAIT = 30;
    private static final String EXPECTED_HEADLINE = "Anxious wait for news after tsunami cuts off Tonga";
    private static final String EXPECTED_TEXT_OF_SEARCH_BY_CATEGORY = "At The Edge of Asia";

    @Test
    public void checkHeadLineText(){
        getHomePage().clickNewsButton();
        getNewsPage().waitForPageLoad(TIME_TO_WAIT);
        getNewsPage().waitVisibilityOfElement(getNewsPage().getCloseSignInMessageButton(), TIME_TO_WAIT);
        getNewsPage().clickCloseSignInMessageButton();
        Assert.assertEquals(getNewsPage().getHeadLineText(),EXPECTED_HEADLINE);
    }

    @Test
    public void checkLinesText(){
        getHomePage().clickNewsButton();
        getNewsPage().waitForPageLoad(TIME_TO_WAIT);
        getNewsPage().waitVisibilityOfElement(getNewsPage().getCloseSignInMessageButton(), TIME_TO_WAIT);
        getNewsPage().clickCloseSignInMessageButton();
        for(int i = 0; i < getNewsPage().getLines().size();i++){
            Assert.assertEquals(getNewsPage().getLines().get(i).getText(),getNewsPage().getExpectedLinesForCheck().get(i));
        }
    }

    @Test
    public void checkSearchByCategoryOfHeadline(){
        getHomePage().clickNewsButton();
        getNewsPage().waitForPageLoad(TIME_TO_WAIT);
        getNewsPage().waitVisibilityOfElement(getNewsPage().getCloseSignInMessageButton(), TIME_TO_WAIT);
        getNewsPage().clickCloseSignInMessageButton();
        getNewsPage().fillSearchField(getNewsPage().getTextOfHeadlineCategory());
        Assert.assertEquals(getSearchResultsPage().getFirstSearchedLineText(), EXPECTED_TEXT_OF_SEARCH_BY_CATEGORY);
    }

}
