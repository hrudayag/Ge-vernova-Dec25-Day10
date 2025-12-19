public class MyLinkedList<K, V> {
    MyMapNode<K, V> head;
    public MyMapNode<K, V> search(K key) {
        MyMapNode<K, V> current = head;
        while (current != null) {
            if (current.key.equals(key))
                return current;
            current = current.next;
        }
        return null;
    }
    public void add(K key, V value) {
        MyMapNode<K, V> node = search(key);
        if (node == null) {
            MyMapNode<K, V> newNode = new MyMapNode<>(key, value);
            newNode.next = head;
            head = newNode;
        } else {
            node.value = value;
        }
    }
    public void remove(K key) {
        MyMapNode<K, V> current = head, prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null)
                    head = current.next;
                else
                    prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    public void display() {
        MyMapNode<K, V> current = head;
        while (current != null) {
            System.out.println(current.key + " : " + current.value);
            current = current.next;
        }
    }
}
