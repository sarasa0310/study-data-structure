package linkedlist.doublylinkedlist;

import linkedlist.singlylinkedlist.MyNode;

public class MyNewNode<T> extends MyNode<T> {

    private MyNode<T> prev;

    public MyNewNode(T data) {
        super(data);
        this.prev = null;
    }

    public MyNode<T> getPrev() {
        return prev;
    }

    public void setPrev(MyNode<T> prev) {
        this.prev = prev;
    }

}
