package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config.DatabaseTypeCondition;
import org.springframework.context.annotation.Conditional;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Conditional(DatabaseTypeCondition.class)
public @interface DatabaseType {
	String value();
}