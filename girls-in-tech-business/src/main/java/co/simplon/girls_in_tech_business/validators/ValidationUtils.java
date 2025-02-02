package co.simplon.girls_in_tech_business.validators;

import java.util.Map;

import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import jakarta.servlet.http.HttpServletRequest;

public final class ValidationUtils {

	// utilitaire
	private ValidationUtils() {
		// Not instantiable
	}

	@SuppressWarnings("unchecked")
	static String pathVariableString(String name) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		Map<String, String> pathVariables = (Map<String, String>) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		return pathVariables.get(name);
	}

	static Long pathVariableAsLong(String name) {
		return Long.valueOf(pathVariableString(name));
	}

	static Integer pathVariableAsInteger(String name) {
		return Integer.valueOf(pathVariableString(name));
	}

	static Boolean pathVariableAsBoolean(String name) {
		return Boolean.valueOf(pathVariableString(name));
	}
}

