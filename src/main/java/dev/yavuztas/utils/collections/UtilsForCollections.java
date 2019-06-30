package dev.yavuztas.utils.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Utility class for collection conversion and manupilation
 * 
 * @author Yavuz Tas
 *
 */
public class UtilsForCollections {

	private UtilsForCollections() {

	}

	public static List<Integer> toList(int[] array) {
		return Arrays.stream(array).boxed().collect(Collectors.toList());
	}

	public static List<Long> toList(long[] array) {
		return Arrays.stream(array).boxed().collect(Collectors.toList());
	}

	public static List<Double> toList(double[] array) {
		return Arrays.stream(array).boxed().collect(Collectors.toList());
	}

	public static <T> List<T> toList(T[] array) {
		return Arrays.stream(array).collect(Collectors.toList());
	}

	public static Set<Integer> toSet(int[] array) {
		return Arrays.stream(array).boxed().collect(Collectors.toSet());
	}

	public static Set<Long> toSet(long[] array) {
		return Arrays.stream(array).boxed().collect(Collectors.toSet());
	}

	public static Set<Double> toSet(double[] array) {
		return Arrays.stream(array).boxed().collect(Collectors.toSet());
	}

	public static <T> Set<T> toSet(T[] array) {
		return Arrays.stream(array).collect(Collectors.toSet());
	}

	public static <T> Set<T> toSetByPreserveOrder(T[] array) {
		return Arrays.stream(array).collect(Collectors.toCollection(LinkedHashSet::new));
	}

	public static <T> String join(Collection<T> collection, String separator) {
		return collection.stream().map(String::valueOf).collect(Collectors.joining(separator));
	}

	public static <T> String join(T[] array, String separator) {
		return Arrays.stream(array).map(String::valueOf).collect(Collectors.joining(separator));
	}

	public static <T> String toStringByProperty(Collection<T> collection, String property) {
		return toStringByProperty(collection, property, 5);
	}

	// TODO implement without any dependencies...
	public static <T> String toStringByProperty(Collection<T> collection, String property, int limit) {
		String result = collection.stream().limit(limit).toString();
		// .map(object -> String.valueOf(property != null ?
		// UtilsForReflection.getValue(object, property) : object))
		// .collect(Collectors.joining(", "));

		if (collection.size() > limit) {
			result += ", ...";
		}

		return "[" + result + "]";
	}

}
