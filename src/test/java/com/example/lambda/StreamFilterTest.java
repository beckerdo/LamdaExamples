package com.example.lambda;

import static org.junit.Assert.*;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class StreamFilterTest {

	@Test
	public void filterTest() {
		List<Person> pl = Person.createShortList();
		SearchCriteria search = SearchCriteria.getInstance();

		List<Person> expected = pl.stream()
		    .filter(search.getCriteria("allDraftees"))
		    .collect(Collectors.toList());

		// The idea is to pass an array/list of predicates and get a filtered stream back.
//		List<Person> generated = StreamFilter.filter( pl.stream(), 
//		    p -> p.getAge() >= 18, p.getAge() <= 25, p.getGender() == Gender.MALE)
//		   .collect(Collectors.toList());

		// Placeholder hack
        assertEquals( "count", 2, expected.size());
        // What is wanted
        // assertEquals( "count", expected.size(), generated.size());
	}
}
