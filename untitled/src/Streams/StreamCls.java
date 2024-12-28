package Streams;

import java.util.function.Function;
import java.util.function.Predicate;

public class StreamCls {

    public static void main (String[]args){

      //  Thread t1 = new Thread();

        // lambda expression is a annonymous function
        Thread t2 = new Thread(() -> {
            System.out.println("Run");
        });

        MathOperation mathOperation = ((a, b) -> a+b);
       int res= mathOperation.operation(3,6);
        System.out.println(res);

        //predicate is a functional interface
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(4));
        Predicate<String> str = x -> x.startsWith("A");
        str.test("Ankit"); // return true
        Predicate<String> stt = x -> x.toLowerCase().endsWith("t");
        Predicate<String> endWith = str.and(stt);
        endWith.test("Anurag"); // return false

        // function is also a functional interface
        Function<Integer,Integer> returns = x -> 2 *x;

        System.out.println(returns.apply(100));
    }
}
 class Task implements Runnable{

    @Override
    public void run() {
        System.out.println("Run");
    }
}
@FunctionalInterface
interface MathOperation{  //functional interface
    int operation(int a, int b);
}
