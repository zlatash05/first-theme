import java.util.*;

public class Heap {

    private static class MaxHeap {
        private List<Integer> heap;

        public MaxHeap() {
            heap = new ArrayList<>();
        }

        public void insert(int k) {
            heap.add(k);
            heapifyUp(heap.size() - 1);
        }

        public Integer extract() {
            if (heap.isEmpty()) {
                return null;
            }

            int max = heap.get(0);
            int lastIndex = heap.size() - 1;
            heap.set(0, heap.get(lastIndex));
            heap.remove(lastIndex);

            if (!heap.isEmpty()) {
                heapifyDown(0);
            }

            return max;
        }

        private void heapifyUp(int index) {
            int parentIndex = (index - 1) / 2;

            while (index > 0 && heap.get(index) > heap.get(parentIndex)) {
                swap(index, parentIndex);
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            }
        }

        private void heapifyDown(int index) {
            int leftChildIndex;
            int rightChildIndex;
            int largestIndex;

            while (true) {
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
                largestIndex = index;

                if (leftChildIndex < heap.size() && heap.get(leftChildIndex) > heap.get(largestIndex)) {
                    largestIndex = leftChildIndex;
                }

                if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(largestIndex)) {
                    largestIndex = rightChildIndex;
                }

                if (largestIndex != index) {
                    swap(index, largestIndex);
                    index = largestIndex;
                } else {
                    break; // Heap property is satisfied
                }
            }
        }

        private void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline after reading the integer N

        MaxHeap maxHeap = new MaxHeap();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            if (parts[0].equals("0")) {
                int number = Integer.parseInt(parts[1]);
                maxHeap.insert(number);
            } else if (parts[0].equals("1")) {
                Integer extracted = maxHeap.extract();
                System.out.println(extracted);
            }
        }
        scanner.close();
    }
}
