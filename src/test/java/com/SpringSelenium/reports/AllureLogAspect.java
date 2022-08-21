package com.SpringSelenium.reports;


import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;

import static io.qameta.allure.util.AspectUtils.getParametersMap;
import static io.qameta.allure.util.NamingUtils.processNameTemplate;

@Aspect
@Component
public class AllureLogAspect {
    private static final Logger logger = LogManager.getLogger(AllureLogAspect.class);

    @Before("@annotation(io.qameta.allure.Step) && execution(* *(..))")
    public void beforeStep(JoinPoint joinPoint) {
        String stepName = getStepName(joinPoint);
        logger.info("BEGIN:  " + stepName);
    }

    @AfterReturning(pointcut = "@annotation(com.SpringSelenium.reports.helpfulannotations.StepWithResult)", returning = "result")
    public void afterStepWithResults(JoinPoint joinPoint, Object result) {
        String stepName = getStepName(joinPoint);
        if (result != null)
            logger.info(stepName + " - is Finished with such a result: [" + result + "]");
    }


    private String getStepName(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Map<String, Object> parametersMap = getParametersMap(joinPoint);
        Method method = methodSignature.getMethod();
        Step step = method.getAnnotation(Step.class);
        String stepName = step.value();
        return Optional.of(stepName)
                .filter(x -> x != null)
                .map(it -> processNameTemplate(it, parametersMap))
                .orElse(methodSignature.getName());
    }
}

