package com.hybris;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.experimental.categories.Category;

public class AnnotationUtils {

	public static Map<String, Set<String>> countMethodsWithAnnotation(
			Class<?> className, Class<? extends Annotation> annotation) {

		Map<String, Set<String>> annotationMap = new HashMap<String, Set<String>>();
		Set<String> methodSet = new HashSet<String>();

		for (Method m : className.getMethods()) {
			Category category = m.getAnnotation(Category.class);
			if (category != null) {
				Class<?>[] clazzes = category.value();

				for (Class<?> clazz : clazzes) {
					if (clazz.getName().equalsIgnoreCase(annotation.getName())) {

						methodSet.add(m.getName());

						annotationMap.put(annotation.getName(), methodSet);

					}
				}

			}
		}
		return annotationMap;
	}
	// Other methods for custom annotation processing

}
