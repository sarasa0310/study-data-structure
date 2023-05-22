package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyTreeNode {

    private final Object data;
    private final List<MyTreeNode> children;

    public MyTreeNode(Object data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public Object getData() {
        return data;
    }

    public List<MyTreeNode> getChildren() {
        return children;
    }

    public void addChild(MyTreeNode child) {
        this.children.add(child);
    }

    public void addChild(Object data) {
        MyTreeNode child = new MyTreeNode(data);
        this.children.add(child);
    }

    public void removeChild(MyTreeNode nodeToRemove) {
        if (this.children.isEmpty()) return;
        else if (this.children.contains(nodeToRemove)) {
            this.children.remove(nodeToRemove);
            return;
        }
        else {
           for (MyTreeNode child : this.children) {
               child.removeChild(nodeToRemove);
           }
        }
    }

    public void removeChild(Object data) {
        if (this.children.isEmpty()) return;
        for (MyTreeNode child : this.children) {
            if (Objects.equals(child.data, data)) {
                removeChild(child);
                return;
            }
        }
        for (MyTreeNode child : this.children) {
            child.removeChild(data);
        }
    }

}
