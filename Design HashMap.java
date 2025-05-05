import java.util.LinkedList;

class MyHashMap {

    private static final int SIZE = 1000;
    private LinkedList<Pair>[] table;

    public MyHashMap() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<Pair> bucket = table[index];

        for (Pair pair : bucket) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }

        bucket.add(new Pair(key, value));
    }

    public int get(int key) {
        int index = hash(key);
        LinkedList<Pair> bucket = table[index];

        for (Pair pair : bucket) {
            if (pair.key == key) {
                return pair.value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        LinkedList<Pair> bucket = table[index];

        bucket.removeIf(pair -> pair.key == key);
    }

    private static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }
}

