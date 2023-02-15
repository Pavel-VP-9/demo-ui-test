package by.itacademy.pavelpetrik.web;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OnlinerTest {
    @Test
    public void testOpenOnliner(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(OnlinerPage.URL);

        WebElement copyrightElement = driver.findElement(By.xpath(OnlinerPage.COPYRIGHT));
        Assert.assertEquals("Error","© 2001—2023 Onlíner",copyrightElement.getText() );
        driver.quit();

    }
    @Test
    public void testOpenOnlinerLoginForm(){

    }
}
