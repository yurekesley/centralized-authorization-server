package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config.dataSource;

import java.util.Map;

import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.annotation.DatabaseType;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author yure.placido
 *
 */
public class DatabaseTypeCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Map<String, Object> attributes = metadata.getAnnotationAttributes(DatabaseType.class.getName());
		String type = (String) attributes.get("value");

		String enabledDBType = System.getProperty("app.auth.driver");

		if (enabledDBType == null)
			enabledDBType = context.getEnvironment().getProperty("app.auth.driver");

		return (enabledDBType != null && type != null && enabledDBType.equalsIgnoreCase(type));
	}

}
