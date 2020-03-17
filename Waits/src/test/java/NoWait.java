import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NoWait {
    @Test
    public void testImplicitWait() {
        //set browser properties
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        try {
            WebElement enterAnyText = driver.findElement(By.name("q"));
            enterAnyText.sendKeys("Selenium");
            enterAnyText.submit();
            Assert.assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
        } catch (NoSuchElementException e) {
            // If there is not enough time to fo find all elements in DOM the test will fail with this exception and message.
            System.out.println("Element Not Found");
        } finally {
            driver.quit();
        }
    }
}
