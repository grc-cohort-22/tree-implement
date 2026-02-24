import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
  public static void main(String[] args) {
    TreeNode<String> Stringroot = new TreeNode<String>("lol", null, null);
    Stringroot.left = new TreeNode<String>("Laugh", null, null);
    Stringroot.right = new TreeNode<String>("Chuckle", null, null);

    TreeNode<Integer> root = new TreeNode<Integer>(10, null, null);
    root.left = new TreeNode<Integer>(9, null, null);
    root.left.left = new TreeNode<Integer>(5, null, null);
    root.left.right = new TreeNode<Integer>(2, null, null);
    root.right = new TreeNode<Integer>(15, null, null);
    root.right.left = new TreeNode<Integer>(-3, null, null);
    root.right.right = new TreeNode<Integer>(5, null, null);
    root.right.right.right = new TreeNode<Integer>(22, null, null);

    TreeNode<Integer> Megaroot = new TreeNode<Integer>(1, null , null);
    TreeNode<Integer> current = Megaroot;

    for (int i=0; i < 500000; i++) {
      current.right = new TreeNode<Integer>(1, null, null);
      current = current.right;
    }

    //preOrder(root);
    //System.out.println();
    //postOrder(root);
    //System.out.println();
    //inOrder(root);
    //System.out.println();
    //inOrder(Stringroot);
    //System.out.println();
    //preOrderGreater(root);
    //System.out.println();
    //System.out.println(countNodes(root));
    //System.out.print(countNodes(Stringroot));
    //System.out.print(toMap(root));
    //preOrderIter(Megaroot);
    LevelOrder(Megaroot);
  }
  public static void preOrder(TreeNode<?> node){
    if (node == null) return;
    System.out.print(node.value);
    preOrder(node.left);
    preOrder(node.right);
  }
  public static void postOrder(TreeNode<?> node){
    if (node == null) return;
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.value + " ");
  }
  public static <T> void preOrderIter(TreeNode<T> node){
    if (node == null) return;
    Stack<TreeNode<T>> stack = new Stack<>();
    stack.push(node);
    while(!stack.isEmpty()) {
      TreeNode<T> current = stack.pop();
      if (current==null) continue;
      System.out.print(current.value);
      stack.push(current.right);
      stack.push(current.left);
    }
  }
  public static <T> void LevelOrder(TreeNode<T> node){
    if (node == null) return;
    Queue<TreeNode<T>> stack = new LinkedList<>();
    stack.add(node);
    while(!stack.isEmpty()) {
      TreeNode<T> current = stack.poll();
      if (current==null) continue;
      System.out.print(current.value);
      stack.add(current.left);
      stack.add(current.right);
    }
  }
  public static void inOrder(TreeNode<?> node){
    if (node == null) return;
    inOrder(node.left);
    System.out.print(node.value + " ");
    inOrder(node.right);
  }
  public static void preOrderGreater(TreeNode<Integer> node){
    if (node == null) return;
    if (node.value > 7) {
      System.out.print(node.value + " ");
    }
    preOrderGreater(node.left);
    preOrderGreater(node.right);
  }
  public static int countNodes(TreeNode<?> node) {
    if (node == null) return 0;
    if (node.right == null && node.left == null) return 1;
    return countNodes(node.right) + countNodes(node.left) + 1;
  }

  public static <T> Map<T, Integer> toMap(TreeNode<T> node) {
  Map<T, Integer> counts = new HashMap<>();
  toMap(node, counts);
  return counts;
  }

  private static <T> void toMap(TreeNode<T> node, Map<T, Integer> counts) {
    if (node == null) return;
    counts.put(node.value, counts.getOrDefault(node.value, 0)+1);
    toMap(node.left, counts);
    toMap(node.right, counts);
    return;
  }
}
