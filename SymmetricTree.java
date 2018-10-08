
import java.util.LinkedList;

class Tree {

   int val;
   Tree left;
   Tree right;

   Tree(int v) {
       this.val = v;
       this.left = null;
       this.right = null;
   }

}


class SymmetricTree {

    boolean isSymmetric(Tree t) {

        boolean ret;
        LinkedList<Tree> left = new LinkedList<>();
        LinkedList<Tree> right = new LinkedList<>();
 
        if (t == null) return true;
        if (t.left == null || t.right == null) return t.left == t.right;

        left.addLast(t.left);
        right.addLast(t.right);

        while ( !(left.isEmpty()) || !(right.isEmpty()) ){

                if (left.isEmpty() != right.isEmpty()) return false;
                Tree leftPop = left.removeFirst();
                Tree rightPop = right.removeFirst();

                if (leftPop.val != rightPop.val) return false;

                if (leftPop.left != null) left.addLast(leftPop.left);
                if (leftPop.right != null) left.addLast(leftPop.right);

                if (rightPop.right != null) right.addLast(rightPop.right);
                if (rightPop.left != null) right.addLast(rightPop.left);

        }
       

        return true;

    }


   public static void main(String[] args) {

      SymmetricTree stree = new SymmetricTree();

      Tree t = null;
      System.out.println(stree.isSymmetric(t));     

      t = new Tree(1);
      System.out.println(stree.isSymmetric(t));     

      t.left = new Tree(2);
      System.out.println(stree.isSymmetric(t));    

      t.right = new Tree(3);
      System.out.println(stree.isSymmetric(t));    

      t.right.val = 2;
      System.out.println(stree.isSymmetric(t));    

      t.left.left = new Tree(3);
      t.left.right = new Tree(4);

      t.right.left = new Tree(3);
      t.right.right = new Tree(4);
      System.out.println(stree.isSymmetric(t));    

      t.right.left.val = 4;
      t.right.right.val = 3;
      System.out.println(stree.isSymmetric(t));     


      System.out.println(Integer.MAX_VALUE%10);
      System.out.println(Math.abs(Integer.MIN_VALUE%10));

   }


}
