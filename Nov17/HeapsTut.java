import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapsTut {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());// maxHeap

        minHeap.add(10); // highest priority as it's min heap
        minHeap.add(20);
        minHeap.add(50); // lowest

        maxHeap.add(1); // lowest
        maxHeap.add(2);
        maxHeap.add(3);
        maxHeap.add(5); // highest because it is maxheap
        System.out.println(minHeap.peek());
        System.out.println(maxHeap.peek());

        // ==========================================
        // Custom Heap Implementation
        // ==========================================

        /**
         * Let us say we want to prioritize based on GPA
         */

        Comparator<Student> gpaComparator = (s1, s2) -> Double.compare(s2.getGPA(), s1.getGPA());
        PriorityQueue<Student> honorRoll = new PriorityQueue<>(gpaComparator);
        honorRoll.add(new Student("Alice", 3.6));
        honorRoll.add(new Student("Alice", 3.9));
        honorRoll.add(new Student("Alice", 3.5));

        System.out.println("Highest gpa " + honorRoll.poll());
        System.out.print("Second highest gpa " + honorRoll.poll());
    }
}

/**
 * For custom comparision let's first create a student class
 */

class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public double getGPA() {
        return gpa;
    }

    @Override
    public String toString() {
        return name + " (" + gpa + ")";
    }
}