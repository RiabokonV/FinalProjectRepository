package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    private WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public NewsPage getNewsPage() {
        return new NewsPage(driver);
    }

    public QuestionsPage getQuestionsPage() {
        return new QuestionsPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }
    public Form getForm(){
        return new Form(driver);
    }
}
