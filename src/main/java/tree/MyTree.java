package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MyTree {

    private final MyTreeNode root;

    public MyTree(MyTreeNode root) {
        this.root = root;
    }

    public void dfs(MyTreeNode current) {
        System.out.print(current.getData() + " ");
        for (MyTreeNode child : current.getChildren()) {
            dfs(child);
        }
    }

    public void bfs() {
        MyTreeNode current = this.root;

        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.print(current.getData() + " ");
            queue.addAll(current.getChildren());
        }
    }

    public static void main(String[] args) {
        MyTreeNode rootNode = new MyTreeNode("Users");

        MyTreeNode user1 = new MyTreeNode("eunjiil");
        MyTreeNode user2 = new MyTreeNode("kimdabin");

        MyTreeNode downloads = new MyTreeNode("Downloads");
        MyTreeNode desktop = new MyTreeNode("Desktop");

        rootNode.addChild(user1);
        rootNode.addChild(user2);

        user1.addChild(downloads);
        user1.addChild(desktop);

        user2.addChild("Love");
        user2.addChild("Broken");

        rootNode.removeChild(desktop);
        rootNode.removeChild("Broken");

        MyTree myFileDir = new MyTree(rootNode);

        System.out.print("DFS: ");
        myFileDir.dfs(rootNode);

        System.out.println();

        System.out.print("BFS: ");
        myFileDir.bfs();
    }

}
