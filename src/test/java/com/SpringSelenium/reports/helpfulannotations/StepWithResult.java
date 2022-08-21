package com.SpringSelenium.reports.helpfulannotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StepWithResult {
}
