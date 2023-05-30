import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;

    Node(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTree<T> {
    private Node<T> root;

    BinaryTree() {
        root = null;
    }

    private Node<T> insertNode(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (data.toString().compareTo(node.data.toString()) <= 0) {
            node.left = insertNode(node.left, data);
        } else {
            node.right = insertNode(node.right, data);
        }

        return node;
    }

    void insert(T data) {
        root = insertNode(root, data);
    }

    private void preorderTraversal(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    private void inorderTraversal(Node<T> node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    private void postorderTraversal(Node<T> node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    void preorder() {
        System.out.print("Preorder Traversal: ");
        preorderTraversal(root);
        System.out.println();
    }

    void inorder() {
        System.out.print("Inorder Traversal: ");
        inorderTraversal(root);
        System.out.println();
    }

    void postorder() {
        System.out.print("Postorder Traversal: ");
        postorderTraversal(root);
        System.out.println();
    }

    private void drawTree(Node<T> node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + node.data.toString());
            drawTree(node.left, prefix + (isLeft ? "|   " : "    "), true);
            drawTree(node.right, prefix + (isLeft ? "|   " : "    "), false);
        }
    }

    void draw() {
        System.out.println("Binary Tree:");
        drawTree(root, "", false);
    }
}

public class Keg2 {
    public static void main(String[] args) {
        BinaryTree<Object> binaryTree = new BinaryTree<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pencarian Berkas Data, Masukkan Data dengan angka dan huruf. Contoh 1A 2B");
        System.out.print("Masukkan data : ");

        String input = scanner.nextLine();

        String[] data = input.split(" ");
        for (String item : data) {
            binaryTree.insert(item);
        }

        binaryTree.preorder();
        binaryTree.inorder();
        binaryTree.postorder();

        binaryTree.draw();
    }
}
