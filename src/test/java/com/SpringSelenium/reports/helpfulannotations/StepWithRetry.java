package com.SpringSelenium.reports.helpfulannotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StepWithRetry {
    int value () default 3;
}
