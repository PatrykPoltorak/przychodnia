package com.example.przychodnia;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumPatientTests {

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
    @Order(1)
    public void addPatientValuesCheckTest() {
        chromeDriver.get("http://localhost:8080/patient/add");
        chromeDriver.findElementById("name").sendKeys("testName");
        chromeDriver.findElementById("surname").sendKeys("testSurname");
        chromeDriver.findElementById("city").sendKeys("testCity");
        chromeDriver.findElementById("street").sendKeys("testStreet");
        chromeDriver.findElementById("streetNumber").clear();
        chromeDriver.findElementById("streetNumber").sendKeys("asd");
        chromeDriver.findElementById("pesel").clear();
        chromeDriver.findElementById("pesel").sendKeys("asd");
        chromeDriver.findElementByClassName("btn").click();
        Assertions.assertEquals(chromeDriver.getCurrentUrl(), "http://localhost:8080/patient/add");
    }

    @Test
    @Order(2)
    public void addPatientTest() {
        chromeDriver.get("http://localhost:8080/patient/add");
        chromeDriver.findElementById("name").sendKeys("testName");
        chromeDriver.findElementById("surname").sendKeys("testSurname");
        chromeDriver.findElementById("city").sendKeys("testCity");
        chromeDriver.findElementById("street").sendKeys("testStreet");
        chromeDriver.findElementById("streetNumber").clear();
        chromeDriver.findElementById("streetNumber").sendKeys("1");
        chromeDriver.findElementById("pesel").clear();
        chromeDriver.findElementById("pesel").sendKeys("11111111111");
        chromeDriver.findElementByClassName("btn").click();
        Assertions.assertEquals(chromeDriver.getCurrentUrl(), "http://localhost:8080/patient");
    }

    @Test
    @Order(3)
    public void checkIfPatientAddedTest() {
        chromeDriver.get("http://localhost:8080/patient");
        chromeDriver.findElementById("input").sendKeys("11111111111");
        List<WebElement> elements = chromeDriver.findElementsByTagName("tr");
        Assertions.assertTrue(elements.size() > 1);
    }

    @Test
    @Order(4)
    public void deletePatientTest() {
        chromeDriver.get("http://localhost:8080/patient");
        chromeDriver.findElementById("input").sendKeys("11111111111");
        List<WebElement> elements = chromeDriver.findElementsByTagName("tr")
                .stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList());

        elements.get(1).findElements(By.className("btn")).get(1).click();
        chromeDriver.switchTo().alert().accept();

        chromeDriver.findElementById("input").sendKeys("11111111111");
        elements = chromeDriver.findElementsByTagName("tr");
        Assertions.assertTrue(elements.size() > 1);
    }
}
