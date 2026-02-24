import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Map;
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
    stringRoot.left.left = new TreeNode<String>("are", null, null);
    stringRoot.left.right = new TreeNode<String>("hello", null, null);

    stringRoot.right = new TreeNode<String>("I", null, null);
    stringRoot.right.left = new TreeNode<String>("am", null, null);
    stringRoot.right.right = new TreeNode<String>("am", null, null);
    stringRoot.right.right.right = new TreeNode<String>("good", null, null);

    TreeNode<Integer> megaRoot = new TreeNode<Integer>(1, null, null);
    TreeNode<Integer> current = megaRoot;
    for(int i = 2; i <= 50000; i++) {
      current.right = new TreeNode<Integer>(i, null, null);
      current = current.right;
    }

    levelOrder(root);

    //preOrderIter(megaRoot);

    // System.out.println("Preorder recursive");
    // preorder(root);
    // System.out.println("Preorder iterative");
    // preOrderIter(root);

    TreeNode<Integer> newRoot = new TreeNode<Integer>(3, new TreeNode<Integer>(9, null, new TreeNode<Integer>(4, null, null)), null);
    //newRoot.left = new TreeNode<Integer>(9, null, null);
    //newRoot.left.right = new TreeNode<Integer>(4, null, null);
    newRoot.right = new TreeNode<Integer>(4, null, null);
    newRoot.right.left = new TreeNode<Integer>(9, null, null);
    newRoot.right.right = new TreeNode<Integer>(6, null, null);
    newRoot.right.right.left = new TreeNode<Integer>(4, null, null);

    // { "hello": 1, "how": 2, "you": 1 }
    List<String> wordList = List.of("hello", "how", "you", "how");
    //System.out.println(listToMap(wordList));

    //preorder(root);
    //postorder(root);
    //inorder(stringRoot);

    //printGreater(root, 4);
    //System.out.println(countNodes(root));

    //System.out.println(toMap(stringRoot));
  }

  // Print a tree rooted at the given node in pre-order
  public static void preorder(TreeNode<?> node) {
    if (node == null) return; // if null, return
    System.out.println(node.value); // print value 
    preorder(node.left); // traverse left
    preorder(node.right); // traverse right 
  }

  // depth first search 
  public static <T> void preOrderIter(TreeNode<T> node) {
    Stack<TreeNode<T>> stack = new Stack<>();
    stack.push(node);

    while(!stack.empty()) {
      TreeNode<T> current = stack.pop();
      if (current == null) {
        continue;
      }
      System.out.println(current.value);
      stack.push(current.right);
      stack.push(current.left);      
    }
  }

  // breath first search (level order)
  public static <T> void levelOrder(TreeNode<T> node) {
    Queue<TreeNode<T>> queue = new LinkedList<>();
    queue.add(node);

    while(!queue.isEmpty()) {
      TreeNode<T> current = queue.poll();
      if (current == null) {
        continue;
      }
      System.out.println(current.value);
      queue.add(current.left);
      queue.add(current.right);
    }
  }

  // public static <T> Map<T,Integer> toMap(TreeNode<T> node) {
  //   Map<T, Integer> counts = new HashMap<>();
  //   toMap(node, counts);
  //   return counts;
  // }

  // private static <T> void toMap(TreeNode<T> node, Map<T, Integer> counts) {
  //   if(node == null) return;
    
  //   // fill up those counts
  //   counts.put(node.value, counts.getOrDefault(node.value, 0) + 1);
  //   toMap(node.left, counts);
  //   toMap(node.right, counts);
  // }

  public static Map<String, Integer> listToMap(List<String> list){

//     for word in list:
//        if our word is a key in the map:
// 	        newValue = map.get(word) + 1
// 	        map.put(word, newValue)
//        else:
// 	        map.put(word, 1)

    // "hello", "how", "you", "how"

    Map<String, Integer> map = new HashMap<>(); // {"hello": 1, "how": 1, "you": 1}

    int count = 0;

    for (int i = 0; i < list.size(); i++) {
      String word = list.get(i); // how 

      if (map.containsKey(word)){
        count = map.get(word) + 1; // value of count = 2
        map.put(word, count);
      } else {
        map.put(word, 1);
      }
    }
    return map;
  }


  public static int countNodes(TreeNode<?> node) {
    if (node == null) return 0;
    return countNodes(node.left) + countNodes(node.right) + 1;

    //return node == null ? 0 : countNodes(node.left) + countNodes(node.right) + 1;

    // int leftCount = countNodes(node.left);
    // int rightCount = countNodes(node.right);
    // int overallCount = leftCount + rightCount + 1;
    // return overallCount;
  }

  public static void printGreater(TreeNode<Integer> node, int threshold) {
    if (node == null) return; 
    if (node.value > threshold) {
      System.out.println(node.value);
    }
    printGreater(node.left, threshold);
    printGreater(node.right, threshold);
  }

  // Print a tree rooted at the given node in post-order
  public static <T> void postorder(TreeNode<T> node) {
    if (node == null) return;
    postorder(node.left);
    postorder(node.right);
    System.out.println(node.value);
  }

  // Print a tree rooted at the given node in in-order
  public static <E> void inorder(TreeNode<E> node) {
    if (node == null) return;
    inorder(node.left);
    System.out.println(node.value);
    inorder(node.right);
  }
}