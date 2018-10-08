import java.util.List;
import java.util.ArrayList;

class GenerateParentheses {



     List<String> generate(int n) {

          List<String> ret = new ArrayList<String>();
          if (n == 0) return ret;
          helper(ret, "", 0, 0, n);
          return ret;
     }


    void helper(List<String> list, String partialString, int numLeft, int numRight, int targetNum) {

        if (numLeft == targetNum && numRight == numLeft) {
            list.add(partialString);
            return;
        }

        if (numLeft < targetNum) {
           helper(list, partialString + '(', numLeft + 1, numRight, targetNum);
        }
        if (numRight < numLeft) {
           helper(list, partialString + ')', numLeft, numRight + 1, targetNum);
        }
        return;

    }


   public static void main(String[] args) {

       GenerateParentheses gp = new GenerateParentheses();
       System.out.println(gp.generate(0));
       System.out.println(gp.generate(1));
       System.out.println(gp.generate(2));
       System.out.println(gp.generate(3));
  }


}
