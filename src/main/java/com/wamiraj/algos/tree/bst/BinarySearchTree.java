package com.wamiraj.algos.tree.bst;

/**
 * Binary Search tree insertion implemenation
 * GeeksForGeeks:
 * https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 */
public class BinarySearchTree {

    // Root node
    private Node root;

    // Constructor
    public BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertKey(root, key);
    }

    private Node insertKey(Node root, int key) {
        // if the tree is empty return a new node
        if(root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise traverse down the tree
        if(key < root.key) {
            root.left = insertKey(root.left, key);
        } else if (key > root.key) {
            root.right = insertKey(root.right,key);
        }

        // Return the unchanged root node
        return root;
    }

    // This methods internall calls inOrderTraverseRec.
    void inOrderTraverse() {
        inOrderTraverseRec(root);
    }

    private void inOrderTraverseRec(Node root) {
        if(root != null) {
            inOrderTraverseRec(root.left);
            System.out.println(root.key);
            inOrderTraverseRec(root.right);
        }
    }


    class Node {
        int key;
        Node left, right;

        public Node (int item) {
            key = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // print inorder traversal of the tree
        bst.inOrderTraverse();

    }
}
