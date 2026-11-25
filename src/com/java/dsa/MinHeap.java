package com.java.dsa;

import org.w3c.dom.xpath.XPathResult;

import java.lang.classfile.instruction.LineNumber;

public class MinHeap {

    static int[] heap = new int[100];
    static int size = 0;

    static void insert(int value) {
        heap[size] = value;
        int index = size;
        size++;

        // move up maintain minheap
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap[index] < heap[parent]) {

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
        int largest = index;

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left > 0 && heap[left] < heap[largest])
            largest = left;
        if (right > 0 && heap[right] < heap[largest])
            largest = right;

        if (largest != index) {
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

        // delete first node
        heap[0] = heap[size - 1];
        size--;

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
