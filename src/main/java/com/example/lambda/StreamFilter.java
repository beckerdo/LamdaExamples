package com.example.lambda;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * This class can perform filtering on streams using an array of predicates.
    Predicate<Person> allDrivers = p -> p.getAge() >= 16;
    Predicate<Person> allDraftees = p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Gender.MALE;
    Predicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;
    Predicate<Person> allRetirees = p -> p.getAge() >= 62;
    
 * @author <a href="mailto:dan@danbecker.info">Dan Becker</a>
 */
public class StreamFilter {
    
    // My generic syntax foo is low. Will fix this laters
//    public Stream<T> filter( Stream<T> given, Predicate<? super T>... predicates ) {
//        Stream<T> returned = Stream.empty();
//        // for ( Predicate<? super T> predicate : predicates ) { 
//        // }
//        returned = given.stream()
//                .filter(predicate);
//        return returned;
//    }
}