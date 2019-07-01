package dev.yavuztas.utils.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import dev.yavuztas.utils.collections.UtilsForCollections;
import junit.framework.Assert;

/**
 * Unit tests for {@link UtilsForCollections}
 * 
 * @author Yavuz Tas
 *
 */
public class UtilsForCollectionsTest {

	@Test
	public void arrayToListTest() {

		String[] array = new String[] { "apple", "banana", "orange" };

		List<String> list = UtilsForCollections.toList(array);
		Assert.assertEquals(array.length, list.size());

		for (int i = 0; i < array.length; i++) {
			Assert.assertEquals(array[i], list.get(i));
		}

	}

	@Test
	public void primitiveIntArrayToListTest() {

		int[] intArray = new int[] { 1, 2, 3 };

		List<Integer> list = UtilsForCollections.toList(intArray);
		Assert.assertEquals(intArray.length, list.size());

		for (int i = 0; i < intArray.length; i++) {
			Assert.assertEquals(intArray[i], list.get(i).intValue());
		}

	}

	@Test
	public void primitiveLongArrayToListTest() {

		long[] array = new long[] { 1, 3, 5, 6, 7 };

		List<Long> list = UtilsForCollections.toList(array);
		Assert.assertEquals(array.length, list.size());

		for (int i = 0; i < array.length; i++) {
			Assert.assertEquals(array[i], list.get(i).longValue());
		}

	}

	@Test
	public void primitiveDoubleArrayToListTest() {

		double[] array = new double[] { 1.0, 3.0, 5.1, 6.2, 7.3 };

		List<Double> list = UtilsForCollections.toList(array);
		Assert.assertEquals(array.length, list.size());

		for (int i = 0; i < array.length; i++) {
			Assert.assertEquals(array[i], list.get(i).doubleValue());
		}

	}

	@Test
	public void arrayToSetTest() {

		String[] array = new String[] { "apple", "banana", "banana", "orange" };

		Set<String> set = UtilsForCollections.toSet(array);
		Assert.assertEquals(array.length - 1, set.size());

		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String element = (String) iterator.next();
			int found = Arrays.binarySearch(array, element);
			Assert.assertTrue(found > -1);
			Assert.assertEquals(array[found], element);
		}

	}

	@Test
	public void primitiveIntArrayToSetTest() {

		int[] array = new int[] { 1, 2, 2, 3 };

		Set<Integer> set = UtilsForCollections.toSet(array);
		Assert.assertEquals(array.length - 1, set.size());

		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			Integer element = iterator.next();
			int found = Arrays.binarySearch(array, element);
			Assert.assertTrue(found > -1);
			Assert.assertEquals(array[found], element.intValue());
		}

	}

	@Test
	public void primitiveLongArrayToSetTest() {

		long[] array = new long[] { 1, 3, 5, 6, 7 };

		Set<Long> set = UtilsForCollections.toSet(array);
		Assert.assertEquals(array.length, set.size());

		Iterator<Long> iterator = set.iterator();
		while (iterator.hasNext()) {
			Long element = iterator.next();
			int found = Arrays.binarySearch(array, element);
			Assert.assertTrue(found > -1);
			Assert.assertEquals(array[found], element.longValue());
		}

	}

	@Test
	public void primitiveDoubleArrayToSetTest() {

		double[] array = new double[] { 1.0, 3.0, 5.1, 6.2, 7.3 };

		Set<Double> set = UtilsForCollections.toSet(array);
		Assert.assertEquals(array.length, set.size());

		Iterator<Double> iterator = set.iterator();
		while (iterator.hasNext()) {
			Double element = iterator.next();
			int found = Arrays.binarySearch(array, element);
			Assert.assertTrue(found > -1);
			Assert.assertEquals(array[found], element.doubleValue());
		}

	}

	@Test
	public void arrayToSetPreserverOrderTest() {

		String[] array = new String[] { "apple", "banana", "avocado", "orange" };

		Set<String> set = UtilsForCollections.toSet(array, true);
		Assert.assertEquals(array.length, set.size());

		int i = 0;
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			Assert.assertEquals(array[i++], (String) iterator.next());
		}
	}

	@Test
	public void listToSetTest() {

		List<String> list = Arrays.asList(new String[] { "apple", "banana", "banana", "orange" });
		Set<String> set = UtilsForCollections.toSet(list);

		Assert.assertEquals(list.size() - 1, set.size());

		for (String element : set) {
			Assert.assertTrue(list.contains(element));
		}

	}

	@Test
	public void setToListTest() {

		Set<String> set = Arrays.stream(new String[] { "apple", "banana", "avocado", "orange" }).collect(Collectors.toSet());
		List<String> list = UtilsForCollections.toList(set);

		Assert.assertEquals(set.size(), list.size());

		for (String element : list) {
			Assert.assertTrue(set.contains(element));
		}

	}

	@Test
	public void listToSetPreserverOrderTest() {

		List<String> list = Arrays.asList(new String[] { "apple", "banana", "avocado", "orange" });
		Set<String> set = UtilsForCollections.toSet(list, true);

		Assert.assertEquals(list.size(), set.size());

		int i = 0;
		for (String element : set) {
			Assert.assertEquals(list.get(i++), element);
		}

	}

	@Test
	public void filterArrayTest() {

		String[] array = new String[] { "apple", "banana", "orange", "avocado", "mango" };
		List<String> filtered = UtilsForCollections.filterArray(array, v -> v.startsWith("a"));

		Assert.assertEquals(filtered.size(), 2);
		Assert.assertEquals(filtered.get(0), "apple");
		Assert.assertEquals(filtered.get(1), "avocado");
	}

	@Test
	public void filterCollectionTest() {

		String[] array = new String[] { "apple", "banana", "orange", "avocado", "mango" };
		List<String> filtered = UtilsForCollections.filterCollection(Arrays.asList(array), v -> v.startsWith("a"));

		Assert.assertEquals(filtered.size(), 2);
		Assert.assertEquals(filtered.get(0), "apple");
		Assert.assertEquals(filtered.get(1), "avocado");
	}

	@Test
	public void arrayToStringTest() {

		String[] array = new String[] { "apple", "banana", "orange", "avocado", "mango" };
		String string = UtilsForCollections.join(array, ", ", 3);
		Assert.assertEquals("apple, banana, orange, ...", string);
	}

	@Test
	public void collectionToStringTest() {

		String[] array = new String[] { "apple", "banana", "orange", "avocado", "mango" };
		String string = UtilsForCollections.join(Arrays.asList(array), ", ", 10);
		Assert.assertEquals("apple, banana, orange, avocado, mango", string);
	}

}
