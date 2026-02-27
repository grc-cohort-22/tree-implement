import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<Integer>(10, null, null);

    TreeNode<String> stringRoot = new TreeNode<String>("hello", null, null);
    stringRoot.left = new TreeNode<String>("how", null, null);
    stringRoot.left.left = new TreeNode<String>("are", null, null);
    stringRoot.left.right = new TreeNode<String>("you", null, null);

    stringRoot.right = new TreeNode<String>("I", null, null);
    stringRoot.right.left = new TreeNode<String>("am", null, null);
    stringRoot.right.right = new TreeNode<String>("so", null, null);
    stringRoot.right.right.right = new TreeNode<String>("good", null, null);

    TreeNode<Integer> megaRoot = new TreeNode<Integer>(1, null, null);
    TreeNode<Integer> current = megaRoot;

    for (int i = 2; i<=50000; i++) {
      current.right = new TreeNode<Integer>(i, null, null);
      current = current.right;
    }

    // preOrderIter(megaRoot);
    levelOrder(stringRoot);
    
    // System.out.println("Preorder recursive");
    // preorder(root);
    // System.out.println("Preorder iterative");
    // preOrderIter(root);

    // preorder(megaRoot);
    // preorder(root);
    // postorder(root);
    // inorder(stringRoot);
    // printGreater(root, 1);
    // System.out.println(countNodes(root));
    // Map<String, Integer> counts = new HashMap<>();
    // System.out.println(toMap(stringRoot));
  }

  // Print a tree rooted at the given node in pre-order 
  public static void preorder(TreeNode<?> node) {
    // if null, return
    if(node == null) {
      return;
    }
    // print value
    System.out.println(node.value);
    // traverse left
    preorder(node.left);
    // traverse right
    preorder(node.right);
  }
  
  public static <T> void preOrderIter(TreeNode<T> node) {
    Stack<TreeNode<T>> stack = new Stack<>();
    
    stack.push(node);

    while (!stack.isEmpty()) {
      TreeNode<T> current = stack.pop();

      if (current == null) continue;

      System.out.println(current.value);
      stack.push(current.right);
      stack.push(current.left);
      
    }
  }

  public static <T> void levelOrder(TreeNode<T> node) {
    Queue<TreeNode<T>> stack = new LinkedList<>();
    
    stack.add(node);

    while (!stack.isEmpty()) {
      TreeNode<T> current = stack.poll();

      if (current == null) continue;

      System.out.println(current.value);
      stack.add(current.left);
      stack.add(current.right);
      
    }
  
  }

  public static <T> Map<T, Integer> toMap(TreeNode<T> node){
    Map<T, Integer> counts = new HashMap<>();
    toMap(node, counts);
    return counts;
  }

  private static <T> Map<T, Integer> toMap(TreeNode<T> node, Map <T, Integer> counts) {
    if (node == null) {
      return counts;
    }
    counts.put(node.value, counts.getOrDefault(node.value, 0) + 1 );
    toMap(node.left, counts);
    toMap(node.right, counts);
    return counts;
  }

  public static int countNodes(TreeNode<?> node){

    if (node == null) return 0;
    return countNodes(node.left) + countNodes(node.right) + 1;
    // int leftCount = countNodes(node.left);
    // int rightCount = countNodes(node.right);
    // int overallCount = leftCount + rightCount + 1;
    // return overallCount;
  }

  public static void printGreater(TreeNode<Integer> node, int threshold) {
    if (node == null) return;

    if (node.value > threshold){
      System.out.println(node.value);
    }

    printGreater(node.left, threshold);
    printGreater(node.right, threshold);
  }


  public static void postorder(TreeNode<?> node){
    if (node == null) return;
    postorder(node.left);
    postorder(node.right);
    System.out.println(node.value);
  }

  public static void inorder(TreeNode<?> node){
    if (node == null) return;

    inorder(node.left);
    System.out.println(node.value);
    inorder(node.right);
  }
}
