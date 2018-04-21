import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo07 {
    public static void main(String[] args) {
        String str = "CH";
//        System.out.println(str.substring(0, 1) + str.substring(2, str.length()));
        System.out.println(str.substring(0, 2));
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
//        permutation("", sb.toString(), 0);

    }

    private static void permutation(String prefix, String str, int next) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i) + " ", str.substring(0, i) + str.substring(i + 1, n), next++);
            }
        }
    }

}
