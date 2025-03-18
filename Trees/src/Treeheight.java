import java.util.Scanner;

class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = heightRec(root.left);
            int rightHeight = heightRec(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        while (true) {
            if (!scanner.hasNextInt()) {
                break;
            }
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            bst.insert(number);
        }

        System.out.println(bst.height());
        scanner.close();
    }
}
