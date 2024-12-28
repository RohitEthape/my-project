package maths;

public class ReverseNo {
        public int reverse(int x) {
            int rev = 0;

            while (x != 0) {
                int last = x % 10;

                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && last > Integer.MAX_VALUE % 10)) {
                    return 0;
                }
                if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && last < Integer.MIN_VALUE % 10)) {
                    return 0;
                }

                rev = rev * 10 + last;
                x = x / 10;
            }

            return rev;
        }



        public boolean isPalindrome(int x) {    //121

            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }

            int rev = 0;

            while (x > rev) {
                int last = x % 10;  //121
                rev = rev * 10 + last; //121
                x = x / 10;
            }
            return x == rev || x == rev / 10;
        }


}






