class Node {
   int val;
   Node next;

   Node(int v) {
      this.val = v;
      this.next = null;
   }

   public String toString() {
      Node current = this;
      StringBuilder builder = new StringBuilder();
      while (current != null) {
         builder.append(current.val);
         builder.append("->");
         current = current.next;
      }
      return builder.substring(0, builder.length() - 2);
   }
}



class AddTwoNumbers {

     Node addTwoNumbers(Node num1, Node num2) {

         Node head = new Node(0);
         Node current = head;
         int sum = 0;
         int carryover = 0;

         while (num1 != null || num2 != null) {

              sum = 0;
              if (num1 != null) {
                   sum += num1.val;
                   num1 = num1.next;
              }
              if (num2 != null) {
                   sum += num2.val;
                   num2 = num2.next;
              }

              sum += carryover;
              carryover = sum/10;

              current.next = new Node(sum%10);
              current = current.next;
          }

          if (carryover != 0) {
              current.next = new Node(carryover);
          }

          return head.next;
     }


     public static void main(String[] args) {

           Node num1 = null;
           Node num2 = null; // must explicitly assign null if you want to test null.

           AddTwoNumbers calc = new AddTwoNumbers();

           System.out.println(calc.addTwoNumbers(num1, num2));

           num1 = new Node(9);
           System.out.println(calc.addTwoNumbers(num1, num2));

           num2 = new Node(8);
           System.out.println(calc.addTwoNumbers(num1, num2));

           num1.next = new Node(1);
           System.out.println(calc.addTwoNumbers(num1, num2));

           num2.next = new Node(8);
           System.out.println(calc.addTwoNumbers(num1, num2));

           num2.next.next = new Node(1);
           System.out.println(calc.addTwoNumbers(num1, num2));

     }


}
