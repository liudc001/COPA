package com.alibaba.sofa.command.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Inherited
@Component
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PreInterceptor {

    Class<? extends com.alibaba.sofa.dto.Command>[] commands() default {};

}
