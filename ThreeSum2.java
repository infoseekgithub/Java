import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class ThreeSum2{

   //Return the values of the 3 elements, not the original indexes, since array will be sorted.
   static List<List<Integer>> getThreeSum(int[] arr, int target){

      List<List<Integer>> ret = new ArrayList<List<Integer>>();
      int arrLen = arr.length;
      // int i = 0, j = arrLen - 1, k = 1;
      // Should not fix two end points, and move the third one within the two end points. 
      // Reason: You have to fix one element, and find the other two end points.

      int i = 0, k = 1, j = arrLen - 1;

      if (arrLen < 3) {
         return ret;
      }

      //First sort the array
      Arrays.sort(arr);

      while (i  < arrLen - 2) {  // i, k, j must be three distinct array elements
         //setting the other two points for each i
         k = i + 1;
         j = arrLen - 1;

/* Nice to have the following gating test, but not necessary.
         if (arr[i] + arr[k] + arr[k + 1] > target) {
            break; // no other possibilities
	 } else if (arr[i] + arr[j] + arr[j - 1] < target) {
            i++; //this 'i' won't work, move to next i
            continue;
         }
*/
	 while (k < j) {
            if (arr[i] + arr[k] + arr[j] == target) {
               List<Integer> tmpList = new ArrayList<>();
	       tmpList.add(arr[i]);
	       tmpList.add(arr[k]);
	       tmpList.add(arr[j]);
               ret.add(tmpList);
               
	       //Remove possible duplicates
	       k++;
               j--;

               //wrong. Enless loop
	       //while (k < j) {
               //  if (arr[k] == arr[k-1]) {
	       //        k++;
	       //  }
	       //}

	       while (k < j && arr[k] == arr[k-1]) {
	          k++;
	       }
	       while (k < j && arr[j] == arr[j+1]) {
	          j--;
	       }
               // In equal case, both k and j should be updated, and exclude all their dups


	    } else if (arr[i] + arr[k] + arr[j] < target) {
               k++; 
               //In this condition, should remove dup of arr[k] cases
	       while (k < j && arr[k] == arr[k-1]) {
	          k++;
	       }
               // In 'less' case, k should ++, and should exclude all its dups

            } else {
               j--;
               while (k < j && arr[j] == arr[j+1]) {
                  j--;
               }
               // In 'more' case, j should --, and should exclude all its dups
            } 

         } //while k < j

         i++;

         // Further remove duplicates of arr[i], and arr[j]
         while (i < arrLen - 2  && arr[i] == arr[i-1]) {
            i++;
         };
         // when updating i in the outer loop, should remove dups of arr[i]


      } // while i < arrLen - 2
    
      return ret;

   }


   public static void main(String[] args) {

	System.out.println(getThreeSum(new int[]{1}, 1));
	System.out.println(getThreeSum(new int[]{1, 2}, 1));

	System.out.println(getThreeSum(new int[]{1, 0, -1}, 0));
	System.out.println(getThreeSum(new int[]{0, 1, 0, -1}, 0));
	System.out.println(getThreeSum(new int[]{1, -1,  0, -1}, 0));

	System.out.println(getThreeSum(new int[]{1, 2, 0, 4, 3, 5, 0, 1, 2, 6, 3, 3, 3, 6, 7}, 6));
	System.out.println(getThreeSum(new int[]{0, 0, 1, 1, 2, 2, 3, 3, 3, 3, 4, 5, 6, 6, 7}, 6));
    }

}
