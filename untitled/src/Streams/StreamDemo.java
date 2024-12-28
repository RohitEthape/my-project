package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo extends Exception{
    public  static void main(String[]args){
        // what is Stream
        // a sequence of elements supporting finctional and declarative programming
        // source, intermediate operations and terminal operation
        // Stream is interface that supports sequence of elements supporting and aggregate operations.
        /*
        How to create stream
        1 . from collection
         List<Integer> num = Arrays.asList(1,2,3,4,8);
        Stream<Integer> stream= num.stream();
       2 . from Arrays
        String[] arr = {"w","e"};
        Arrays.stream(arr);
        3 .
        Stream<Integer> strr = Stream.of(1,2,3);
        4 . Infinite Stream
                Stream<Integer> st = Stream.generate(() -> 1).limit(100);
         Stream<Integer> st = Stream.generate(() -> 1); // infinite stream with value of 1
         5 . from iterator
                     Stream.iterate(1,x -> x+1).limit(100).collect(Collectors.toList());

         */

        List<Integer> num = Arrays.asList(1,2,3,4,8);
       // Stream<Integer> stream= num.stream();
         System.out.println( num.stream().filter(x -> x % 2 ==0).count());

            Stream.iterate(1,x -> x+1).limit(100).collect(Collectors.toList());


    }
}
