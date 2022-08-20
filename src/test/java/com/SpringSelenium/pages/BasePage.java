package com.SpringSelenium.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.Duration;
import java.time.temporal.ChronoUnit;


public abstract class BasePage {

    @Autowired
    protected WebDriver driver;
    @Autowired
    protected ApplicationContext context;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final static long WAIT_TIME = 20;


    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }


    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, Duration.of(timeToWait, ChronoUnit.SECONDS)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForAjaxToComplete(long timeToWait) {
        new WebDriverWait(driver, Duration.of(timeToWait, ChronoUnit.SECONDS)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return window.jQuery != undefined && jQuery.active == 0;"));
    }

    public void waitVisibilityOfElement(long timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(timeToWait, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
