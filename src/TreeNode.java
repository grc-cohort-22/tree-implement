public class TreeNode<T> {
    // -- Instance fields --

    // The value of the node
    public T value;

    // Left and right pointers
    public TreeNode<T> left;
    public TreeNode<T> right;

    // -- Contructors --
    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}