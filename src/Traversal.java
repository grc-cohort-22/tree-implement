public class Traversal {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode <Integer> (10, null, null);
    root.left = new TreeNode <Integer> (9, null,null);
    root.left.left = new TreeNode<Integer> (5, null,null);
    root.left.right = new TreeNode <Integer> (2, null,null);

    root.right = new TreeNode <Integer> (15, null, null);
    root.right.left = new TreeNode <Integer> (-3, null, null);
    root.right.right = new TreeNode <Integer> (5, null, null);
    root.right.right.right = new TreeNode <Integer> (22, null, null);


    TreeNode <String> stringRoot = new TreeNode<String> ("Hello", null, null);
    stringRoot.left = new TreeNode <String> ("how", null,null);
    stringRoot.left.left = new TreeNode<String> ("are", null,null);
    stringRoot.left.right = new TreeNode <String> ("you", null,null);

    stringRoot.right = new TreeNode <String> ("I", null, null);
    stringRoot.right.left = new TreeNode <String> ("am", null, null);
    stringRoot.right.right = new TreeNode <String> ("so", null, null);
    stringRoot.right.right.right = new TreeNode <String> ("good", null, null);


    //preorder(root);
    //postorder(root);
    //inorder(root);

    //printGreater(root, 4);
    System.out.println(countNodes(root));


  }

  public static int countNodes(TreeNode<?> node) {
    //if(node == null) return 0;
    return node == null ? 0: countNodes(node.left) + countNodes(node.right) + 1;
    // int leftCount = countNodes(node.left);
    // int rightCount = countNodes(node.right);
    // int overallCount = leftCount + rightCount + 1;

    // return overallCount;

  }

  public static void printGreater(TreeNode<Integer> node, int threshold) {
    if(node == null) return;
    if(node.value > threshold) {
      System.out.println(node.value);
    }
    printGreater(node.left, threshold);
    printGreater(node.right, threshold);
 }


  // Print a tree rooted at the given node in pre-order
  public static void preorder(TreeNode<?> node){
    //if null, return
    if(node == null) return;
    //print value
    System.out.println(node.value);
    //traverse left to recursion and tree works
    preorder(node.left);
    //traverse right
    preorder(node.right);

  }

  public static <T> void postorder(TreeNode<T> node){
    if(node == null) return;
     postorder(node.left);
     postorder(node.right);
     // print after recursion
    System.out.println(node.value);
  }

  public static <E> void inorder(TreeNode <E> node){
    if(node == null) return;
    inorder(node.left);
    System.out.println(node.value);
    inorder(node.right);


  }
}
