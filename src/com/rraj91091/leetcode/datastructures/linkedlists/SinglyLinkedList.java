package com.rraj91091.leetcode.datastructures.linkedlists;

public class SinglyLinkedList {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            next = null;
        }
    }

    public void printList() {
        Node currentNode = head;

        while(currentNode != null) {
            System.out.print(currentNode.data);
            if(currentNode.next != null) {
                System.out.print("->");
            }
            currentNode = currentNode.next;
        }

        System.out.println();
    }

    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void append(int val) {
        Node currentNode = head;

        if(currentNode == null) {
            head = new Node(val);
            return;
        }

        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }

        Node newNode = new Node(val);
        currentNode.next = newNode;
    }

    /* Inserts after the first occurrence of the given value*/
    public void insertAfter(int nodeValue, int newValue) {
        Node currentNode = head;

        while(currentNode != null) {
            if(currentNode.data == nodeValue) {
                Node nextNode = currentNode.next;
                Node newNode = new Node(newValue);
                newNode.next = nextNode;

                currentNode.next = newNode;

                return;
            }

            currentNode = currentNode.next;
        }

        System.out.println("Node Not Found!");
    }

    /* Inserts after the first occurrence of the given value*/
    public void insertAfter(Node previousNode, int newValue) {
        Node currentNode = head;

        if(previousNode == null) {
            System.out.println("Previous Node cannot be null");
            return;
        }

        Node newNode = new Node(newValue);
        newNode.next = previousNode.next;
        previousNode.next = newNode;
    }

    // deletes first occurrence of the value
    public void remove(int val) {
        Node currentNode = head;
        Node previousNode = null;

        while(currentNode != null) {
            if(currentNode.data == val) {

                if(previousNode == null) {
                    head = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }

                return;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        System.out.println("Value Not Found!");
    }

    // deletes node at the given position, with 0 being the first position
    public void removeAtPosition(int position) {
        Node currentNode = head;
        Node previousNode = null;

        if(position < 0) {
            System.out.println("Invalid Position : " + position);
            return;
        }

        int i = 0;
        while(currentNode != null) {
            if(i == position) {
                Node nextNode = currentNode.next;
                previousNode.next = currentNode.next;

                return;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
            i++;
        }

        System.out.println("Position Out of Bounds!");
    }

    public int valueAtPosition(int position) {
        //TODO

        return 0;
    }

}
