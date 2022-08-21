package com.SpringSelenium.reports;

import com.SpringSelenium.pages.BasePage;
import com.SpringSelenium.reports.helpfulannotations.StepWithRetry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;

@Component
@Aspect
public class TestRepeater {

    private static final Logger logger = LogManager.getLogger(AllureLogAspect.class);
    private static final ThreadLocal<Boolean> process = new ThreadLocal<>();

    private Boolean getCurrentProcess() {
        return process.get();
    }

    @Around("@annotation(com.SpringSelenium.reports.helpfulannotations.StepWithRetry)")
    public Object handleMethodWithReties(ProceedingJoinPoint proceedingJoinPoint) {
        process.set(true);
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        StepWithRetry retry = method.getAnnotation(StepWithRetry.class);
        int amountOfRetries = retry.value();
        Throwable throwable = null;
        Object result = null;
        boolean processed = false;
        int i = 0;
        while (!processed && i < amountOfRetries) {
            try {
                result = proceedingJoinPoint.proceed();
                processed = true;
            } catch (Throwable e) {
                logger.warn("Attempt #" + i + "\r\n" + e);
                throwable = e;
            }
            i++;
        }
        process.set(false);
        if (!processed)
            return throwable;
        else
            return result;
    }
}
