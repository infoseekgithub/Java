



class RemoveElement {


static int removeElement(int[] arr, int toRemove) {


   int indx = 0;
   for (int i = 0; i < arr.length; i++) {

       if (arr[i] != toRemove) {
            arr[indx++] = arr[i];
       }
   }

   return indx;

}


public static void main(String[] args) {

int[] a = {};

System.out.println(removeElement(a, 10));


int[] b = new int[1];

//b = {1};
System.out.println(removeElement(b, 0));


int[]  c = {10};
System.out.println(removeElement(c, 10));


int[] d = {1, 2, 10};
System.out.println(removeElement(d, 10));

int[] e = {10, 1, 2};
System.out.println(removeElement(e, 10));

int[] f = {1, 10, 2};
System.out.println(removeElement(f, 10));

int[] g = {1, 10, 10, 2};
System.out.println(removeElement(g, 10));

int[] h = {10, 10, 1, 2};
System.out.println(removeElement(h, 10));

int[] i = {10, 1, 10, 2};
System.out.println(removeElement(i, 10));

int[] j = {1, 2, 10, 10};
System.out.println(removeElement(j, 10));

int[] k = {10, 10, 10};
System.out.println(removeElement(k, 10));


}


}
