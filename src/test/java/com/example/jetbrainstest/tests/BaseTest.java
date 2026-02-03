package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.CommunityPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    protected ChromeDriver driver;
    protected CommunityPage cp;

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
}