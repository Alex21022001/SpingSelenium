package com.SpringSelenium.utils;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

public class ScreenShotUtil implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        Object o = context.getRequiredTestInstance();
        Field field = Arrays.stream(o.getClass().getDeclaredFields()).filter(x -> x.getName().equals("driver")).findFirst().get();
        field.setAccessible(true);
        WebDriver driver;
        try {
            driver = (WebDriver) field.get(o);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        Object o = context.getRequiredTestInstance();
        Field field = Arrays.stream(o.getClass().getDeclaredFields()).filter(x -> x.getName().equals("driver")).findFirst().get();
        field.setAccessible(true);
        WebDriver driver;
        try {
            driver = (WebDriver) field.get(o);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        Object o = context.getRequiredTestInstance();
        Field field = Arrays.stream(o.getClass().getDeclaredFields()).filter(x -> x.getName().equals("driver")).findFirst().get();
        field.setAccessible(true);
        WebDriver driver;
        try {
            driver = (WebDriver) field.get(o);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Allure.getLifecycle().addAttachment("ScreenShot","image/png",".png",((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
        driver.quit();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Object o = context.getRequiredTestInstance();
        Field field = Arrays.stream(o.getClass().getDeclaredFields()).filter(x -> x.getName().equals("driver")).findFirst().get();
        field.setAccessible(true);
        WebDriver driver;
        try {
            driver = (WebDriver) field.get(o);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Allure.getLifecycle().addAttachment("ScreenShot","image/png",".png",((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
        driver.quit();
    }
}
