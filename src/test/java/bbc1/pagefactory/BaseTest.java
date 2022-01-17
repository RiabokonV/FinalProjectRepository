package bbc1.pagefactory;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    private WebDriver driver;
    private static final String BBC_URL = "https://www.bbc.com/";

    @Before
    public void testSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BBC_URL);
    }

    @After
    public void windowClose() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }
    public Form getForm(){return new Form(getDriver());}
    public HomePage getHomePage(){
        return new HomePage(getDriver());
    }
    public NewsPage getNewsPage(){
        return new NewsPage(getDriver());
    }
    public QuestionsPage getQuestionsPage(){
        return new QuestionsPage(getDriver());
    }
    public SearchResultsPage getSearchResultsPage(){
        return new SearchResultsPage(getDriver());
    }
}
