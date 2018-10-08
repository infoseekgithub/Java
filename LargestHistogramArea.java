
import java.util.LinkedList;

class LargestHistogramArea {


      static int getLargestHistogramArea(int[] height) {
          
           int max = 0;
           LinkedList<Integer> mystack = new LinkedList<Integer>();
          
           for (int i = 0; i <= height.length; i++) {

               int curr = (i==height.length)?0:height[i];
             
               while (mystack.size() > 0 && curr < height[mystack.getLast()]) {
               
                         int poppedIndex = mystack.removeLast();
                         int areaSpanLeft = (mystack.size()>0)?(mystack.getLast() + 1): 0;
                         int areaSpan = i - areaSpanLeft;
                         int area = areaSpan * height[poppedIndex];
                         max = (max < area)?area:max;
                }
               
                mystack.addLast(i);              
           }

           mystack.clear();
           return max;
      }


      public static void main(String[] args) {

          System.out.println(getLargestHistogramArea(new int[]{}));
          System.out.println(getLargestHistogramArea(new int[]{1}));
          System.out.println(getLargestHistogramArea(new int[]{1,2}));
          System.out.println(getLargestHistogramArea(new int[]{2,1}));
          System.out.println(getLargestHistogramArea(new int[]{1,2,1}));
          System.out.println(getLargestHistogramArea(new int[]{2,1,2}));
          System.out.println(getLargestHistogramArea(new int[]{1,2,3}));
          System.out.println(getLargestHistogramArea(new int[]{1,3,2}));
          System.out.println(getLargestHistogramArea(new int[]{3,2,1}));
          System.out.println(getLargestHistogramArea(new int[]{3,1,2}));
          System.out.println(getLargestHistogramArea(new int[]{2,1,3}));
          System.out.println(getLargestHistogramArea(new int[]{2,3,1}));
          System.out.println(getLargestHistogramArea(new int[]{1,1,1}));
      }

}
