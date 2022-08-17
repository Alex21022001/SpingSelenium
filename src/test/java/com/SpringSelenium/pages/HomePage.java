package com.SpringSelenium.pages;

import com.SpringSelenium.annotations.LazyComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

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

    @FindBy(xpath = "//a[.//*[@id='anime_id_17']]")
    private WebElement tg;

    @FindBy(xpath = "//a[.//*[@id='anime_id_12']]")
    private WebElement codeGias;




    public HomePage goToHomePage(String url) {
        driver.get(url);
        waitForPageLoadComplete(WAIT_TIME);
        return this;
    }

    public HomePage goToLogin(String name, String password) {
        singIn.click();
        waitForPageLoadComplete(WAIT_TIME);
        inputLogin.clear();
        inputLogin.sendKeys(name);
        inputPassword.clear();
        inputPassword.sendKeys(password);
        loginSubmit.click();
        waitForPageLoadComplete(WAIT_TIME);
        tg.click();
        waitForPageLoadComplete(WAIT_TIME);
        return this;
    }
    public HomePage test(){
        waitForPageLoadComplete(WAIT_TIME);
        codeGias.click();
        waitForPageLoadComplete(WAIT_TIME);
        return this;
    }
}
