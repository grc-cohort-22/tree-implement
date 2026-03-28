
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(10, null, null);

    root.left = new TreeNode<>(9, null, null);
    root.left.left = new TreeNode<>(5, null, null);
    root.left.right = new TreeNode<>(2, null, null);

    root.right = new TreeNode<>(15, null, null);
    root.right.left = new TreeNode<>(-3, null, null);
    root.right.right = new TreeNode<>(5, null, null);
    root.right.right.right = new TreeNode<>(22, null, null);

    TreeNode<String> stringRoot = new TreeNode<>("root", null, null);
    stringRoot.left = new TreeNode<>("9", null, null);
    stringRoot.left.left = new TreeNode<>("5", null, null);
    stringRoot.left.right = new TreeNode<>("2", null, null);

    stringRoot.right = new TreeNode<>("15", null, null);
    stringRoot.right.left = new TreeNode<>("-3", null, null);
    stringRoot.right.right = new TreeNode<>("5", null, null);
    stringRoot.right.right.right = new TreeNode<>("22", null, null);

    //System.out.println(stringRoot.left.right.value); 
    // preOrder(stringRoot);
    // System.out.println();
    // postOrder(stringRoot);
    // System.out.println();
    // inOrder(stringRoot);
    // System.out.println();

    // printGreater(root, 5);

    // System.out.println(countNode(root));

    // System.out.println(toMap(stringRoot));

    TreeNode<Integer> megaRoot = new TreeNode<Integer>(1, null, null);

    TreeNode<Integer> current = megaRoot;

    for (int i = 2; i <= 5000; i++) {
        current.right = new TreeNode<Integer>(i, null, null);
        current = current.right;
    }
    levelOrderIter(root);
  }

  public static <T> void preOrderIter(TreeNode<T> node){
    Stack<TreeNode<T>> stack = new Stack<>();

    stack.push(node);

    while(!stack.empty()){
      TreeNode<T> current = stack.pop();
      if(current == null) continue;
      System.out.print(current.value + " ");
      stack.push(current.left);
      stack.push(current.right);
    }
  }
  public static <T> void levelOrderIter(TreeNode<T> node){
    Queue<TreeNode<T>> stack = new LinkedList<>();

    stack.add(node);

    while(!stack.isEmpty()){
      TreeNode<T> current = stack.poll();
      if(current == null) continue;
      System.out.print(current.value + " ");
      stack.add(current.left);
      stack.add(current.right);
    }
  }

  public static int countNode(TreeNode<?> node){
    if(node == null) return 0;
    return countNode(node.left) + countNode(node.right) + 1;
    //if(node != null) {return countNode(node.left) + countNode(node.right) + 1;} else return 0;
  }
  public static void printGreater(TreeNode<Integer> node, int threshold){
    
    if(node == null) return;
    if(node.value > threshold){
      System.out.print(node.value + " ");
    }
    printGreater(node.left, threshold);
    printGreater(node.right, threshold);
  }

  public static void preOrder(TreeNode<?> node) {
      if(node == null) return;
      System.out.print(node.value + " ");
      preOrder(node.left);
      preOrder(node.right);
  }
  public static <T> void postOrder(TreeNode<T> node) {
      if(node == null) return;
      postOrder(node.left);
      postOrder(node.right);
      System.out.print(node.value + " ");
  }
  public static <E> void inOrder(TreeNode<E> node) {
      if(node == null) return;
      inOrder(node.left);
      System.out.print(node.value + " ");
      inOrder(node.right);
  }

  public static <T> Map<T, Integer> toMap(TreeNode<T> node){
    Map<T, Integer> returnMap = new HashMap<>();
    toMap(node, returnMap);
    return returnMap;
  }
  private static <T> void toMap(TreeNode<T> node, Map<T, Integer> returnMap){
    if(node == null) return;
    returnMap.put(node.value, returnMap.getOrDefault(node.value, 0) + 1);

    toMap(node.left, returnMap);
    toMap(node.right, returnMap);
  }

  //These are all how I initially built the methods ahead of you:

  // public static void preOrder(TreeNode node){
  //   System.out.print(node.value + " ");
  //   if(node.left != null){
  //     preOrder(node.left);
  //   }
  //   if(node.right != null){
  //     preOrder(node.right);
  //   }
  // }
  // public static void postOrder(TreeNode node){
    
  //   if(node.left != null){
  //     postOrder(node.left);
  //   }
  //   if(node.right != null){
  //     postOrder(node.right);
  //   }
  //   System.out.print(node.value + " ");
  // }
  // public static void inOrder(TreeNode node){
    
  //   if(node.left != null){
  //     inOrder(node.left);
  //   }
  //   System.out.print(node.value + " ");
  //   if(node.right != null){
  //     inOrder(node.right);
  //   }
    
  // }
}
