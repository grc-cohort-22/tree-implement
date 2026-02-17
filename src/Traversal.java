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

    System.out.println("======PRE ORDER======");
    preorder(root);
    System.out.println("======POST ORDER======");
    postorder(root);
    System.out.println("======IN ORDER======");
    inorder(root);
  }

    //print tree rooted at given node in pre-order.
  public static void preorder(TreeNode<?> node) {
    if(node == null) return;
    System.out.println(node.value);
    preorder(node.left);
    preorder(node.right);
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
}
