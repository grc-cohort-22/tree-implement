import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;



public class Traversal {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<Integer>(10, null, null);
    // TreeNode root = new TreeNode<Integer>(10, null, null);
    root.left = new TreeNode<Integer>(9, null, null);
    root.left.left = new TreeNode<Integer>(5, null, null);
    root.left.right = new TreeNode<Integer>(2, null, null);

    root.right = new TreeNode<Integer>(15, null, null);
    root.right.left = new TreeNode<Integer>(-3, null, null);
    root.right.right = new TreeNode<Integer>(5,  null, null);
    root.right.right.right = new TreeNode<Integer>(22,  null, null);

    TreeNode<String> stringRoot = new TreeNode<String>("hello", null, null);
    stringRoot.left = new TreeNode<String>("how", null, null);
    stringRoot.left.left = new TreeNode<String>("are", null, null);
    stringRoot.left.right = new TreeNode<String>("hello", null, null);

    stringRoot.right = new TreeNode<String>("you", null, null);
    stringRoot.right.left = new TreeNode<String>("i", null, null);
    stringRoot.right.right = new TreeNode<String>("miss",  null, null);
    stringRoot.right.right.right = new TreeNode<String>("you",  null, null);

    TreeNode<Integer> megaRoot = new TreeNode<Integer>(1, null, null);

    TreeNode<Integer> current = megaRoot;

    for (int i = 2; i <= 50000; i++) {
      current.right = new TreeNode<Integer>(i, null, null);
      current = current.right;
    }

    levelOrder(root);
    //  preOrderIter(megaRoot);
    // System.out.println("Preorder recursive");
    // preorder(root);
    // System.out.println("preorder iterative"); 
    // preOrderIter(root);

    // // preOrder(root); // root in the beginning
    // postOrder(root); // root in the end
    // inOrder(root); // root in the middle
    // printGreater(root, 100);
    // System.out.println(countNodes(root));
    // Map<String, Integer> counts = new HashMap<>();
    // System.out.println(toMap(stringRoot));

  } 
    // print a tree routed at the given node in pre order
    public static void preOrder(TreeNode<?> node) {
      if(node == null) {// if full return
        return;
      }
      System.out.println(node.value);  // print value
      preOrder(node.left); // traverse left 
      preOrder(node.right); // traverse  right

    }
  
  public static <T> void preOrderIter(TreeNode<T> node) {
    Stack<TreeNode<T>> stack = new Stack<>();
    stack.push(node);

    while(!stack.empty()) {
      TreeNode<T> current = stack.pop();

      if (current ==null ) {
        continue;
      }

      // if (current != null) {
      System.out.println(current.value);
      stack.push(current.right); 
      stack.push(current.left);
    
    }
  }
     public static <T> void levelOrder(TreeNode<T> node) {
    Queue<TreeNode<T>> queue = new LinkedList<>();
    queue.add(node);

    while(!queue.isEmpty()) {
      TreeNode<T> current = queue.poll();

      if (current ==null ) {
        continue;
      }

      // if (current != null) {
      System.out.println(current.value);
      queue.add(current.left); 
      queue.add(current.right);
    
    }

  }
  public static <T> Map<T, Integer> toMap(TreeNode<T> node) {
    Map<T, Integer> counts = new HashMap<>();
    toMap(node, counts);
    return counts;
  }

  private static <T> void toMap(TreeNode<T> node, Map<T, Integer > counts) {
    if (node == null) {
      return;
    }
    // fill up the counts
    counts.put(node.value, counts.getOrDefault(node.value, 0) + 1);
    toMap(node.left, counts);
    toMap(node.right, counts);
  
  
  }


  public static int countNodes(TreeNode<?> node) {
    // if node is null : return 0;
    if (node == null) return 0;
    return 1 + countNodes(node.left) + countNodes(node.right);

    // or
    // return node == null? 0 : 1 + countNodes(node.left) + countNodes(node.right);


    // // leftCount = count nodes in left subtree
    // int leftCount = countNodes(node.left);
    // // rightCount = count nodes in right subtree
    // int rightCount = countNodes(node.right);
    // // overallCount = leftcount + rightcount + 1 --> 1 is th eparent
    // int overallCount = leftCount + rightCount + 1;
    // // return  overallCount
    // return overallCount;

  }
  public static void printGreater(TreeNode<Integer> node, int threshold) {
    if (node == null) return;
    if (node.value > threshold) {
      System.out.println(node.value);
    }
    printGreater(node.left, threshold);
    printGreater(node.right, threshold);

    
  }


    // print after recursion
        public static <T> void postOrder(TreeNode<T> node) {
          if (node == null) return;
          postOrder(node.left);
          postOrder(node.right);
          System.out.println(node.value);
        }

        public static <E> void inOrder(TreeNode<E> node) {
          if (node == null) return;
          inOrder(node.left);
          System.out.println(node.value);
          inOrder(node.right);
          
            
        }
      }


