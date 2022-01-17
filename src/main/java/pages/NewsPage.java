package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class NewsPage extends BasePage {
    public NewsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='gs-c-promo-body gs-u-display-none gs-u-display-inline-block@m gs-u-mt@xs gs-u-mt0@m gel-1/3@m']/div/a/h3")
    private WebElement headLine; //Ash-covered Tonga is like a moonscape say residents

    @FindBy(xpath = "//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-pica-bold nw-o-link-split__anchor']/h3")
    private List<WebElement> lines;

    @FindBy(xpath = "//div[@class='gs-c-promo-body gs-u-display-none gs-u-display-inline-block@m gs-u-mt@xs gs-u-mt0@m gel-1/3@m']/ul/li/a/span")
    private WebElement categoryOfHeadline;

    @FindBy(xpath = "//div[@class='orb-nav-section orb-nav-search']/form/div/input[@id='orb-search-q']")
    private WebElement searchField;

    @FindBy(xpath = "//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']/a[@href='/news/coronavirus']")
    private WebElement coronavirusButton;

    @FindBy(xpath = "//div[@class='tp-iframe-wrapper tp-active']/button[@class='tp-close tp-active']")
    private WebElement closeSignInMessageButton;

    @FindBy(xpath = "//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']/a[@href='/news/have_your_say']")
    private WebElement yourCoronavirusStoryButton;

    @FindBy(xpath = "//div[@class='gs-c-promo-body gs-u-mt@xxs gs-u-mt@m gs-u-mt@m gel-1/2@xs gel-1/1@m gs-c-promo-body--flex']/div/a[@href='/news/52143212']")
    private WebElement questionsButton;

    private List<String> expectedLinesForCheck = lines.stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());

    public WebElement getQuestionsButton() {
        return questionsButton;
    }

    public void fillSearchField(String textToSearch) {
        searchField.sendKeys(textToSearch, Keys.RETURN);
    }

    public void clickQuestionsButton() {
        questionsButton.click();
    }

    public void clickYourCoronavirusStoryButton() {
        yourCoronavirusStoryButton.click();
    }

    public WebElement getCloseSignInMessageButton() {
        return closeSignInMessageButton;
    }

    public void clickCloseSignInMessageButton() {
        closeSignInMessageButton.click();
    }

    public void clickCoronavirusButton() {
        coronavirusButton.click();
    }

    public String getTextOfHeadlineCategory() {
        return categoryOfHeadline.getText();
    }

    public String getHeadLineText() {
        return headLine.getText();
    }

    public List<WebElement> getLines() {
        return lines;
    }

    public List<String> getExpectedLinesForCheck() {
        return expectedLinesForCheck;
    }

}
