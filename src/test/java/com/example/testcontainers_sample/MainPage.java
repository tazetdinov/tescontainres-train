package com.example.testcontainers_sample;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement searchButton = $("[data-test=menu-main-icon-search]");

    public SelenideElement searchInput = $("[data-test=search-input]");

}
