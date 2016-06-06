package com.example.lambda;

import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import org.junit.Test;

/**
 * Demonstrates syntax of Lambda expressions in Java 8.
 * http://www.oracle.com/webfolder
 * /technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
 */
public class ComparatorTest {

	@Test
	public void comparatorTest() {
		List<Person> personList = Person.createShortList();

		// Sort with Inner Class
		Collections.sort(personList, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.getSurName().compareTo(p2.getSurName());
			}
		});
		System.out.println("Sorted Asc SurName with Inner class");
		for (Person p : personList) {
			p.printWesternName();
		}

		// Use Lambda instead
		// Print Asc
		System.out.println("Sorted Asc SurName with Lambda");
		Collections.sort(personList, 
		        (Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName()));
		for (Person p : personList) {
			p.printWesternName();
		}

		// Print Desc
		System.out.println("Sorted Desc SurName with Lambda");
		Collections.sort(personList,
				(p1, p2) -> p2.getSurName().compareTo(p1.getSurName()));
		for (Person p : personList) {
			p.printWesternName();
		}

	}
}