import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
    @Test
    public void testExplicitWaitByTitle(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("selenium");
        query.submit();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("selenium");
            }});

        Assert.assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));

        driver.quit();
    }
    @Test
    public void explicitWaitTitleContains() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        //Enter a term to search and submit
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("selenium");
        query.submit();
        //Create Wait using WebDriverWait.
        //This will wait for 10 seconds for timeout before title is updated with search term
        //If title is updated in specified time limit test will move to the text step
        //instead of waiting for 10 seconds
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("selenium"));

        //Verify Title
        Assert.assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));

        driver.quit();
    }

}

