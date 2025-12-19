public class MyBinarySearchTree<K extends Comparable<K>> {
    private MyBinaryNode<K> root;
    private int size = 0;

    public void add(K key) {
        root = addRecursively(root, key);
    }

    private MyBinaryNode<K> addRecursively(MyBinaryNode<K> node, K key) {
        if (node == null) {
            size++;
            return new MyBinaryNode<>(key);
        }
        if (key.compareTo(node.key) < 0)
            node.left = addRecursively(node.left, key);
        else
            node.right = addRecursively(node.right, key);
        return node;
    }

    public int size() {
        return size;
    }

    public boolean search(K key) {
        return searchRecursively(root, key);
    }

    private boolean searchRecursively(MyBinaryNode<K> node, K key) {
        if (node == null)
            return false;
        if (node.key.equals(key))
            return true;
        if (key.compareTo(node.key) < 0)
            return searchRecursively(node.left, key);
        else
            return searchRecursively(node.right, key);
    }
    //uc1
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> bst = new MyBinarySearchTree<>();
        bst.add(56);
        bst.add(30);
        bst.add(70);
        System.out.println("Size: " + bst.size());
    }

}
