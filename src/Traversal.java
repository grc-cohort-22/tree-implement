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
    stringRoot.left = new TreeNode<String>("how", null, null);
    stringRoot.left.left = new TreeNode<String>("hello", null, null);
    stringRoot.left.right = new TreeNode<String>("you", null, null);

    stringRoot.right = new TreeNode<String>("I", null, null);
    stringRoot.right.left = new TreeNode<String>("I", null, null);
    stringRoot.right.right = new TreeNode<String>("so", null, null);
    stringRoot.right.right.right = new TreeNode<String>("good", null, null);

    TreeNode<Integer> megaRoot = new TreeNode<Integer>(1, null, null);
    TreeNode<Integer> current = megaRoot;

    for (int i = 2; i <= 5000; i++) {
      current.right = new TreeNode<Integer>(i, null, null);
      current = current.right;
    }

    // preorder(root);
    // postorder(root);
    // inorder(root);
    // printGreater(root, 4);
    // System.out.println(countNodes(root));
    // Map<String, Integer> counts = new HashMap<>();
    // System.out.println(toMap(stringRoot));
    // preOrderIter(megaRoot);

    System.out.println("Preorder recuresive");
    preorder(root);
    System.out.println("Preorder iterative");
    // preOrderIter(root);
    leverOrder(root);

  }

  public static <T> void leverOrder(TreeNode<T> node) {
    Queue<TreeNode<T>> queue = new LinkedList<>();

    queue.add(node);
    while (!queue.isEmpty()) {
      TreeNode<T> current = queue.poll();

      if (current == null) {
        continue; // move to the top of the loop
      }

      System.out.println(current.value);
      queue.add(current.left);
      queue.add(current.right);

    }

  }

  public static <T> void preOrderIter(TreeNode<T> node) {
    Stack<TreeNode<T>> stack = new Stack<>();

    stack.push(node);
    while (!stack.empty()) {
      TreeNode<T> current = stack.pop();

      if (current == null) {
        continue; // move to the top of the loop
      }

      System.out.println(current.value);
      stack.push(current.right);
      stack.push(current.left);

    }

  }

  // print tree rooted at the given node in pre-order
  public static void preorder(TreeNode<?> node) {

    if (node == null)
      return;
    System.out.println(node.value);
    preorder(node.left);
    preorder(node.right);

  }

  public static <T> Map<T, Integer> toMap(TreeNode<T> node) {
    Map<T, Integer> counts = new HashMap<>();
    toMap(node, counts);
    return counts;

  }

  private static <T> void toMap(TreeNode<T> node, Map<T, Integer> counts) {

    if (node == null)
      return;
    // Fill up the counts
    counts.put(node.value, counts.getOrDefault(node.value, 0) + 1);
    toMap(node.left, counts);
    toMap(node.right, counts);

  }

  public static int countNodes(TreeNode<?> node) {
    // if (node == null) return 0;
    // if (node == null)
    // return 0;
    return node == null ? 0 : countNodes(node.left) + countNodes(node.right) + 1;
    // int leftCount = countNodes(node.left);
    // int rightCount = countNodes(node.right);
    // int overAllCount = leftCount + rightCount + 1;
    // return overAllCount;

  }

  public static void printGreater(TreeNode<Integer> node, int threshold) {

    if (node == null)
      return;
    if (node.value > threshold) {
      System.out.println(node.value);
    }
    printGreater(node.left, threshold);
    printGreater(node.right, threshold);

  }

  public static <T> void postorder(TreeNode<T> node) {

    if (node == null)
      return;
    postorder(node.left);
    postorder(node.right);
    System.out.println(node.value);

  }

  public static <E> void inorder(TreeNode<E> node) {
    if (node == null)
      return;
    inorder(node.left);
    System.out.println(node.value);
    inorder(node.right);

  }

}
