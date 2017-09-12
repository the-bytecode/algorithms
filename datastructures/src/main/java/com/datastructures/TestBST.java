package com.datastructures;

import java.util.Optional;

/**
 * Created by chandrashekar.v on 8/31/2017.
 */
public class TestBST {


    private Node root;

    public void addNode(int data) {
        root = addNodeRec(root, data);
    }

    private Node addNodeRec(Optional<Node> node, int data) {
        node.ifPresent(n -> {
            if (data < n.getData())
                n.setLeft(addNodeRec(Optional.of(n.getLeft()), data));
            else if(data > n.getData())
                n.setRight(addNodeRec(Optional.of(n.getRight()), data));


        });
        return node.orElse(new Node(data));
    }




    private Node addNodeRec(Node node, int data) {
        if (null == node) {
            node = new Node(data);
            return node;
        }

        if (data < node.data) {
            node.left = addNodeRec(node.left, data);
        } else if (data > node.data) {
            node.right = addNodeRec(node.right, data);
        }
        return node;
    }

public static class Node {
    public Node left;

    public Node right;

    public int data;

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node(int data) {
        this.data = data;
    }
}
}
