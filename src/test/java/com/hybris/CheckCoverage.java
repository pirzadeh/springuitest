package com.hybris;

import java.util.Map;
import java.util.Set;

import com.hybris.test.categories.LoginFeature;
import com.hybris.test.smoke.TestSmoke;

public class CheckCoverage {

	public static void main(String[] args) {

		Map<String, Set<String>> annotationCountMap;
		annotationCountMap = AnnotationUtils.countMethodsWithAnnotation(
				TestSmoke.class, LoginFeature.class);

		System.out.println(new PrettyPrint<String, Set<String>>(
				annotationCountMap));

	}
}
