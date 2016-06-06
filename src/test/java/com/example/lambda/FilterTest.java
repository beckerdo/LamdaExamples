package com.example.lambda;

import java.util.List;

import org.junit.Test;

public class FilterTest {

	@Test
	public void filterTest() {
		List<Person> pl = Person.createShortList();
		SearchCriteria search = SearchCriteria.getInstance();

		System.out.println("\n=== Western Pilot Phone List ===");
		pl.stream()
		    .filter(search.getCriteria("allPilots"))
			.forEach(Person::printWesternName);

		System.out.println("\n=== Eastern Draftee Phone List ===");
		pl.stream()
		    .filter(search.getCriteria("allDraftees"))
			.forEach(Person::printEasternName);

	}
}
