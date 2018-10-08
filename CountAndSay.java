class CountAndSay{

   static String countSay(int n) {

       String str = "1";

       StringBuilder sb = new StringBuilder();

       for (int j = 2; j <= n; j++ ){

               int counts = 1;
              
               for (int k = 1; k < str.length(); k++) {

                   if (str.charAt(k) == str.charAt(k-1)) {

                       counts++;

                   } else {

                        sb.append(counts).append(str.charAt(k-1));

                        counts = 1;

                   }

               } //for k loop    

               // here, k == str.length()

               sb.append(counts).append(str.charAt(str.length() - 1)); 
               str = sb.toString();
               sb.setLength(0);  //empty the stringbuider


       } // for j loop

       return str;

    }


    public static void main(String[] args) {

       System.out.println(countSay(1));         

       System.out.println(countSay(2));

       System.out.println(countSay(3));

       System.out.println(countSay(4));

       System.out.println(countSay(5));

    }

}



