import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static boolean isPrimeNo(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public static int generatePermutation(int n){
        String strNum = String.valueOf(n);
        Set<String> permutations = new HashSet<>();
        permute(strNum, 0, strNum.length()-1,permutations );

        for (String permutation: permutations){
            int permutationNum = Integer.parseInt(permutation);

            if(isPrimeNo(permutationNum)){
                return permutationNum;
            }
        }
        return 0;
    }

    public static void permute(String  str, int l, int r, Set<String> permutations){
        if(l == r){
            permutations.add(str);
        }
        else{
            for(int i=l;i<=r;i++){
                str = swap(str, l, i);
                permute(str, l+1, r, permutations);
                str = swap(str, l,i);
            }
        }
    }
    public static String swap(String str, int i, int j){
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("PLease Enter a number");
        int num = sc.nextInt();
        System.out.println(generatePermutation(num));

    }
}