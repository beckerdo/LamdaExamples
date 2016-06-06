package com.example.lambda;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * This class can perform filtering on streams using an array of predicates.
 * <p>
 * This page has lots of help https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html   
 *     
 * @author <a href="mailto:dan@danbecker.info">Dan Becker</a>
 */
public class StreamFilter {
    
    /** 
     * This method performs a number of filter predicates on the given stream.
     * <p>
     * Example:
     * <pre>
     * List<Person> generated = StreamFilter.filter( pl.stream(), 
     *     (Person p) -> p.getAge() >= 18, (Person p) -> p.getAge() <= 25, (Person p) -> p.getGender() == Gender.MALE)
     *      .collect(Collectors.toList());
     * </pre>
     * @param given
     * @param predicates
     * @return
     */
    @SafeVarargs // gets rid of large list warning.
    public static <T> Stream<T> filter( Stream<T> given, Predicate<? super T>... predicates ) {
        Stream<T> returned = Stream.empty();
        // http://stackoverflow.com/questions/24553761/how-to-apply-multiple-predicates-to-a-java-util-stream
        Predicate<? super T> onePredicate = Arrays.stream(predicates).reduce(Predicate::and).orElse(t->true);
        returned = given
           .filter(onePredicate);
        return returned;
    }
}