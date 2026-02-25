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
    stringRoot.left = new TreeNode<String>("bine", null, null);
    stringRoot.left.left = new TreeNode<String>("hello", null, null);
    stringRoot.left.right = new TreeNode<String>("lime", null, null);

    stringRoot.right = new TreeNode<String>("chime", null, null);
    stringRoot.right.left = new TreeNode<String>("lime", null, null);
    stringRoot.right.right = new TreeNode<String>("climb", null, null);
    stringRoot.right.right.right = new TreeNode<String>("help", null, null);
    System.out.println();

    // System.out.print("pre-order: ");
    // preOrder(root);
    // System.out.println();
    // System.out.print("post-order: ");
    // postOrder(root);
    // System.out.println();
    // System.out.print("in-order: ");
    // inOrder(root);

    // inOrder(stringRoot);
    // printGreater(root, 4);
    // System.out.println(countNodes(stringRoot));

    TreeNode<Integer> megaRoot = new TreeNode<Integer>(1, null, null);
    TreeNode<Integer> current = megaRoot;

    for(int i = 2; i <= 5000; i++){
      current.right = new TreeNode<Integer>(i, null, null);
      current = current.right;

    }
    // preOrder(megaRoot);
    // System.out.println(toMap(stringRoot));
    // System.out.println("Preorder recursive");
    // preOrder(root);
    // System.out.println("Preorder recursive");
    // preOrderIter(megaRoot);
    LevelOrder(root);
  }

   //Print a tree rooted at a given node in pre-order
   public static void preOrder(TreeNode<?> node){
    if (node == null) return; 
    System.out.print(node.value + " ");
    preOrder(node.left);
    preOrder(node.right);
  }

  public static <T> void preOrderIter(TreeNode<T> node) {
    Stack<TreeNode<T>> stack = new Stack<>();

    stack.push(node);
    
    while(!stack.empty()){
      TreeNode<T> current = stack.pop();

      if(current == null){
        continue;
      }
    
      System.out.println(current.value);
      stack.push(current.right);
      stack.push(current.left);
        
      
    }
  }
  
  public static <T> void LevelOrder(TreeNode<T> node) {
    Queue<TreeNode<T>> queue = new LinkedList<>();

    queue.add(node);
    
    while(!queue.isEmpty()){
      TreeNode<T> current = queue.poll();

      if(current == null){
        continue;
      }
    
      System.out.println(current.value);
      
      queue.add(current.left);
      queue.add(current.right);
        
      
    }
  }
  public static <T> Map<T, Integer> toMap(TreeNode<T> node){
    Map<T, Integer> counts = new HashMap<>();
    toMap(node, counts);
    return counts;
  }

  private static <T> void toMap(TreeNode<T> node, Map<T, Integer> counts){
    if(node == null) { return;}
    // fill up those counts
    counts.put(node.value, counts.getOrDefault(node.value, 0) + 1);
    toMap(node.left, counts);
    toMap(node.right, counts);
  }

  
  public static int countNodes(TreeNode<?> node){
    return node == null ? 0 : 1 + countNodes(node.left) + countNodes(node.right);
    // if (node == null) { return 0; }
    // int leftCount = countNodes(node.left);
    // int rightCount = countNodes(node.right);
    // int overallCount = leftCount + rightCount + 1;
    // return overallCount;
  }
  public static void printGreater(TreeNode<Integer> node, int threshold){
    if(node == null) return;
    if (node.value > threshold) { System.out.println(node.value); }
    printGreater(node.left, threshold);
    printGreater(node.right, threshold);
  }
 

  //Print a tree rooted at a given node in pre-order
  public static <T> void postOrder(TreeNode<T> node){
    if (node == null) return; 
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.value + " ");
  }

  //Print a tree rooted at a given node in pre-order
  public static <E> void inOrder(TreeNode<E> node){
    if (node == null) return; 
    postOrder(node.left);
    System.out.print(node.value + " ");
    postOrder(node.right);
  }
}
