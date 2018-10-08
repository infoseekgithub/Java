class Most2Distinct {

    static String getMost2Distinct(String s) {

         if (s == null || s.length() <= 2) {

            return s;
         }

         int start = 0, cur = 0, numOfRepeat = 0, maxLen = 0, maxStart = 0;
         char[] distinct = {0, 0};

         while (cur < s.length() ) {

              //populate 'distinct'
              if (distinct[0] == 0) {
                  distinct[0] = s.charAt(cur);
              } else if (distinct[1] == 0) {
                  distinct[1] = s.charAt(cur);
              }

              if (s.charAt(cur) != distinct[0] && s.charAt(cur) != distinct[1]) {
	          if (s.charAt(cur -1) == distinct[0]) {
		     distinct[1] = s.charAt(cur);
	          } else {
		     distinct[0] = s.charAt(cur);
	          }

	          if (cur - start > maxLen) {
		     maxLen = cur - start;
		     maxStart = start;
	          }

	          // renew 'start'
	          start = cur - numOfRepeat;

	      }

              if (cur == 0 || s.charAt(cur) != s.charAt(cur -1) ) {
                 numOfRepeat = 1;
              } else {
                 numOfRepeat++;
              }

              cur++;
         }

        
         if (cur - start > maxLen) {
             maxLen = cur - start;
             maxStart = start;
         }

         return s.substring(maxStart, maxStart + maxLen);

    }


   public static void main(String[] args) {

         System.out.println(getMost2Distinct(""));

         System.out.println(getMost2Distinct("a"));

         System.out.println(getMost2Distinct("ab"));

         System.out.println(getMost2Distinct("abac"));

         System.out.println(getMost2Distinct("abcbbbbcccbdddadacb"));

   }

}
