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


        PriorityQueue<Restaurant> minHeapByClass = new PriorityQueue<>();
        System.out.println("최소 힙");
        runHeapTestByClass(minHeapByClass);

        PriorityQueue<Restaurant> maxHeapByClass = new PriorityQueue<>(Collections.reverseOrder());
        System.out.println("최대 힙");
        runHeapTestByClass(maxHeapByClass);
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

    public static void runHeapTestByClass(PriorityQueue<Restaurant> heap) {
        heap.add(new Restaurant(1, 5));
        heap.add(new Restaurant(1, 4));
        heap.add(new Restaurant(2, 5));
        heap.add(new Restaurant(4, 3));
        heap.add(new Restaurant(4, 5));
        while(!heap.isEmpty()) {
            System.out.println(heap.poll().toString());
        }
    }

    static class Restaurant implements Comparable<Restaurant>{
        int grade;
        int distance;

        public Restaurant(int grade, int distance) {
            this.grade = grade;
            this.distance = distance;
        }

        public String toString() {
            return "grade : "+this.grade +" and distance :"+this.distance;
        }

        @Override
        public int compareTo(Restaurant target) {
            if(this.grade == target.grade) {
                return this.distance <= target.distance ? -1 : 1;
            }
            else {
                return this.grade <= target.grade ? -1 : 1;
            }
        }
    }
}
