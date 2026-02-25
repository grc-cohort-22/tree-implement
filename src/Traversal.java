import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(10);
    // <-- root
    root.left = new TreeNode<>(9);
    root.left.left = new TreeNode<>(5);
    root.left.right = new TreeNode<>(2);
    //     root -->
    root.right = new TreeNode<>(15);
    root.right.left = new TreeNode<>(-3);
    root.right.right = new TreeNode<>(5);
    root.right.right.right = new TreeNode<>(22);


    TreeNode<String> stringRoot = new TreeNode<>("Hello");
    // <-- stringRoot
    stringRoot.left = new TreeNode<>("world");
    stringRoot.left.left = new TreeNode<>("test");
    stringRoot.left.right = new TreeNode<>("1234");
    //     stringroot -->
    stringRoot.right = new TreeNode<>("abcd");
    stringRoot.right.left = new TreeNode<>("node");
    stringRoot.right.right = new TreeNode<>("another node");
    stringRoot.right.right.right = new TreeNode<>("another another node");

    System.out.print("\nPre Order:  ");
    preOrder(root);
    System.out.print("\nPost Order: ");
    postOrder(root);
    System.out.print("\nIn Order:   ");
    inOrder(root);

    System.out.print("\nPre Order:  ");
    preOrder(stringRoot);
    System.out.print("\nPost Order: ");
    postOrder(stringRoot);
    System.out.print("\nIn Order:   ");
    inOrder(stringRoot);

    System.out.print("\nPrint Greater:  ");
    printGreater(root, 7);

    System.out.print("\nPrint node count:  ");
    System.out.print(countNodes(root)+"\n");
    
    //System.out.print(toMap(root));

    TreeNode<Integer> megaRoot = new TreeNode<>(1);
    /*
    TreeNode<Integer> current = megaRoot;
    
    for (int i = 2; i<=5000; i++) {
      current.right = new TreeNode<>(i);
      current = current.right;
    }
    */
    System.out.println("\npreOrderIter: ");
    preOrderIter(root);
    System.out.println("\nlevelOrder: ");
    levelOrder(root);
  }

  public static <T> void preOrderIter(TreeNode<T> node) {
    Stack<TreeNode<T>> stack = new Stack<>();
    stack.push(node);

    while(!stack.isEmpty()) {
      TreeNode<T> current = stack.pop();
      if (current == null) continue;

      System.out.print(" " + current.value);

      stack.push(current.right);
      stack.push(current.left);
    }
  }

  public static <T> void levelOrder(TreeNode<T> node) {
    Queue<TreeNode<T>> queue = new LinkedList<>();
    queue.add(node);

    while(!queue.isEmpty()) {
      TreeNode<T> current = queue.poll();
      if (current == null) continue;

      System.out.print(" " + current.value);

      queue.add(current.left);
      queue.add(current.right);
    }
  }
  // Print a tree rooted at the given node in pre-order
  public static void preOrder(TreeNode<?> node) { // can't use ? in body
    if (node == null) return;
    System.out.print(" ["+ node.value +"]");
    preOrder(node.left);
    preOrder(node.right);
  }

  // Print a tree rooted at the given node in post-order
  public static <T> void postOrder(TreeNode<T> node) { // can use T in body
    if (node == null) return;
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(" ["+ node.value +"]");

    //List<T> myList = new ArrayList<>();
    //myList.add(node.value);
  }

  // Print a tree rooted at the given node in order
  public static <E> void inOrder(TreeNode<E> node) {
    if (node == null) return;
    postOrder(node.left);
    System.out.print(" ["+ node.value +"]");
    postOrder(node.right);
  }

  // Print a tree rooted at the given node in pre-order where node values > threshold value
  public static void printGreater(TreeNode<Integer> node, int threshold) {
    if (node == null) return;
    if (node.value > threshold) System.out.print(" ["+ node.value +"]");
    printGreater(node.left, threshold);
    printGreater(node.right, threshold);
  }

  public static int countNodes(TreeNode<?> node) {
    return countNodes(node, 0);
  }

  private static int countNodes(TreeNode<?> node, int count) {
    if (node == null) return count;
    count++;
    count = countNodes(node.left, count);
    count = countNodes(node.right, count);
    return count;
  }
  public static <T> Map<T, Integer> toMap(TreeNode<T> node) {
     Map<T, Integer> counts = new HashMap<>();
    return toMap(node, counts);
  }
  private static <T> Map<T, Integer> toMap(TreeNode<T> node, Map<T, Integer> counts) {
    if (node == null) {
      return counts;
    }
    counts.put(node.value, counts.getOrDefault(node.value, 0)+1);
    toMap(node.left, counts);
    toMap(node.right, counts);
    return counts;
  }
}
