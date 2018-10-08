

class LastWordLength{

   static int getLastWordLength(String str) {
      int endW = str.length() - 1;
      while(endW >= 0 && str.charAt(endW) == ' ') {
          endW--;
      }  

      int startW = endW;

      while(startW >=0 && str.charAt(startW) != ' ') {
         startW--;
      }

      return endW - startW;

   }


  public static void main(String[] args) {
 
       System.out.println(getLastWordLength(""));
       System.out.println(getLastWordLength(" a"));
       System.out.println(getLastWordLength("a "));     
       System.out.println(getLastWordLength("a bc def"));
       System.out.println(getLastWordLength(" a bc def "));
  }

}
