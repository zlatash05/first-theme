import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinarySearchTreeLeaves {

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

    static void findLeaves(Node root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.data);
            return;
        }
        findLeaves(root.left, leaves);
        findLeaves(root.right, leaves);
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

        List<Integer> leaves = new ArrayList<>();
        findLeaves(root, leaves);
        Collections.sort(leaves);

        for (int leaf : leaves) {
            System.out.println(leaf);
        }
        scanner.close();
    }
}

