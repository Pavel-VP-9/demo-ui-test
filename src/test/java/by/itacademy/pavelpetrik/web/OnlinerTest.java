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
        // выполняем проверку, что текст веб элемента COPYRIGHT соответствует «© 2001—2023 Onlíner
        Assert.assertEquals("Error","© 2001—2023 Onlíner",copyrightElement.getText() );
        driver.quit();

    }
    @Test
    public void testOpenOnlinerLoginForm(){
        WebDriver driver = new ChromeDriver(); // создали веб браузер
        driver.manage().window().maximize(); // расширили веб страницу
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// задержка
        driver.get(OnlinerPage.URL); // Открыли страницу
        WebElement btnEntrance = driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE));
        btnEntrance.click();
        // отправили переменную LABEL_ENTRANCE в метод findElement
        // находим элемент с помощью driver удовлетворяющий нашему локатору
        WebElement textOfBtnElement = driver.findElement(By.xpath(OnlinerPage.LABEL_ENTRANCE));
        Assert.assertEquals("Text", "Вход", textOfBtnElement.getText());
        driver.quit();


    }
    @Test
    public void testOnlinerLoginFormWithEmptyCredentials(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(OnlinerPage.URL);
        WebElement btnEntrance = driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE));
        btnEntrance.click();
        WebElement elementBtnEntrance = driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE_2));
        elementBtnEntrance.click();
        WebElement elementNik = driver.findElement(By.xpath(OnlinerPage.ERROR_LABEL_NIK_E_MAIL));
        Assert.assertEquals("Nik is wrong", "Ввидите Nik или e-mail",elementNik.getText());
        WebElement elementPassword = driver.findElement(By.xpath(OnlinerPage.ERROR_LABEL_PASSWORD));
        Assert.assertEquals("Password is wrong", " Введите пароль ", elementPassword.getText());
        driver.quit();


    }
    @Test
    public void testOnlinerLoginFormWithEmptyPassword(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(OnlinerPage.URL);
        WebElement btnEntrance = driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE));
        btnEntrance.click();
        WebElement inputNikMail= driver.findElement(By.xpath(OnlinerPage.INPUT_NIK_MAIL));
        inputNikMail.sendKeys("test@gmail.com");
        WebElement elementBtnEntrance = driver.findElement(By.xpath(OnlinerPage.BTN_ENTRANCE_2));
        elementBtnEntrance.click();
        WebElement elementPassword = driver.findElement(By.xpath(OnlinerPage.ERROR_LABEL_PASSWORD_ONLY));
        Assert.assertEquals("Password is wrong", "Введите ппароль", elementPassword.getText());
        driver.quit();

    }

}
