package com.example.lambda;

import java.util.List;

import org.junit.Test;

/**
 * Demonstrates syntax of Lambda expressions in Java 8.
 * http://www.oracle.com/webfolder
 * /technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
 */
public class FilterMapReduceTest {

	@Test
	public void filterMapReduceTest() {
		List<Person> pl = Person.createShortList();

		SearchCriteria search = SearchCriteria.getInstance();

		System.out.println("\nOldest with iteration");
		long longAge = 0;
		long instant = System.currentTimeMillis();
		for (Person p : pl) {
			long age = p.getAge();
			if (age >= 65) {
				if (age > longAge)
					longAge = age;
			}
		}
		System.out.println("Oldest Age: " + longAge);
		System.out.println("Elapsed Time: "
				+ (System.currentTimeMillis() - instant));

		// Get sum of ages
		System.out.println("\nOldest with serial filter/map/reduce");
		instant = System.currentTimeMillis();
		int maxAge = pl.stream().filter(search.getCriteria("retirees"))
				.mapToInt(p -> p.getAge()).max().getAsInt();
		System.out.println("Oldest Age: " + maxAge);
		System.out.println("Elapsed Time: "
				+ (System.currentTimeMillis() - instant));

		// Get sum of ages
		System.out.println("\nOldest with parallel filter/map/reduce");
		instant = System.currentTimeMillis();
		maxAge = pl.parallelStream().filter(search.getCriteria("retirees"))
				.mapToInt(p -> p.getAge()).max().getAsInt();
		System.out.println("Oldest Age: " + maxAge);
		System.out.println("Elapsed Time: "
				+ (System.currentTimeMillis() - instant));
	}
}