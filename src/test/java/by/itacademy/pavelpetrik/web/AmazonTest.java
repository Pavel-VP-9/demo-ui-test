package by.itacademy.pavelpetrik.web;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AmazonTest {

    @Test

    public void testOpenAmazon(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(AmazonPage.URL);
        WebElement copyrightElement = driver.findElement(By.xpath(AmazonPage.COPYRIGHT));
        // выполняем проверку, что текст веб элемента COPYRIGHT соответствует «© 1996-2023, Amazon.com, Inc. or its affiliates
        Assert.assertEquals("Error","© 1996-2023, Amazon.com, Inc. or its affiliates",copyrightElement.getText() );
        driver.quit();
    }
}
