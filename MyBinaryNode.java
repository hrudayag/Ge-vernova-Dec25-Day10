public class MyBinaryNode<K extends Comparable<K>> implements INode<K> {
    K key;
    MyBinaryNode<K> left;
    MyBinaryNode<K> right;

    public MyBinaryNode(K key) {
        this.key = key;
    }
    public K getKey() {
        return key;
    }
}