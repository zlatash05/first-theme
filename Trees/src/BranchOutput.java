import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BranchOutput {

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

    static void findSingleChildNodes(Node root, List<Integer> nodes) {
        if (root == null) {
            return;
        }

        if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
            nodes.add(root.data);
        }

        findSingleChildNodes(root.left, nodes);
        findSingleChildNodes(root.right, nodes);
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

        List<Integer> singleChildNodes = new ArrayList<>();
        findSingleChildNodes(root, singleChildNodes);
        Collections.sort(singleChildNodes);

        for (int node : singleChildNodes) {
            System.out.println(node);
        }
        scanner.close();
    }
}
