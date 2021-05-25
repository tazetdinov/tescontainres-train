package com.example.testcontainers_sample;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

@Testcontainers
public class MainPageTest {
    MainPage mainPage = new MainPage();

    @Container
    public static BrowserWebDriverContainer<?> browser = new BrowserWebDriverContainer<>()
            .withCapabilities(new ChromeOptions());

    @Test
    public void search() {
        RemoteWebDriver remoteWebDriver = browser.getWebDriver();
        WebDriverRunner.setWebDriver(remoteWebDriver);

        open("https://www.jetbrains.com/");

        mainPage.searchButton.click();

        mainPage.searchInput.sendKeys("Selenium");

        mainPage.searchInput.pressEnter();

        mainPage.searchInput.shouldHave(attribute("value", "Selenium"));
    }

    @AfterAll
    static void afterAll() {
        Selenide.closeWindow();
    }
}
