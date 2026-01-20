package com.example.jetbrainstest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommunityPage {
    @FindBy(css = "div>ul>li:nth-child(9)>ul>li:nth-child(3)")
    private WebElement devRecButton;

    @FindBy(css = "a[data-test=button")
    private WebElement applyButton;

    @FindBy(css = "div[class='topLevelMessage']")
    private WebElement answerFromSystem;

    public void setDevRecButton() {
        devRecButton.click();
        System.out.println("Переход на страницу IT-сообщества");
    }


    public void setApplyButton() {
        applyButton.click();
        System.out.println("Отправка заявки");
    }

    public String getAnswerFromSystem() {
        String expectedAnswer = answerFromSystem.getText();
        System.out.println("Ответ системы после отправки заявки");
        return expectedAnswer;
    }

    public boolean checkIfDevRecButtonIsEnabled() {
        System.out.println("Проверка кнопки Developer Recognition");
        return devRecButton.isEnabled();
    }

    public boolean checkIfAppllyButtonIsEnabled() {
        System.out.println("Проверка кнопки Apply");
        return applyButton.isEnabled();
    }

    public CommunityPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}