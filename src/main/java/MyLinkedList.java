public class MyLinkedList<T> {

    private MyNode<T> head;

    public MyLinkedList() {
        this.head = null;
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
