package dev.yavuztas.utils.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Utility class for collections
 * 
 * @author Yavuz Tas
 *
 */
public class UtilsForCollections {

    private UtilsForCollections() {

    }

    public static <T> List<T> toList(T[] array) {
        return Arrays.stream(array)
            .collect(Collectors.toList());
    }

    public static List<Integer> toList(int[] array) {
        return Arrays.stream(array)
            .boxed()
            .collect(Collectors.toList());
    }

    public static List<Long> toList(long[] array) {
        return Arrays.stream(array)
            .boxed()
            .collect(Collectors.toList());
    }

    public static List<Double> toList(double[] array) {
        return Arrays.stream(array)
            .boxed()
            .collect(Collectors.toList());
    }

    public static <T> Set<T> toSet(T[] array) {
        return UtilsForCollections.toSet(array, false);
    }

    public static <T> Set<T> toSet(T[] array, boolean preserveOrder) {
        if (preserveOrder) {
            return Arrays.stream(array)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        }
        return Arrays.stream(array)
            .collect(Collectors.toSet());
    }

    public static Set<Integer> toSet(int[] array) {
        return Arrays.stream(array)
            .boxed()
            .collect(Collectors.toSet());
    }

    public static Set<Long> toSet(long[] array) {
        return Arrays.stream(array)
            .boxed()
            .collect(Collectors.toSet());
    }

    public static Set<Double> toSet(double[] array) {
        return Arrays.stream(array)
            .boxed()
            .collect(Collectors.toSet());
    }

    public static <T> List<T> toList(Collection<T> collection) {
        return collection.stream()
            .collect(Collectors.toList());
    }

    public static <T> Set<T> toSet(Collection<T> collection) {
        return UtilsForCollections.toSet(collection, false);
    }

    public static <T> Set<T> toSet(Collection<T> collection, boolean preserveOrder) {
        if (preserveOrder) {
            return collection.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new));
        }
        return collection.stream()
            .collect(Collectors.toSet());
    }

    public static <T> List<T> filterArray(T[] array, Predicate<? super T> predicate) {
        return Arrays.stream(array)
            .filter(predicate)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public static <T> List<T> filterCollection(Collection<T> collection, Predicate<? super T> predicate) {
        return collection.stream()
            .filter(predicate)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public static <T> String join(T[] array, String separator) {
        return UtilsForCollections.join(array, separator, 0);
    }

    public static <T> String join(T[] array, String separator, int limit) {
        if (limit > 0 && array.length > limit) {
            return Arrays.stream(array)
                .limit(limit)
                .map(String::valueOf)
                .collect(Collectors.joining(separator)) + separator + "...";
        }
        return Arrays.stream(array)
            .map(String::valueOf)
            .collect(Collectors.joining(separator));
    }

    public static <T> String join(Collection<T> collection, String separator) {
        return UtilsForCollections.join(collection, separator, 0);
    }

    public static <T> String join(Collection<T> collection, String separator, int limit) {
        if (limit > 0 && collection.size() > limit) {
            return collection.stream()
                .limit(limit)
                .map(String::valueOf)
                .collect(Collectors.joining(separator)) + separator + "...";
        }
        return collection.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(separator));
    }

}
