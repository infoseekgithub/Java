class ListNode{

   int val;
   ListNode next;

   ListNode(int val) {

      this.val = val;
   }


   @Override
    public String toString() {
         ListNode cur = this;
         StringBuilder sb = new StringBuilder();

         while (cur != null) {

             sb.append(cur.val).append("->");
             cur = cur.next;
         }

         return sb.substring(0, sb.length() - 2);
    }

}



class ReverseKGroup {
/*
   static ListNode reverseK(ListNode input, int k) {

      if (k <= 0) return null; //invalid case

      if (k == 1) return input;


      ListNode head= input, tail = input, ret = null;
      ListNode prevSegmentTail = null; //stores the last element of a K-group
      int i = 1;
      while (tail != null) {

          if (i % k == 0) {
              //Found the tail
              ListNode cur = head.next, prev = head;
              while (cur != tail) {
                  ListNode tmp = cur.next;
                  cur.next = prev;

                  prev = cur; //iterate to next item
                  cur = tmp; //iterate to next item
              }

              head.next = tail.next; //head becomes tail
              tail.next = prev; //tail becomes head

              //for segment connection
              if (prevSegmentTail != null) prevSegmentTail.next = tail;
              prevSegmentTail = head;

              ret = (ret == null) ? tail:ret; //set 'ret' only once, the first tail.

              head = head.next;
              tail = head;
              i++;
          } else {
              tail = tail.next;
              i++;
          }
      }

      ret = (ret == null)?input:ret;  //if input has length smaller than k, then ret is null

      return ret;
   }

*/


    static ListNode reverseK(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode node = new ListNode(0), pre = node;
        node.next = head;
        for (int i = 1; head != null; ++i) {
            if (i % k == 0) {
                pre = reverse(pre, head.next);
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        return node.next;
    }

    static ListNode reverse(ListNode pre, ListNode next) {
        ListNode head = pre.next;
        ListNode move = head.next;
        while (move != next) {
            head.next = move.next;
            move.next = pre.next;
            pre.next = move;
            move = head.next;
        }
        return head;
    }


  public static void main(String[] args){

     ListNode list = null;
     System.out.println(reverseK(list, 2));

     list = new ListNode(1);
//     System.out.println(reverseK(list, -1));
//     System.out.println(reverseK(list, 0));
     System.out.println(reverseK(list, 1));
     System.out.println(reverseK(list, 2));

     list.next = new ListNode(2);
     
     list = reverseK(list, 1);
     System.out.println(list);
     list = reverseK(list, 2);
     System.out.println(list);

     list.val = 1;
     list.next.val = 2;
     list.next.next = new ListNode(3);
     list = reverseK(list, 2);
     System.out.println(list);

     list.val = 1;
     list.next.val = 2;
     list.next.next.val = 3;
     list = reverseK(list, 3);
     System.out.println(list);

     list.val = 1;
     list.next.val = 2;
     list.next.next.val = 3;
     list.next.next.next = new ListNode(4);
     list = reverseK(list, 2);
     System.out.println(list);

     list.val = 1;
     list.next.val = 2;
     list.next.next.val = 3;
     list.next.next.next.val = 4;
     list = reverseK(list, 3);
     System.out.println(list);

     list.val = 1;
     list.next.val = 2;
     list.next.next.val = 3;
     list.next.next.next.val = 4;
     list = reverseK(list, 4);
     System.out.println(list);

  }

}
