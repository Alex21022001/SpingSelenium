package com.SpringSelenium.aop;

import com.SpringSelenium.annotations.TakeScreenshot;
import com.SpringSelenium.utils.ScreenShotUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Aspect
@Component
public class ScreenShotAspect {
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @After("@annotation(takeScreenshot)")
    public void after(JoinPoint joinPoint, TakeScreenshot takeScreenshot) throws IOException {
        this.screenShotUtil.takeScreenShot(joinPoint.getSignature().getName());
    }
}
