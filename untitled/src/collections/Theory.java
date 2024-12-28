package collections;

import java.lang.reflect.Field;
import java.util.*;

public class Theory {

    public static void main(String []args) throws Exception {
        /*
        List increase size dynamically   -- Initial capacity is 10.
        Arraylist can increase size by  1.5 times the current capacity

         */
// Type 1
        ArrayList<Integer> arr= new ArrayList<>();
        arr.add(1);
        arr.add(11);
        arr.add(13);
        arr.get(0);
        System.out.println(arr.size());
        for(int x : arr){
            System.out.println(x);
        }
        arr.remove(1);   // remove by index
        arr.remove(Integer.valueOf(1));  // it will remove by value -- one is object
        arr.set(2,7);
        
        // converting list to array
        Object[] array = arr.toArray();
        // for mention type of array
        arr.toArray(arr.toArray(new Integer[0]));

        // to sort list  in assending order by default
        Collections.sort(arr);
        System.out.println(arr);

        // second type for sort
        arr.sort(null);   // it will sort list in assending order
        arr.sort((a,b) -> a -b ); // for sorting using a lambda expressions (asc)
        arr.sort((a,b) -> b-a); // for sorting using a lambda expressions (desc)


        // Comparator to sort in desc and asc order by custom logic by using compare(o1,o2) which is comparing two objects of same type by usimg lambda expretions which implemets this class

        arr.sort(new StrinLengthComparator());


        getArrayListCapacity(arr);
// Type 2
        List<String> list= Arrays.asList("Mondat" , "tues");
        list.add("thur");   // it will return fix size we can only modify . cant add
        list.add(1,"thur");
        list.sort(new StrinLengthComparator1());
        // we can use lambda exprectios directly instead of comparable
        list.sort((a,b)-> a.length() - b.length());  // assending
        list.sort((a,b) -> b.length() - a.length());  // desc orders
// Type 3 for creating list
        List<Integer> list1 = List.of(1,2,3,4);
        list1.add(4);   //  . cant add
        list1.set(1,7);  // unmodified list
    }

// to print capacity by using reflection   for this You need to enable VM options in configuration sitting and add this command
   //   --add-opens java.base/java.util=ALL-UNNAMED

    public static void getArrayListCapacity(ArrayList<?> list) throws NoSuchFieldException, IllegalAccessException {
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true); // Make private field accessible
        Object[] elementData = (Object[]) field.get(list);
        System.out.println("capacity"+ elementData.length);
    }


}

class StrinLengthComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1,Integer o2){

        /*
         // return int will shows order of sorting
         1. if return number is positive then it will sort in ascending order ex. = 5-3 = 2
         2. if return number is negative then it will sort in desc order  ex. 3-5 = -2
         3. if return number is zero then it will sort  order is same  ex = 3-3 = 0
            use this logic blindly in string as well
         */
        return (o2-o1);
       // return (o1 - o2);

    }
}

class StrinLengthComparator1 implements Comparator<String>{

    @Override
    public int compare(String o1,String o2){

        /*
         // return int will shows order of sorting
         1. if return number is positive then it will sort in ascending order ex. = 5-3 = 2
         2. if return number is negative then it will sort in desc order  ex. 3-5 = -2
         3. if return number is zero then it will sort  order is same  ex = 3-3 = 0
            use this logic blindly in string as well

            o1    o2
            "ok" "bue"
         */


        return (o2.length() - o1.length());
       //  return (o1.length() - o2.length());

    }
}
