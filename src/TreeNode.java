public class TreeNode<T> {

  public T value;
  public TreeNode<T> left;
  public TreeNode<T> right;

  public TreeNode(T data, TreeNode<T> left, TreeNode<T> right){
    this.value = data;
    this.left = left;
    this.right = right;
    
  }
}