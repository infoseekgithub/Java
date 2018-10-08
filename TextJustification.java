import java.util.List;
import java.util.ArrayList;

class TextJustification {

static String getWhitespace(int i) {

   StringBuilder sb = new StringBuilder();

   for (int j = 0; j < i; j++) {

      sb.append(" ");
   }

   return sb.toString();
}


static List<String> justify(String[] text, int lineWidth) {


    int start = 0, end = 1;
    int words = 1, whitespace = 0;
    int len = text[0].length();
    int wordsAll = text.length;

    List<String> ret = new ArrayList<>();

    while (start < wordsAll) {
        end = start + 1;

//        while (end < wordsAll &&  len + text[end].length() + 1 <=  lineWidth) {
//ambigious definition of variable 'len', based on later use of 'len', it should be the len of words only

        while (end < wordsAll &&  len + text[end].length() + end - start <=  lineWidth) { //each word should have at least 1 whitespace after it, except the last word

             //len+= text[end].length() + 1; //ambigious definition of variable 'len', based on later use of 'len', it should be the len of words only
             len+= text[end].length();
             end++;
        }

        if (end == wordsAll) { // "end = wordsAll", last line. Note that last line is left-justification, not full-justification

            words = end - start;
            StringBuffer sb = new StringBuffer();
            for (int i = start; i < end - 1; i++) {
               sb.append(text[i]);
               sb.append(" "); //"words - 1" words has one whitespace, last word does not have to have.
            }

            sb.append(text[end-1]);
            sb.append(getWhitespace(lineWidth - len - (words - 1))); //"words - 1" words has one whitespace, last word does not have to have.

            ret.add(sb.toString());
            break;

        } else {  //  (len + text[end].length() + words >  lineWidth)
             words = end - start;
             StringBuilder sb = new StringBuilder();

             if (words == 1) { //"words == 1" case is also left-justification
                whitespace = lineWidth - len;
                sb.append(text[start]);
	        sb.append(getWhitespace(whitespace));
             } else {
                whitespace = (lineWidth - len)/(words - 1);
                for (int i = start; i < end; i++) {
                   sb.append(text[i]);
                   if (i < (lineWidth - len)%(words - 1) ) {
                      sb.append(getWhitespace(whitespace + 1));
                   } else if (i < end - 1) {  //end word of line does not have whitespace
                      sb.append(getWhitespace(whitespace));
                   }

                }

             }

             ret.add(sb.toString());
             start = end;
             len = text[start].length();
         }

    } // while loop

    return ret;

}


public static void main(String[] args) {

   String[] text1 = new String[]{"Love"};
   String[] text2 = new String[]{"I", "like", "you"};
   String[] text3 = new String[]{"I", "like", "to", "talk", "with", "you"};
   int len = 11;
   System.out.println(justify(text1, len)); 
   System.out.println(justify(text2, len));
   System.out.println(justify(text3, len));

}


}
