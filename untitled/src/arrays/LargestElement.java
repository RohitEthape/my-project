package arrays;

public class LargestElement {

    public int largest(int [] n){    // Time ->  O(N)
       int large;

        large= n[0];
        for (int j : n) {
            if (j > large) {
                large = j;
            }
        }
        return large;
    }

    public int Secondlargest(int [] n){   //Time ->  O(N)

       int sLarge = -1;
        int large = n[0];

        large= n[0];
        for (int j : n) {
            if (j > large) {
                sLarge= large ;
                large = j;
            } else if (j < large && j > sLarge ) {
                sLarge= j;
            }
        }
        return sLarge;
    }
}
