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
        //uc1
        String sentence = "To be or not to be";
        String[] words1 = sentence.toLowerCase().split(" ");

        MyHashTable<String, Integer> table1 = new MyHashTable<>();

        for (String word : words1) {
            MyMapNode<String, Integer> node = table1.get(word);
            if (node == null)
                table1.add(word, 1);
            else
                table1.add(word, node.value + 1);
        }
        System.out.println("UC1 Output:");
        table1.display();
        //uc2
        String para = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        String[] words2 = para.toLowerCase().split(" ");
        MyHashTable<String, Integer> table2 = new MyHashTable<>();
        for (String word : words2) {
            MyMapNode<String, Integer> node = table2.get(word);
            if (node == null)
                table2.add(word, 1);
            else
                table2.add(word, node.value + 1);
        }
        System.out.println("\nUC2 Output:");
        table2.display();
    }
}