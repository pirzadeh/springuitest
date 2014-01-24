package com.hybris;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PrettyPrint<K, V> {
	private Map<K, V> map;

	public PrettyPrint(Map<K, V> map) {
		this.map = map;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<Entry<K, V>> iter = map.entrySet().iterator();

		while (iter.hasNext()) {
			Entry<K, V> entry = iter.next();
			sb.append(entry.getKey());
			
			sb.append(" (");
			sb.append(((Set<?>) entry.getValue()).size());
			sb.append(") ");
			
			sb.append('=').append('"');
			sb.append(entry.getValue());
	

			sb.append('"');
			if (iter.hasNext()) {
				sb.append(',').append(' ');
			}
		}
		return sb.toString();

	}
}