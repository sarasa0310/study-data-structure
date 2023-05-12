public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.addToHead("first");
        myLinkedList.addToTail("second");
        myLinkedList.addToTail("third");

        myLinkedList.printList();

        myLinkedList.removeHead();
        myLinkedList.removeTail();

        myLinkedList.printList();

        MyLinkedList<Integer> integerMyLinkedList = new MyLinkedList<>();

        integerMyLinkedList.addToTail(1);
        integerMyLinkedList.addToHead(2);
        integerMyLinkedList.addToTail(3);

        integerMyLinkedList.printList();

        integerMyLinkedList.removeHead();
        integerMyLinkedList.removeTail();

        integerMyLinkedList.printList();
    }
}
