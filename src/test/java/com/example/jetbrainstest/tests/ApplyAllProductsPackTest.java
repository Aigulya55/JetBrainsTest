package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.CommunityPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApplyAllProductsPackTest extends BaseTest {
    @Test
    public void applyForDevelopRecognition() {
        CommunityPage cp = new CommunityPage(driver);

        cp.setDevRecButton();
        assertTrue(cp.checkIfDevRecButtonIsEnabled(), "Кнопка 'Developer Recognition' недоступна");
        assertTrue(cp.checkIfAppllyButtonIsEnabled(), "Функция Apply недоступна");
        cp.setApplyButton();

        cp.getAnswerFromSystem();
        String AnswerFromSystem = "Unfortunately, we're unable to deliver licenses to your country/region owing to existing legal restrictions.";
        assertEquals(AnswerFromSystem, cp.getAnswerFromSystem(), "Услуга недоступна для РФ");
    }
}