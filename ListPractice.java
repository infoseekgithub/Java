
import java.util.*;

class ListPractice {


  static HashMap<Integer, Integer> getHash(int[] arr) {

    Map<Integer, Integer> map = new HashMap<>();

    Integer key, value;

    for (int i = 0; i < arr.length; i++) {

       if (i%3 == 0) {
          key = arr[i];
       } else if (i%3 == 1) {
          value = arr[i];
          map.put(key, value);
          key = null;
          value = null;
       }

    }
    if (key != null) {
          map.put(key, null);
    }

    return map;
  }


  public static void main(String[] args) {

    int[] a = {0, 1, 2, 3};
    int[] b = {0, 1, 2, 3, 4};
    int[] c = {0, 1, 2, 3, 4, 5};

    System.out.println(getHash(a));
    System.out.println(getHash(b));
    System.out.println(getHash(c));

  }

}
