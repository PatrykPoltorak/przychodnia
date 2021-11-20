package com.example.przychodnia;

import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumLoginPageTests {

    private ChromeDriver chromeDriver;

    @BeforeEach
    public void setup() {
        String chromeDriverPath = System.getProperty("user.home") + "\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }

    @AfterEach
    public void clean() {
        chromeDriver.quit();
    }

    @Test
    public void homePageWorking() {
        chromeDriver.get("http://localhost:8080/home");
        Assertions.assertFalse(chromeDriver.findElementsById("username").isEmpty());
    }

    @Test
    public void homePageRedirectToLoginPage() {
        chromeDriver.get("http://localhost:8080/home");
        Assertions.assertEquals(chromeDriver.getCurrentUrl(), "http://localhost:8080/login");
    }

    @Test
    public void loginPageCorrectLogin() {
        chromeDriver.get("http://localhost:8080/home");
        chromeDriver.findElementById("username").sendKeys("admin");
        chromeDriver.findElementById("password").sendKeys("password");
        chromeDriver.findElementByClassName("btn").click();
        Assertions.assertEquals(chromeDriver.getCurrentUrl(), "http://localhost:8080/home");
    }

    @Test
    public void loginPageIncorrectLogin() {
        chromeDriver.get("http://localhost:8080/home");
        chromeDriver.findElementById("username").sendKeys("admin");
        chromeDriver.findElementById("password").sendKeys("password1");
        chromeDriver.findElementByClassName("btn").click();
        Assertions.assertEquals(chromeDriver.getCurrentUrl(), "http://localhost:8080/login?error");
    }


    @Test
    public void loginPageLogout() {
        chromeDriver.get("http://localhost:8080/home");
        chromeDriver.findElementById("username").sendKeys("admin");
        chromeDriver.findElementById("password").sendKeys("password");
        chromeDriver.findElementByClassName("btn").click();
        chromeDriver.get("http://localhost:8080/logout");
        chromeDriver.findElementByClassName("btn").click();
        Assertions.assertEquals(chromeDriver.getCurrentUrl(), "http://localhost:8080/login");
    }


}
