package bbc1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;

public class Part1 {
    private WebDriver driver;

    @Before
    public void testSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com/");
    }

    @Test
    public void checkTheNameOfHeadline() {
        driver.findElement(By.xpath("//div[@class='orb-nav-section orb-nav-links orb-nav-focus']/ul/li[@class='orb-nav-newsdotcom']/a[@href='https://www.bbc.com/news']"))
                .click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String headLine = driver.findElement(By.xpath("//div[@class='gs-c-promo-body gs-u-display-none gs-u-display-inline-block@m gs-u-mt@xs gs-u-mt0@m gel-1/3@m']/div/a/h3")).getText();
        String expectedHeadLine = "Uproar as Macron vows to 'piss off'";
        assertEquals(expectedHeadLine, headLine);
    }

    @Test
    public void checkTheNameOfSecondaryLines() {
        driver.findElement(By.xpath("//div[@class='orb-nav-section orb-nav-links orb-nav-focus']/ul/li[@class='orb-nav-newsdotcom']/a[@href='https://www.bbc.com/news']"))
                .click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> lines = driver.findElements(By.xpath("//a[@class='gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-pica-bold nw-o-link-split__anchor']/h3"));
        List<String> textOfLines = lines.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        for (int i = 0; i < lines.size(); i++) {
            assertEquals(textOfLines.get(i), lines.get(i).getText());
        }
    }

    @Test
    public void checkSearchFromHeadlineCategory() {
        driver.findElement(By.xpath("//div[@class='orb-nav-section orb-nav-links orb-nav-focus']/ul/li[@class='orb-nav-newsdotcom']/a[@href='https://www.bbc.com/news']"))
                .click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String searchedText = driver.findElement(By.xpath("//div[@class='gs-c-promo-body gs-u-display-none gs-u-display-inline-block@m gs-u-mt@xs gs-u-mt0@m gel-1/3@m']/ul/li/a/span"))
                .getText();
        driver.findElement(By.xpath("//div[@class='orb-nav-section orb-nav-search']/form/div/input[@id='orb-search-q']"))
                .sendKeys(searchedText);
        driver.findElement(By.xpath("//div[@class='orb-nav-section orb-nav-search']/form/div/input[@id='orb-search-q']"))
                .sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String expectedText = "Australia: Earth's Magical Kingdom";
        assertEquals(driver.findElement(By.xpath("(//div[@class='ssrcss-dirbxo-PromoSwitchLayoutAtBreakpoints e3z3r3u0']/div/div/a/span/p/span)[1]")).getText(), expectedText);
    }

    @After
    public void windowClose() {
        driver.close();
    }
}
