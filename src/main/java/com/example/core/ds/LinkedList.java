package com.example.core.ds;

import java.util.ArrayList;

public class LinkedList {
    //head of the list
    Node head;
    // static inner class
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    public LinkedList insert(LinkedList list, int data){
        // create new node with data
        Node new_node = new Node(data);

        if(list.head == null){
            list.head = new_node;
        }else {
            //traverse till the end
            Node last = list.head;
            while (last.next !=null){
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public void printList(LinkedList list){
        Node currNode = list.head;
        System.out.print("Linked List: ");
        while (currNode !=null){
            System.out.print(" "+currNode.data);
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        //insert
        LinkedList list = new LinkedList();
        list.insert(list, 1);
        list.insert(list, 2);
        list.insert(list, 3);
        list.insert(list, 4);
        list.insert(list, 5);

        //print
        list.printList(list);

        ArrayList l;

    }

}
