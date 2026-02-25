
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class toMap {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(2, null, null);
    root.left = new TreeNode<>(1, null, null);
    root.left.left = new TreeNode<>(7, null, null);
    root.left.right = new TreeNode<>(4, null, null);

    root.right = new TreeNode<>(3, null, null);
    root.right.left = new TreeNode<>(5, null, null);
    root.right.right = new TreeNode<>(6, null, null);
    root.right.right = new TreeNode<>(9, null, null);
    root.right.right.right  = new TreeNode<>(8, null, null);

    TreeNode<String> stringRoot = new TreeNode<>("hello",null,null);
    stringRoot.left = new TreeNode<>("hello", null, null);
    stringRoot.left.left = new TreeNode<>("hello", null, null);
    stringRoot.left.right = new TreeNode<>("hello", null, null);

    stringRoot.right = new TreeNode<>("am", null, null);
    stringRoot.right.left = new TreeNode<>("am", null, null);
    stringRoot.right.right = new TreeNode<>("am", null, null);
    stringRoot.right.right.right = new TreeNode<>("good", null, null);

    TreeNode<Integer> megaRoot = new TreeNode<Integer>(1, null, null);

    TreeNode<Integer> current = megaRoot;

    for(int i = 2; i <= Integer.MAX_VALUE; i++){
      current.right = new TreeNode<Integer>(i, null, null);
      current = current.right;
    }
    // System.out.println("Preorder recursive");
    // preorder(root);
    // System.out.println("Preorder iterative");
    //  preOrderIter(root);
    preOrderIter(megaRoot);

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

    public static void preorder(TreeNode<Integer> node){
    if(node == null) return;
    System.out.println(node.value);
    preorder(node.left);
    preorder(node.right);
  }

  public static <T> void preOrderIter(TreeNode<T> node){
    Stack<TreeNode<T>> stack = new Stack<>();
    stack.push(node);

    while(!stack.isEmpty()){
      TreeNode<T> current = stack.pop();

      if(current == null){
        continue;
      }

      System.out.println(current.value);
      stack.push(current.right);
      stack.push(current.left);
      
    }
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

  public static int countNodes(TreeNode<?> node){
   return node == null ? 0 : 1 + countNodes(node.left) + countNodes(node.right);
  }

  public static void printGreater(TreeNode<Integer> node, int threshold){
    if(node == null) return;
    if(node.value > threshold){
        System.out.println(node.value);

    }
    printGreater(node.left,threshold);
    printGreater(node.right,threshold);
  }

  public static <T> void inorder(TreeNode<T> node){
    if(node == null) return;
    inorder(node.left);
    System.out.print(node.value + " ");
    inorder(node.right);
  }

  public static <E> void postorder(TreeNode<E> node){
    if(node == null) return;
    postorder(node.left);
    postorder(node.right);
    System.out.print(node.value + " ");
  }


}