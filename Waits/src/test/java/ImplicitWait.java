import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {


    @Test
    public void testImplicitWait() {
        //set browser properties
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        // adding implicit wait at the beginning to wait all of the elements in DOM. Not recommended will affect the execution performance.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            WebElement enterAnyText = driver.findElement(By.name("q"));
            enterAnyText.sendKeys("Selenium");
            enterAnyText.submit();
            Assert.assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
        } catch (NoSuchElementException e) {
            System.out.println("Element Not Found");
        } finally {
            driver.quit();
        }
    }
}





