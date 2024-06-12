package com.w2m.spaceships.api.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.w2m.spaceships.api.controllers.SpaceshipController.getSpaceshipById(..)) && args(id)")
    public void getSpaceshipById(Long id) {}

    @After("getSpaceshipById(id)")
    public void logIfNegative(Long id) {
        if (id < 0) {
            System.out.println("Se intentó consultar una nave con un ID negativo: " + id);
        }
    }
}
