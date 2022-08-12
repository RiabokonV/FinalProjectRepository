package bbc1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertNotNull;

public class Part2 {
    private WebDriver driver;

    @Before
    public void testSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bbc.com/");
    }

    @Test
    public void checkInvalidQuestionInfo() {
        driver.findElement(By.xpath("//div[@class='orb-nav-section orb-nav-links orb-nav-focus']/ul/li[@class='orb-nav-newsdotcom']/a[@href='https://www.bbc.com/news']"))
                .click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']/a[@href='/news/coronavirus']"))
                .click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tp-iframe-wrapper tp-active']/button[@class='tp-close tp-active']")));
        driver.findElement(By.xpath("//div[@class='tp-iframe-wrapper tp-active']/button[@class='tp-close tp-active']")).click();
        driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']/a[@href='/news/have_your_say']"))
                .click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='gs-c-promo-body gs-u-mt@xxs gs-u-mt@m gs-u-mt@m gel-1/2@xs gel-1/1@m gs-c-promo-body--flex']/div/a[@href='/news/52143212']"))
                .click();
        driver.findElement(By.xpath("//div[@class='embed-content-container']/div[@class='long-text-input-container']/textarea"))
                .sendKeys(Keys.SPACE);
        driver.findElement(By.xpath("//div[@class='embed-content-container']/div[@class='button-container']/button"))
                .click();
        assertNotNull(driver.findElement(By.xpath("//div[@class='embed-content-container']/div[@class='long-text-input-container']/div[@class='input-error-message']")));
    }

    @Test
    public void checkInvalidNameInfo() {
        driver.findElement(By.xpath("//div[@class='orb-nav-section orb-nav-links orb-nav-focus']/ul/li[@class='orb-nav-newsdotcom']/a[@href='https://www.bbc.com/news']"))
                .click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']/a[@href='/news/coronavirus']"))
                .click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tp-iframe-wrapper tp-active']/button[@class='tp-close tp-active']")));
        driver.findElement(By.xpath("//div[@class='tp-iframe-wrapper tp-active']/button[@class='tp-close tp-active']")).click();
        driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']/a[@href='/news/have_your_say']"))
                .click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='gs-c-promo-body gs-u-mt@xxs gs-u-mt@m gs-u-mt@m gel-1/2@xs gel-1/1@m gs-c-promo-body--flex']/div/a[@href='/news/52143212']"))
                .click();
        driver.findElement(By.xpath("//div[@class='text-input']/input[@placeholder='Name']"))
                .sendKeys(Keys.SPACE);
        driver.findElement(By.xpath("//div[@class='embed-content-container']/div[@class='button-container']/button"))
                .click();
        assertNotNull(driver.findElement(By.xpath("//div[@class='text-input--error']/div[@class='input-error-message']")));
    }

    @Test
    public void checkInvalidEmailInfo() {
        driver.findElement(By.xpath("//div[@class='orb-nav-section orb-nav-links orb-nav-focus']/ul/li[@class='orb-nav-newsdotcom']/a[@href='https://www.bbc.com/news']"))
                .click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']/a[@href='/news/coronavirus']"))
                .click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tp-iframe-wrapper tp-active']/button[@class='tp-close tp-active']")));
        driver.findElement(By.xpath("//div[@class='tp-iframe-wrapper tp-active']/button[@class='tp-close tp-active']")).click();
        driver.findElement(By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']/a[@href='/news/have_your_say']"))
                .click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='gs-c-promo-body gs-u-mt@xxs gs-u-mt@m gs-u-mt@m gel-1/2@xs gel-1/1@m gs-c-promo-body--flex']/div/a[@href='/news/52143212']"))
                .click();
        driver.findElement(By.xpath("//div[@class='text-input']/input[@placeholder='Email address']"))
                .sendKeys(Keys.SPACE);
        driver.findElement(By.xpath("//div[@class='embed-content-container']/div[@class='button-container']/button"))
                .click();
        assertNotNull(driver.findElement(By.xpath("//div[@class='text-input--error']/div[@class='input-error-message']")));
    }

    @After
    public void windowClose() {
        driver.close();
    }

}
