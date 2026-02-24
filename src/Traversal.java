import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<Integer>(10, null, null);
    root.left = new TreeNode<Integer>(9, null, null);
    root.left.left = new TreeNode<Integer>(5, null, null);
    root.left.right = new TreeNode<Integer>(2, null, null);

    root.right = new TreeNode<Integer>(15, null, null);
    root.right.left = new TreeNode<Integer>(-3, null, null);
    root.right.right = new TreeNode<Integer>(5, null, null);
    root.right.right.right = new TreeNode<Integer>(22, null, null);

    TreeNode<String> stringRoot = new TreeNode<String>("hello", null, null);
    stringRoot.left = new TreeNode<String>("How", null, null);
    stringRoot.left.left = new TreeNode<String>("and", null, null);
    stringRoot.left.right = new TreeNode<String>("and", null, null);

    stringRoot.right = new TreeNode<String>("I", null, null);
    stringRoot.right.left = new TreeNode<String>("am", null, null);
    stringRoot.right.right = new TreeNode<String>("so", null, null);
    stringRoot.right.right.right = new TreeNode<String>("good", null, null);

    TreeNode<Integer> megaRoot = new TreeNode<Integer>(1, null, null);
    TreeNode<Integer> current = megaRoot;
    for(int i = 2; i <= 50000; i++) {
      current.right = new TreeNode<Integer>(i, null, null);
      current = current.right;
    }

    levelOrderIter(root);

    //preOrderIter(megaRoot);
    // System.out.println("Preorder Recursive");
    // preOrder(root);

    // System.out.println("Preorder Iterative");
    // preOrderIter(root);

    // preOrder(root);
    System.out.println();
    // postOrder(root);
    //printGrader(root, 100);
    // System.out.println(countNodes(stringRoot));
    
    //System.out.println(toMap(stringRoot));
  }

  public static <T> void preOrderIter(TreeNode<T> node) {
    Stack<TreeNode<T>> stack = new Stack<>();
    stack.push(node);
    while(!stack.isEmpty()) {
      TreeNode<T> currentNode = stack.pop();

      if(currentNode == null) continue; // move onto next iteration, will not stop loop

      System.out.println(currentNode.value);
      stack.push(currentNode.right);
      stack.push(currentNode.left);
    } 
  }

  public static <T> void levelOrderIter(TreeNode<T> node) {
    Queue<TreeNode<T>> queue = new LinkedList<>();
    queue.add(node);
    while(!queue.isEmpty()) {
      TreeNode<T> currentNode = queue.remove();

      if(currentNode == null) continue; // move onto next iteration, will not stop loop

      System.out.println(currentNode.value);
      queue.add(currentNode.left);
      queue.add(currentNode.right);
    } 
  }

  // Print tree rooted at the given node in pre-order.
  // ? if you dont need to reuse it, parameterize
  public static void preOrder(TreeNode<?> node) {
    if (node == null)
      return; 
    System.out.println(node.value);
    preOrder(node.left);
    preOrder(node.right);
  }

  public static <T> Map<T, Integer> toMap(TreeNode<T> node) {
    Map<T, Integer> counts = new HashMap<>();
    toMap(node, counts);
    return counts;
  }

  private static <T> void toMap(TreeNode<T> node, Map<T, Integer> counts) {
    if(node == null) return;
    // fill up those counts
    counts.put(node.value, counts.getOrDefault(node.value, 0) + 1);
    toMap(node.left, counts);
    toMap(node.right, counts);
  }

  public static int countNodes(TreeNode<?> node) {
    return node == null ? 0 : 1 + countNodes(node.left) + countNodes(node.right);
  }

  public static void printGrader(TreeNode<Integer> node, int threshold) {
    if (node == null) return;
    if(node.value > threshold) {
      System.out.println(node.value);
    }
    printGrader(node.left, threshold);
    printGrader(node.right, threshold);
  }



  // type variable if you need to reuse it
  public static <T> void postOrder(TreeNode<T> node) {
    if (node == null)
      return;
    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.value);
  }

  public static <E> void inOrder(TreeNode<E> node) {
    if (node == null)
      return;
    inOrder(node.left);
    System.out.println(node.value);
    inOrder(node.right);
  }
}
