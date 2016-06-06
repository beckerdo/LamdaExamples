package com.example.lambda;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StreamFilterTest {

	@Test
	public void filterTest() {
		List<Person> pl = Person.createShortList();
		SearchCriteria search = SearchCriteria.getInstance();

        // Predicate<Person> allDraftees = p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
		List<Person> expected = pl.stream()
		    .filter(search.getCriteria("allDraftees"))
		    .collect(Collectors.toList());
		List<Person> generated = StreamFilter.filter( pl.stream(), 
		    (Person p) -> p.getAge() >= 18, (Person p) -> p.getAge() <= 25, (Person p) -> p.getGender() == Gender.MALE)
		   .collect(Collectors.toList());
        assertEquals( "count", 2, expected.size());
        assertEquals( "count", expected.size(), generated.size());
        
        // Predicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;
        expected = pl.stream()
           .filter(search.getCriteria("allPilots"))
           .collect(Collectors.toList());
        generated = StreamFilter.filter( pl.stream(), 
            (Person p) -> p.getAge() >= 23, (Person p) -> p.getAge() <= 65 )
            .collect(Collectors.toList());
        assertEquals( "count", 4, expected.size());
        assertEquals( "count", expected.size(), generated.size());
        
        // Predicate<Person> allDrivers = p -> p.getAge() >= 16;
        expected = pl.stream()
           .filter(search.getCriteria("allDrivers"))
           .collect(Collectors.toList());
        generated = StreamFilter.filter( pl.stream(), 
            (Person p) -> p.getAge() >= 18 )
            .collect(Collectors.toList());
        assertEquals( "count", 7, expected.size());
        assertEquals( "count", expected.size(), generated.size());
	}
}
