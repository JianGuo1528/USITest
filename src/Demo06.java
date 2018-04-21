import java.util.*;

public class Demo06 {
    public static void main(String[] args) {
        int[] i = {-1, 0, 1, 2, -1, -4};
        //-4, -1, -1, 0, 1, 2
        List<int[]> zeroSum = findZeroSum(i);

        for (int[] ints : zeroSum) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static List<int[]> findZeroSum(int[] arr) {
        List<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < arr.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        int[] targetArr = new int[]{arr[i], arr[j], arr[k]};
                        Arrays.sort(targetArr);
                        boolean flag = false;
                        for (int[] tempArr : list) {
                            flag = targetArr[0] == tempArr[0] && targetArr[1] == tempArr[1] && targetArr[2] == tempArr[2];
                            if (flag) {
                                break;
                            }
                        }
                        if (!flag) {
                            list.add(targetArr);
                        }
                    }
                }
            }
        }
        return list;
    }
}
