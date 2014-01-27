package com.hybris.test.base;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class TestScope implements Scope {

	private Map<String, Object> cache = new HashMap<String, Object>();

	public void reset() {
		cache.clear();
	}

	public Object get(String name, ObjectFactory<?> objectFactory) {
		if (!cache.containsKey(name)) {
			cache.put(name, objectFactory.getObject());
		}
		return cache.get(name);
	}

	public Object remove(String name) {
		return cache.remove(name);
	}

	public void registerDestructionCallback(String name, Runnable callback) {
	}

	public Object resolveContextualObject(String key) {
		return null;
	}

	public String getConversationId() {
		return null;
	}

}
