import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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


    TreeNode<String> root2 = new TreeNode<String>("hello", null, null);
    root2.left = new TreeNode<String>("how", null, null);
    root2.left.left = new TreeNode<String>("are", null, null);
    root2.left.right = new TreeNode<String>("you", null, null);
    root2.right = new TreeNode<String>("i", null, null);
    root2.right.left = new TreeNode<String>("am", null, null);
    root2.right.right = new TreeNode<String>("so", null, null);
    root2.right.right.right = new TreeNode<String>("good", null, null);
/* 
    System.out.println("======PRE ORDER======");
    preorder(root);
    System.out.println("======POST ORDER======");
    postorder(root);
    System.out.println("======IN ORDER======");
    inorder(root);

    printGreater(root, 7);
*/
    //System.out.println(countNodes(root));

    TreeNode<Integer> megaRoot = new TreeNode<Integer>(1, null, null);

    TreeNode<Integer> current = megaRoot;

    for(int i = 2; i <= 50000; i++) {
      current.right = new TreeNode<Integer>(i, null, null);
      current = current.right;
    }


    levelOrder(root);
    //preOrderIter(megaRoot);

    /*System.out.println("Preorder recursive");
    preorder(root);
    System.out.println("Preorder iterative");
    preOrderIter(root);*/
  }

  public static <T> void preOrderIter(TreeNode<T> node) {
    Stack<TreeNode<T>> stack = new Stack<>();
    stack.push(node);
  
    while(!stack.empty()) {
      TreeNode<T> current = stack.pop();
      if(current == null) continue;

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
      if(current == null) continue;

      System.out.println(current.value);
      queue.add(current.left);
      queue.add(current.right);
    }
  }

    //print tree rooted at given node in pre-order.
  public static void preorder(TreeNode<?> node) {
    if(node == null) return;
    System.out.println(node.value);
    preorder(node.left);
    preorder(node.right);
  }


  public static int countNodes(TreeNode<?> node) {
    if(node == null) return 0;
    return 1 + countNodes(node.left) + countNodes(node.right);
  }

  public static void printGreater(TreeNode<Integer> node, int threshold) {
    if(node == null) return;
    if(node.value > threshold) {
      System.out.println(node.value);
    }
    printGreater(node.left, threshold);
    printGreater(node.right, threshold);
  }

  public static void postorder(TreeNode<?> node) {
    if(node == null) return;
    postorder(node.left);
    postorder(node.right);
    System.out.println(node.value);
  }

  public static void inorder(TreeNode<?> node) {
    if(node == null) return;
    inorder(node.left);
    System.out.println(node.value);
    inorder(node.right);
  }

  public static <T> Map<T, Integer> toMap(TreeNode<T> node){
    Map<T, Integer> counts = new HashMap<>();
    toMap(node, counts);
    return counts;
  } 

  private static <T> void toMap(TreeNode<T> node, Map<T, Integer> counts){
    if(node == null){
      return;
    }

    // fill up those counts
    counts.put(node.value, counts.getOrDefault(node.value, 0) + 1);

    toMap(node.left, counts);
    toMap(node.right, counts);    
  }
}