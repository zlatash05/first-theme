import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class ForkOutput {
    private Node root;

    public ForkOutput() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void printNodesWithTwoChildren() {
        printNodesWithTwoChildrenRec(root);
    }

    private void printNodesWithTwoChildrenRec(Node root) {
        if (root == null) {
            return;
        }

        // Симметричный обход (in-order)
        printNodesWithTwoChildrenRec(root.left);

        // Проверяем, есть ли у вершины два ребенка
        if (root.left != null && root.right != null) {
            System.out.println(root.data);
        }

        printNodesWithTwoChildrenRec(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ForkOutput tree = new ForkOutput();

        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            tree.insert(num);
        }

        tree.printNodesWithTwoChildren();

        scanner.close();
    }
}