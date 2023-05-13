package doublylinkedlist;

public class MyDoublyLinkedList<T> {

    private MyNewNode<T> head;
    private MyNewNode<T> tail;

    public MyDoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // addToHead()
    public void addToHead(T data) {
        MyNewNode<T> newHead = new MyNewNode<>(data);
        MyNewNode<T> currentHead = this.head;

        if (currentHead != null) {
            currentHead.setPrev(newHead);
            newHead.setNext(currentHead);
        }

        this.head = newHead;

        if (this.tail == null) this.tail = newHead;
    }

    // addToTail()
    public void addToTail(T data) {
        MyNewNode<T> newTail = new MyNewNode<>(data);
        MyNewNode<T> currentTail = this.tail;

        if (currentTail != null) {
            currentTail.setNext(newTail);
            newTail.setPrev(currentTail);
        }

        this.tail = newTail;

        if (this.head == null) this.head = newTail;
    }

    // removeHead()
    public T removeHead() {
        MyNewNode<T> removedHead = this.head;

        if (removedHead == null) return null;

        MyNewNode<T> newHead = (MyNewNode<T>) removedHead.getNext();

        if (newHead != null) newHead.setPrev(null);

        this.head = newHead;

        if (removedHead == this.tail) removeTail();

        return removedHead.getData();
    }

    // removeTail()
    public T removeTail() {
        MyNewNode<T> removedTail = this.tail;

        if (removedTail == null) return null;

        MyNewNode<T> newTail = (MyNewNode<T>) removedTail.getPrev();

        if (newTail != null) newTail.setNext(null);

        this.tail = newTail;

        if (removedTail == this.head) removeHead();

        return removedTail.getData();
    }

    // removeByData()
    public MyNewNode<T> removeByData(T data) {
        MyNewNode<T> removedNode = null;
        MyNewNode<T> currentNode = this.head;

        while (currentNode != null) {
            if (currentNode.getData() == data) {
                removedNode = currentNode;
                break;
            }
            currentNode = (MyNewNode<T>) currentNode.getNext();
        }

        if (removedNode == null) return null;

        if (removedNode == this.head) removeHead();
        else if (removedNode == this.tail) removeTail();
        else {
            MyNewNode<T> previousNode = (MyNewNode<T>) removedNode.getPrev();
            MyNewNode<T> nextNode = (MyNewNode<T>) removedNode.getNext();
            previousNode.setNext(nextNode);
            nextNode.setPrev(previousNode);
        }

        return removedNode;
    }

    // printList()
    public void printList() {
        StringBuilder output = new StringBuilder("<head> ");

        MyNewNode<T> currentNode = this.head;

        while (currentNode != null) {
            output.append(currentNode.getData()).append(" ");
            currentNode = (MyNewNode<T>) currentNode.getNext();
        }

        output.append("<tail>");

        System.out.println(output);
    }

    public static void main(String[] args) {
        MyDoublyLinkedList<String> myDoublyLinkedList =
                new MyDoublyLinkedList<>();

        myDoublyLinkedList.addToHead("are");
        myDoublyLinkedList.addToHead("how");
        myDoublyLinkedList.addToTail("you?");

        myDoublyLinkedList.printList();

        String removedData = myDoublyLinkedList.removeHead();
        String removedData2 = myDoublyLinkedList.removeTail();

        System.out.println(removedData);
        System.out.println(removedData2);
        myDoublyLinkedList.printList();

        MyDoublyLinkedList<Integer> integerMyDoublyLinkedList =
                new MyDoublyLinkedList<>();

        integerMyDoublyLinkedList.addToTail(1);
        integerMyDoublyLinkedList.addToTail(2);
        integerMyDoublyLinkedList.addToTail(3);
        integerMyDoublyLinkedList.addToTail(4);
        integerMyDoublyLinkedList.addToTail(5);

        MyNewNode<Integer> removedNode = integerMyDoublyLinkedList.removeByData(2);
        MyNewNode<Integer> removedNode2 = integerMyDoublyLinkedList.removeByData(4);

        System.out.println(removedNode.getData());
        System.out.println(removedNode2.getData());
        integerMyDoublyLinkedList.printList();
    }

}
