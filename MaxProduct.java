class MaxProduct {

   static int getMaxProduct(int[] arr) {

         int max = Integer.MIN_VALUE;

         // Keep tracking the product from the first element, or from the element that is after 0, this may be either the largest positive product, or the largest negative product. The largest negative product can turn into the largest positive product, with appearing a negative element.

         int largestPositive = 1;
         int largestNegative = 1;
         //why init them to 1?
         // if currentElement >0, largestPositive = largestPositive * currentElement
         // Init largestPositive to 1, so the above is true for the first element if it is positive

        //what about initializing largestNegative to 1? It can be used to track the case that there has been no negative element yet in the array. In this case, there is no largestNegative. Setting it to 1 is actually an artificial value. Actually, you can also set it to Integer.MAX_VALUE; When largestNegative is not negative, its value will not participate in calculation of any product.

        largestNegative = Integer.MAX_VALUE;

         for (int i = 0; i < arr.length; i++) {

               if (arr[i] > 0) {

                  if (largestNegative < 0) {
                      largestNegative = largestNegative * arr[i];
                  } else { //largestNegative > 0, meaning there has been no negative element before arr[i]
                      // Nothing to do, keep largestNegative unchanged.
                  }        
                  //if largestNegative is negative, then update it with largestNegative * arr[i]; otherwise it is 1, and there still has no negative elements yet, so keep it to be 1

                  largestPositive = largestPositive * arr[i];


               } else if (arr[i] < 0) {
                   //cross assigning, thus needs to store a value
                   int largestPositiveBak = largestPositive;

                   if (largestNegative < 0) { //there has been a negative element before arr[i]
                       largestPositive = largestNegative * arr[i];
                   } else { //largestNegative > 0, meaning arr[i] is the first negative element
                       largestPositive = 1;  //recounting largestPositive after the first negative element, e.g. 2, -1, 3, 4. Recounting largestPositive after element '-1'
                   }

                   largestNegative = largestPositiveBak * arr[i]; 
                   //largestNegative inits to 1, but once there is an negative element, it will never go back to 1
                   //In comparison, largestPositive inits to 1, gets to be larger than 1 if there is a positive element larger than 1, or there are two negative elements with product larger than 1, but it is reset to one after the first negative element.

                  //In sum, there are two products to track: product1 is the product of  all elements from the beginning; product2 is the product of elements after the first negative element. These two products must be of opposite sign, i.e. one is positive, the other must be negative. That is to say, one is largestPositive, the other must be largestNegative, vice versa.

               } else { //arr[i] == 0
                 // This is a special case. Both of the two products end up to be 0 when arr[i] == 0. Resetting and restarting

                 largestNegative = Integer.MAX_VALUE;
                 largestPositive = 1;   //Note: if all elements of the array are 0, the calculation will be wrong. The problem assumes that there are at lease 1 positive element

               }

               //Update 'max' whenever there is a new value of largestPositive
               max = max >largestPositive?max:largestPositive; 

         }

         return max;

   }


   public static void main(String[] args) {

         System.out.println(getMaxProduct(new int[] {1, 2, 3}));
         System.out.println(getMaxProduct(new int[] {-1, -2, -3}));
         System.out.println(getMaxProduct(new int[] {2, 3, -1, 3, 4}));
         System.out.println(getMaxProduct(new int[] {2, 3, -1, 3, 4, -1}));
         System.out.println(getMaxProduct(new int[] {2, 3, -1, 3, 4, -1, 2}));
         System.out.println(getMaxProduct(new int[] {0, 2, 3, -1, 3, 4, -1, 2}));
         System.out.println(getMaxProduct(new int[] {2, 3, -1, 3, 0,  4, -1, 2}));
         System.out.println(getMaxProduct(new int[] {2, 3, -1, 3, 4, -1, 2, 0}));

   }

}
