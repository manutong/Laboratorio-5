import java.util.*;
import java.io.*;

public class BST {
    public class Node {
        int data;
        List<String> values;
        Node left, right;

        Node(int data, String value) {
            this.data = data;
            this.values = new ArrayList<>();
            this.values.add(value);
        }
    }

    private Node root;

    public void put(int data, String value) {
        root = put(root, data, value);
    }

    private Node put(Node node, int data, String value) {
        if (node == null) return new Node(data, value);
        if (data < node.data) {
            node.left = put(node.left, data, value);
        } else if (data > node.data) {
            node.right = put(node.right, data, value);
        } else {
            node.values.add(value);
        }
        return node;
    }

    public List<String> get(int data) {
        Node node = get(root, data);
        return node == null ? new ArrayList<>() : node.values;
    }

    private Node get(Node node, int data) {
        if (node == null) return null;
        if (data < node.data) return get(node.left, data);
        else if (data > node.data) return get(node.right, data);
        else return node;
    }

    public List<String> getInRange(int lo, int hi) {
        List<String> result = new ArrayList<>();
        getInRange(root, lo, hi, result);
        return result;
    }

    private void getInRange(Node node, int lo, int hi, List<String> result) {
        if (node == null) return;
        if (lo < node.data) getInRange(node.left, lo, hi, result);
        if (lo <= node.data && node.data <= hi) result.addAll(node.values);
        if (node.data < hi) getInRange(node.right, lo, hi, result);
    }

    public List<String> successor(int key) {
        Node succ = null;
        Node current = root;
        while (current != null) {
            if (key < current.data) {
                succ = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return succ == null ? new ArrayList<>() : succ.values;
    }
    public void removeValue(int data, String value) {
        root = removeValue(root, data, value);
    }

    private Node removeValue(Node node, int data, String value) {
        if (node == null) return null;

        if (data < node.data) {
            node.left = removeValue(node.left, data, value);
        } else if (data > node.data) {
            node.right = removeValue(node.right, data, value);
        } else {
            node.values.remove(value); // remueve el nombre
            // si ya no quedan valores, eliminamos el nodo entero
            if (node.values.isEmpty()) {
                if (node.left == null) return node.right;
                if (node.right == null) return node.left;
                Node successor = min(node.right);
                node.data = successor.data;
                node.values = successor.values;
                node.right = deleteMin(node.right);
            }
        }
        return node;
    }

    private Node min(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

}
