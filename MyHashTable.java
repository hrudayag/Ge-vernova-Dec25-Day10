public class MyHashTable<K, V> {
    private final int SIZE = 10;
    MyLinkedList<K, V>[] buckets;

    public MyHashTable() {
        buckets = new MyLinkedList[SIZE];
        for (int i = 0; i < SIZE; i++)
            buckets[i] = new MyLinkedList<>();
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void add(K key, V value) {
        int index = getIndex(key);
        buckets[index].add(key, value);
    }

    public MyMapNode<K, V> get(K key) {
        int index = getIndex(key);
        return buckets[index].search(key);
    }

    public void remove(K key) {
        int index = getIndex(key);
        buckets[index].remove(key);
    }

    public void display() {
        for (MyLinkedList<K, V> list : buckets)
            list.display();
    }
    public static void main(String[] args) {
        String sentence = "To be or not to be";
        String[] words = sentence.toLowerCase().split(" ");

        MyHashTable<String, Integer> table = new MyHashTable<>();

        for (String word : words) {
            MyMapNode<String, Integer> node = table.get(word);
            if (node == null)
                table.add(word, 1);
            else
                table.add(word, node.value + 1);
        }

        table.display();
    }
}