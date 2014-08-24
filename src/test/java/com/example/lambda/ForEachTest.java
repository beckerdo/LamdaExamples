package com.example.lambda;

import java.util.List;

import org.junit.Test;

public class ForEachTest {
  
	@Test
	public void forEachTest() {
		List<Person> pl = Person.createShortList();

		System.out.println("=== Western Phone List ===");
		pl.forEach(p -> p.printWesternName());

		System.out.println("=== Eastern Phone List ===");
		pl.forEach(Person::printEasternName);

		System.out.println("=== Custom Phone List ===");
		pl.forEach(p -> {
			System.out.println(
				p.printCustom(r -> "Name: " + r.getGivenName()
					+ " EMail: " + r.getEmail()));
		});
	}

}