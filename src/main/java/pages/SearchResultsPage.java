package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage{
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[@class='ssrcss-dirbxo-PromoSwitchLayoutAtBreakpoints e3z3r3u0']/div/div/a/span/p/span)[1]")
    private WebElement firstSearchedLine;

    public WebElement getFirstSearchedLine() {
        return firstSearchedLine;
    }

    public String getFirstSearchedLineText(){
       return firstSearchedLine.getText();
    } //At The Edge of Asia

}
