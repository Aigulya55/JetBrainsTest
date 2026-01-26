package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.CommunityPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplyAllProductsPackTest {
    private WebDriver driver;
    private CommunityPage cp;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        this.driver.get("https://www.jetbrains.com.cn/en-us/");
        cp = new CommunityPage(driver);
    }

    @AfterEach
    public void tearDown() {
        this.driver.quit();
    }

    @Test
    public void applyForDevelopRecognition() {
        cp.setDevRecButton();
        assertTrue(cp.checkIfDevRecButtonIsEnabled(), "Кнопка 'Developer Recognition' недоступна");

        cp.setApplyButton();
        assertTrue(cp.checkIfAppllyButtonIsDisplayed(), "Функция Apply недоступна");

        cp.getAnswerFromSystem();
        String AnswerFromSystem = "Unfortunately, we're unable to deliver licenses to your country/region owing to existing legal restrictions.";
        assertEquals(AnswerFromSystem, cp.getAnswerFromSystem(), "Услуга недоступна для РФ");
    }
}