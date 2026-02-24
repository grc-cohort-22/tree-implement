import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

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
    stringRoot.left.left = new TreeNode<String>("are", null, null);
    stringRoot.left.right = new TreeNode<String>("you", null, null);

    stringRoot.right = new TreeNode<String>("I", null, null);
    stringRoot.right.left = new TreeNode<String>("am", null, null);
    stringRoot.right.right = new TreeNode<String>("so", null, null);
    stringRoot.right.right.right = new TreeNode<String>("good", null, null);

    TreeNode<Integer> megaRoot = new TreeNode<Integer>(1, null, null);

    TreeNode<Integer> current = megaRoot;

    for(int i = 2; i <= 50000; i++) {
      current.right = new TreeNode<Integer> (i, null, null);
      current = current.right;
    }

    levelOrder(root);

    //preOrderIter(megaRoot);

    //System.out.println("Preorder recursive");
    //preOrder(root);
    //System.out.println("Preorder iterative");
    //preOrderIter(root);

    //postOrder(root);
    //inOrder(stringRoot);
    //printGreater(root, 7);
    //System.out.println(countNodes(root));
    //System.out.println(toMap(stringRoot));
  }

  public static <T> void preOrderIter(TreeNode<T> node) {
    Stack<TreeNode<T>> stack = new Stack<>();

    stack.push(node);

    while(!stack.empty()) {
      TreeNode<T> current = stack.pop();

      if(current == null) { continue; }

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

      if(current == null) { continue; }

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
    if(node == null) { return; }
    counts.put(node.value, counts.getOrDefault(node.value, 0) + 1);
    toMap(node.left, counts);
    toMap(node.right, counts);
  }

  public static int countNodes(TreeNode<?> node) {
    return node == null ? 0 : countNodes(node.left) + countNodes(node.right) + 1;
    //int leftCount = countNodes(node.left);
    //int rightCount = countNodes(node.right);
    //int overallCount = leftCount + rightCount + 1;
    //return overallCount;
  }

  public static void printGreater(TreeNode<Integer> node, int threshold) {
    if (node == null) return;
    if (node.value > threshold) System.out.println(node.value);
    printGreater(node.left, threshold);
    printGreater(node.right, threshold);
  }

  // print a tree rooted at the given node in pre-order
  public static void preOrder(TreeNode<?> node) {
    //if null, return
    if (node == null) { return; }
    //print value
    System.out.println(node.value);
    //traverse left
    preOrder(node.left);
    //traverse right
    preOrder(node.right);
  }

  public static <T> void postOrder(TreeNode<T> node) {
    if (node == null) { return; }
    postOrder(node.left);
    postOrder(node.right);
    System.out.println(node.value);
  }

  public static <E> void inOrder(TreeNode<E> node) {
    if (node == null) { return; }
    inOrder(node.left);
    System.out.println(node.value);
    inOrder(node.right);
  }
}
