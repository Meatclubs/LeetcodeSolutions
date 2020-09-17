package com.rraj91091.leetcode;

import com.rraj91091.leetcode.algorithms.searching.BinarySearch;
import com.rraj91091.leetcode.algorithms.searching.FindingKthLargestLowestNumber;
import com.leetcode.algorithms.sorting.*;
import com.rraj91091.leetcode.datastructures.linkedlists.DoublyLinkedList;
import com.rraj91091.leetcode.datastructures.linkedlists.SinglyLinkedList;
import com.rraj91091.leetcode.leetcode.RomanToInt;
import com.rraj91091.leetcode.algorithms.sorting.*;

public class MainClass {

    public static void main(String[] args) {
        //testDoublyLinkedList();
        //testSingularLinkedList();
        //testMergeSort();
        //testQuickSort();
        //testInsertionSort();
        //testBinarySearch();
        //testHeapSort();
        //testFindingKthLargestLowestNumber();
        //testMerge();

        System.out.println(RomanToInt.romanToInt("XXIV"));
    }

    static void testMerge() {
        int[] A = {1,2,3,4,5,0,0,0};
        int[] B = {6,7,8};

        int[] result = Sort2Arrays.merge(A,B);

        for(int i=0; i < result.length; i++) {
            if(i!=0) {
                System.out.print(",");
            }
            System.out.print(result[i]);
        }

        System.out.println();
        int[] AA = {4,5,6,7,8,9,0,0,0};
        int[] BA = {1,2,3};

        int[] result2 = Sort2Arrays.merge(A,B);

        for(int i=0; i < result2.length; i++) {
            if(i!=0) {
                System.out.print(",");
            }
            System.out.print(result2[i]);
        }
    }

    static void testFindingKthLargestLowestNumber() {
        int[] arr = {6,5,4,1,3,9,8,2,0,7};

        int kthLargest = FindingKthLargestLowestNumber.findKthLargest(arr, 5);
        System.out.println("Kth Largest: " + kthLargest);
    }

    static void testHeapSort() {
        int[] arr = {6,5,4,1,3,9,8,2,0,7};

        int[] result = HeapSort.sortAscending(arr);
        System.out.println(PrintUtils.printArray(result));
    }

    static void testBinarySearch() {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};

        int index = BinarySearch.search(arr, 3,0,arr.length-1);
        System.out.println("Value found at index: " + index);
    }

    static void testInsertionSort() {
        int[] arr = new int[10];
        for(int i = 0; i<10; i++) {
            arr[i] = (int) (Math.random()*10);
        }

        int[] result = InsertionSort.sort(arr);
        System.out.println(PrintUtils.printArray(result));
    }

    static void testQuickSort() {
        int[] arr = new int[10];
        for(int i = 0; i<10; i++) {
            arr[i] = (int) (Math.random()*10);
        }

        int[] result = QuickSort.sort(arr, 0, arr.length-1);
        System.out.println(PrintUtils.printArray(result));
    }

    static void testMergeSort() {
        int[] arr = {7,5,3,2,6,4,9,8,1,0};

        int[] result = MergeSort.sort(arr);
        System.out.println(PrintUtils.printArray(result));
    }

    static void testDoublyLinkedList() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.push(8);
        doublyLinkedList.append(2);
        doublyLinkedList.push(4);
        doublyLinkedList.append(5);
        doublyLinkedList.push(6);
        doublyLinkedList.append(7);

        doublyLinkedList.insertAfter(4, 0);
        doublyLinkedList.insertAfter(0, 9);
        doublyLinkedList.insertAfter(7, 1);

        System.out.print("Linked List : ");
        doublyLinkedList.printList();
        System.out.print("Linked List : ");
        doublyLinkedList.printListBackwards();

        doublyLinkedList.remove(1);
        System.out.print("Linked List : ");
        doublyLinkedList.printList();
        System.out.print("Linked List : ");
        doublyLinkedList.printListBackwards();

        doublyLinkedList.removeAtPosition(0);
        System.out.print("Linked List : ");
        doublyLinkedList.printList();
        System.out.print("Linked List : ");
        doublyLinkedList.printListBackwards();

        doublyLinkedList.remove(7);
        System.out.print("Linked List : ");
        doublyLinkedList.printList();
        System.out.print("Linked List : ");
        doublyLinkedList.printListBackwards();

        doublyLinkedList.removeAtPosition(4);
        System.out.print("Linked List : ");
        doublyLinkedList.printList();
        System.out.print("Linked List : ");
        doublyLinkedList.printListBackwards();
    }

    static void testSingularLinkedList() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.append(2);
        singlyLinkedList.push(4);
        singlyLinkedList.append(5);
        singlyLinkedList.push(6);
        singlyLinkedList.append(7);

        singlyLinkedList.insertAfter(4, 0);
        singlyLinkedList.insertAfter(0, 9);
        singlyLinkedList.insertAfter(7, 1);

        System.out.print("Linked List : ");
        singlyLinkedList.printList();

        singlyLinkedList.remove(1);
        System.out.print("Linked List : ");
        singlyLinkedList.printList();

        singlyLinkedList.removeAtPosition(0);
        System.out.print("Linked List : ");
        singlyLinkedList.printList();

        singlyLinkedList.remove(7);
        System.out.print("Linked List : ");
        singlyLinkedList.printList();

        singlyLinkedList.removeAtPosition(4);
        System.out.print("Linked List : ");
        singlyLinkedList.printList();
    }

}
