
import java.util.HashMap;
import java.util.HashSet;

class LongestRepeatingK {

   static int getLongestRepeatingK(String str, int k) {

       if (str == null) return -1;

       int strLen = str.length();
       int start = 0;
       int max = 0, tmpMax = 0;

       HashMap<Character, Integer> freqMap = new HashMap<>();
       HashSet<Character> lessKset = new HashSet<>();

       if (k <= 0) return strLen;
       if (strLen < k) return -1;
       if (strLen > 0 && k == 1) return strLen;

       for (int i = 0; i < strLen; i++) {
           freqMap.put(str.charAt(i), (freqMap.containsKey(str.charAt(i))?freqMap.get(str.charAt(i)):0 ) +1 );
       }

      for (Character c : freqMap.keySet()) {
          if (freqMap.get(c) < k) {
              lessKset.add(c);
          }
      }

      if (lessKset.size() == 0) {
          return strLen;
      }

      if (lessKset.size() == freqMap.size() ) {
          return 0;
      }

      for (int i = 0;  i < strLen; i++) {
           if (lessKset.contains(str.charAt(i))) {
                if (start < i) {
                     tmpMax = getLongestRepeatingK(str.substring(start, i), k);
                     max = max<tmpMax?tmpMax:max;
                }
                start = i + 1; //'start' should increase whenever charAt(i) is in lessKset
           }
      }
  
      if (start < strLen) {
           tmpMax = getLongestRepeatingK(str.substring(start, strLen), k);
           max = max<tmpMax?tmpMax:max;
      }   

      return max;

  }


  public static void main(String[] args) {

     System.out.println(getLongestRepeatingK(null, 0));
     System.out.println(getLongestRepeatingK(null, 1));
     System.out.println(getLongestRepeatingK("", 0));
     System.out.println(getLongestRepeatingK("", 1));
     System.out.println(getLongestRepeatingK("", -1));
     System.out.println(getLongestRepeatingK("abbac", 1));
     System.out.println(getLongestRepeatingK("abbac", 2));
     System.out.println(getLongestRepeatingK("abbac", 3));
     System.out.println(getLongestRepeatingK("abbaccbbaab", 2));
     System.out.println(getLongestRepeatingK("abbabaccbbaabbaa", 3));
  }


}
