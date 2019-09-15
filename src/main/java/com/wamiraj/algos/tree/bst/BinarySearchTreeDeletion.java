package com.wamiraj.algos.tree.bst;

/**
 * Binary Search tree insertion implemenation
 * GeeksForGeeks:
 * https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
 */
public class BinarySearchTreeDeletion {

    // Root node
    private Node root;

    // Constructor
    public BinarySearchTreeDeletion() {
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

    void deleteKey(int key) {
        deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        //Base case: if the tree is empty
        if(root == null) return root;

        // Otherwise recurse down the tree
        if(key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            //Key is same as the root key

            // Node with only one child or no child
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.key = minValue (root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);

        }

        return root;
    }

    int minValue(Node root) {
        int minV = root.key;
        while(root.left != null) {
            minV = root.left.key;
            root = root.left;
        }
        return minV;
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

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */

        BinarySearchTreeDeletion bst = new BinarySearchTreeDeletion();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);



        // print inorder traversal of the tree
        System.out.println("\nCreate Tree");
        System.out.println("Inorder traversal of the tree");
        bst.inOrderTraverse();

        // Delete 20
        System.out.println("\nDelete 20");
        bst.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        bst.inOrderTraverse();


        // Delete 30
        System.out.println("\nDelete 30");
        bst.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        bst.inOrderTraverse();

        // Delete 50
        System.out.println("\nDelete 50");
        bst.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        bst.inOrderTraverse();
    }
}
