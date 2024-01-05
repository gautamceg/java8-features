package com.example.ds;

import java.util.Scanner;

public class SingleLinkedList {
    Node head;
    public SingleLinkedList(Node head){
        this.head = head;
    }

    public void addToLast(int data){
        final Node n = new Node(data);
        if (head == null || head.next==null){
            head = n;
        }
        else {
            Node curr = head;
            while (curr.next != null){
                curr = curr.next;
            }
            curr.next = n;
        }
    }

    public void addToStart(int data){
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    public void iterateAll(Node node){
        Node temp = node;
        System.out.println("Iterate all");
        while (temp.next !=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("last: " + temp.data);

    }

    public static void main(String[] args) {
        Node head = new Node(0);
        SingleLinkedList list = new SingleLinkedList(head);
        Scanner sc = new Scanner(System.in);

        System.out.println("Input one: ");
        int x = sc.nextInt();
        list.addToLast(x);

        System.out.println("Input two: ");
        int y = sc.nextInt();
        list.addToLast(y);

        //iterate all
        list.iterateAll(head);

    }
}

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
