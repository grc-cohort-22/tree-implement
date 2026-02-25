import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.Stack;

public class Traversal {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(10, null, null);
    root.left = new TreeNode<Integer>(9, null, null);
    root.left.left = new TreeNode<Integer>(5, null, null);
    root.left.right = new TreeNode<Integer>(2, null, null);

    root.right = new TreeNode<Integer>(15, null, null);
    root.right.left = new TreeNode<Integer>(-3, null, null);
    root.right.right = new TreeNode<Integer>(5, null, null);
    root.right.right.right = new TreeNode<Integer>(22, null, null);

    TreeNode<String> stringRoot = new TreeNode<String>("hello", null, null);
    stringRoot.left = new TreeNode<String>("how", null, null);
    stringRoot.left.left = new TreeNode<String>("are", null, null);
    stringRoot.left.right = new TreeNode<String>("you", null, null);

    stringRoot.right = new TreeNode<String>("I", null, null);
    stringRoot.right.left = new TreeNode<String>("am", null, null);
    stringRoot.right.right = new TreeNode<String>("so", null, null);
    stringRoot.right.right.right = new TreeNode<String>("good", null, null);

    TreeNode<Integer> megaRoot = new TreeNode<>(1, null, null);
    TreeNode<Integer> current = megaRoot;

    for (int i = 2; i <= 5000; i++ ) {
      current.right = new TreeNode<Integer>(i, null, null);
      current = current.right;
    }

    System.out.println("Preorder recursive");
    preorder(root);
    System.out.println("Preorder iterative");
    perOrderIter(root);
    System.out.println("Preorder iterative");
    levelOrder(root);
    // preorder(root);
    // postorder(root);
    // inorder(stringRoot);
    // printGreater(root, 7);
    // Map<String, Integer> counts = new HashMap<>();
    // System.out.println(toMap(root));
  }

  //print a tree roted at the given node in pre-order
  public static <T> void preorder(TreeNode<?> node) {
    if (node == null) {
      return;
    }
    //print value
    System.out.println(node.value);
    //traverse left
    preorder(node.left);
    //traverse right
    preorder(node.right);

  }

  public static <T> void perOrderIter(TreeNode<T> node) {
    Stack<TreeNode<T>> stack = new Stack<>();
    // TreeNode<T> current = node;

    stack.push(node);

    while (!stack.isEmpty()) {
      TreeNode<T> current = stack.pop();

      if (current == null)  {
        continue;
      }

      System.out.println(current.value);
      stack.push(current.right);
      stack.push(current.left);
    }
  }

  public static <T> void levelOrder(TreeNode<T> node) {
    Queue<TreeNode<T>> queue = new LinkedList<>();

    queue.add(node);

    while (!queue.isEmpty()) {
      TreeNode<T> current = queue.poll();

      if (current == null)  {
        continue;
      }

      System.out.println(current.value);
      queue.add(current.left);
      queue.add(current.right);
    }
  }

  public static <T> Map<T,Integer> toMap(TreeNode<T> node) {
    Map<T, Integer> counts = new HashMap<>();
    toMap(node, counts);

    return counts;
  }

  private static <T> void toMap(TreeNode<T> node, Map<T, Integer> counts) {
    if (node == null) {
      return;
    }
    //fill up those counts
    counts.put(node.value, counts.getOrDefault(node.value, 0) + 1);
    toMap(node.left, counts);
    toMap(node.right, counts);
  }

  public static int countNodes(TreeNode<?> node) {
    if (node == null) {
      return 0;
    }
    int leftCount = countNodes(node.left);
    int rightCount = countNodes(node.right);
    int overallCount = leftCount + rightCount + 1;

    return overallCount;
    //return node == null ? 0 : 1 + countNodes(node.left) + countNodes(node.right);
    // return countNodes(node.left) + countNodes(node.right) + 1;
  }

  public static void printGreater(TreeNode<Integer> node, int threshold) {
    if (node == null) {
      return;
    }
    //print value
    if (node.value > threshold) {
      System.out.println(node.value);
    }
    
    //traverse left
    printGreater(node.left, threshold);
    //traverse right
    printGreater(node.right, threshold);
  }

  public static <T> void postorder(TreeNode<?> node) {
    if (node == null) return;
    postorder(node.left);
    postorder(node.right);
    System.out.println(node.value);
  }

  public static <T> void inorder(TreeNode<?> node) {
    if (node == null) return;
    inorder(node.left);
    System.out.println(node.value);
    inorder(node.right);

  }
}

/**
 * A utility class for performing operations on a binary tree of Strings.
 */
public class QuickCheck {

  /**
   * Prints all strings longer than 7 characters in a tree.
   * The strings should be printed in pre-order.
   * Each qualifying string should appear on its own line.
   * 
   * If the node itself is null, the method should print nothing.
   * 
   * You can assume that there are no null Strings stored in the tree nodes.
   *
   * @param node the root node of the binary tree
   */
  public static void printLongerThan7(TreeNode<String> node) {
    if (node == null) {
      return;
    }

    if ((node.value).length() > 7) {
      System.out.println(node.value);
    }

    printLongerThan7(node.left);
    printLongerThan7(node.right);

  }

  /**
   * Returns the sum of all nodes holding odd numbers.
   * 
   * If the node itself is null, return 0.
   * 
   * You can assume there are no null Integers held in the values.
   *
   * @param node the root node of the binary tree
   * @return the sum of all odd-valued nodes
   */
  public static int oddSum(TreeNode<Integer> node) {
    if (node == null) {
      return 0;
    }

    int left = oddSum(node.left);
    int right = oddSum(node.right);

    if (node.value % 2 != 0) {
      return left + right + node.value;
    }
    return left + right;
   

  }
}