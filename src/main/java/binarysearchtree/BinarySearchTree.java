package binarysearchtree;

public class BinarySearchTree {

    public int value;
    public int depth;
    public BinarySearchTree left;
    public BinarySearchTree right;

    // 루트 노드 전용 생성자
    public BinarySearchTree(int value) {
        this.value = value;
        this.depth = 1;
        this.left = null;
        this.right = null;
    }

    // 그 외 노드 생성자
    public BinarySearchTree(int value, int depth) {
        this.value = value;
        this.depth = depth;
        this.left = null;
        this.right = null;
    }

    // 노드 삽입
    public void insert(int value) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = new BinarySearchTree(value, this.depth + 1);
                System.out.printf("Tree node %d added to the %s of %d at depth %d \n",
                        value, "left", this.value, this.depth + 1);
            } else {
                this.left.insert(value);
            }
        } else {
            if (this.right == null) {
                this.right = new BinarySearchTree(value, this.depth + 1);
                System.out.printf("Tree node %d added to the %s of %d at depth %d \n",
                        value, "right", this.value, this.depth + 1);
            } else {
                this.right.insert(value);
            }
        }
    }

    // 값 검색
    public BinarySearchTree getNodeByValue(int value) {
        if (value == this.value) return this;
        else if (value < this.value && this.left != null) {
            return this.left.getNodeByValue(value);
        } else if (value > this.value && this.right != null) {
            return this.right.getNodeByValue(value);
        }
        return null;
    }

    // 깊이 우선 순회(중위 순회)
    public void depthFirstTraversal() {
        if (this.left != null) {
            this.left.depthFirstTraversal();
        }
        System.out.printf("%d ", this.value);
        if (this.right != null) {
            this.right.depthFirstTraversal();
        }
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "value=" + value +
                ", depth=" + depth +
                '}';
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(12);
        tree.insert(37);
        tree.insert(87);
        tree.insert(66);
        tree.insert(100);
        tree.insert(0);
        tree.insert(18);

        System.out.println(tree.getNodeByValue(100));
        System.out.println(tree.getNodeByValue(55));

        tree.depthFirstTraversal();
    }

}
