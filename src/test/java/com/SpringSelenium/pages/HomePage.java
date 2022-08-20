package com.SpringSelenium.pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class HomePage extends BasePage {


    @FindBy(xpath = "//a[@class='login_btn circle']")
    private WebElement singIn;

    @FindBy(xpath = "//*[@id='login_input1']")
    private WebElement inputLogin;

    @FindBy(xpath = "//*[@id='login_input2']")
    private WebElement inputPassword;

    @FindBy(css = "#login_submit")
    private WebElement loginSubmit;

    @FindBy(xpath = "//a[text()='Профиль']")
    private WebElement profile;

    @FindBy(xpath = "//ul[@class='site_nav_l']/li")
    private List<WebElement> listOfMenu;

    @FindBy(xpath = "//input[@value='Найти']")
    private WebElement but;


    @Step(value = "go to {url}")
    @Story("go to main page")
    public HomePage goToHomePage(String url) {
        driver.get(url);
        waitForPageLoadComplete(WAIT_TIME);
        return this;
    }

    @Step(value = "Try to sing in using {0} and {1}")
    @Description("Method try to login in a site ")
    public HomePage goToLogin(String name, String password) {
        singIn.click();
        waitForPageLoadComplete(WAIT_TIME);
        inputLogin.clear();
        inputLogin.sendKeys(name);
        inputPassword.clear();
        inputPassword.sendKeys(password);
        loginSubmit.click();
        waitForPageLoadComplete(WAIT_TIME);
        return this;
    }

    public HomePage choseTitle() {
        waitForPageLoadComplete(WAIT_TIME);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        listOfMenu.get(8).click();
        waitForPageLoadComplete(WAIT_TIME);

        return this;
    }

    @Step("Verify singing in a site")
    public boolean isLogin() {
        try {
            profile.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return profile.isDisplayed();
    }
}
