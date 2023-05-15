package singlylinkedlist;

import java.util.Objects;

public class MyLinkedList<T> {

    private MyNode<T> head;

    public MyLinkedList() {
        this.head = null;
    }

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.addToTail("first");
        myLinkedList.addToTail("second");
        myLinkedList.addToTail("third");
        myLinkedList.addToTail("fourth");
        myLinkedList.addToTail("fifth");

        myLinkedList.printList();

        myLinkedList.swapNode("first", "fifth");
        myLinkedList.swapNode("second", "fourth");

        myLinkedList.printList();
    }

    public void swapNode(T data1, T data2) {
        if (Objects.equals(data1, data2)) return;

        MyNode<T> node1 = this.head;
        MyNode<T> node2 = this.head;
        MyNode<T> node1Prev = null;
        MyNode<T> node2Prev = null;

        while (node1 != null) {
            if (node1.getData().equals(data1)) {
                break;
            }
            node1Prev = node1;
            node1 = node1.getNext();
        }

        while (node2 != null) {
            if (node2.getData().equals(data2)) {
                break;
            }
            node2Prev = node2;
            node2 = node2.getNext();
        }

        if (node1 == null || node2 == null) return;

        if (node1Prev == null) {
            this.head = node2;
        } else {
            node1Prev.setNext(node2);
        }

        if (node2Prev == null) {
            this.head = node1;
        } else {
            node2Prev.setNext(node1);
        }

        MyNode<T> temp = node1.getNext();
        node1.setNext(node2.getNext());
        node2.setNext(temp);
    }

    public void addToHead(T data) {
        MyNode<T> newHead = new MyNode<>(data);
        MyNode<T> currentHead = this.head;
        this.head = newHead;
        if (currentHead != null) {
            newHead.setNext(currentHead);
        }
    }

    public void addToTail(T data) {
        MyNode<T> newTail = new MyNode<>(data);
        MyNode<T> currentNode = this.head;
        if (currentNode == null) {
            this.head = newTail;
        } else {
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newTail);
        }
    }

    public void removeHead() {
        this.head = this.head.getNext();
    }

    public void removeTail() {
        MyNode<T> currentNode = this.head;
        MyNode<T> previousNode = null;

        while (currentNode.getNext() != null) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (previousNode != null) {
            previousNode.setNext(null);
        } else {
            this.head = null;
        }
    }

    public void printList() {
        StringBuilder output = new StringBuilder("<head> ");

        MyNode<T> currentNode = this.head;

        while (currentNode != null) {
            output.append(currentNode.getData()).append(" ");
            currentNode = currentNode.getNext();
        }

        output.append("<tail>");

        System.out.println(output);
    }

}
