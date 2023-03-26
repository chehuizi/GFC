package com.bmf.agent.api.registrar;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({BMFRegistrar.class})
public @interface EnableBMFScan {

    String[] basePackages() default {};
}
