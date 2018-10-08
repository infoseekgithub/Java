
class MaxSubarray{

   static int getLargestSum(int[] arr) {


      int max = 0;
      int maxUsingCurrent = 0;

      for (int i = 0; i < arr.length; i++) {
        
         maxUsingCurrent = (maxUsingCurrent > 0)?(maxUsingCurrent + arr[i]):arr[i];

         max = (maxUsingCurrent > max)?maxUsingCurrent:max;
      }
      return max;

   }


  public static void main(String[] args){

    System.out.println(getLargestSum(new int[]{}));

    System.out.println(getLargestSum(new int[]{-1}));

    System.out.println(getLargestSum(new int[]{1}));

    System.out.println(getLargestSum(new int[]{-1, -2}));

    System.out.println(getLargestSum(new int[]{-1, 2}));

    System.out.println(getLargestSum(new int[]{1, -2}));

    System.out.println(getLargestSum(new int[]{0, 1, -1, -1, 1}));

  }


}
