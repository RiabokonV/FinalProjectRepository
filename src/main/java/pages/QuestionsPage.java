package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class QuestionsPage extends BasePage {
    public QuestionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='button-container']/button")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='embed-content-container']/div[@class='long-text-input-container']/div[@class='input-error-message']")
    private WebElement errorQuestionMessage;

    @FindBy(xpath = "//div[@class='text-input--error']/div[@class='input-error-message']")
    private WebElement errorNameMessage;

    @FindBy(xpath = "//div[@class='text-input--error']/div[@class='input-error-message']")
    private WebElement errorEmailMessage;


    public WebElement getTextToForm (String text){
        return getDriver().findElement(By.xpath("//input[@placeholder='" + text+ "']"));
    }

    private HashMap<String,String> map = new HashMap<>();
    {
        map.put("What questions would you like us to answer?"," ");
        map.put("Name", "Aleg ");
        map.put("Email address", " ");
    }

//    public String getFormXpath() {
//        return formXpath;
//    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public WebElement getErrorEmailMessage() {
        return errorEmailMessage;
    }

    public WebElement getErrorNameMessage() {
        return errorNameMessage;
    }

    public WebElement getErrorQuestionMessage() {
        return errorQuestionMessage;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

}
