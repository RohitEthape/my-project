package Streams;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermidiateOpt {
    public static void main(String[] args) {
        // Intermediate operations transform a stream into another stream.
        // They are lazy, meaning they don't execute until a terminal operation is invoked.

        // Sample list
        List<String> list = Arrays.asList("Akshit", "rohit", "datta");

        // Example of intermediate operations with lazy evaluation
        Stream<String> str = list.stream()
                .filter(x -> x.startsWith("A"))  // filters strings that start with "A"
                .limit(10);  // limits the number of elements to 10 (though in this case it's unnecessary as list size is smaller)

        // Terminal operation: counting the filtered elements
        long res = list.stream()
                .filter(x -> x.startsWith("A")).count();  // terminal operation, it will trigger execution

        System.out.println("Count of strings starting with 'A': " + res);

        // Corrected: convert all strings in the stream to uppercase
        Stream<String> stringStream = list.stream().map(String::toUpperCase);  // Applies toUpperCase() on each element of the stream

        // Collect the result into a list and print it
        List<String> upperCaseList = stringStream.collect(Collectors.toList()); //same
        List<String> upperCaseList1 = stringStream.toList(); //same
        System.out.println("Uppercase List: " + upperCaseList);
         Stream<String> sorted = list.stream().sorted((a,b)-> a.length() - b.length()); // same
        Stream<String> sorted1 = list.stream().sorted(Comparator.comparingInt(String::length)); //same
        list.stream().filter(x -> x.startsWith("A")).distinct().count();

        //skip

        list.stream().filter(x -> x.startsWith("A")).distinct().skip(10).limit(100);



    }
}
