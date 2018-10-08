import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class ThreeSum{


    List<List<Integer>> get3Sum(int[] arr) {

       List<List<Integer>> ret = new ArrayList<>();

       Arrays.sort(arr);

       int arrLen = arr.length;

       if (arrLen < 3) return ret;

       for (int i = 0; i < arrLen - 2; i++ ) {

           if (i != 0 && arr[i] == arr[i-1]) {
               i++;
               continue;  //bypass duplicated arr[i]
           }

           int j = i + 1, k = arrLen - 1;
           while (j < k) {
               int sum = arr[i] + arr[j] + arr[k];

               if (sum == 0) {
                  List<Integer> list = new ArrayList<Integer>();
                  list.add(arr[i]);
                  list.add(arr[j]);
                  list.add(arr[k]);
                  ret.add(list);
                  j++;
                  while (j < k && arr[j] == arr[j -1]) {
                      j++;
                  }

                  k--;
                  while (j < k && arr[k] == arr[k+1]) {
                      k--;
                  }

               } else if (sum > 0) {
                  k--;
                  while (j < k && arr[k] == arr[k+1]) {
                      k--;
                  }

               } else {
                  j++;
                  while (j < k && arr[j] == arr[j -1]) {
                      j++;
                  }

               }

           }


       }

       return ret;
    }


    public static void main(String[] args) {

          ThreeSum ts = new ThreeSum();

          System.out.println(ts.get3Sum(new int[]{}));

          System.out.println(ts.get3Sum(new int[]{1, 2}));

          System.out.println(ts.get3Sum(new int[]{1, 2, -3}));

          System.out.println(ts.get3Sum(new int[]{0, 0, 0, 0}));

          System.out.println(ts.get3Sum(new int[]{0, 1, 2, -3}));

          System.out.println(ts.get3Sum(new int[]{1, -1, 2, -2, 0, 3}));
    }

}
