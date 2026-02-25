import java.util.*;
public class Traversal {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<Integer>(10, new TreeNode<Integer>(9, new TreeNode<Integer>(5, null, null), new TreeNode<Integer>(2, null, null)), new TreeNode<Integer>(15, new TreeNode<Integer>(-3, null, null), new TreeNode<Integer>(5, null, new TreeNode<Integer>(22, null, null))));
    
    // preorder(root);
    // System.out.println();
    // postorder(root);
    // System.out.println();
    // inorder(root);
    // System.out.println();

    TreeNode<String> stringRoot = new TreeNode<String>("Hello", new TreeNode<String>("Hello", new TreeNode<String>("am", null, null), new TreeNode<String>("am", null, null)), new TreeNode<String>("I", new TreeNode<String>("am", null, null), new TreeNode<String>("so", null, new TreeNode<String>("good", null, null))));

    TreeNode<Integer> megaRoot = new TreeNode<Integer>(1, null, null);

    TreeNode<Integer> current = megaRoot;

    for (int i = 2; i < 5000; i++) {
      current.right = new TreeNode<Integer>(i, null, null);
      current = current.right;
    }

    // preorder(megaRoot);

    levelOrder(root);

    // System.out.println("Preorder Recursive: ");
    // preorder(root);
    // System.out.println();
    // System.out.println("Preorder Iterative");
    // preOrderIter(megaRoot);
    // System.out.println();

    // System.out.println();

    // preorder(stringRoot);
    // System.out.println();
    // postorder(stringRoot);
    // System.out.println();
    // inorder(stringRoot);
    // System.out.println();

    // printGreater(root, 10);
    // System.out.println();

    // System.out.println(countNodes(root));
    // System.out.println(toMap(stringRoot));
    
  }

  public static <T> void levelOrder(TreeNode<T> node){
    Queue<TreeNode<T>> queue = new LinkedList<>();

    queue.add(node);

    while(!queue.isEmpty()){
      TreeNode<T> current = queue.poll();

      if(current == null){
        continue;
      }

      System.out.print(current.value + " ");
      queue.add(current.left);
      queue.add(current.right);
    }
  }

  public static <T> void preOrderIter(TreeNode<T> node) {
    Stack<TreeNode<T>> stack = new Stack<>();
    stack.push(node); 

    while(!stack.isEmpty()) {
      TreeNode<T> current = stack.pop();
      if (current == null) continue;
      System.out.print(current.value + " ");
      stack.push(current.right);
      stack.push(current.left);
    }
  }
  
  public static <T> Map<T, Integer> toMap(TreeNode<T> node) {
    Map<T, Integer> counts = new HashMap<>();
    toMap(node, counts);
    return counts;
  }
  
  private static <T> void toMap(TreeNode<T> node, Map<T, Integer> counts) {
    if (node == null) {
      return;
    }
    counts.put(node.value, counts.getOrDefault(node.value, 0) + 1);
    toMap(node.left, counts);
    toMap(node.right, counts);
  }

  public static int countNodes(TreeNode<?> node) {
    int count = 0;
    if (node == null) {
      return 0;
    } else {
      count++;
      count += (countNodes(node.right) + countNodes(node.left)); 
    }
    return count;
  }
  
  public static void printGreater(TreeNode<Integer> node, int threshold) {
    if (node == null) return;
    if (node.value > threshold) {
      System.out.print(node.value + " ");
    }
    printGreater(node.left, threshold);
    printGreater(node.right, threshold);
  }

  public static <T> void preorder(TreeNode<T> node) {
    if (node == null) return;
    System.out.print(node.value + " ");
    preorder(node.left);
    preorder(node.right);
  }

  public static <T> void postorder(TreeNode<T> node) {
    if (node == null) return;
    postorder(node.left);
    postorder(node.right);
    System.out.print(node.value + " ");
  }

  public static <T> void inorder(TreeNode<T> node) {
    if (node == null) return;
    inorder(node.left);
    System.out.print(node.value + " ");
    inorder(node.right);
  }
}
