package com.example.przychodnia;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumHomePageTests {

    private static ChromeDriver chromeDriver;

    @BeforeEach
    public void setup() {
        String chromeDriverPath = System.getProperty("user.home") + "\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("http://localhost:8080/home");
        chromeDriver.findElementById("username").sendKeys("admin");
        chromeDriver.findElementById("password").sendKeys("password");
        chromeDriver.findElementByClassName("btn").click();
    }

    @AfterEach
    public void clean() {
        chromeDriver.quit();
    }

    @Test
    public void searchTest() {
        chromeDriver.get("http://localhost:8080/home");
        chromeDriver.findElementById("input").sendKeys("Tomasz");
        List<WebElement> elements = chromeDriver.findElementsByTagName("tr");
        elements.remove(0);
        boolean ok = true;
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                ok &= element.getAttribute("innerHTML").contains("Tomasz");
            } else {
                ok &= !element.getAttribute("innerHTML").contains("Tomasz");
            }
        }
        Assertions.assertTrue(ok);
    }


    @Test
    public void filterTest() {
        chromeDriver.get("http://localhost:8080/home");
        chromeDriver.findElementById("closedVisit").click();
        List<WebElement> elements = chromeDriver.findElementsByTagName("tr");
        elements.remove(0);
        boolean ok = true;
        for (WebElement element : elements) {
            if (element.isDisplayed()) {
                ok &= element.getAttribute("innerHTML").contains("Wizyta Zrealizowana");
            }
        }
        Assertions.assertTrue(ok);
    }


}
