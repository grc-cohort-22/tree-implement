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


    //preorder(root);
    //postorder(root);
    //inorder(stringRoot);

    //printGreater(root, 4);
    System.out.println(countNodes(root));
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

  // Print a tree rooted at the given node in pre-order
  public static void preorder(TreeNode<?> node) {
    if (node == null) return; // if null, return
    System.out.println(node.value); // print value 
    preorder(node.left); // traverse left
    preorder(node.right); // traverse right 
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