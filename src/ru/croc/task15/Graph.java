package ru.croc.task15;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Node root;
    private final Map<String, Node> hashMap = new HashMap<>();

    public Graph() {
        // nothing...
    }

    public void addNode(String name, String parentName, int time) {
        Node node = new Node(name, parentName, time);
        hashMap.put(name, node);

        if (parentName.equals("-")) {
            root = node;
        } else {
            hashMap.get(parentName).addChildren(node);
        }
    }

    public Node getRoot() {
        return this.root;
    }
}
