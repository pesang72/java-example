package du.study.priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        System.out.println("최소 힙");
        runHeapTest(minHeap); //1 2 3 5 8

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        System.out.println("최대 힙");
        runHeapTest(maxHeap); // 8 5 3 2 1
    }

    public static void runHeapTest(PriorityQueue<Integer> heap) {
        heap.add(1);
        heap.add(8);
        heap.add(5);
        heap.add(2);
        heap.add(3);
        while(!heap.isEmpty()) {
            System.out.print(heap.poll() + " ");
        }
        System.out.println();
    }
}
