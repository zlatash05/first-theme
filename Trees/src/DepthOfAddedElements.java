import java.util.Scanner;

public class DepthOfAddedElements {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class InsertResult {
        Node root;
        int depth;

        InsertResult(Node root, int depth) {
            this.root = root;
            this.depth = depth;
        }
    }

    static InsertResult insert(Node root, int data, int currentDepth) {
        if (root == null) {
            return new InsertResult(new Node(data), currentDepth);
        }

        if (data < root.data) {
            InsertResult result = insert(root.left, data, currentDepth + 1);
            root.left = result.root;
            return new InsertResult(root, result.depth);
        } else if (data > root.data) {
            InsertResult result = insert(root.right, data, currentDepth + 1);
            root.right = result.root;
            return new InsertResult(root, result.depth);
        } else {

            return new InsertResult(root, -1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;

        while (scanner.hasNextInt()) {
            int data = scanner.nextInt();
            if (data == 0) {
                break;
            }

            InsertResult result = insert(root, data, 1);

            if (result.depth != -1) {
                System.out.print(result.depth + " ");
            }

            root = result.root;

        }

        System.out.println();
        scanner.close();
    }
}

