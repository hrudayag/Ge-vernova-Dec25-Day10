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
        MyBinarySearchTree<Integer> bst1 = new MyBinarySearchTree<>();
        bst1.add(56);
        bst1.add(30);
        bst1.add(70);
        System.out.println("Output for UC1:");
        System.out.println("Size: " + bst1.size());
        //uc2
        MyBinarySearchTree<Integer> bst2 = new MyBinarySearchTree<>();
        int[] nodes = {56, 30, 70, 22, 40, 60, 95, 11, 65, 3, 16, 63, 67};
        for (int n : nodes)
            bst2.add(n);
        System.out.println("Output for UC2:");
        System.out.println("Total Nodes: " + bst2.size());

        //uc3
        System.out.println("Output for UC3:");
        System.out.println("Is 63 present? " + bst2.search(63));
    }

}
