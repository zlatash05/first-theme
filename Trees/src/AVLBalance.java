import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class AVLBalance {

    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;
        int data;

        while (true) {
            data = scanner.nextInt();
            if (data == 0) {
                break;
            }
            root = insert(root, data);
        }

        if (isBalanced(root)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }
}