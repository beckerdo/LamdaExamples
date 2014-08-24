package com.example.lambda;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class ListTest {

	@Test
	public void listTest() {

		List<Person> pl = Person.createShortList();

		SearchCriteria search = SearchCriteria.getInstance();

		// Make a new list after filtering.
		List<Person> pilotList = pl.stream()
				.filter(search.getCriteria("allPilots"))
				.collect(Collectors.toList());

		System.out.println("\n=== Western Pilot Phone List ===");
		pilotList.forEach(Person::printWesternName);

	}
}