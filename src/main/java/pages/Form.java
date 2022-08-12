package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class Form extends QuestionsPage{
    public Form (WebDriver driver){
        super(driver);
    }

//    public void fillForm(HashMap<String,String> map){
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            getDriver().findElement(By.xpath(getFormXpath()+entry.getKey()+"]")).sendKeys(entry.getValue());
//        }
//        clickSubmitButton();
//    }
}
