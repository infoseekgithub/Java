class InsertPosition {

/* Good way
    static int findInsertPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = (right + left) >> 1;
        while (left <= right) {
            if (target <= nums[mid]) right = mid - 1;
            else left = mid + 1;
            mid = (right + left) >> 1;
        }
        return left;
    }

*/
   static int findInsertPosition(int[] arr, int num) {



/* Bad way */
     int len = arr.length;
     if (len == 0) {
        return 0;
     }
 
     int start = 0, end = len - 1;
     int mid = (start + end)/2;

     if (num <= arr[0]) {
        return 0;
     }


     if (num == arr[len -1]) {

        return len -1;
     }

    if (num > arr[len -1] ){
      return len;
    }


    while (start < end -1) {  // if use "start < end", there could be infinite loop e.g. ([0, 2], 1)

         if (arr[mid] == num) {
             return mid;
         } else if (arr[mid] < num) {
            start = mid;                      //with this, arr[start] is always smaller than num
            mid = (start + end)/2;
         } else {
            end = mid;                 //with this, arr[end] is always larger than num
            mid = (start + end)/2;
         }
         // start can never be larger than end, the end-of-loop condition is actually start==end


      }
      return end;

   }



   public static void main(String[] args) {

   int[] a = {};
   System.out.println(findInsertPosition(a, 1));

  
   int[] b = {2};
   System.out.println(findInsertPosition(b, 1));
   System.out.println(findInsertPosition(b, 3));

   int[] c = {1,3};
   System.out.println(findInsertPosition(c, 0));
   System.out.println(findInsertPosition(c, 1));
   System.out.println(findInsertPosition(c, 2));
   System.out.println(findInsertPosition(c, 3));
   System.out.println(findInsertPosition(c, 4));


   int[] d = {1, 2, 4, 6};
   System.out.println(findInsertPosition(d, 0));
   System.out.println(findInsertPosition(d, 1));
   System.out.println(findInsertPosition(d, 2));
   System.out.println(findInsertPosition(d, 3));
   System.out.println(findInsertPosition(d, 5));
   System.out.println(findInsertPosition(d, 6));
   System.out.println(findInsertPosition(d, 7));

  }

}
