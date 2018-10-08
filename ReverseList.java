

class ListNode {

   int val;
   ListNode next;

   ListNode(int val) {
      this.val = val;
   }

   @Override
   public String toString() {

      StringBuilder sb = new StringBuilder();
      ListNode cur = this;
      while (cur != null) {
          sb.append(cur.val).append("->");
          cur = cur.next;
      }
      return sb.substring(0, sb.length() - 2);
   }
}

class ReverseList {

   static ListNode  reverse(ListNode input) {

      if (input == null) return null;
 
      ListNode prev = input, cur = input.next;
      input.next = null;

      while (cur != null) {

           ListNode tmp = cur.next; //store
           cur.next = prev; //reverse the pointer
          
           prev = cur; //iterate next item
           cur = tmp; //iterate next item
      }

      return prev;
   }


   public static void main(String[] args) {

      ListNode list = null;
      System.out.println(reverse(list));

      list = new ListNode(1);
      System.out.println(reverse(list));

      list.next = new ListNode(2);
      list.next.next = new ListNode(3);
      System.out.println(reverse(list));

   }

}
