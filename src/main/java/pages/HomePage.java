package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class='orb-nav-newsdotcom']/a[@href='https://www.bbc.com/news']")
    private WebElement newsButton;

    public void openHomePage(String url) {
        getDriver().get(url);
    }

    public void clickNewsButton() {
        newsButton.click();
    }
}
