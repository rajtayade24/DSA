package com.java.dsa.heap;

import java.lang.classfile.instruction.LineNumber;

public class Introduction {

    static int[] heap = new int[100];
    static int size = 0;

    static void insert(int value) {
        // Step 1: Insert at the end
        heap[size] = value;
        int index = size;
        size++;

        // Step 2: Move up to maintain Max Heap
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap[index] > heap[parent]) {
                // Swap child and parent
                int temp = heap[index];
                heap[index] = heap[parent];
                heap[parent] = temp;

                index = parent;
            } else {
                break;
            }
        }
    }

    static void heapify(int index) {

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        int largest = index;

        if (left>0&& heap[left] > heap[largest]) // Check left child
            largest = left;
        if (right >0 && heap[right] > heap[largest]) // Check right child
            largest = right;

        // If parent is already largest, stop
        if (largest != index) {
            // Swap parent with the larger child
            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;

            heapify(largest);
        }
    }

    static void delete() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return;
        }

        // Step 1: Delete first node
        heap[0] = heap[size - 1];
        size--;

        // Step 2: Move down to maintain Max Heap
        heapify(0);
    }

    static void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        insert(20);
        insert(15);
        insert(12);
        insert(18);
        insert(13);
        insert(31);

        printHeap();

        delete();
        printHeap();

    }
}
